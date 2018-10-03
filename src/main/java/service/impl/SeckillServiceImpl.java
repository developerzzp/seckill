package service.impl;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import dao.SeckillDao;
import dao.SuccessKilledDao;
import dto.Seckill;
import dto.SuccessKilled;
import enums.SeckillStatusEnum;
import exception.RepectException;
import exception.SeckillCloseException;
import exception.SeckillException;
import service.SeckillService;
import vo.Exposer;
import vo.executeResult;
@Service
public class SeckillServiceImpl implements SeckillService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeckillDao seckillDao;
	@Autowired
	private SuccessKilledDao successKilledDao;
	//盐值，用于混淆MD5
	private final String slat = "chensiqiwoaini";
	private Seckill seckill;
	private String getMd5(long seckillId) {
		String base = seckillId+"/"+slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}
	public List<Seckill> getSeckillList() {
		// TODO Auto-generated method stub
		return seckillDao.queryAll();
	}

	public Seckill getOneSeckill(long seckillId) {
		// TODO Auto-generated method stub
		return seckillDao.queryById(seckillId);
	}

	public Exposer exportSeckillUrl(long seckillId) {
		seckill = seckillDao.queryById(seckillId);
		if(seckill == null) {
			return new Exposer(false, seckillId);
		}
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		Date nowTime = new Date();
		if(nowTime.getTime()<startTime.getTime()||
				nowTime.getTime()>endTime.getTime()) {
			return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
		}
		//不可逆,
		String md5 = getMd5(seckillId);
		return new Exposer(true, md5, seckillId);
	}
	/**
	 * 使用注解控制事务方法的优点:
	 * 1.开发团队达成一致预定，明确标注事务方法的编程风格;
	 * 2.保证事务方法的执行时间尽可能短，不要穿插其他的网络操作，
	 * 或者剥离到方法外面
	 * 3.不是所有的方法都需要事务,如只有一条修改操作，只读操作不需要事务
	 * 控制
	 * mysql
	 */
	@Transactional
	public executeResult executeSeckill(long seckillId, long userPhone, String md5)  throws RepectException,SeckillCloseException,SeckillException{
		try {
			
			if(md5 == null || !md5.equals(getMd5(seckillId))) {
				throw new SeckillException("Seckill Data Rewrite");
			}
			//执行秒杀逻辑,减库存,插入秒杀逻辑
			Date nowTime = new Date();
			int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
			if(updateCount<=0) {
				throw new SeckillCloseException("seckill is close");
			}else {
				//记录购买行为
				int insertCount = successKilledDao.insertSuccessKill(seckillId, userPhone);
				if(insertCount<=0) {
					throw new RepectException("killed repeat");
				}else {
					SuccessKilled successKilled = successKilledDao.queryByIdWithSuccessKill(seckillId, userPhone);
					return new executeResult(seckillId,SeckillStatusEnum.SUCCESS, successKilled);
				}
			}
		} catch (SeckillCloseException e1) {
			throw e1;
		} catch(RepectException e2) {
			throw e2;
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SeckillException("seckill inner error"+e.getMessage());
		}
	}
}

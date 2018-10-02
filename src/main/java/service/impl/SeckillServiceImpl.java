package service.impl;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import dao.SeckillDao;
import dao.SuccessKilledDao;
import dto.Seckill;
import dto.SuccessKilled;
import exception.RepectException;
import exception.SeckillCloseException;
import exception.SeckillException;
import service.SeckillService;
import vo.Exposer;
import vo.executeResult;
public class SeckillServiceImpl implements SeckillService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private SeckillDao seckillDao;
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
		if(seckill!=null) {
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

	public executeResult executeSeckill(long seckillId, long userPhone, String md5)  throws RepectException,SeckillCloseException,SeckillException{
		try {
			
			if(md5 == null || md5.equals(getMd5(seckillId))) {
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
					return new executeResult(seckillId, 1, "秒杀成功", successKilled);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SeckillException("seckill inner error"+e.getMessage());
		}
	}
}

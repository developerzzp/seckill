package service;

import java.util.List;


import dto.Seckill;
import vo.Exposer;
import vo.executeResult;

/**
 * 业务接口：站在使用者的的角度设计接口
 * @author developerzzp
 *
 *1.方法定义粒度
 *{
 *1.执行秒杀
 *}
 *2.参数
 *3.返回类型
 */
public interface SeckillService {
	/**
	 * 查询所有秒杀记录
	 * @return
	 */
	List<Seckill> getSeckillList();
	
	/**
	 * 查询单个秒杀记录
	 * @param seckillId
	 * @return
	 */
	Seckill getOneSeckill(long seckillId);
	/**
	 * 秒杀开始时输出秒杀接口,否则输出系统时间
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	/**
	 * 执行秒杀
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 * @return 
	 */
	executeResult executeSeckill(long seckillId,long userPhone,String md5);
	
}

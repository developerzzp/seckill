package dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import dto.Seckill;

public interface SeckillDao {
	/**
	 * 秒杀成功,减库存
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime")Date killTime);
	/**
	 * 查询偏移量查询秒杀商品列表
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * 查询偏移量查询秒杀商品列表
	 * @return
	 */
	List<Seckill> queryAll();
}

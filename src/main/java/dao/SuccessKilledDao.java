package dao;


import org.apache.ibatis.annotations.Param;

import dto.SuccessKilled;

public interface SuccessKilledDao {
	/**
	 * 插入成功秒杀商品信息
	 * @param successKilled
	 * @return
	 */
	int insertSuccessKill(@Param("seckillId") long seckillId,@Param("userPhone")long userPhone);
	/**
	 * 
	 * @param seckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSuccessKill(long seckillId,@Param("userPhone")long userPhone);

}

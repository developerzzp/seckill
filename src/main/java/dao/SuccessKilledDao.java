package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dto.SuccessKilled;

public interface SuccessKilledDao {
	/**
	 * 插入成功秒杀商品信息
	 * @param successKilled
	 * @return
	 */
	int insertSuccessKill(@Param("seckillId") long seckillId,@Param("userPhone")String userPhone);
	/**
	 * 
	 * @param seckillId
	 * @return
	 */
	List<SuccessKilled> queryByIdWithSuccessKill(long seckillId);

}

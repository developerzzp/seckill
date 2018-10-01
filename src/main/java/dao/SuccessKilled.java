package dao;

import java.util.List;

public interface SuccessKilled {
	/**
	 * 插入成功秒杀商品信息
	 * @param successKilled
	 * @return
	 */
	int insertSuccessKill(long seckillId,String userPhone);
	/**
	 * 
	 * @param seckillId
	 * @return
	 */
	List<SuccessKilled> queryByIdWithSuccessKill(long seckillId);

}

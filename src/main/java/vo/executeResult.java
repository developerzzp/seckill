package vo;

import dto.SuccessKilled;

public class executeResult {
	private long seckillId;
	private int status;
	private String statsInfo;
	/**
	 * 秒杀成功对象
	 */
	
	
	private SuccessKilled successKilled;
	public executeResult(long seckillId, int status, String statsInfo, SuccessKilled successKilled) {
		super();
		this.seckillId = seckillId;
		this.status = status;
		this.statsInfo = statsInfo;
		this.successKilled = successKilled;
	}
	
	
	public executeResult(long seckillId, int status, String statsInfo) {
		super();
		this.seckillId = seckillId;
		this.status = status;
		this.statsInfo = statsInfo;
	}


	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatsInfo() {
		return statsInfo;
	}
	public void setStatsInfo(String statsInfo) {
		this.statsInfo = statsInfo;
	}
	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}
	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}
}

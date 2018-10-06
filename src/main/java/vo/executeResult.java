package vo;


import dto.SuccessKilled;
import enums.SeckillStatusEnum;
public class executeResult {
	private long seckillId;
	private int status;
	private String statsInfo;
	private SuccessKilled successKilled;
	public executeResult(long seckillId, SeckillStatusEnum seckillStatusEnum, SuccessKilled successKilled) {
		this.seckillId = seckillId;
		this.status = seckillStatusEnum.getStatus();
		this.statsInfo = seckillStatusEnum.getStatusInfo();
		this.successKilled = successKilled;
	}
	public executeResult(long seckillId, SeckillStatusEnum statEnum) {
		super();
		this.seckillId = seckillId;
		this.status = statEnum.getStatus();
		this.statsInfo = statEnum.getStatusInfo();
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

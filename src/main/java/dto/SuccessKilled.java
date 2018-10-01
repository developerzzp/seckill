package dto;

import java.util.Date;

public class SuccessKilled {
	private long seckillId;
	private String userPhone;
	private short status;
	private Date createTime;
	private Seckill seckill;
	@Override
	public String toString() {
		return "SuccessKilled [seckillId=" + seckillId + ", user_phone=" + userPhone + ", status=" + status
				+ ", createTime=" + createTime + ", seckill=" + seckill + "]";
	}
	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Seckill getSeckill() {
		return seckill;
	}
	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
}

package com.baobab.m.vo;

import java.util.Date;

public class CouponCpVO {
	private int seq_num;
	private String serial_num;
	private int cp_seq;
	private String cp_name;
	private String cou_title;
	private String cou_intro;
	private String cou_kind;
	private int buy_ea;
	private int use_ea;
//	private int remain_ea;
	private int dl_user_ea;
	private Date buy_date;
	private Date period;
	private String status;
	private String orderNum;

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public CouponCpVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CouponCpVO [seq_num=" + seq_num + ", serial_num=" + serial_num + ", cp_seq=" + cp_seq + ", cp_name="
				+ cp_name + ", cou_title=" + cou_title + ", cou_intro=" + cou_intro + ", cou_kind=" + cou_kind
				+ ", buy_ea=" + buy_ea + ", use_ea=" + use_ea + ", dl_user_ea=" + dl_user_ea + ", buy_date=" + buy_date
				+ ", period=" + period + ", status=" + status + ", orderNum=" + orderNum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buy_date == null) ? 0 : buy_date.hashCode());
		result = prime * result + buy_ea;
		result = prime * result + ((cou_intro == null) ? 0 : cou_intro.hashCode());
		result = prime * result + ((cou_kind == null) ? 0 : cou_kind.hashCode());
		result = prime * result + ((cou_title == null) ? 0 : cou_title.hashCode());
		result = prime * result + ((cp_name == null) ? 0 : cp_name.hashCode());
		result = prime * result + cp_seq;
		result = prime * result + dl_user_ea;
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result + seq_num;
		result = prime * result + ((serial_num == null) ? 0 : serial_num.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + use_ea;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CouponCpVO other = (CouponCpVO) obj;
		if (buy_date == null) {
			if (other.buy_date != null)
				return false;
		} else if (!buy_date.equals(other.buy_date))
			return false;
		if (buy_ea != other.buy_ea)
			return false;
		if (cou_intro == null) {
			if (other.cou_intro != null)
				return false;
		} else if (!cou_intro.equals(other.cou_intro))
			return false;
		if (cou_kind == null) {
			if (other.cou_kind != null)
				return false;
		} else if (!cou_kind.equals(other.cou_kind))
			return false;
		if (cou_title == null) {
			if (other.cou_title != null)
				return false;
		} else if (!cou_title.equals(other.cou_title))
			return false;
		if (cp_name == null) {
			if (other.cp_name != null)
				return false;
		} else if (!cp_name.equals(other.cp_name))
			return false;
		if (cp_seq != other.cp_seq)
			return false;
		if (dl_user_ea != other.dl_user_ea)
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (seq_num != other.seq_num)
			return false;
		if (serial_num == null) {
			if (other.serial_num != null)
				return false;
		} else if (!serial_num.equals(other.serial_num))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (use_ea != other.use_ea)
			return false;
		return true;
	}

	public String getSerial_num() {
		return serial_num;
	}

	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}

	public int getCp_seq() {
		return cp_seq;
	}

	public void setCp_seq(int cp_seq) {
		this.cp_seq = cp_seq;
	}

	public String getCp_name() {
		return cp_name;
	}

	public CouponCpVO(int seq_num, String serial_num, int cp_seq, String cp_name, String cou_title, String cou_intro,
			String cou_kind, int buy_ea, int use_ea, int dl_user_ea, Date buy_date, Date period, String status, String orderNum) {
		super();
		this.seq_num = seq_num;
		this.serial_num = serial_num;
		this.cp_seq = cp_seq;
		this.cp_name = cp_name;
		this.cou_title = cou_title;
		this.cou_intro = cou_intro;
		this.cou_kind = cou_kind;
		this.buy_ea = buy_ea;
		this.use_ea = use_ea;
		this.dl_user_ea = dl_user_ea;
		this.buy_date = buy_date;
		this.period = period;
		this.status = status;
		this.orderNum = orderNum;
	}

	public int getSeq_num() {
		return seq_num;
	}

	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}

	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}

	public String getCou_title() {
		return cou_title;
	}

	public void setCou_title(String cou_title) {
		this.cou_title = cou_title;
	}

	public String getCou_intro() {
		return cou_intro;
	}

	public void setCou_intro(String cou_intro) {
		this.cou_intro = cou_intro;
	}

	public String getCou_kind() {
		return cou_kind;
	}

	public void setCou_kind(String cou_kind) {
		this.cou_kind = cou_kind;
	}

	public int getBuy_ea() {
		return buy_ea;
	}

	public void setBuy_ea(int buy_ea) {
		this.buy_ea = buy_ea;
	}

	public int getUse_ea() {
		return use_ea;
	}

	public void setUse_ea(int use_ea) {
		this.use_ea = use_ea;
	}

	public int getDl_user_ea() {
		return dl_user_ea;
	}

	public void setDl_user_ea(int dl_user_ea) {
		this.dl_user_ea = dl_user_ea;
	}

	public Date getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}

	public Date getPeriod() {
		return period;
	}

	public void setPeriod(Date period) {
		this.period = period;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

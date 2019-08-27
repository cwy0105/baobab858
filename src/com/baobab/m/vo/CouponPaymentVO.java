package com.baobab.m.vo;

import java.util.Date;

public class CouponPaymentVO {

	private int seq_num;
	private String goods;
	private int disPrice;
	private String userPhone;
	private String email;
	private int cpSeq;
	private String tid;
	private String status;
	private Date buy_date;
	private Date cancel_date;
	private String orderNum;
	private String payCode;

	public CouponPaymentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CouponPaymentVO(int seq_num, String goods, int disPrice, String userPhone, String email, int cpSeq,
			String tid, String status, Date buy_date, Date cancel_date, String orderNum, String payCode) {
		super();
		this.seq_num = seq_num;
		this.goods = goods;
		this.disPrice = disPrice;
		this.userPhone = userPhone;
		this.email = email;
		this.cpSeq = cpSeq;
		this.tid = tid;
		this.status = status;
		this.buy_date = buy_date;
		this.cancel_date = cancel_date;
		this.orderNum = orderNum;
		this.payCode = payCode;
	}

	public int getSeq_num() {
		return seq_num;
	}

	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public int getDisPrice() {
		return disPrice;
	}

	public void setDisPrice(int disPrice) {
		this.disPrice = disPrice;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCpSeq() {
		return cpSeq;
	}

	public void setCpSeq(int cpSeq) {
		this.cpSeq = cpSeq;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}

	public Date getCancel_date() {
		return cancel_date;
	}

	public void setCancel_date(Date cancel_date) {
		this.cancel_date = cancel_date;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buy_date == null) ? 0 : buy_date.hashCode());
		result = prime * result + ((cancel_date == null) ? 0 : cancel_date.hashCode());
		result = prime * result + cpSeq;
		result = prime * result + disPrice;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((payCode == null) ? 0 : payCode.hashCode());
		result = prime * result + seq_num;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		result = prime * result + ((userPhone == null) ? 0 : userPhone.hashCode());
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
		CouponPaymentVO other = (CouponPaymentVO) obj;
		if (buy_date == null) {
			if (other.buy_date != null)
				return false;
		} else if (!buy_date.equals(other.buy_date))
			return false;
		if (cancel_date == null) {
			if (other.cancel_date != null)
				return false;
		} else if (!cancel_date.equals(other.cancel_date))
			return false;
		if (cpSeq != other.cpSeq)
			return false;
		if (disPrice != other.disPrice)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (payCode == null) {
			if (other.payCode != null)
				return false;
		} else if (!payCode.equals(other.payCode))
			return false;
		if (seq_num != other.seq_num)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		if (userPhone == null) {
			if (other.userPhone != null)
				return false;
		} else if (!userPhone.equals(other.userPhone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CouponPaymentVO [seq_num=" + seq_num + ", goods=" + goods + ", disPrice=" + disPrice + ", userPhone="
				+ userPhone + ", email=" + email + ", cpSeq=" + cpSeq + ", tid=" + tid + ", status=" + status
				+ ", buy_date=" + buy_date + ", cancel_date=" + cancel_date + ", orderNum=" + orderNum + ", payCode="
				+ payCode + "]";
	}

}

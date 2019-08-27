package com.baobab.m.vo;

import java.util.Date;

public class CallHistoryVO {
	private int seq_num;
	private String user_phone;
	private String cp_phone;
	private String cp_name;
	private String cp_address;
	private Date call_date;
	private String cp_div;
	public CallHistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CallHistoryVO(int seq_num, String user_phone, String cp_phone, String cp_name, String cp_address,
			Date call_date, String cp_div) {
		super();
		this.seq_num = seq_num;
		this.user_phone = user_phone;
		this.cp_phone = cp_phone;
		this.cp_name = cp_name;
		this.cp_address = cp_address;
		this.call_date = call_date;
		this.cp_div = cp_div;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getCp_phone() {
		return cp_phone;
	}
	public void setCp_phone(String cp_phone) {
		this.cp_phone = cp_phone;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public String getCp_address() {
		return cp_address;
	}
	public void setCp_address(String cp_address) {
		this.cp_address = cp_address;
	}
	public Date getCall_date() {
		return call_date;
	}
	public void setCall_date(Date call_date) {
		this.call_date = call_date;
	}
	public String getCp_div() {
		return cp_div;
	}
	public void setCp_div(String cp_div) {
		this.cp_div = cp_div;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((call_date == null) ? 0 : call_date.hashCode());
		result = prime * result + ((cp_address == null) ? 0 : cp_address.hashCode());
		result = prime * result + ((cp_div == null) ? 0 : cp_div.hashCode());
		result = prime * result + ((cp_name == null) ? 0 : cp_name.hashCode());
		result = prime * result + ((cp_phone == null) ? 0 : cp_phone.hashCode());
		result = prime * result + seq_num;
		result = prime * result + ((user_phone == null) ? 0 : user_phone.hashCode());
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
		CallHistoryVO other = (CallHistoryVO) obj;
		if (call_date == null) {
			if (other.call_date != null)
				return false;
		} else if (!call_date.equals(other.call_date))
			return false;
		if (cp_address == null) {
			if (other.cp_address != null)
				return false;
		} else if (!cp_address.equals(other.cp_address))
			return false;
		if (cp_div == null) {
			if (other.cp_div != null)
				return false;
		} else if (!cp_div.equals(other.cp_div))
			return false;
		if (cp_name == null) {
			if (other.cp_name != null)
				return false;
		} else if (!cp_name.equals(other.cp_name))
			return false;
		if (cp_phone == null) {
			if (other.cp_phone != null)
				return false;
		} else if (!cp_phone.equals(other.cp_phone))
			return false;
		if (seq_num != other.seq_num)
			return false;
		if (user_phone == null) {
			if (other.user_phone != null)
				return false;
		} else if (!user_phone.equals(other.user_phone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CallHistoryVO [seq_num=" + seq_num + ", user_phone=" + user_phone + ", cp_phone=" + cp_phone
				+ ", cp_name=" + cp_name + ", cp_address=" + cp_address + ", call_date=" + call_date + ", cp_div="
				+ cp_div + "]";
	}
	
}

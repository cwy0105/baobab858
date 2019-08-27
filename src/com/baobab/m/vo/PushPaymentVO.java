package com.baobab.m.vo;

import java.util.Date;

public class PushPaymentVO {
	private String menu_name;
	private int all_ea;
	private int ea;
	private int pay;
	private String name;
	private String email;
	private String tid;
	private Date buy_date;
	private String cp_name;
	private String acc_num;
	private String tu_num;
	private String bl_num;
	private String status;
	private Date cancel_date;
	private int cp_seq;
	
	public PushPaymentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getAll_ea() {
		return all_ea;
	}
	

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public void setAll_ea(int all_ea) {
		this.all_ea = all_ea;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}

	public String getCp_name() {
		return cp_name;
	}

	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}

	public String getAcc_num() {
		return acc_num;
	}

	public void setAcc_num(String acc_num) {
		this.acc_num = acc_num;
	}

	public String getTu_num() {
		return tu_num;
	}

	public void setTu_num(String tu_num) {
		this.tu_num = tu_num;
	}

	public String getBl_num() {
		return bl_num;
	}

	public void setBl_num(String bl_num) {
		this.bl_num = bl_num;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCancel_date() {
		return cancel_date;
	}

	public void setCancel_date(Date cancel_date) {
		this.cancel_date = cancel_date;
	}

	public int getCp_seq() {
		return cp_seq;
	}

	public void setCp_seq(int cp_seq) {
		this.cp_seq = cp_seq;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acc_num == null) ? 0 : acc_num.hashCode());
		result = prime * result + all_ea;
		result = prime * result + ((bl_num == null) ? 0 : bl_num.hashCode());
		result = prime * result + ((buy_date == null) ? 0 : buy_date.hashCode());
		result = prime * result + ((cancel_date == null) ? 0 : cancel_date.hashCode());
		result = prime * result + ((cp_name == null) ? 0 : cp_name.hashCode());
		result = prime * result + cp_seq;
		result = prime * result + ea;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((menu_name == null) ? 0 : menu_name.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pay;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		result = prime * result + ((tu_num == null) ? 0 : tu_num.hashCode());
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
		PushPaymentVO other = (PushPaymentVO) obj;
		if (acc_num == null) {
			if (other.acc_num != null)
				return false;
		} else if (!acc_num.equals(other.acc_num))
			return false;
		if (all_ea != other.all_ea)
			return false;
		if (bl_num == null) {
			if (other.bl_num != null)
				return false;
		} else if (!bl_num.equals(other.bl_num))
			return false;
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
		if (cp_name == null) {
			if (other.cp_name != null)
				return false;
		} else if (!cp_name.equals(other.cp_name))
			return false;
		if (cp_seq != other.cp_seq)
			return false;
		if (ea != other.ea)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (menu_name == null) {
			if (other.menu_name != null)
				return false;
		} else if (!menu_name.equals(other.menu_name))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pay != other.pay)
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
		if (tu_num == null) {
			if (other.tu_num != null)
				return false;
		} else if (!tu_num.equals(other.tu_num))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PushPaymentVO [menu_name=" + menu_name + ", all_ea=" + all_ea + ", ea=" + ea + ", pay=" + pay
				+ ", name=" + name + ", email=" + email + ", tid=" + tid + ", buy_date=" + buy_date + ", cp_name="
				+ cp_name + ", acc_num=" + acc_num + ", tu_num=" + tu_num + ", bl_num=" + bl_num + ", status=" + status
				+ ", cancel_date=" + cancel_date + ", cp_seq=" + cp_seq + "]";
	}

	
	
}

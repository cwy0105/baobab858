package com.baobab.m.vo;

import java.util.Date;

public class BasketVO {
	private String email;
	private String cp_name;
	private int cp_seq;
	private String menu_name;
	private String option;
	private int ea;
	private int menu_pay;
	private int dis_price;
	private Date date;
	private int seq_num;
	public BasketVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BasketVO(String email, String cp_name, int cp_seq, String menu_name, String option, int ea, int menu_pay,
			int dis_price, Date date, int seq_num) {
		super();
		this.email = email;
		this.cp_name = cp_name;
		this.cp_seq = cp_seq;
		this.menu_name = menu_name;
		this.option = option;
		this.ea = ea;
		this.menu_pay = menu_pay;
		this.dis_price = dis_price;
		this.date = date;
		this.seq_num = seq_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public int getCp_seq() {
		return cp_seq;
	}
	public void setCp_seq(int cp_seq) {
		this.cp_seq = cp_seq;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public int getMenu_pay() {
		return menu_pay;
	}
	public void setMenu_pay(int menu_pay) {
		this.menu_pay = menu_pay;
	}
	public int getDis_price() {
		return dis_price;
	}
	public void setDis_price(int dis_price) {
		this.dis_price = dis_price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cp_name == null) ? 0 : cp_name.hashCode());
		result = prime * result + cp_seq;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + dis_price;
		result = prime * result + ea;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((menu_name == null) ? 0 : menu_name.hashCode());
		result = prime * result + menu_pay;
		result = prime * result + ((option == null) ? 0 : option.hashCode());
		result = prime * result + seq_num;
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
		BasketVO other = (BasketVO) obj;
		if (cp_name == null) {
			if (other.cp_name != null)
				return false;
		} else if (!cp_name.equals(other.cp_name))
			return false;
		if (cp_seq != other.cp_seq)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dis_price != other.dis_price)
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
		if (menu_pay != other.menu_pay)
			return false;
		if (option == null) {
			if (other.option != null)
				return false;
		} else if (!option.equals(other.option))
			return false;
		if (seq_num != other.seq_num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BasketVO [email=" + email + ", cp_name=" + cp_name + ", cp_seq=" + cp_seq + ", menu_name=" + menu_name
				+ ", option=" + option + ", ea=" + ea + ", menu_pay=" + menu_pay + ", dis_price=" + dis_price
				+ ", date=" + date + ", seq_num=" + seq_num + "]";
	}
	
	
}

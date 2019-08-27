package com.baobab.m.vo;

import java.util.Date;

public class AdminLoginHistoryVO {
	private int seq_num;
	private String email;
	private Date login_date;
	public AdminLoginHistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminLoginHistoryVO(int seq_num, String email, Date login_date) {
		super();
		this.seq_num = seq_num;
		this.email = email;
		this.login_date = login_date;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLogin_date() {
		return login_date;
	}
	public void setLogin_date(Date login_date) {
		this.login_date = login_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((login_date == null) ? 0 : login_date.hashCode());
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
		AdminLoginHistoryVO other = (AdminLoginHistoryVO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (login_date == null) {
			if (other.login_date != null)
				return false;
		} else if (!login_date.equals(other.login_date))
			return false;
		if (seq_num != other.seq_num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AdminLoginHistoryVO [seq_num=" + seq_num + ", email=" + email + ", login_date=" + login_date + "]";
	}
}

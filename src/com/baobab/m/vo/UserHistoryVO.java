package com.baobab.m.vo;

import java.util.Date;

public class UserHistoryVO {
	private int seqNum;
	private String email;
	private String div_code;
	private Date change_date;
	public UserHistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserHistoryVO(int seqNum, String email, String div_code, Date change_date) {
		super();
		this.seqNum = seqNum;
		this.email = email;
		this.div_code = div_code;
		this.change_date = change_date;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiv_code() {
		return div_code;
	}
	public void setDiv_code(String div_code) {
		this.div_code = div_code;
	}
	public Date getChange_date() {
		return change_date;
	}
	public void setChange_date(Date change_date) {
		this.change_date = change_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((change_date == null) ? 0 : change_date.hashCode());
		result = prime * result + ((div_code == null) ? 0 : div_code.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + seqNum;
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
		UserHistoryVO other = (UserHistoryVO) obj;
		if (change_date == null) {
			if (other.change_date != null)
				return false;
		} else if (!change_date.equals(other.change_date))
			return false;
		if (div_code == null) {
			if (other.div_code != null)
				return false;
		} else if (!div_code.equals(other.div_code))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (seqNum != other.seqNum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserHistoryVO [seqNum=" + seqNum + ", email=" + email + ", div_code=" + div_code + ", change_date="
				+ change_date + "]";
	}
}

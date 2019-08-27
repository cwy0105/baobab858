package com.baobab.m.vo;

import java.util.Date;

public class AdminVisitantVO {
	private int seq_num;
	private String user_phone;
	private Date visit_date;
	private String email;
	private String div_code;
	private int cnt;
	private String startDate;
	private String endDate;
	public AdminVisitantVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminVisitantVO(int seq_num, String user_phone, Date visit_date, String email, String div_code, int cnt,
			String startDate, String endDate) {
		super();
		this.seq_num = seq_num;
		this.user_phone = user_phone;
		this.visit_date = visit_date;
		this.email = email;
		this.div_code = div_code;
		this.cnt = cnt;
		this.startDate = startDate;
		this.endDate = endDate;
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
	public Date getVisit_date() {
		return visit_date;
	}
	public void setVisit_date(Date visit_date) {
		this.visit_date = visit_date;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cnt;
		result = prime * result + ((div_code == null) ? 0 : div_code.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + seq_num;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((user_phone == null) ? 0 : user_phone.hashCode());
		result = prime * result + ((visit_date == null) ? 0 : visit_date.hashCode());
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
		AdminVisitantVO other = (AdminVisitantVO) obj;
		if (cnt != other.cnt)
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
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (seq_num != other.seq_num)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (user_phone == null) {
			if (other.user_phone != null)
				return false;
		} else if (!user_phone.equals(other.user_phone))
			return false;
		if (visit_date == null) {
			if (other.visit_date != null)
				return false;
		} else if (!visit_date.equals(other.visit_date))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AdminVisitantVO [seq_num=" + seq_num + ", user_phone=" + user_phone + ", visit_date=" + visit_date
				+ ", email=" + email + ", div_code=" + div_code + ", cnt=" + cnt + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
}

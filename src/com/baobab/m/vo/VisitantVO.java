package com.baobab.m.vo;

public class VisitantVO {
	private int seq_num;
	private String user_phone;
	private int visit_num;
	private String last_visit_date;
	public VisitantVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VisitantVO(int seq_num, String user_phone, int visit_num, String last_visit_date) {
		super();
		this.seq_num = seq_num;
		this.user_phone = user_phone;
		this.visit_num = visit_num;
		this.last_visit_date = last_visit_date;
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
	public int getVisit_num() {
		return visit_num;
	}
	public void setVisit_num(int visit_num) {
		this.visit_num = visit_num;
	}
	public String getLast_visit_date() {
		return last_visit_date;
	}
	public void setLast_visit_date(String last_visit_date) {
		this.last_visit_date = last_visit_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((last_visit_date == null) ? 0 : last_visit_date.hashCode());
		result = prime * result + seq_num;
		result = prime * result + ((user_phone == null) ? 0 : user_phone.hashCode());
		result = prime * result + visit_num;
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
		VisitantVO other = (VisitantVO) obj;
		if (last_visit_date == null) {
			if (other.last_visit_date != null)
				return false;
		} else if (!last_visit_date.equals(other.last_visit_date))
			return false;
		if (seq_num != other.seq_num)
			return false;
		if (user_phone == null) {
			if (other.user_phone != null)
				return false;
		} else if (!user_phone.equals(other.user_phone))
			return false;
		if (visit_num != other.visit_num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "VisitantVO [seq_num=" + seq_num + ", user_phone=" + user_phone + ", visit_num=" + visit_num
				+ ", last_visit_date=" + last_visit_date + "]";
	}
	
}

package com.baobab.m.vo;

import java.util.Date;

public class VisitantHistoryVO {
	private int seq_num;
	private String user_phone;
	private String visit_type;
	private Date visit_date;
	public VisitantHistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VisitantHistoryVO(int seq_num, String user_phone, String visit_type, Date visit_date) {
		super();
		this.seq_num = seq_num;
		this.user_phone = user_phone;
		this.visit_type = visit_type;
		this.visit_date = visit_date;
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
	public String getVisit_type() {
		return visit_type;
	}
	public void setVisit_type(String visit_type) {
		this.visit_type = visit_type;
	}
	public Date getVisit_date() {
		return visit_date;
	}
	public void setVisit_date(Date visit_date) {
		this.visit_date = visit_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seq_num;
		result = prime * result + ((user_phone == null) ? 0 : user_phone.hashCode());
		result = prime * result + ((visit_date == null) ? 0 : visit_date.hashCode());
		result = prime * result + ((visit_type == null) ? 0 : visit_type.hashCode());
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
		VisitantHistoryVO other = (VisitantHistoryVO) obj;
		if (seq_num != other.seq_num)
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
		if (visit_type == null) {
			if (other.visit_type != null)
				return false;
		} else if (!visit_type.equals(other.visit_type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "VisitantHistoryVO [seq_num=" + seq_num + ", user_phone=" + user_phone + ", visit_type=" + visit_type
				+ ", visit_date=" + visit_date + "]";
	}
}

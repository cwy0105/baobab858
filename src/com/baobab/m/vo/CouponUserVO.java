package com.baobab.m.vo;

import java.util.Date;

public class CouponUserVO {

	private int seq_num;
	private String serial_num;
	private String email;
	private int cp_seq;
	private String cp_name;
	private String cou_title;
	private String cou_intro;
	private Date period;
	private Date dl_date;
	public CouponUserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CouponUserVO(int seq_num, String serial_num, String email, int cp_seq, String cp_name, String cou_title,
			String cou_intro, Date period, Date dl_date) {
		super();
		this.seq_num = seq_num;
		this.serial_num = serial_num;
		this.email = email;
		this.cp_seq = cp_seq;
		this.cp_name = cp_name;
		this.cou_title = cou_title;
		this.cou_intro = cou_intro;
		this.period = period;
		this.dl_date = dl_date;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	public String getSerial_num() {
		return serial_num;
	}
	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	public Date getDl_date() {
		return dl_date;
	}
	public void setDl_date(Date dl_date) {
		this.dl_date = dl_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cou_intro == null) ? 0 : cou_intro.hashCode());
		result = prime * result + ((cou_title == null) ? 0 : cou_title.hashCode());
		result = prime * result + ((cp_name == null) ? 0 : cp_name.hashCode());
		result = prime * result + cp_seq;
		result = prime * result + ((dl_date == null) ? 0 : dl_date.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result + seq_num;
		result = prime * result + ((serial_num == null) ? 0 : serial_num.hashCode());
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
		CouponUserVO other = (CouponUserVO) obj;
		if (cou_intro == null) {
			if (other.cou_intro != null)
				return false;
		} else if (!cou_intro.equals(other.cou_intro))
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
		if (dl_date == null) {
			if (other.dl_date != null)
				return false;
		} else if (!dl_date.equals(other.dl_date))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		return true;
	}
	@Override
	public String toString() {
		return "CouponUserVO [seq_num=" + seq_num + ", serial_num=" + serial_num + ", email=" + email + ", cp_seq="
				+ cp_seq + ", cp_name=" + cp_name + ", cou_title=" + cou_title + ", cou_intro=" + cou_intro
				+ ", period=" + period + ", dl_date=" + dl_date + "]";
	}
	
	
}

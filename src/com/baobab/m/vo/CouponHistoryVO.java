package com.baobab.m.vo;

import java.util.Date;

public class CouponHistoryVO {
	private String serial_num;
	private String dl_user_email;
	private int cp_seq;
	private String status;
	private Date cur_date;
	private String title;
	private String cp_name;
	private String option;

	public CouponHistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CouponHistoryVO(String serial_num, String dl_user_email, int cp_seq, String status, Date cur_date,
			String title, String cp_name, String option) {
		super();
		this.serial_num = serial_num;
		this.dl_user_email = dl_user_email;
		this.cp_seq = cp_seq;
		this.status = status;
		this.cur_date = cur_date;
		this.title = title;
		this.cp_name = cp_name;
		this.option = option;
	}

	@Override
	public String toString() {
		return "CouponHistoryVO [serial_num=" + serial_num + ", dl_user_email=" + dl_user_email + ", cp_seq=" + cp_seq
				+ ", status=" + status + ", cur_date=" + cur_date + ", title=" + title + ", cp_name=" + cp_name
				+ ", option=" + option + "]";
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getCp_name() {
		return cp_name;
	}

	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}

	public String getSerial_num() {
		return serial_num;
	}

	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}

	public String getDl_user_email() {
		return dl_user_email;
	}

	public void setDl_user_email(String dl_user_email) {
		this.dl_user_email = dl_user_email;
	}

	public int getCp_seq() {
		return cp_seq;
	}

	public void setCp_seq(int cp_seq) {
		this.cp_seq = cp_seq;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCur_date() {
		return cur_date;
	}

	public void setCur_date(Date cur_date) {
		this.cur_date = cur_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cp_name == null) ? 0 : cp_name.hashCode());
		result = prime * result + cp_seq;
		result = prime * result + ((cur_date == null) ? 0 : cur_date.hashCode());
		result = prime * result + ((dl_user_email == null) ? 0 : dl_user_email.hashCode());
		result = prime * result + ((option == null) ? 0 : option.hashCode());
		result = prime * result + ((serial_num == null) ? 0 : serial_num.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		CouponHistoryVO other = (CouponHistoryVO) obj;
		if (cp_name == null) {
			if (other.cp_name != null)
				return false;
		} else if (!cp_name.equals(other.cp_name))
			return false;
		if (cp_seq != other.cp_seq)
			return false;
		if (cur_date == null) {
			if (other.cur_date != null)
				return false;
		} else if (!cur_date.equals(other.cur_date))
			return false;
		if (dl_user_email == null) {
			if (other.dl_user_email != null)
				return false;
		} else if (!dl_user_email.equals(other.dl_user_email))
			return false;
		if (option == null) {
			if (other.option != null)
				return false;
		} else if (!option.equals(other.option))
			return false;
		if (serial_num == null) {
			if (other.serial_num != null)
				return false;
		} else if (!serial_num.equals(other.serial_num))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}

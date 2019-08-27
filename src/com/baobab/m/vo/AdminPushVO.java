package com.baobab.m.vo;

import java.util.Date;

public class AdminPushVO {
	private int seq_num;
	private String writer;
	private String title;
	private String message;
	private String push_div;
	private Date push_date;
	public AdminPushVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminPushVO(int seq_num, String writer, String title, String message, String push_div, Date push_date) {
		super();
		this.seq_num = seq_num;
		this.writer = writer;
		this.title = title;
		this.message = message;
		this.push_div = push_div;
		this.push_date = push_date;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPush_div() {
		return push_div;
	}
	public void setPush_div(String push_div) {
		this.push_div = push_div;
	}
	public Date getPush_date() {
		return push_date;
	}
	public void setPush_date(Date push_date) {
		this.push_date = push_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((push_date == null) ? 0 : push_date.hashCode());
		result = prime * result + ((push_div == null) ? 0 : push_div.hashCode());
		result = prime * result + seq_num;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
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
		AdminPushVO other = (AdminPushVO) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (push_date == null) {
			if (other.push_date != null)
				return false;
		} else if (!push_date.equals(other.push_date))
			return false;
		if (push_div == null) {
			if (other.push_div != null)
				return false;
		} else if (!push_div.equals(other.push_div))
			return false;
		if (seq_num != other.seq_num)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AdminPushVO [seq_num=" + seq_num + ", writer=" + writer + ", title=" + title + ", message=" + message
				+ ", push_div=" + push_div + ", push_date=" + push_date + "]";
	}
}

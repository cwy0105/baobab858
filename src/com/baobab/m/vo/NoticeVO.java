package com.baobab.m.vo;

import java.util.Date;

public class NoticeVO {
	private int seq_num;
	private String writer;
	private String title;
	private String content;
	private String read_div;
	private Date noti_date;
	public NoticeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeVO(int seq_num, String writer, String title, String content, String read_div, Date noti_date) {
		super();
		this.seq_num = seq_num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.read_div = read_div;
		this.noti_date = noti_date;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRead_div() {
		return read_div;
	}
	public void setRead_div(String read_div) {
		this.read_div = read_div;
	}
	public Date getNoti_date() {
		return noti_date;
	}
	public void setNoti_date(Date noti_date) {
		this.noti_date = noti_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((noti_date == null) ? 0 : noti_date.hashCode());
		result = prime * result + ((read_div == null) ? 0 : read_div.hashCode());
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
		NoticeVO other = (NoticeVO) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (noti_date == null) {
			if (other.noti_date != null)
				return false;
		} else if (!noti_date.equals(other.noti_date))
			return false;
		if (read_div == null) {
			if (other.read_div != null)
				return false;
		} else if (!read_div.equals(other.read_div))
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
		return "NoticeVO [seq_num=" + seq_num + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", read_div=" + read_div + ", noti_date=" + noti_date + "]";
	}
}

package com.baobab.m.vo;

import java.util.Date;

public class CpPushVO {
	private String cpName;
	private int radius;
	private int fanEa;
	private int normalEa;
	private String title;
	private String message;
	private Date sendDate;
	private int seqNum;
	private int cpSeq;
	public CpPushVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CpPushVO(String cpName, int radius, int fanEa, int normalEa, String title, String message, Date sendDate,
			int seqNum, int cpSeq) {
		super();
		this.cpName = cpName;
		this.radius = radius;
		this.fanEa = fanEa;
		this.normalEa = normalEa;
		this.title = title;
		this.message = message;
		this.sendDate = sendDate;
		this.seqNum = seqNum;
		this.cpSeq = cpSeq;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getFanEa() {
		return fanEa;
	}
	public void setFanEa(int fanEa) {
		this.fanEa = fanEa;
	}
	public int getNormalEa() {
		return normalEa;
	}
	public void setNormalEa(int normalEa) {
		this.normalEa = normalEa;
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
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public int getCpSeq() {
		return cpSeq;
	}
	public void setCpSeq(int cpSeq) {
		this.cpSeq = cpSeq;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + cpSeq;
		result = prime * result + fanEa;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + normalEa;
		result = prime * result + radius;
		result = prime * result + ((sendDate == null) ? 0 : sendDate.hashCode());
		result = prime * result + seqNum;
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
		CpPushVO other = (CpPushVO) obj;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (cpSeq != other.cpSeq)
			return false;
		if (fanEa != other.fanEa)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (normalEa != other.normalEa)
			return false;
		if (radius != other.radius)
			return false;
		if (sendDate == null) {
			if (other.sendDate != null)
				return false;
		} else if (!sendDate.equals(other.sendDate))
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CpPushVO [cpName=" + cpName + ", radius=" + radius + ", fanEa=" + fanEa + ", normalEa=" + normalEa
				+ ", title=" + title + ", message=" + message + ", sendDate=" + sendDate + ", seqNum=" + seqNum
				+ ", cpSeq=" + cpSeq + "]";
	}
}

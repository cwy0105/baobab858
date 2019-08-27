package com.baobab.m.vo;

public class StatVO {
	private String cpName;
	private String startDate;
	private String endDate;
	private String selDate;
	@Override
	public String toString() {
		return "statVO [cpName=" + cpName + ", startDate=" + startDate + ", endDate=" + endDate + ", selDate=" + selDate
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((selDate == null) ? 0 : selDate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		StatVO other = (StatVO) obj;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (selDate == null) {
			if (other.selDate != null)
				return false;
		} else if (!selDate.equals(other.selDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
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
	public String getSelDate() {
		return selDate;
	}
	public void setSelDate(String selDate) {
		this.selDate = selDate;
	}
	public StatVO(String cpName, String startDate, String endDate, String selDate) {
		super();
		this.cpName = cpName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.selDate = selDate;
	}
	public StatVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}

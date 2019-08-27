package com.baobab.m.vo;

import java.util.Date;

public class CPHistoryVO {
	private int seqNum;
	private String cpName;
	private String ownerName;
	private int cpSales;
	private String bandName;
	private Date cpBandDate;
	private String franName;
	private double baobabCom;
	private double bandCom;
	private Date baobabConDate;
	private String cpGrade;
	private String cpLevel;
	private Date updateDate;
	public CPHistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CPHistoryVO(int seqNum, String cpName, String ownerName, int cpSales, String bandName, Date cpBandDate,
			String franName, double baobabCom, double bandCom, Date baobabConDate, String cpGrade, String cpLevel,
			Date updateDate) {
		super();
		this.seqNum = seqNum;
		this.cpName = cpName;
		this.ownerName = ownerName;
		this.cpSales = cpSales;
		this.bandName = bandName;
		this.cpBandDate = cpBandDate;
		this.franName = franName;
		this.baobabCom = baobabCom;
		this.bandCom = bandCom;
		this.baobabConDate = baobabConDate;
		this.cpGrade = cpGrade;
		this.cpLevel = cpLevel;
		this.updateDate = updateDate;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getCpSales() {
		return cpSales;
	}
	public void setCpSales(int cpSales) {
		this.cpSales = cpSales;
	}
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	public Date getCpBandDate() {
		return cpBandDate;
	}
	public void setCpBandDate(Date cpBandDate) {
		this.cpBandDate = cpBandDate;
	}
	public String getFranName() {
		return franName;
	}
	public void setFranName(String franName) {
		this.franName = franName;
	}
	public double getBaobabCom() {
		return baobabCom;
	}
	public void setBaobabCom(double baobabCom) {
		this.baobabCom = baobabCom;
	}
	public double getBandCom() {
		return bandCom;
	}
	public void setBandCom(double bandCom) {
		this.bandCom = bandCom;
	}
	public Date getBaobabConDate() {
		return baobabConDate;
	}
	public void setBaobabConDate(Date baobabConDate) {
		this.baobabConDate = baobabConDate;
	}
	public String getCpGrade() {
		return cpGrade;
	}
	public void setCpGrade(String cpGrade) {
		this.cpGrade = cpGrade;
	}
	public String getCpLevel() {
		return cpLevel;
	}
	public void setCpLevel(String cpLevel) {
		this.cpLevel = cpLevel;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bandCom);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((bandName == null) ? 0 : bandName.hashCode());
		temp = Double.doubleToLongBits(baobabCom);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((baobabConDate == null) ? 0 : baobabConDate.hashCode());
		result = prime * result + ((cpBandDate == null) ? 0 : cpBandDate.hashCode());
		result = prime * result + ((cpGrade == null) ? 0 : cpGrade.hashCode());
		result = prime * result + ((cpLevel == null) ? 0 : cpLevel.hashCode());
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + cpSales;
		result = prime * result + ((franName == null) ? 0 : franName.hashCode());
		result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
		result = prime * result + seqNum;
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
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
		CPHistoryVO other = (CPHistoryVO) obj;
		if (Double.doubleToLongBits(bandCom) != Double.doubleToLongBits(other.bandCom))
			return false;
		if (bandName == null) {
			if (other.bandName != null)
				return false;
		} else if (!bandName.equals(other.bandName))
			return false;
		if (Double.doubleToLongBits(baobabCom) != Double.doubleToLongBits(other.baobabCom))
			return false;
		if (baobabConDate == null) {
			if (other.baobabConDate != null)
				return false;
		} else if (!baobabConDate.equals(other.baobabConDate))
			return false;
		if (cpBandDate == null) {
			if (other.cpBandDate != null)
				return false;
		} else if (!cpBandDate.equals(other.cpBandDate))
			return false;
		if (cpGrade == null) {
			if (other.cpGrade != null)
				return false;
		} else if (!cpGrade.equals(other.cpGrade))
			return false;
		if (cpLevel == null) {
			if (other.cpLevel != null)
				return false;
		} else if (!cpLevel.equals(other.cpLevel))
			return false;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (cpSales != other.cpSales)
			return false;
		if (franName == null) {
			if (other.franName != null)
				return false;
		} else if (!franName.equals(other.franName))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CPHistoryVO [seqNum=" + seqNum + ", cpName=" + cpName + ", ownerName=" + ownerName + ", cpSales="
				+ cpSales + ", bandName=" + bandName + ", cpBandDate=" + cpBandDate + ", franName=" + franName
				+ ", baobabCom=" + baobabCom + ", bandCom=" + bandCom + ", baobabConDate=" + baobabConDate
				+ ", cpGrade=" + cpGrade + ", cpLevel=" + cpLevel + ", updateDate=" + updateDate + "]";
	}
	
	
}

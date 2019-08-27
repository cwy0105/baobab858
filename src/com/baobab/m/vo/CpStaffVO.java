package com.baobab.m.vo;

import java.util.Date;

public class CpStaffVO {

	private int seqNum;
	private String email;
	private String staffPhone;
	private String staffName;
	private String staffGender;
	private String divCode;
	private int cpSeq;
	private Date registDate;
	private String status;
	
	public CpStaffVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CpStaffVO(int seqNum, String email, String staffPhone, String staffName, String staffGender, String divCode,
			int cpSeq, Date registDate, String status) {
		super();
		this.seqNum = seqNum;
		this.email = email;
		this.staffPhone = staffPhone;
		this.staffName = staffName;
		this.staffGender = staffGender;
		this.divCode = divCode;
		this.cpSeq = cpSeq;
		this.registDate = registDate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "CpStaffVO [seqNum=" + seqNum + ", email=" + email + ", staffPhone=" + staffPhone + ", staffName="
				+ staffName + ", staffGender=" + staffGender + ", divCode=" + divCode + ", cpSeq=" + cpSeq
				+ ", registDate=" + registDate + ", status=" + status + "]";
	}

	public int getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffGender() {
		return staffGender;
	}

	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}

	public String getDivCode() {
		return divCode;
	}

	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	public int getCpSeq() {
		return cpSeq;
	}

	public void setCpSeq(int cpSeq) {
		this.cpSeq = cpSeq;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}

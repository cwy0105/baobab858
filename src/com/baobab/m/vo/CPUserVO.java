package com.baobab.m.vo;

import java.util.Date;

public class CPUserVO {
	private String email;
	private String cpName;
	private String ownerName;
	private String license;
	private String cpLicenseNum;
	private String cpBankBookImg;
	private String account_holder;
	private String bank;
	private String accountNumber;
	private String cpSGL;
	private String cpEleTraCon;
	private Date con_date;
	private String cpCon;
	private String cpSSNum;
	private int push_ea;
	public CPUserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CPUserVO(String email, String cpName, String ownerName, String license, String cpLicenseNum,
			String cpBankBookImg, String account_holder, String bank, String accountNumber, String cpSGL,
			String cpEleTraCon, Date con_date, String cpCon, String cpSSNum, int push_ea) {
		super();
		this.email = email;
		this.cpName = cpName;
		this.ownerName = ownerName;
		this.license = license;
		this.cpLicenseNum = cpLicenseNum;
		this.cpBankBookImg = cpBankBookImg;
		this.account_holder = account_holder;
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.cpSGL = cpSGL;
		this.cpEleTraCon = cpEleTraCon;
		this.con_date = con_date;
		this.cpCon = cpCon;
		this.cpSSNum = cpSSNum;
		this.push_ea = push_ea;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getCpLicenseNum() {
		return cpLicenseNum;
	}
	public void setCpLicenseNum(String cpLicenseNum) {
		this.cpLicenseNum = cpLicenseNum;
	}
	public String getCpBankBookImg() {
		return cpBankBookImg;
	}
	public void setCpBankBookImg(String cpBankBookImg) {
		this.cpBankBookImg = cpBankBookImg;
	}
	public String getAccount_holder() {
		return account_holder;
	}
	public void setAccount_holder(String account_holder) {
		this.account_holder = account_holder;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCpSGL() {
		return cpSGL;
	}
	public void setCpSGL(String cpSGL) {
		this.cpSGL = cpSGL;
	}
	public String getCpEleTraCon() {
		return cpEleTraCon;
	}
	public void setCpEleTraCon(String cpEleTraCon) {
		this.cpEleTraCon = cpEleTraCon;
	}
	public Date getcon_date() {
		return con_date;
	}
	public void setcon_date(Date con_date) {
		this.con_date = con_date;
	}
	public String getCpCon() {
		return cpCon;
	}
	public void setCpCon(String cpCon) {
		this.cpCon = cpCon;
	}
	public String getCpSSNum() {
		return cpSSNum;
	}
	public void setCpSSNum(String cpSSNum) {
		this.cpSSNum = cpSSNum;
	}
	public int getPush_ea() {
		return push_ea;
	}
	public void setPush_ea(int push_ea) {
		this.push_ea = push_ea;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account_holder == null) ? 0 : account_holder.hashCode());
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result + ((con_date == null) ? 0 : con_date.hashCode());
		result = prime * result + ((cpBankBookImg == null) ? 0 : cpBankBookImg.hashCode());
		result = prime * result + ((cpCon == null) ? 0 : cpCon.hashCode());
		result = prime * result + ((cpEleTraCon == null) ? 0 : cpEleTraCon.hashCode());
		result = prime * result + ((cpLicenseNum == null) ? 0 : cpLicenseNum.hashCode());
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + ((cpSGL == null) ? 0 : cpSGL.hashCode());
		result = prime * result + ((cpSSNum == null) ? 0 : cpSSNum.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((license == null) ? 0 : license.hashCode());
		result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
		result = prime * result + push_ea;
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
		CPUserVO other = (CPUserVO) obj;
		if (account_holder == null) {
			if (other.account_holder != null)
				return false;
		} else if (!account_holder.equals(other.account_holder))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
			return false;
		if (con_date == null) {
			if (other.con_date != null)
				return false;
		} else if (!con_date.equals(other.con_date))
			return false;
		if (cpBankBookImg == null) {
			if (other.cpBankBookImg != null)
				return false;
		} else if (!cpBankBookImg.equals(other.cpBankBookImg))
			return false;
		if (cpCon == null) {
			if (other.cpCon != null)
				return false;
		} else if (!cpCon.equals(other.cpCon))
			return false;
		if (cpEleTraCon == null) {
			if (other.cpEleTraCon != null)
				return false;
		} else if (!cpEleTraCon.equals(other.cpEleTraCon))
			return false;
		if (cpLicenseNum == null) {
			if (other.cpLicenseNum != null)
				return false;
		} else if (!cpLicenseNum.equals(other.cpLicenseNum))
			return false;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (cpSGL == null) {
			if (other.cpSGL != null)
				return false;
		} else if (!cpSGL.equals(other.cpSGL))
			return false;
		if (cpSSNum == null) {
			if (other.cpSSNum != null)
				return false;
		} else if (!cpSSNum.equals(other.cpSSNum))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (license == null) {
			if (other.license != null)
				return false;
		} else if (!license.equals(other.license))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		if (push_ea != other.push_ea)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CPUserVO [email=" + email + ", cpName=" + cpName + ", ownerName=" + ownerName + ", license=" + license
				+ ", cpLicenseNum=" + cpLicenseNum + ", cpBankBookImg=" + cpBankBookImg + ", account_holder="
				+ account_holder + ", bank=" + bank + ", accountNumber=" + accountNumber + ", cpSGL=" + cpSGL
				+ ", cpEleTraCon=" + cpEleTraCon + ", con_date=" + con_date + ", cpCon=" + cpCon + ", cpSSNum=" + cpSSNum
				+ ", push_ea=" + push_ea + "]";
	}
}

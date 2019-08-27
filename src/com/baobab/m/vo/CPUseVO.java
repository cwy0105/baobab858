package com.baobab.m.vo;

import java.util.Date;

public class CPUseVO {
	private String email;
	private String CP_name;
	private String owner_name;
	private String CP_license;
	private String CP_license_num;
	private String CP_bankbook_img;
	private String account_holder;
	private String bank;
	private String account_number;
	private String CP_SGL;
	private String CP_Ele_Tra_con;
	private Date con_date;
	private String CP_con;
	private String CP_SS_NUM;
	private int push_ea;
	public CPUseVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CPUseVO(String email, String CP_name, String owner_name, String license, String cpLicenseNum,
			String CP_bankbook_img, String account_holder, String bank, String account_number, String CP_SGL,
			String CP_Ele_Tra_con, Date con_date, String CP_con, String CP_SS_NUM, int push_ea) {
		super();
		this.email = email;
		this.CP_name = CP_name;
		this.owner_name = owner_name;
		this.CP_license = license;
		this.CP_license_num = cpLicenseNum;
		this.CP_bankbook_img = CP_bankbook_img;
		this.account_holder = account_holder;
		this.bank = bank;
		this.account_number = account_number;
		this.CP_SGL = CP_SGL;
		this.CP_Ele_Tra_con = CP_Ele_Tra_con;
		this.con_date = con_date;
		this.CP_con = CP_con;
		this.CP_SS_NUM = CP_SS_NUM;
		this.push_ea = push_ea;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCP_name() {
		return CP_name;
	}
	public void setCP_name(String CP_name) {
		this.CP_name = CP_name;
	}
	public String getowner_name() {
		return owner_name;
	}
	public void setowner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getLicense() {
		return  CP_license;
	}
	public void setLicense(String license) {
		this.CP_license = license;
	}
	public String getCpLicenseNum() {
		return CP_license_num;
	}
	public void setCpLicenseNum(String cpLicenseNum) {
		this.CP_license_num = cpLicenseNum;
	}
	public String getCP_bankbook_img() {
		return CP_bankbook_img;
	}
	public void setCP_bankbook_img(String CP_bankbook_img) {
		this.CP_bankbook_img = CP_bankbook_img;
	}
	public String getaccount_holder() {
		return account_holder;
	}
	public void setaccount_holder(String account_holder) {
		this.account_holder = account_holder;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getaccount_number() {
		return account_number;
	}
	public void setaccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getCP_SGL() {
		return CP_SGL;
	}
	public void setCP_SGL(String CP_SGL) {
		this.CP_SGL = CP_SGL;
	}
	public String getCP_Ele_Tra_con() {
		return CP_Ele_Tra_con;
	}
	public void setCP_Ele_Tra_con(String CP_Ele_Tra_con) {
		this.CP_Ele_Tra_con = CP_Ele_Tra_con;
	}
	public Date getcon_date() {
		return con_date;
	}
	public void setcon_date(Date con_date) {
		this.con_date = con_date;
	}
	public String getCP_con() {
		return CP_con;
	}
	public void setCP_con(String CP_con) {
		this.CP_con = CP_con;
	}
	public String getCP_SS_NUM() {
		return CP_SS_NUM;
	}
	public void setCP_SS_NUM(String CP_SS_NUM) {
		this.CP_SS_NUM = CP_SS_NUM;
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
		result = prime * result + ((account_number == null) ? 0 : account_number.hashCode());
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result + ((con_date == null) ? 0 : con_date.hashCode());
		result = prime * result + ((CP_bankbook_img == null) ? 0 : CP_bankbook_img.hashCode());
		result = prime * result + ((CP_con == null) ? 0 : CP_con.hashCode());
		result = prime * result + ((CP_Ele_Tra_con == null) ? 0 : CP_Ele_Tra_con.hashCode());
		result = prime * result + ((CP_license_num == null) ? 0 : CP_license_num.hashCode());
		result = prime * result + ((CP_name == null) ? 0 : CP_name.hashCode());
		result = prime * result + ((CP_SGL == null) ? 0 : CP_SGL.hashCode());
		result = prime * result + ((CP_SS_NUM == null) ? 0 : CP_SS_NUM.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((CP_license == null) ? 0 : CP_license.hashCode());
		result = prime * result + ((owner_name == null) ? 0 : owner_name.hashCode());
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
		CPUseVO other = (CPUseVO) obj;
		if (account_holder == null) {
			if (other.account_holder != null)
				return false;
		} else if (!account_holder.equals(other.account_holder))
			return false;
		if (account_number == null) {
			if (other.account_number != null)
				return false;
		} else if (!account_number.equals(other.account_number))
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
		if (CP_bankbook_img == null) {
			if (other.CP_bankbook_img != null)
				return false;
		} else if (!CP_bankbook_img.equals(other.CP_bankbook_img))
			return false;
		if (CP_con == null) {
			if (other.CP_con != null)
				return false;
		} else if (!CP_con.equals(other.CP_con))
			return false;
		if (CP_Ele_Tra_con == null) {
			if (other.CP_Ele_Tra_con != null)
				return false;
		} else if (!CP_Ele_Tra_con.equals(other.CP_Ele_Tra_con))
			return false;
		if (CP_license_num == null) {
			if (other.CP_license_num != null)
				return false;
		} else if (!CP_license_num.equals(other.CP_license_num))
			return false;
		if (CP_name == null) {
			if (other.CP_name != null)
				return false;
		} else if (!CP_name.equals(other.CP_name))
			return false;
		if (CP_SGL == null) {
			if (other.CP_SGL != null)
				return false;
		} else if (!CP_SGL.equals(other.CP_SGL))
			return false;
		if (CP_SS_NUM == null) {
			if (other.CP_SS_NUM != null)
				return false;
		} else if (!CP_SS_NUM.equals(other.CP_SS_NUM))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (CP_license == null) {
			if (other.CP_license != null)
				return false;
		} else if (!CP_license.equals(other.CP_license))
			return false;
		if (owner_name == null) {
			if (other.owner_name != null)
				return false;
		} else if (!owner_name.equals(other.owner_name))
			return false;
		if (push_ea != other.push_ea)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CPUseVO [email=" + email + ", CP_name=" + CP_name + ", owner_name=" + owner_name + ", CP_license=" + CP_license
				+ ", CP_license_num=" + CP_license_num + ", CP_bankbook_img=" + CP_bankbook_img + ", account_holder="
				+ account_holder + ", bank=" + bank + ", account_number=" + account_number + ", CP_SGL=" + CP_SGL
				+ ", CP_Ele_Tra_con=" + CP_Ele_Tra_con + ", con_date=" + con_date + ", CP_con=" + CP_con + ", CP_SS_NUM=" + CP_SS_NUM
				+ ", push_ea=" + push_ea + "]";
	}
}

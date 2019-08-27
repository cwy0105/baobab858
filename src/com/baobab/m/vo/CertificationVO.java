package com.baobab.m.vo;

public class CertificationVO {
	private String certNo;
	private String reqDate;
	private String result;
	private String resultCode;
	private String phoneNo;
	private String authNo;
	private String extendVar;
	public CertificationVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CertificationVO(String certNo, String reqDate, String result, String resultCode, String phoneNo,
			String authNo, String extendVar) {
		super();
		this.certNo = certNo;
		this.reqDate = reqDate;
		this.result = result;
		this.resultCode = resultCode;
		this.phoneNo = phoneNo;
		this.authNo = authNo;
		this.extendVar = extendVar;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getReqDate() {
		return reqDate;
	}
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAuthNo() {
		return authNo;
	}
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	public String getExtendVar() {
		return extendVar;
	}
	public void setExtendVar(String extendVar) {
		this.extendVar = extendVar;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authNo == null) ? 0 : authNo.hashCode());
		result = prime * result + ((certNo == null) ? 0 : certNo.hashCode());
		result = prime * result + ((extendVar == null) ? 0 : extendVar.hashCode());
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		result = prime * result + ((reqDate == null) ? 0 : reqDate.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((resultCode == null) ? 0 : resultCode.hashCode());
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
		CertificationVO other = (CertificationVO) obj;
		if (authNo == null) {
			if (other.authNo != null)
				return false;
		} else if (!authNo.equals(other.authNo))
			return false;
		if (certNo == null) {
			if (other.certNo != null)
				return false;
		} else if (!certNo.equals(other.certNo))
			return false;
		if (extendVar == null) {
			if (other.extendVar != null)
				return false;
		} else if (!extendVar.equals(other.extendVar))
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		if (reqDate == null) {
			if (other.reqDate != null)
				return false;
		} else if (!reqDate.equals(other.reqDate))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (resultCode == null) {
			if (other.resultCode != null)
				return false;
		} else if (!resultCode.equals(other.resultCode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CertificationVO [certNo=" + certNo + ", reqDate=" + reqDate + ", result=" + result + ", resultCode="
				+ resultCode + ", phoneNo=" + phoneNo + ", authNo=" + authNo + ", extendVar=" + extendVar + "]";
	}
}

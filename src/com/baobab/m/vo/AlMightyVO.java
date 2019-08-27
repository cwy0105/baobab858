package com.baobab.m.vo;

public class AlMightyVO {

	private String almightyID;
	private String almightyPW;
	
	public String getAlmightyID() {
		return almightyID;
	}
	public void setAlmightyID(String almightyID) {
		this.almightyID = almightyID;
	}
	public String getAlmightyPW() {
		return almightyPW;
	}
	public void setAlmightyPW(String almightyPW) {
		this.almightyPW = almightyPW;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((almightyID == null) ? 0 : almightyID.hashCode());
		result = prime * result + ((almightyPW == null) ? 0 : almightyPW.hashCode());
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
		AlMightyVO other = (AlMightyVO) obj;
		if (almightyID == null) {
			if (other.almightyID != null)
				return false;
		} else if (!almightyID.equals(other.almightyID))
			return false;
		if (almightyPW == null) {
			if (other.almightyPW != null)
				return false;
		} else if (!almightyPW.equals(other.almightyPW))
			return false;
		return true;
	}
	public AlMightyVO(String almightyID, String almightyPW) {
		super();
		this.almightyID = almightyID;
		this.almightyPW = almightyPW;
	}
	public AlMightyVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AlMighty [almightyID=" + almightyID + ", almightyPW=" + almightyPW + "]";
	}
	
	
	
}

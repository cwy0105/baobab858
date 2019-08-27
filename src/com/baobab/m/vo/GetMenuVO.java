package com.baobab.m.vo;

public class GetMenuVO {
	private String cpName;
	private String menuDiv;
	public GetMenuVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GetMenuVO(String cpName, String menuDiv) {
		super();
		this.cpName = cpName;
		this.menuDiv = menuDiv;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getMenuDiv() {
		return menuDiv;
	}
	public void setMenuDiv(String menuDiv) {
		this.menuDiv = menuDiv;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpName == null) ? 0 : cpName.hashCode());
		result = prime * result + ((menuDiv == null) ? 0 : menuDiv.hashCode());
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
		GetMenuVO other = (GetMenuVO) obj;
		if (cpName == null) {
			if (other.cpName != null)
				return false;
		} else if (!cpName.equals(other.cpName))
			return false;
		if (menuDiv == null) {
			if (other.menuDiv != null)
				return false;
		} else if (!menuDiv.equals(other.menuDiv))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GetMenuVO [cpName=" + cpName + ", menuDiv=" + menuDiv + "]";
	}
	
	
}

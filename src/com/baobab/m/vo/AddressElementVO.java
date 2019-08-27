package com.baobab.m.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressElementVO {
	private List<String> types = null;
	private String longName;
	private String shortName;
	private String code;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	public AddressElementVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddressElementVO(List<String> types, String longName, String shortName, String code,
			Map<String, Object> additionalProperties) {
		super();
		this.types = types;
		this.longName = longName;
		this.shortName = shortName;
		this.code = code;
		this.additionalProperties = additionalProperties;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalProperties == null) ? 0 : additionalProperties.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((longName == null) ? 0 : longName.hashCode());
		result = prime * result + ((shortName == null) ? 0 : shortName.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
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
		AddressElementVO other = (AddressElementVO) obj;
		if (additionalProperties == null) {
			if (other.additionalProperties != null)
				return false;
		} else if (!additionalProperties.equals(other.additionalProperties))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (longName == null) {
			if (other.longName != null)
				return false;
		} else if (!longName.equals(other.longName))
			return false;
		if (shortName == null) {
			if (other.shortName != null)
				return false;
		} else if (!shortName.equals(other.shortName))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AddressElementVO [types=" + types + ", longName=" + longName + ", shortName=" + shortName + ", code="
				+ code + ", additionalProperties=" + additionalProperties + "]";
	}
}

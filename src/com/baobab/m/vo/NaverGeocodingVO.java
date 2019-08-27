package com.baobab.m.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaverGeocodingVO {
	private String status;
	private Meta meta;
	private List<Address> addresses = null;
	private String errorMessage;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	public NaverGeocodingVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NaverGeocodingVO(String status, Meta meta, List<Address> addresses, String errorMessage,
			Map<String, Object> additionalProperties) {
		super();
		this.status = status;
		this.meta = meta;
		this.addresses = addresses;
		this.errorMessage = errorMessage;
		this.additionalProperties = additionalProperties;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
		result = prime * result + ((meta == null) ? 0 : meta.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		NaverGeocodingVO other = (NaverGeocodingVO) obj;
		if (additionalProperties == null) {
			if (other.additionalProperties != null)
				return false;
		} else if (!additionalProperties.equals(other.additionalProperties))
			return false;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (errorMessage == null) {
			if (other.errorMessage != null)
				return false;
		} else if (!errorMessage.equals(other.errorMessage))
			return false;
		if (meta == null) {
			if (other.meta != null)
				return false;
		} else if (!meta.equals(other.meta))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NaverGeocodingVO [status=" + status + ", meta=" + meta + ", addresses=" + addresses + ", errorMessage="
				+ errorMessage + ", additionalProperties=" + additionalProperties + "]";
	}
}

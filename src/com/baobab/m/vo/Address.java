package com.baobab.m.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Address {
	private String roadAddress;
	private String jibunAddress;
	private String englishAddress;
	private List<AddressElementVO> addressElements = null;
	private String x;
	private String y;
	private Integer distance;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String roadAddress, String jibunAddress, String englishAddress,
			List<AddressElementVO> addressElements, String x, String y, Integer distance,
			Map<String, Object> additionalProperties) {
		super();
		this.roadAddress = roadAddress;
		this.jibunAddress = jibunAddress;
		this.englishAddress = englishAddress;
		this.addressElements = addressElements;
		this.x = x;
		this.y = y;
		this.distance = distance;
		this.additionalProperties = additionalProperties;
	}
	public String getRoadAddress() {
		return roadAddress;
	}
	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}
	public String getJibunAddress() {
		return jibunAddress;
	}
	public void setJibunAddress(String jibunAddress) {
		this.jibunAddress = jibunAddress;
	}
	public String getEnglishAddress() {
		return englishAddress;
	}
	public void setEnglishAddress(String englishAddress) {
		this.englishAddress = englishAddress;
	}
	public List<AddressElementVO> getAddressElements() {
		return addressElements;
	}
	public void setAddressElements(List<AddressElementVO> addressElements) {
		this.addressElements = addressElements;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
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
		result = prime * result + ((addressElements == null) ? 0 : addressElements.hashCode());
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((englishAddress == null) ? 0 : englishAddress.hashCode());
		result = prime * result + ((jibunAddress == null) ? 0 : jibunAddress.hashCode());
		result = prime * result + ((roadAddress == null) ? 0 : roadAddress.hashCode());
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
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
		Address other = (Address) obj;
		if (additionalProperties == null) {
			if (other.additionalProperties != null)
				return false;
		} else if (!additionalProperties.equals(other.additionalProperties))
			return false;
		if (addressElements == null) {
			if (other.addressElements != null)
				return false;
		} else if (!addressElements.equals(other.addressElements))
			return false;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (englishAddress == null) {
			if (other.englishAddress != null)
				return false;
		} else if (!englishAddress.equals(other.englishAddress))
			return false;
		if (jibunAddress == null) {
			if (other.jibunAddress != null)
				return false;
		} else if (!jibunAddress.equals(other.jibunAddress))
			return false;
		if (roadAddress == null) {
			if (other.roadAddress != null)
				return false;
		} else if (!roadAddress.equals(other.roadAddress))
			return false;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [roadAddress=" + roadAddress + ", jibunAddress=" + jibunAddress + ", englishAddress="
				+ englishAddress + ", addressElements=" + addressElements + ", x=" + x + ", y=" + y + ", distance="
				+ distance + ", additionalProperties=" + additionalProperties + "]";
	}
}

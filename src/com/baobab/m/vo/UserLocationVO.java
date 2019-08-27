package com.baobab.m.vo;

import java.util.Date;

public class UserLocationVO {
	private String user;
	private String longitude;
	private String latitude;
	private String addr;
	private String push_token;
	private Date location_date;
	public UserLocationVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserLocationVO(String user, String longitude, String latitude, String addr, String push_token,
			Date location_date) {
		super();
		this.user = user;
		this.longitude = longitude;
		this.latitude = latitude;
		this.addr = addr;
		this.push_token = push_token;
		this.location_date = location_date;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPush_token() {
		return push_token;
	}
	public void setPush_token(String push_token) {
		this.push_token = push_token;
	}
	public Date getLocation_date() {
		return location_date;
	}
	public void setLocation_date(Date location_date) {
		this.location_date = location_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((location_date == null) ? 0 : location_date.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((push_token == null) ? 0 : push_token.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UserLocationVO other = (UserLocationVO) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (location_date == null) {
			if (other.location_date != null)
				return false;
		} else if (!location_date.equals(other.location_date))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (push_token == null) {
			if (other.push_token != null)
				return false;
		} else if (!push_token.equals(other.push_token))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserLocationVO [user=" + user + ", longitude=" + longitude + ", latitude=" + latitude + ", addr=" + addr
				+ ", push_token=" + push_token + ", location_date=" + location_date + "]";
	}
}

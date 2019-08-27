package com.baobab.m.vo;

import java.util.Date;

public class LocationLogVO {
	private int seq_num;
	private String user;
	private String root;
	private String service;
	private String third_person;
	private Date use_date;
	public LocationLogVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocationLogVO(int seq_num, String user, String root, String service, String third_person, Date use_date) {
		super();
		this.seq_num = seq_num;
		this.user = user;
		this.root = root;
		this.service = service;
		this.third_person = third_person;
		this.use_date = use_date;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getThird_person() {
		return third_person;
	}
	public void setThird_person(String third_person) {
		this.third_person = third_person;
	}
	public Date getUse_date() {
		return use_date;
	}
	public void setUse_date(Date use_date) {
		this.use_date = use_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((root == null) ? 0 : root.hashCode());
		result = prime * result + seq_num;
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((third_person == null) ? 0 : third_person.hashCode());
		result = prime * result + ((use_date == null) ? 0 : use_date.hashCode());
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
		LocationLogVO other = (LocationLogVO) obj;
		if (root == null) {
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		if (seq_num != other.seq_num)
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (third_person == null) {
			if (other.third_person != null)
				return false;
		} else if (!third_person.equals(other.third_person))
			return false;
		if (use_date == null) {
			if (other.use_date != null)
				return false;
		} else if (!use_date.equals(other.use_date))
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
		return "LocationLogVO [seq_num=" + seq_num + ", user=" + user + ", root=" + root + ", service=" + service
				+ ", third_person=" + third_person + ", use_date=" + use_date + "]";
	}
}

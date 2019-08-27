package com.baobab.m.vo;

import java.util.Date;

public class AdminAccountVO {
	private int seq_num;
	private String id;
	private String password;
	private String name;
	private String job_class;
	private String department;
	private Date joinDate;
	public AdminAccountVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminAccountVO(int seq_num, String id, String password, String name, String job_class, String department,
			Date joinDate) {
		super();
		this.seq_num = seq_num;
		this.id = id;
		this.password = password;
		this.name = name;
		this.job_class = job_class;
		this.department = department;
		this.joinDate = joinDate;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob_class() {
		return job_class;
	}
	public void setJob_class(String job_class) {
		this.job_class = job_class;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((job_class == null) ? 0 : job_class.hashCode());
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + seq_num;
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
		AdminAccountVO other = (AdminAccountVO) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (job_class == null) {
			if (other.job_class != null)
				return false;
		} else if (!job_class.equals(other.job_class))
			return false;
		if (joinDate == null) {
			if (other.joinDate != null)
				return false;
		} else if (!joinDate.equals(other.joinDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (seq_num != other.seq_num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AdminAccountVO [seq_num=" + seq_num + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", job_class=" + job_class + ", department=" + department + ", joinDate=" + joinDate + "]";
	}
}

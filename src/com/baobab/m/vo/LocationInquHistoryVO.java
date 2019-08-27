package com.baobab.m.vo;

public class LocationInquHistoryVO {
	private int seq_num;
	private String email;
	private String div_code;
	private String name;
	private String jobclass;
	private String department;
	private String ip;
	private String reason;
	public LocationInquHistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocationInquHistoryVO(int seq_num, String email, String div_code, String name, String jobclass,
			String department, String ip, String reason) {
		super();
		this.seq_num = seq_num;
		this.email = email;
		this.div_code = div_code;
		this.name = name;
		this.jobclass = jobclass;
		this.department = department;
		this.ip = ip;
		this.reason = reason;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiv_code() {
		return div_code;
	}
	public void setDiv_code(String div_code) {
		this.div_code = div_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobclass() {
		return jobclass;
	}
	public void setJobclass(String jobclass) {
		this.jobclass = jobclass;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((div_code == null) ? 0 : div_code.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((jobclass == null) ? 0 : jobclass.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
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
		LocationInquHistoryVO other = (LocationInquHistoryVO) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (div_code == null) {
			if (other.div_code != null)
				return false;
		} else if (!div_code.equals(other.div_code))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (jobclass == null) {
			if (other.jobclass != null)
				return false;
		} else if (!jobclass.equals(other.jobclass))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (seq_num != other.seq_num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LocationInquHistoryVO [seq_num=" + seq_num + ", email=" + email + ", div_code=" + div_code + ", name="
				+ name + ", jobclass=" + jobclass + ", department=" + department + ", ip=" + ip + ", reason=" + reason
				+ "]";
	}
}

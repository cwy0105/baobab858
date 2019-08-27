package com.baobab.m.vo;

public class UserSearchVO {
	private String email;
	private String user_password;
	private String phon_num;
	private String div_code;
	private String push_agree;
	private String email_agree;
	private String sms_agree;
	private String join_date;
	public UserSearchVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSearchVO(String email, String user_password, String phon_num, String div_code, String push_agree,
			String email_agree, String sms_agree, String join_date) {
		super();
		this.email = email;
		this.user_password = user_password;
		this.phon_num = phon_num;
		this.div_code = div_code;
		this.push_agree = push_agree;
		this.email_agree = email_agree;
		this.sms_agree = sms_agree;
		this.join_date = join_date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getPhon_num() {
		return phon_num;
	}
	public void setPhon_num(String phon_num) {
		this.phon_num = phon_num;
	}
	public String getDiv_code() {
		return div_code;
	}
	public void setDiv_code(String div_code) {
		this.div_code = div_code;
	}
	public String getPush_agree() {
		return push_agree;
	}
	public void setPush_agree(String push_agree) {
		this.push_agree = push_agree;
	}
	public String getEmail_agree() {
		return email_agree;
	}
	public void setEmail_agree(String email_agree) {
		this.email_agree = email_agree;
	}
	public String getSms_agree() {
		return sms_agree;
	}
	public void setSms_agree(String sms_agree) {
		this.sms_agree = sms_agree;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((div_code == null) ? 0 : div_code.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((email_agree == null) ? 0 : email_agree.hashCode());
		result = prime * result + ((join_date == null) ? 0 : join_date.hashCode());
		result = prime * result + ((phon_num == null) ? 0 : phon_num.hashCode());
		result = prime * result + ((push_agree == null) ? 0 : push_agree.hashCode());
		result = prime * result + ((sms_agree == null) ? 0 : sms_agree.hashCode());
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
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
		UserSearchVO other = (UserSearchVO) obj;
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
		if (email_agree == null) {
			if (other.email_agree != null)
				return false;
		} else if (!email_agree.equals(other.email_agree))
			return false;
		if (join_date == null) {
			if (other.join_date != null)
				return false;
		} else if (!join_date.equals(other.join_date))
			return false;
		if (phon_num == null) {
			if (other.phon_num != null)
				return false;
		} else if (!phon_num.equals(other.phon_num))
			return false;
		if (push_agree == null) {
			if (other.push_agree != null)
				return false;
		} else if (!push_agree.equals(other.push_agree))
			return false;
		if (sms_agree == null) {
			if (other.sms_agree != null)
				return false;
		} else if (!sms_agree.equals(other.sms_agree))
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserSearchVO [email=" + email + ", user_password=" + user_password + ", phon_num=" + phon_num
				+ ", div_code=" + div_code + ", push_agree=" + push_agree + ", email_agree=" + email_agree
				+ ", sms_agree=" + sms_agree + ", join_date=" + join_date + "]";
	}
}

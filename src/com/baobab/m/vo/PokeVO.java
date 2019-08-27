package com.baobab.m.vo;

import java.util.Date;

public class PokeVO {
	private int seq_num;
	private String user_phone;
	private String cp_name;
	private String cp_address;
	private int score;
	private int rev_num;
	private String div_code;
	private int cp_seq;
	private Date poke_date;
	public PokeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PokeVO(int seq_num, String user_phone, String cp_name, String cp_address, int score, int rev_num,
			String div_code, int cp_seq, Date poke_date) {
		super();
		this.seq_num = seq_num;
		this.user_phone = user_phone;
		this.cp_name = cp_name;
		this.cp_address = cp_address;
		this.score = score;
		this.rev_num = rev_num;
		this.div_code = div_code;
		this.cp_seq = cp_seq;
		this.poke_date = poke_date;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public String getCp_address() {
		return cp_address;
	}
	public void setCp_address(String cp_address) {
		this.cp_address = cp_address;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRev_num() {
		return rev_num;
	}
	public void setRev_num(int rev_num) {
		this.rev_num = rev_num;
	}
	public String getDiv_code() {
		return div_code;
	}
	public void setDiv_code(String div_code) {
		this.div_code = div_code;
	}
	public int getCp_seq() {
		return cp_seq;
	}
	public void setCp_seq(int cp_seq) {
		this.cp_seq = cp_seq;
	}
	public Date getPoke_date() {
		return poke_date;
	}
	public void setPoke_date(Date poke_date) {
		this.poke_date = poke_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cp_address == null) ? 0 : cp_address.hashCode());
		result = prime * result + ((cp_name == null) ? 0 : cp_name.hashCode());
		result = prime * result + cp_seq;
		result = prime * result + ((div_code == null) ? 0 : div_code.hashCode());
		result = prime * result + ((poke_date == null) ? 0 : poke_date.hashCode());
		result = prime * result + rev_num;
		result = prime * result + score;
		result = prime * result + seq_num;
		result = prime * result + ((user_phone == null) ? 0 : user_phone.hashCode());
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
		PokeVO other = (PokeVO) obj;
		if (cp_address == null) {
			if (other.cp_address != null)
				return false;
		} else if (!cp_address.equals(other.cp_address))
			return false;
		if (cp_name == null) {
			if (other.cp_name != null)
				return false;
		} else if (!cp_name.equals(other.cp_name))
			return false;
		if (cp_seq != other.cp_seq)
			return false;
		if (div_code == null) {
			if (other.div_code != null)
				return false;
		} else if (!div_code.equals(other.div_code))
			return false;
		if (poke_date == null) {
			if (other.poke_date != null)
				return false;
		} else if (!poke_date.equals(other.poke_date))
			return false;
		if (rev_num != other.rev_num)
			return false;
		if (score != other.score)
			return false;
		if (seq_num != other.seq_num)
			return false;
		if (user_phone == null) {
			if (other.user_phone != null)
				return false;
		} else if (!user_phone.equals(other.user_phone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PokeVO [seq_num=" + seq_num + ", user_phone=" + user_phone + ", cp_name=" + cp_name + ", cp_address="
				+ cp_address + ", score=" + score + ", rev_num=" + rev_num + ", div_code=" + div_code + ", cp_seq="
				+ cp_seq + ", poke_date=" + poke_date + "]";
	}
}

package com.baobab.m.vo;

public class CPmainImgVO {
	private int seq_num;
	private String cp_name;
	private String img_url;
	private int cp_seq;
	public CPmainImgVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CPmainImgVO(int seq_num, String cp_name, String img_url, int cp_seq) {
		super();
		this.seq_num = seq_num;
		this.cp_name = cp_name;
		this.img_url = img_url;
		this.cp_seq = cp_seq;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public int getCp_seq() {
		return cp_seq;
	}
	public void setCp_seq(int cp_seq) {
		this.cp_seq = cp_seq;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cp_name == null) ? 0 : cp_name.hashCode());
		result = prime * result + cp_seq;
		result = prime * result + ((img_url == null) ? 0 : img_url.hashCode());
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
		CPmainImgVO other = (CPmainImgVO) obj;
		if (cp_name == null) {
			if (other.cp_name != null)
				return false;
		} else if (!cp_name.equals(other.cp_name))
			return false;
		if (cp_seq != other.cp_seq)
			return false;
		if (img_url == null) {
			if (other.img_url != null)
				return false;
		} else if (!img_url.equals(other.img_url))
			return false;
		if (seq_num != other.seq_num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CPmainImgVO [seq_num=" + seq_num + ", cp_name=" + cp_name + ", img_url=" + img_url + ", cp_seq="
				+ cp_seq + "]";
	}
}

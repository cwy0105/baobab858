package com.baobab.m.vo;

public class NonCpMenuVO {
	private int seq_num;
	private String cp_name;
	private String thisCode;
	private int loc_seq;
	private String menu_name;
	private String price;
	private String img_url;
	public NonCpMenuVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NonCpMenuVO(int seq_num, String cp_name, String thisCode, int loc_seq, String menu_name, String price,
			String img_url) {
		super();
		this.seq_num = seq_num;
		this.cp_name = cp_name;
		this.thisCode = thisCode;
		this.loc_seq = loc_seq;
		this.menu_name = menu_name;
		this.price = price;
		this.img_url = img_url;
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
	public String getThisCode() {
		return thisCode;
	}
	public void setThisCode(String thisCode) {
		this.thisCode = thisCode;
	}
	public int getLoc_seq() {
		return loc_seq;
	}
	public void setLoc_seq(int loc_seq) {
		this.loc_seq = loc_seq;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cp_name == null) ? 0 : cp_name.hashCode());
		result = prime * result + ((img_url == null) ? 0 : img_url.hashCode());
		result = prime * result + loc_seq;
		result = prime * result + ((menu_name == null) ? 0 : menu_name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + seq_num;
		result = prime * result + ((thisCode == null) ? 0 : thisCode.hashCode());
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
		NonCpMenuVO other = (NonCpMenuVO) obj;
		if (cp_name == null) {
			if (other.cp_name != null)
				return false;
		} else if (!cp_name.equals(other.cp_name))
			return false;
		if (img_url == null) {
			if (other.img_url != null)
				return false;
		} else if (!img_url.equals(other.img_url))
			return false;
		if (loc_seq != other.loc_seq)
			return false;
		if (menu_name == null) {
			if (other.menu_name != null)
				return false;
		} else if (!menu_name.equals(other.menu_name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (seq_num != other.seq_num)
			return false;
		if (thisCode == null) {
			if (other.thisCode != null)
				return false;
		} else if (!thisCode.equals(other.thisCode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NonCpMenuVO [seq_num=" + seq_num + ", cp_name=" + cp_name + ", thisCode=" + thisCode + ", loc_seq="
				+ loc_seq + ", menu_name=" + menu_name + ", price=" + price + ", img_url=" + img_url + "]";
	}
}

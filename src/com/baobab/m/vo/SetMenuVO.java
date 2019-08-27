package com.baobab.m.vo;

public class SetMenuVO {
	private int seq_num;
	private String menu_name;
	private String cp_name;
	private String menu_price;
	private String menu_dis_price;
	private String menu_img;
	private String menu_detail;
	private int cp_seq;
	public SetMenuVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SetMenuVO(int seq_num, String menu_name, String cp_name, String menu_price, String menu_dis_price,
			String menu_img, String menu_detail, int cp_seq) {
		super();
		this.seq_num = seq_num;
		this.menu_name = menu_name;
		this.cp_name = cp_name;
		this.menu_price = menu_price;
		this.menu_dis_price = menu_dis_price;
		this.menu_img = menu_img;
		this.menu_detail = menu_detail;
		this.cp_seq = cp_seq;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public String getMenu_price() {
		return menu_price;
	}
	public void setMenu_price(String menu_price) {
		this.menu_price = menu_price;
	}
	public String getMenu_dis_price() {
		return menu_dis_price;
	}
	public void setMenu_dis_price(String menu_dis_price) {
		this.menu_dis_price = menu_dis_price;
	}
	public String getMenu_img() {
		return menu_img;
	}
	public void setMenu_img(String menu_img) {
		this.menu_img = menu_img;
	}
	public String getMenu_detail() {
		return menu_detail;
	}
	public void setMenu_detail(String menu_detail) {
		this.menu_detail = menu_detail;
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
		result = prime * result + ((menu_detail == null) ? 0 : menu_detail.hashCode());
		result = prime * result + ((menu_dis_price == null) ? 0 : menu_dis_price.hashCode());
		result = prime * result + ((menu_img == null) ? 0 : menu_img.hashCode());
		result = prime * result + ((menu_name == null) ? 0 : menu_name.hashCode());
		result = prime * result + ((menu_price == null) ? 0 : menu_price.hashCode());
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
		SetMenuVO other = (SetMenuVO) obj;
		if (cp_name == null) {
			if (other.cp_name != null)
				return false;
		} else if (!cp_name.equals(other.cp_name))
			return false;
		if (cp_seq != other.cp_seq)
			return false;
		if (menu_detail == null) {
			if (other.menu_detail != null)
				return false;
		} else if (!menu_detail.equals(other.menu_detail))
			return false;
		if (menu_dis_price == null) {
			if (other.menu_dis_price != null)
				return false;
		} else if (!menu_dis_price.equals(other.menu_dis_price))
			return false;
		if (menu_img == null) {
			if (other.menu_img != null)
				return false;
		} else if (!menu_img.equals(other.menu_img))
			return false;
		if (menu_name == null) {
			if (other.menu_name != null)
				return false;
		} else if (!menu_name.equals(other.menu_name))
			return false;
		if (menu_price == null) {
			if (other.menu_price != null)
				return false;
		} else if (!menu_price.equals(other.menu_price))
			return false;
		if (seq_num != other.seq_num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SetMenuVO [seq_num=" + seq_num + ", menu_name=" + menu_name + ", cp_name=" + cp_name + ", menu_price="
				+ menu_price + ", menu_dis_price=" + menu_dis_price + ", menu_img=" + menu_img + ", menu_detail="
				+ menu_detail + ", cp_seq=" + cp_seq + "]";
	}
}

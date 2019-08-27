package com.baobab.m.vo;

public class CPEnterMenuVO {
	private int seq_num;
	private String cp_name;
	private String menu_name;
	private int price;
	private int dis_price;
	private int cp_seq;
	public CPEnterMenuVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CPEnterMenuVO(int seq_num, String cp_name, String menu_name, int price, int dis_price, int cp_seq) {
		super();
		this.seq_num = seq_num;
		this.cp_name = cp_name;
		this.menu_name = menu_name;
		this.price = price;
		this.dis_price = dis_price;
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
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDis_price() {
		return dis_price;
	}
	public void setDis_price(int dis_price) {
		this.dis_price = dis_price;
	}
	public int getCp_seq() {
		return cp_seq;
	}
	public void setCp_seq(int cp_seq) {
		this.cp_seq = cp_seq;
	}
	@Override
	public String toString() {
		return "CPEnterMenuVO [seq_num=" + seq_num + ", cp_name=" + cp_name + ", menu_name=" + menu_name + ", price="
				+ price + ", dis_price=" + dis_price + ", cp_seq=" + cp_seq + "]";
	}
}

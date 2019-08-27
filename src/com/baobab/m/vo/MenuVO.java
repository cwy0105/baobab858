package com.baobab.m.vo;

public class MenuVO {
	private int seq_num;
	private String menu_name;
	private String cp_name;
	private String menu_img;
	private int menu_price;
	private int menu_dis_price;
	private String menu_option;
	private String menu_intro;
	private String menu_div;
	private String menu_detail;
	private String set_menu_name;
	private int cp_seq;
	//아래는 메뉴 수정시 사용 필드
	private String update_menuName;
	private String update_option;
	private int update_disPrice;
	private int update_price;
	public MenuVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuVO(int seq_num, String menu_name, String cp_name, String menu_img, int menu_price, int menu_dis_price,
			String menu_option, String menu_intro, String menu_div, String menu_detail, String set_menu_name,
			int cp_seq, String update_menuName, String update_option, int update_disPrice, int update_price) {
		super();
		this.seq_num = seq_num;
		this.menu_name = menu_name;
		this.cp_name = cp_name;
		this.menu_img = menu_img;
		this.menu_price = menu_price;
		this.menu_dis_price = menu_dis_price;
		this.menu_option = menu_option;
		this.menu_intro = menu_intro;
		this.menu_div = menu_div;
		this.menu_detail = menu_detail;
		this.set_menu_name = set_menu_name;
		this.cp_seq = cp_seq;
		this.update_menuName = update_menuName;
		this.update_option = update_option;
		this.update_disPrice = update_disPrice;
		this.update_price = update_price;
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
	public String getMenu_img() {
		return menu_img;
	}
	public void setMenu_img(String menu_img) {
		this.menu_img = menu_img;
	}
	public int getMenu_price() {
		return menu_price;
	}
	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}
	public int getMenu_dis_price() {
		return menu_dis_price;
	}
	public void setMenu_dis_price(int menu_dis_price) {
		this.menu_dis_price = menu_dis_price;
	}
	public String getMenu_option() {
		return menu_option;
	}
	public void setMenu_option(String menu_option) {
		this.menu_option = menu_option;
	}
	public String getMenu_intro() {
		return menu_intro;
	}
	public void setMenu_intro(String menu_intro) {
		this.menu_intro = menu_intro;
	}
	public String getMenu_div() {
		return menu_div;
	}
	public void setMenu_div(String menu_div) {
		this.menu_div = menu_div;
	}
	public String getMenu_detail() {
		return menu_detail;
	}
	public void setMenu_detail(String menu_detail) {
		this.menu_detail = menu_detail;
	}
	public String getSet_menu_name() {
		return set_menu_name;
	}
	public void setSet_menu_name(String set_menu_name) {
		this.set_menu_name = set_menu_name;
	}
	public int getCp_seq() {
		return cp_seq;
	}
	public void setCp_seq(int cp_seq) {
		this.cp_seq = cp_seq;
	}
	public String getUpdate_menuName() {
		return update_menuName;
	}
	public void setUpdate_menuName(String update_menuName) {
		this.update_menuName = update_menuName;
	}
	public String getUpdate_option() {
		return update_option;
	}
	public void setUpdate_option(String update_option) {
		this.update_option = update_option;
	}
	public int getUpdate_disPrice() {
		return update_disPrice;
	}
	public void setUpdate_disPrice(int update_disPrice) {
		this.update_disPrice = update_disPrice;
	}
	public int getUpdate_price() {
		return update_price;
	}
	public void setUpdate_price(int update_price) {
		this.update_price = update_price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cp_name == null) ? 0 : cp_name.hashCode());
		result = prime * result + cp_seq;
		result = prime * result + ((menu_detail == null) ? 0 : menu_detail.hashCode());
		result = prime * result + menu_dis_price;
		result = prime * result + ((menu_div == null) ? 0 : menu_div.hashCode());
		result = prime * result + ((menu_img == null) ? 0 : menu_img.hashCode());
		result = prime * result + ((menu_intro == null) ? 0 : menu_intro.hashCode());
		result = prime * result + ((menu_name == null) ? 0 : menu_name.hashCode());
		result = prime * result + ((menu_option == null) ? 0 : menu_option.hashCode());
		result = prime * result + menu_price;
		result = prime * result + seq_num;
		result = prime * result + ((set_menu_name == null) ? 0 : set_menu_name.hashCode());
		result = prime * result + update_disPrice;
		result = prime * result + ((update_menuName == null) ? 0 : update_menuName.hashCode());
		result = prime * result + ((update_option == null) ? 0 : update_option.hashCode());
		result = prime * result + update_price;
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
		MenuVO other = (MenuVO) obj;
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
		if (menu_dis_price != other.menu_dis_price)
			return false;
		if (menu_div == null) {
			if (other.menu_div != null)
				return false;
		} else if (!menu_div.equals(other.menu_div))
			return false;
		if (menu_img == null) {
			if (other.menu_img != null)
				return false;
		} else if (!menu_img.equals(other.menu_img))
			return false;
		if (menu_intro == null) {
			if (other.menu_intro != null)
				return false;
		} else if (!menu_intro.equals(other.menu_intro))
			return false;
		if (menu_name == null) {
			if (other.menu_name != null)
				return false;
		} else if (!menu_name.equals(other.menu_name))
			return false;
		if (menu_option == null) {
			if (other.menu_option != null)
				return false;
		} else if (!menu_option.equals(other.menu_option))
			return false;
		if (menu_price != other.menu_price)
			return false;
		if (seq_num != other.seq_num)
			return false;
		if (set_menu_name == null) {
			if (other.set_menu_name != null)
				return false;
		} else if (!set_menu_name.equals(other.set_menu_name))
			return false;
		if (update_disPrice != other.update_disPrice)
			return false;
		if (update_menuName == null) {
			if (other.update_menuName != null)
				return false;
		} else if (!update_menuName.equals(other.update_menuName))
			return false;
		if (update_option == null) {
			if (other.update_option != null)
				return false;
		} else if (!update_option.equals(other.update_option))
			return false;
		if (update_price != other.update_price)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MenuVO [seq_num=" + seq_num + ", menu_name=" + menu_name + ", cp_name=" + cp_name + ", menu_img="
				+ menu_img + ", menu_price=" + menu_price + ", menu_dis_price=" + menu_dis_price + ", menu_option="
				+ menu_option + ", menu_intro=" + menu_intro + ", menu_div=" + menu_div + ", menu_detail=" + menu_detail
				+ ", set_menu_name=" + set_menu_name + ", cp_seq=" + cp_seq + ", update_menuName=" + update_menuName
				+ ", update_option=" + update_option + ", update_disPrice=" + update_disPrice + ", update_price="
				+ update_price + "]";
	}
}

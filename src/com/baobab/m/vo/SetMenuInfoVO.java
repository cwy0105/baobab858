package com.baobab.m.vo;

public class SetMenuInfoVO {
	private int seq_num;
	private String cp_name;
	private String set_menu_name;
	private String menu;
	private String option;
	private String ea;
	private int cp_seq;
	public SetMenuInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SetMenuInfoVO(int seq_num, String cp_name, String set_menu_name, String menu, String option, String ea,
			int cp_seq) {
		super();
		this.seq_num = seq_num;
		this.cp_name = cp_name;
		this.set_menu_name = set_menu_name;
		this.menu = menu;
		this.option = option;
		this.ea = ea;
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
	public String getSet_menu_name() {
		return set_menu_name;
	}
	public void setSet_menu_name(String set_menu_name) {
		this.set_menu_name = set_menu_name;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getEa() {
		return ea;
	}
	public void setEa(String ea) {
		this.ea = ea;
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
		result = prime * result + ((ea == null) ? 0 : ea.hashCode());
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + ((option == null) ? 0 : option.hashCode());
		result = prime * result + seq_num;
		result = prime * result + ((set_menu_name == null) ? 0 : set_menu_name.hashCode());
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
		SetMenuInfoVO other = (SetMenuInfoVO) obj;
		if (cp_name == null) {
			if (other.cp_name != null)
				return false;
		} else if (!cp_name.equals(other.cp_name))
			return false;
		if (cp_seq != other.cp_seq)
			return false;
		if (ea == null) {
			if (other.ea != null)
				return false;
		} else if (!ea.equals(other.ea))
			return false;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		if (option == null) {
			if (other.option != null)
				return false;
		} else if (!option.equals(other.option))
			return false;
		if (seq_num != other.seq_num)
			return false;
		if (set_menu_name == null) {
			if (other.set_menu_name != null)
				return false;
		} else if (!set_menu_name.equals(other.set_menu_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SetMenuInfoVO [seq_num=" + seq_num + ", cp_name=" + cp_name + ", set_menu_name=" + set_menu_name
				+ ", menu=" + menu + ", option=" + option + ", ea=" + ea + ", cp_seq=" + cp_seq + "]";
	}
}

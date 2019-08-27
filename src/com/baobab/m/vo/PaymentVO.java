package com.baobab.m.vo;

import java.util.Date;

public class PaymentVO {
	private int seq_num;
	private String email;
	private String user_phone;
	private String order_num;
	private String cp_name;
	private int cp_seq;
	private String menus;
	private String goods;
	private String prices;
	private int total_price;
	private int total_dis_price;
	private String status;
	private String tid;
	private String owner_receipt;
	private String used;
	private Date pay_date;
	private Date use_date;
	private Date cancel_date;
	public PaymentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentVO(int seq_num, String email, String user_phone, String order_num, String cp_name, int cp_seq,
			String menus, String goods, String prices, int total_price, int total_dis_price, String status, String tid,
			String owner_receipt, String used, Date pay_date, Date use_date, Date cancel_date) {
		super();
		this.seq_num = seq_num;
		this.email = email;
		this.user_phone = user_phone;
		this.order_num = order_num;
		this.cp_name = cp_name;
		this.cp_seq = cp_seq;
		this.menus = menus;
		this.goods = goods;
		this.prices = prices;
		this.total_price = total_price;
		this.total_dis_price = total_dis_price;
		this.status = status;
		this.tid = tid;
		this.owner_receipt = owner_receipt;
		this.used = used;
		this.pay_date = pay_date;
		this.use_date = use_date;
		this.cancel_date = cancel_date;
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
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public int getCp_seq() {
		return cp_seq;
	}
	public void setCp_seq(int cp_seq) {
		this.cp_seq = cp_seq;
	}
	public String getMenus() {
		return menus;
	}
	public void setMenus(String menus) {
		this.menus = menus;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getPrices() {
		return prices;
	}
	public void setPrices(String prices) {
		this.prices = prices;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getTotal_dis_price() {
		return total_dis_price;
	}
	public void setTotal_dis_price(int total_dis_price) {
		this.total_dis_price = total_dis_price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getOwner_receipt() {
		return owner_receipt;
	}
	public void setOwner_receipt(String owner_receipt) {
		this.owner_receipt = owner_receipt;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
	public Date getUse_date() {
		return use_date;
	}
	public void setUse_date(Date use_date) {
		this.use_date = use_date;
	}
	public Date getCancel_date() {
		return cancel_date;
	}
	public void setCancel_date(Date cancel_date) {
		this.cancel_date = cancel_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cancel_date == null) ? 0 : cancel_date.hashCode());
		result = prime * result + ((cp_name == null) ? 0 : cp_name.hashCode());
		result = prime * result + cp_seq;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + ((menus == null) ? 0 : menus.hashCode());
		result = prime * result + ((order_num == null) ? 0 : order_num.hashCode());
		result = prime * result + ((owner_receipt == null) ? 0 : owner_receipt.hashCode());
		result = prime * result + ((pay_date == null) ? 0 : pay_date.hashCode());
		result = prime * result + ((prices == null) ? 0 : prices.hashCode());
		result = prime * result + seq_num;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		result = prime * result + total_dis_price;
		result = prime * result + total_price;
		result = prime * result + ((use_date == null) ? 0 : use_date.hashCode());
		result = prime * result + ((used == null) ? 0 : used.hashCode());
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
		PaymentVO other = (PaymentVO) obj;
		if (cancel_date == null) {
			if (other.cancel_date != null)
				return false;
		} else if (!cancel_date.equals(other.cancel_date))
			return false;
		if (cp_name == null) {
			if (other.cp_name != null)
				return false;
		} else if (!cp_name.equals(other.cp_name))
			return false;
		if (cp_seq != other.cp_seq)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (menus == null) {
			if (other.menus != null)
				return false;
		} else if (!menus.equals(other.menus))
			return false;
		if (order_num == null) {
			if (other.order_num != null)
				return false;
		} else if (!order_num.equals(other.order_num))
			return false;
		if (owner_receipt == null) {
			if (other.owner_receipt != null)
				return false;
		} else if (!owner_receipt.equals(other.owner_receipt))
			return false;
		if (pay_date == null) {
			if (other.pay_date != null)
				return false;
		} else if (!pay_date.equals(other.pay_date))
			return false;
		if (prices == null) {
			if (other.prices != null)
				return false;
		} else if (!prices.equals(other.prices))
			return false;
		if (seq_num != other.seq_num)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		if (total_dis_price != other.total_dis_price)
			return false;
		if (total_price != other.total_price)
			return false;
		if (use_date == null) {
			if (other.use_date != null)
				return false;
		} else if (!use_date.equals(other.use_date))
			return false;
		if (used == null) {
			if (other.used != null)
				return false;
		} else if (!used.equals(other.used))
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
		return "PaymentVO [seq_num=" + seq_num + ", email=" + email + ", user_phone=" + user_phone + ", order_num="
				+ order_num + ", cp_name=" + cp_name + ", cp_seq=" + cp_seq + ", menus=" + menus + ", goods=" + goods
				+ ", prices=" + prices + ", total_price=" + total_price + ", total_dis_price=" + total_dis_price
				+ ", status=" + status + ", tid=" + tid + ", owner_receipt=" + owner_receipt + ", used=" + used
				+ ", pay_date=" + pay_date + ", use_date=" + use_date + ", cancel_date=" + cancel_date + "]";
	}
	
}

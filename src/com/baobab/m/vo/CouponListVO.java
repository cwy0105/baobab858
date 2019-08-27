package com.baobab.m.vo;

public class CouponListVO {
	private String couponName;
	private int couponPrice;
	private int couponDiscountPrice;
	private int ea;
	public CouponListVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CouponListVO(String couponName, int couponPrice, int couponDiscountPrice, int ea) {
		super();
		this.couponName = couponName;
		this.couponPrice = couponPrice;
		this.couponDiscountPrice = couponDiscountPrice;
		this.ea = ea;
	}
	@Override
	public String toString() {
		return "CouponListVO [couponName=" + couponName + ", couponPrice=" + couponPrice + ", couponDiscountPrice="
				+ couponDiscountPrice + ", ea=" + ea + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + couponDiscountPrice;
		result = prime * result + ((couponName == null) ? 0 : couponName.hashCode());
		result = prime * result + couponPrice;
		result = prime * result + ea;
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
		CouponListVO other = (CouponListVO) obj;
		if (couponDiscountPrice != other.couponDiscountPrice)
			return false;
		if (couponName == null) {
			if (other.couponName != null)
				return false;
		} else if (!couponName.equals(other.couponName))
			return false;
		if (couponPrice != other.couponPrice)
			return false;
		if (ea != other.ea)
			return false;
		return true;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public int getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(int couponPrice) {
		this.couponPrice = couponPrice;
	}
	public int getCouponDiscountPrice() {
		return couponDiscountPrice;
	}
	public void setCouponDiscountPrice(int couponDiscountPrice) {
		this.couponDiscountPrice = couponDiscountPrice;
	}
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	
	
	
}

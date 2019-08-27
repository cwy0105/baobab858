package com.baobab.m.vo;

public class SearchVO {
	private String word;
	private String location;
	private String selectItem;
	private String sortBy;
	private double longitude;
	private double latitude;
	private int count;
	private int listCount;
	private String menu;
	
	public SearchVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchVO(String word, String location, String selectItem, String sortBy, double longitude, double latitude,
			int count, int listCount, String menu) {
		super();
		this.word = word;
		this.location = location;
		this.selectItem = selectItem;
		this.sortBy = sortBy;
		this.longitude = longitude;
		this.latitude = latitude;
		this.count = count;
		this.listCount = listCount;
		this.menu = menu;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSelectItem() {
		return selectItem;
	}
	public void setSelectItem(String selectItem) {
		this.selectItem = selectItem;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + listCount;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + ((selectItem == null) ? 0 : selectItem.hashCode());
		result = prime * result + ((sortBy == null) ? 0 : sortBy.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
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
		SearchVO other = (SearchVO) obj;
		if (count != other.count)
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (listCount != other.listCount)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		if (selectItem == null) {
			if (other.selectItem != null)
				return false;
		} else if (!selectItem.equals(other.selectItem))
			return false;
		if (sortBy == null) {
			if (other.sortBy != null)
				return false;
		} else if (!sortBy.equals(other.sortBy))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SearchVO [word=" + word + ", location=" + location + ", selectItem=" + selectItem + ", sortBy=" + sortBy
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", count=" + count + ", listCount="
				+ listCount + ", menu=" + menu + "]";
	}
}

package com.baobab.m.vo;

import java.util.Date;

public class SearchHistoryVO {
	private int seqNum;
	private String searchWord;
	private String searchDiv;
	private String searchLocation;
	private String sort;
	private double userLongitude;
	private double userLatitude;
	private String kind;
	private String theme;
	private Date date;
	public SearchHistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchHistoryVO(int seqNum, String searchWord, String searchDiv, String searchLocation, String sort,
			double userLongitude, double userLatitude, String kind, String theme, Date date) {
		super();
		this.seqNum = seqNum;
		this.searchWord = searchWord;
		this.searchDiv = searchDiv;
		this.searchLocation = searchLocation;
		this.sort = sort;
		this.userLongitude = userLongitude;
		this.userLatitude = userLatitude;
		this.kind = kind;
		this.theme = theme;
		this.date = date;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getSearchDiv() {
		return searchDiv;
	}
	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}
	public String getSearchLocation() {
		return searchLocation;
	}
	public void setSearchLocation(String searchLocation) {
		this.searchLocation = searchLocation;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public double getUserLongitude() {
		return userLongitude;
	}
	public void setUserLongitude(double userLongitude) {
		this.userLongitude = userLongitude;
	}
	public double getUserLatitude() {
		return userLatitude;
	}
	public void setUserLatitude(double userLatitude) {
		this.userLatitude = userLatitude;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + ((searchDiv == null) ? 0 : searchDiv.hashCode());
		result = prime * result + ((searchLocation == null) ? 0 : searchLocation.hashCode());
		result = prime * result + ((searchWord == null) ? 0 : searchWord.hashCode());
		result = prime * result + seqNum;
		result = prime * result + ((sort == null) ? 0 : sort.hashCode());
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
		long temp;
		temp = Double.doubleToLongBits(userLatitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(userLongitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SearchHistoryVO other = (SearchHistoryVO) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (searchDiv == null) {
			if (other.searchDiv != null)
				return false;
		} else if (!searchDiv.equals(other.searchDiv))
			return false;
		if (searchLocation == null) {
			if (other.searchLocation != null)
				return false;
		} else if (!searchLocation.equals(other.searchLocation))
			return false;
		if (searchWord == null) {
			if (other.searchWord != null)
				return false;
		} else if (!searchWord.equals(other.searchWord))
			return false;
		if (seqNum != other.seqNum)
			return false;
		if (sort == null) {
			if (other.sort != null)
				return false;
		} else if (!sort.equals(other.sort))
			return false;
		if (theme == null) {
			if (other.theme != null)
				return false;
		} else if (!theme.equals(other.theme))
			return false;
		if (Double.doubleToLongBits(userLatitude) != Double.doubleToLongBits(other.userLatitude))
			return false;
		if (Double.doubleToLongBits(userLongitude) != Double.doubleToLongBits(other.userLongitude))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SearchHistoryVO [seqNum=" + seqNum + ", searchWord=" + searchWord + ", searchDiv=" + searchDiv
				+ ", searchLocation=" + searchLocation + ", sort=" + sort + ", userLongitude=" + userLongitude
				+ ", userLatitude=" + userLatitude + ", kind=" + kind + ", theme=" + theme + ", date=" + date + "]";
	}
}

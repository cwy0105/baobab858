package com.baobab.m.vo;

public class RankVO {
	private String thing;
	private String cnt;
	public RankVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RankVO(String thing, String cnt) {
		super();
		this.thing = thing;
		this.cnt = cnt;
	}
	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnt == null) ? 0 : cnt.hashCode());
		result = prime * result + ((thing == null) ? 0 : thing.hashCode());
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
		RankVO other = (RankVO) obj;
		if (cnt == null) {
			if (other.cnt != null)
				return false;
		} else if (!cnt.equals(other.cnt))
			return false;
		if (thing == null) {
			if (other.thing != null)
				return false;
		} else if (!thing.equals(other.thing))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RankVO [thing=" + thing + ", cnt=" + cnt + "]";
	}
}

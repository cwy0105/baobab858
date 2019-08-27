package com.baobab.m.vo;

public class LocalCPInfoVO {
	private int loc_seq;
	private int number;
	private String cp_name;
	private String road_addr;
	private String local_addr;
	private String tel;
	private String info;
	private String kind;
	private String biztime;
	private double latitude;
	private double longitude;
	private double distance;
	private int rev_num;
	private int rev_grade;
	private int hits;
	private String thisCode;
	public LocalCPInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalCPInfoVO(int loc_seq, int number, String cp_name, String road_addr, String local_addr, String tel,
			String info, String kind, String biztime, double latitude, double longitude, double distance, int rev_num,
			int rev_grade, int hits, String thisCode) {
		super();
		this.loc_seq = loc_seq;
		this.number = number;
		this.cp_name = cp_name;
		this.road_addr = road_addr;
		this.local_addr = local_addr;
		this.tel = tel;
		this.info = info;
		this.kind = kind;
		this.biztime = biztime;
		this.latitude = latitude;
		this.longitude = longitude;
		this.distance = distance;
		this.rev_num = rev_num;
		this.rev_grade = rev_grade;
		this.hits = hits;
		this.thisCode = thisCode;
	}
	public int getLoc_seq() {
		return loc_seq;
	}
	public void setLoc_seq(int loc_seq) {
		this.loc_seq = loc_seq;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public String getRoad_addr() {
		return road_addr;
	}
	public void setRoad_addr(String road_addr) {
		this.road_addr = road_addr;
	}
	public String getLocal_addr() {
		return local_addr;
	}
	public void setLocal_addr(String local_addr) {
		this.local_addr = local_addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getBiztime() {
		return biztime;
	}
	public void setBiztime(String biztime) {
		this.biztime = biztime;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getRev_num() {
		return rev_num;
	}
	public void setRev_num(int rev_num) {
		this.rev_num = rev_num;
	}
	public int getRev_grade() {
		return rev_grade;
	}
	public void setRev_grade(int rev_grade) {
		this.rev_grade = rev_grade;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getThisCode() {
		return thisCode;
	}
	public void setThisCode(String thisCode) {
		this.thisCode = thisCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((biztime == null) ? 0 : biztime.hashCode());
		result = prime * result + ((cp_name == null) ? 0 : cp_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + hits;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + loc_seq;
		result = prime * result + ((local_addr == null) ? 0 : local_addr.hashCode());
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + number;
		result = prime * result + rev_grade;
		result = prime * result + rev_num;
		result = prime * result + ((road_addr == null) ? 0 : road_addr.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		LocalCPInfoVO other = (LocalCPInfoVO) obj;
		if (biztime == null) {
			if (other.biztime != null)
				return false;
		} else if (!biztime.equals(other.biztime))
			return false;
		if (cp_name == null) {
			if (other.cp_name != null)
				return false;
		} else if (!cp_name.equals(other.cp_name))
			return false;
		if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
			return false;
		if (hits != other.hits)
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (loc_seq != other.loc_seq)
			return false;
		if (local_addr == null) {
			if (other.local_addr != null)
				return false;
		} else if (!local_addr.equals(other.local_addr))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (number != other.number)
			return false;
		if (rev_grade != other.rev_grade)
			return false;
		if (rev_num != other.rev_num)
			return false;
		if (road_addr == null) {
			if (other.road_addr != null)
				return false;
		} else if (!road_addr.equals(other.road_addr))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
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
		return "LocalCPInfoVO [loc_seq=" + loc_seq + ", number=" + number + ", cp_name=" + cp_name + ", road_addr="
				+ road_addr + ", local_addr=" + local_addr + ", tel=" + tel + ", info=" + info + ", kind=" + kind
				+ ", biztime=" + biztime + ", latitude=" + latitude + ", longitude=" + longitude + ", distance="
				+ distance + ", rev_num=" + rev_num + ", rev_grade=" + rev_grade + ", hits=" + hits + ", thisCode="
				+ thisCode + "]";
	}
}

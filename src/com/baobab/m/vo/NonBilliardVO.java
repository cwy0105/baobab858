package com.baobab.m.vo;

public class NonBilliardVO {
	private int seq_num;
	private int num;
	private String cp_name;
	private String road_addr;
	private String local_addr;
	private String tel;
	private String info;
	private String kind;
	private int rev_num;
	private int hits;
	private int rev_grade;
	private double latitude;
	private double longitude;
	private double distance;
	public NonBilliardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NonBilliardVO(int seq_num, int num, String cp_name, String road_addr, String local_addr, String tel,
			String info, String kind, int rev_num, int hits, int rev_grade, double latitude, double longitude,
			double distance) {
		super();
		this.seq_num = seq_num;
		this.num = num;
		this.cp_name = cp_name;
		this.road_addr = road_addr;
		this.local_addr = local_addr;
		this.tel = tel;
		this.info = info;
		this.kind = kind;
		this.rev_num = rev_num;
		this.hits = hits;
		this.rev_grade = rev_grade;
		this.latitude = latitude;
		this.longitude = longitude;
		this.distance = distance;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public int getRev_num() {
		return rev_num;
	}
	public void setRev_num(int rev_num) {
		this.rev_num = rev_num;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getRev_grade() {
		return rev_grade;
	}
	public void setRev_grade(int rev_grade) {
		this.rev_grade = rev_grade;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cp_name == null) ? 0 : cp_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + hits;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((local_addr == null) ? 0 : local_addr.hashCode());
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + num;
		result = prime * result + rev_grade;
		result = prime * result + rev_num;
		result = prime * result + ((road_addr == null) ? 0 : road_addr.hashCode());
		result = prime * result + seq_num;
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		NonBilliardVO other = (NonBilliardVO) obj;
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
		if (local_addr == null) {
			if (other.local_addr != null)
				return false;
		} else if (!local_addr.equals(other.local_addr))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (num != other.num)
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
		if (seq_num != other.seq_num)
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NonBilliardVO [seq_num=" + seq_num + ", num=" + num + ", cp_name=" + cp_name + ", road_addr="
				+ road_addr + ", local_addr=" + local_addr + ", tel=" + tel + ", info=" + info + ", kind=" + kind
				+ ", rev_num=" + rev_num + ", hits=" + hits + ", rev_grade=" + rev_grade + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", distance=" + distance + "]";
	}
}

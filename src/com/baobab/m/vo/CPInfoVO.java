package com.baobab.m.vo;

import java.util.Date;

public class CPInfoVO {
	private String CP_name;
	private String owner_email;
	private String CP_grade;
	private String CP_level;
	private String CP_phon;
	private String CP_address;
	private String CP_addr_details;
	private String CP_zipcode;
	private String CP_location;
	private int CP_score;
	private int CP_rev_grade;
	private int CP_rev_num;
	private String Business_start;
	private String Business_end;
	private String CP_intro;
	private String CP_kind;
	private String CP_type;
	private String CP_Theme1;
	private String CP_Theme2;
	private String parking;
	private String close_day;
	private String close_ect;
	private String band_name;
	private Date CP_band_date;
	private String CP_lis_num;
	private int CP_hits;
	private int cur_hits;
	private int CP_calls;
	private String fran_name;
	private double longitude;
	private double latitude;
	private String cp_div;
	private int seq_num;
	private double distance;
	public CPInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CPInfoVO(String cP_name, String owner_email, String cP_grade, String cP_level, String cP_phon,
			String cP_address, String cP_addr_details, String cP_zipcode, String cP_location, int cP_score,
			int cP_rev_grade, int cP_rev_num, String business_start, String business_end, String cP_intro,
			String cP_kind, String cP_type, String cP_Theme1, String cP_Theme2, String parking, String close_day,
			String close_ect, String band_name, Date cP_band_date, String cP_lis_num, int cP_hits, int cur_hits,
			int cP_calls, String fran_name, double longitude, double latitude, String cp_div, int seq_num,
			double distance) {
		super();
		CP_name = cP_name;
		this.owner_email = owner_email;
		CP_grade = cP_grade;
		CP_level = cP_level;
		CP_phon = cP_phon;
		CP_address = cP_address;
		CP_addr_details = cP_addr_details;
		CP_zipcode = cP_zipcode;
		CP_location = cP_location;
		CP_score = cP_score;
		CP_rev_grade = cP_rev_grade;
		CP_rev_num = cP_rev_num;
		Business_start = business_start;
		Business_end = business_end;
		CP_intro = cP_intro;
		CP_kind = cP_kind;
		CP_type = cP_type;
		CP_Theme1 = cP_Theme1;
		CP_Theme2 = cP_Theme2;
		this.parking = parking;
		this.close_day = close_day;
		this.close_ect = close_ect;
		this.band_name = band_name;
		CP_band_date = cP_band_date;
		CP_lis_num = cP_lis_num;
		CP_hits = cP_hits;
		this.cur_hits = cur_hits;
		CP_calls = cP_calls;
		this.fran_name = fran_name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.cp_div = cp_div;
		this.seq_num = seq_num;
		this.distance = distance;
	}
	public String getCP_name() {
		return CP_name;
	}
	public void setCP_name(String cP_name) {
		CP_name = cP_name;
	}
	public String getOwner_email() {
		return owner_email;
	}
	public void setOwner_email(String owner_email) {
		this.owner_email = owner_email;
	}
	public String getCP_grade() {
		return CP_grade;
	}
	public void setCP_grade(String cP_grade) {
		CP_grade = cP_grade;
	}
	public String getCP_level() {
		return CP_level;
	}
	public void setCP_level(String cP_level) {
		CP_level = cP_level;
	}
	public String getCP_phon() {
		return CP_phon;
	}
	public void setCP_phon(String cP_phon) {
		CP_phon = cP_phon;
	}
	public String getCP_address() {
		return CP_address;
	}
	public void setCP_address(String cP_address) {
		CP_address = cP_address;
	}
	public String getCP_addr_details() {
		return CP_addr_details;
	}
	public void setCP_addr_details(String cP_addr_details) {
		CP_addr_details = cP_addr_details;
	}
	public String getCP_zipcode() {
		return CP_zipcode;
	}
	public void setCP_zipcode(String cP_zipcode) {
		CP_zipcode = cP_zipcode;
	}
	public String getCP_location() {
		return CP_location;
	}
	public void setCP_location(String cP_location) {
		CP_location = cP_location;
	}
	public int getCP_score() {
		return CP_score;
	}
	public void setCP_score(int cP_score) {
		CP_score = cP_score;
	}
	public int getCP_rev_grade() {
		return CP_rev_grade;
	}
	public void setCP_rev_grade(int cP_rev_grade) {
		CP_rev_grade = cP_rev_grade;
	}
	public int getCP_rev_num() {
		return CP_rev_num;
	}
	public void setCP_rev_num(int cP_rev_num) {
		CP_rev_num = cP_rev_num;
	}
	public String getBusiness_start() {
		return Business_start;
	}
	public void setBusiness_start(String business_start) {
		Business_start = business_start;
	}
	public String getBusiness_end() {
		return Business_end;
	}
	public void setBusiness_end(String business_end) {
		Business_end = business_end;
	}
	public String getCP_intro() {
		return CP_intro;
	}
	public void setCP_intro(String cP_intro) {
		CP_intro = cP_intro;
	}
	public String getCP_kind() {
		return CP_kind;
	}
	public void setCP_kind(String cP_kind) {
		CP_kind = cP_kind;
	}
	public String getCP_type() {
		return CP_type;
	}
	public void setCP_type(String cP_type) {
		CP_type = cP_type;
	}
	public String getCP_Theme1() {
		return CP_Theme1;
	}
	public void setCP_Theme1(String cP_Theme1) {
		CP_Theme1 = cP_Theme1;
	}
	public String getCP_Theme2() {
		return CP_Theme2;
	}
	public void setCP_Theme2(String cP_Theme2) {
		CP_Theme2 = cP_Theme2;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getClose_day() {
		return close_day;
	}
	public void setClose_day(String close_day) {
		this.close_day = close_day;
	}
	public String getClose_ect() {
		return close_ect;
	}
	public void setClose_ect(String close_ect) {
		this.close_ect = close_ect;
	}
	public String getBand_name() {
		return band_name;
	}
	public void setBand_name(String band_name) {
		this.band_name = band_name;
	}
	public Date getCP_band_date() {
		return CP_band_date;
	}
	public void setCP_band_date(Date cP_band_date) {
		CP_band_date = cP_band_date;
	}
	public String getCP_lis_num() {
		return CP_lis_num;
	}
	public void setCP_lis_num(String cP_lis_num) {
		CP_lis_num = cP_lis_num;
	}
	public int getCP_hits() {
		return CP_hits;
	}
	public void setCP_hits(int cP_hits) {
		CP_hits = cP_hits;
	}
	public int getCur_hits() {
		return cur_hits;
	}
	public void setCur_hits(int cur_hits) {
		this.cur_hits = cur_hits;
	}
	public int getCP_calls() {
		return CP_calls;
	}
	public void setCP_calls(int cP_calls) {
		CP_calls = cP_calls;
	}
	public String getFran_name() {
		return fran_name;
	}
	public void setFran_name(String fran_name) {
		this.fran_name = fran_name;
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
	public String getCp_div() {
		return cp_div;
	}
	public void setCp_div(String cp_div) {
		this.cp_div = cp_div;
	}
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
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
		result = prime * result + ((Business_end == null) ? 0 : Business_end.hashCode());
		result = prime * result + ((Business_start == null) ? 0 : Business_start.hashCode());
		result = prime * result + ((CP_Theme1 == null) ? 0 : CP_Theme1.hashCode());
		result = prime * result + ((CP_Theme2 == null) ? 0 : CP_Theme2.hashCode());
		result = prime * result + ((CP_addr_details == null) ? 0 : CP_addr_details.hashCode());
		result = prime * result + ((CP_address == null) ? 0 : CP_address.hashCode());
		result = prime * result + ((CP_band_date == null) ? 0 : CP_band_date.hashCode());
		result = prime * result + CP_calls;
		result = prime * result + ((CP_grade == null) ? 0 : CP_grade.hashCode());
		result = prime * result + CP_hits;
		result = prime * result + ((CP_intro == null) ? 0 : CP_intro.hashCode());
		result = prime * result + ((CP_kind == null) ? 0 : CP_kind.hashCode());
		result = prime * result + ((CP_level == null) ? 0 : CP_level.hashCode());
		result = prime * result + ((CP_lis_num == null) ? 0 : CP_lis_num.hashCode());
		result = prime * result + ((CP_location == null) ? 0 : CP_location.hashCode());
		result = prime * result + ((CP_name == null) ? 0 : CP_name.hashCode());
		result = prime * result + ((CP_phon == null) ? 0 : CP_phon.hashCode());
		result = prime * result + CP_rev_grade;
		result = prime * result + CP_rev_num;
		result = prime * result + CP_score;
		result = prime * result + ((CP_type == null) ? 0 : CP_type.hashCode());
		result = prime * result + ((CP_zipcode == null) ? 0 : CP_zipcode.hashCode());
		result = prime * result + ((band_name == null) ? 0 : band_name.hashCode());
		result = prime * result + ((close_day == null) ? 0 : close_day.hashCode());
		result = prime * result + ((close_ect == null) ? 0 : close_ect.hashCode());
		result = prime * result + ((cp_div == null) ? 0 : cp_div.hashCode());
		result = prime * result + cur_hits;
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((fran_name == null) ? 0 : fran_name.hashCode());
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((owner_email == null) ? 0 : owner_email.hashCode());
		result = prime * result + ((parking == null) ? 0 : parking.hashCode());
		result = prime * result + seq_num;
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
		CPInfoVO other = (CPInfoVO) obj;
		if (Business_end == null) {
			if (other.Business_end != null)
				return false;
		} else if (!Business_end.equals(other.Business_end))
			return false;
		if (Business_start == null) {
			if (other.Business_start != null)
				return false;
		} else if (!Business_start.equals(other.Business_start))
			return false;
		if (CP_Theme1 == null) {
			if (other.CP_Theme1 != null)
				return false;
		} else if (!CP_Theme1.equals(other.CP_Theme1))
			return false;
		if (CP_Theme2 == null) {
			if (other.CP_Theme2 != null)
				return false;
		} else if (!CP_Theme2.equals(other.CP_Theme2))
			return false;
		if (CP_addr_details == null) {
			if (other.CP_addr_details != null)
				return false;
		} else if (!CP_addr_details.equals(other.CP_addr_details))
			return false;
		if (CP_address == null) {
			if (other.CP_address != null)
				return false;
		} else if (!CP_address.equals(other.CP_address))
			return false;
		if (CP_band_date == null) {
			if (other.CP_band_date != null)
				return false;
		} else if (!CP_band_date.equals(other.CP_band_date))
			return false;
		if (CP_calls != other.CP_calls)
			return false;
		if (CP_grade == null) {
			if (other.CP_grade != null)
				return false;
		} else if (!CP_grade.equals(other.CP_grade))
			return false;
		if (CP_hits != other.CP_hits)
			return false;
		if (CP_intro == null) {
			if (other.CP_intro != null)
				return false;
		} else if (!CP_intro.equals(other.CP_intro))
			return false;
		if (CP_kind == null) {
			if (other.CP_kind != null)
				return false;
		} else if (!CP_kind.equals(other.CP_kind))
			return false;
		if (CP_level == null) {
			if (other.CP_level != null)
				return false;
		} else if (!CP_level.equals(other.CP_level))
			return false;
		if (CP_lis_num == null) {
			if (other.CP_lis_num != null)
				return false;
		} else if (!CP_lis_num.equals(other.CP_lis_num))
			return false;
		if (CP_location == null) {
			if (other.CP_location != null)
				return false;
		} else if (!CP_location.equals(other.CP_location))
			return false;
		if (CP_name == null) {
			if (other.CP_name != null)
				return false;
		} else if (!CP_name.equals(other.CP_name))
			return false;
		if (CP_phon == null) {
			if (other.CP_phon != null)
				return false;
		} else if (!CP_phon.equals(other.CP_phon))
			return false;
		if (CP_rev_grade != other.CP_rev_grade)
			return false;
		if (CP_rev_num != other.CP_rev_num)
			return false;
		if (CP_score != other.CP_score)
			return false;
		if (CP_type == null) {
			if (other.CP_type != null)
				return false;
		} else if (!CP_type.equals(other.CP_type))
			return false;
		if (CP_zipcode == null) {
			if (other.CP_zipcode != null)
				return false;
		} else if (!CP_zipcode.equals(other.CP_zipcode))
			return false;
		if (band_name == null) {
			if (other.band_name != null)
				return false;
		} else if (!band_name.equals(other.band_name))
			return false;
		if (close_day == null) {
			if (other.close_day != null)
				return false;
		} else if (!close_day.equals(other.close_day))
			return false;
		if (close_ect == null) {
			if (other.close_ect != null)
				return false;
		} else if (!close_ect.equals(other.close_ect))
			return false;
		if (cp_div == null) {
			if (other.cp_div != null)
				return false;
		} else if (!cp_div.equals(other.cp_div))
			return false;
		if (cur_hits != other.cur_hits)
			return false;
		if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
			return false;
		if (fran_name == null) {
			if (other.fran_name != null)
				return false;
		} else if (!fran_name.equals(other.fran_name))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (owner_email == null) {
			if (other.owner_email != null)
				return false;
		} else if (!owner_email.equals(other.owner_email))
			return false;
		if (parking == null) {
			if (other.parking != null)
				return false;
		} else if (!parking.equals(other.parking))
			return false;
		if (seq_num != other.seq_num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CPInfoVO [CP_name=" + CP_name + ", owner_email=" + owner_email + ", CP_grade=" + CP_grade
				+ ", CP_level=" + CP_level + ", CP_phon=" + CP_phon + ", CP_address=" + CP_address
				+ ", CP_addr_details=" + CP_addr_details + ", CP_zipcode=" + CP_zipcode + ", CP_location=" + CP_location
				+ ", CP_score=" + CP_score + ", CP_rev_grade=" + CP_rev_grade + ", CP_rev_num=" + CP_rev_num
				+ ", Business_start=" + Business_start + ", Business_end=" + Business_end + ", CP_intro=" + CP_intro
				+ ", CP_kind=" + CP_kind + ", CP_type=" + CP_type + ", CP_Theme1=" + CP_Theme1 + ", CP_Theme2="
				+ CP_Theme2 + ", parking=" + parking + ", close_day=" + close_day + ", close_ect=" + close_ect
				+ ", band_name=" + band_name + ", CP_band_date=" + CP_band_date + ", CP_lis_num=" + CP_lis_num
				+ ", CP_hits=" + CP_hits + ", cur_hits=" + cur_hits + ", CP_calls=" + CP_calls + ", fran_name="
				+ fran_name + ", longitude=" + longitude + ", latitude=" + latitude + ", cp_div=" + cp_div
				+ ", seq_num=" + seq_num + ", distance=" + distance + "]";
	}
}

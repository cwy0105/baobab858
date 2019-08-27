package com.baobab.m.vo;

public class ClassificationVO {
	private String no;
	private String cp_name;
	private String road_addr;
	private String local_addr;
	private String tel;
	private String info;
	private String kind;
	private int seq_num;
	public ClassificationVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassificationVO(String no, String cp_name, String road_addr, String local_addr, String tel, String info,
			String kind, int seq_num) {
		super();
		this.no = no;
		this.cp_name = cp_name;
		this.road_addr = road_addr;
		this.local_addr = local_addr;
		this.tel = tel;
		this.info = info;
		this.kind = kind;
		this.seq_num = seq_num;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
	public int getSeq_num() {
		return seq_num;
	}
	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cp_name == null) ? 0 : cp_name.hashCode());
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + ((local_addr == null) ? 0 : local_addr.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
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
		ClassificationVO other = (ClassificationVO) obj;
		if (cp_name == null) {
			if (other.cp_name != null)
				return false;
		} else if (!cp_name.equals(other.cp_name))
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
		if (local_addr == null) {
			if (other.local_addr != null)
				return false;
		} else if (!local_addr.equals(other.local_addr))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
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
		return "ClassificationVO [no=" + no + ", cp_name=" + cp_name + ", road_addr=" + road_addr + ", local_addr="
				+ local_addr + ", tel=" + tel + ", info=" + info + ", kind=" + kind + ", seq_num=" + seq_num + "]";
	}
	
	
}

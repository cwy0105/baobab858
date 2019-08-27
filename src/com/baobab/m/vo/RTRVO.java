package com.baobab.m.vo;

import java.util.List;

public class RTRVO {
	private CPInfoVO info;
	private List<CPmainImgVO> imgvo;
	public RTRVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RTRVO(CPInfoVO info, List<CPmainImgVO> imgvo) {
		super();
		this.info = info;
		this.imgvo = imgvo;
	}
	public CPInfoVO getInfo() {
		return info;
	}
	public void setInfo(CPInfoVO info) {
		this.info = info;
	}
	public List<CPmainImgVO> getImgvo() {
		return imgvo;
	}
	public void setImgvo(List<CPmainImgVO> imgvo) {
		this.imgvo = imgvo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imgvo == null) ? 0 : imgvo.hashCode());
		result = prime * result + ((info == null) ? 0 : info.hashCode());
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
		RTRVO other = (RTRVO) obj;
		if (imgvo == null) {
			if (other.imgvo != null)
				return false;
		} else if (!imgvo.equals(other.imgvo))
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RTRVO [info=" + info + ", imgvo=" + imgvo + "]";
	}
}

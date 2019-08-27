package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.NonCpImgVO;
import com.baobab.m.vo.NonCpMenuVO;

public interface NonCPinfoDAO {
	List<NonCpMenuVO> getMenus(int seq, String cpName);
	List<NonCpImgVO> getImg(int seq, String cpName);
}

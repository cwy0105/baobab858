package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.NonCpImgVO;
import com.baobab.m.vo.NonCpMenuVO;

@Mapper
public interface NonCPinfoMapper {
	List<NonCpMenuVO> getMenus(LocalCPInfoVO vo);
	List<NonCpImgVO> getImg(LocalCPInfoVO vo);
}

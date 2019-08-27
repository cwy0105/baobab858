package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.AlMightyVO;
import com.baobab.m.vo.CPInfoVO;

@Mapper
public interface AlmightyMapper {
	List<CPInfoVO> cpSearch(String searchWord);
	List<AlMightyVO> almightyLogin(AlMightyVO vo);
}
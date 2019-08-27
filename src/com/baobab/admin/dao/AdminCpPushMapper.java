package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.CpPushVO;

@Mapper
public interface AdminCpPushMapper {
	List<CpPushVO> pushSelect(String searchWord);
}

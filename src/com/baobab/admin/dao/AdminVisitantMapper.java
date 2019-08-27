package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.AdminVisitantVO;

@Mapper
public interface AdminVisitantMapper {
	List<AdminVisitantVO> visitants(AdminVisitantVO vo);
	List<AdminVisitantVO> visitant(AdminVisitantVO vo);
}

package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.SearchVO;

@Mapper
public interface AdminCPMapper {
	List<CPInfoVO> search(SearchVO vo);
}

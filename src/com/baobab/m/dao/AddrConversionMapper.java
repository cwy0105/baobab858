package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.NonBilliardVO;

@Mapper
public interface AddrConversionMapper {
	List<NonBilliardVO> getList();
	void updateGeo(NonBilliardVO vo);
}

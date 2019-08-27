package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.NonBilliardVO;

public interface AddrConversionDAO {
	List<NonBilliardVO> getList();
	void updateGeo(NonBilliardVO vo);
}

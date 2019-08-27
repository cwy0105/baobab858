package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.NonBilliardVO;
import com.baobab.m.vo.SearchVO;

public interface BilliardSearchDAO {
	List<NonBilliardVO> disAll(SearchVO vo);
	List<NonBilliardVO> disLocal(SearchVO vo);
	List<NonBilliardVO> disName(SearchVO vo);
	List<NonBilliardVO> surrounding(SearchVO vo);
	List<NonBilliardVO> popAll(SearchVO vo);
	List<NonBilliardVO> popLocal(SearchVO vo);
	List<NonBilliardVO> popName(SearchVO vo);
}

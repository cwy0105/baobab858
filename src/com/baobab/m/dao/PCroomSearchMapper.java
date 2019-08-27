package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.NonPCroomVO;
import com.baobab.m.vo.SearchVO;

@Mapper
public interface PCroomSearchMapper {
	List<NonPCroomVO> disAll(SearchVO vo);
	List<NonPCroomVO> disLocal(SearchVO vo);
	List<NonPCroomVO> disName(SearchVO vo);
	List<NonPCroomVO> surrounding(SearchVO vo);
	List<NonPCroomVO> popAll(SearchVO vo);
	List<NonPCroomVO> popLocal(SearchVO vo);
	List<NonPCroomVO> popName(SearchVO vo);
}

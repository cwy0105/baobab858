package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.NonKaraokeVO;
import com.baobab.m.vo.SearchVO;

@Mapper
public interface KaraokeSearchMapper {
	List<NonKaraokeVO> disAll(SearchVO vo);
	List<NonKaraokeVO> disLocal(SearchVO vo);
	List<NonKaraokeVO> disName(SearchVO vo);
	List<NonKaraokeVO> surrounding(SearchVO vo);
	List<NonKaraokeVO> popAll(SearchVO vo);
	List<NonKaraokeVO> popLocal(SearchVO vo);
	List<NonKaraokeVO> popName(SearchVO vo);
}

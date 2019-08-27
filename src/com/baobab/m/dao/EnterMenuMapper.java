package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPEnterMenuVO;

@Mapper
public interface EnterMenuMapper {
	void menuInsert(CPEnterMenuVO vo);
	void menuDel(CPEnterMenuVO vo);
	List<CPEnterMenuVO> menuSelect(int cpSeq);
	void menuUpdate(CPEnterMenuVO vo);
}

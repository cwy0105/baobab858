package com.baobab.m.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.CPEnterMenuVO;

public interface EnterMenuDAO {
	int menuInsert(HttpServletRequest request);
	int menuDel(int cpSeq, int seqNum);
	List<CPEnterMenuVO> menuSelect(int cpSeq);
	int menuUpdate(HttpServletRequest request);
}

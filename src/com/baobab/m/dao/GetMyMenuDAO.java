package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.MenuVO;

public interface GetMyMenuDAO {
	List<MenuVO> getMenu(int cpSeq);
	List<MenuVO> getThisMenu(int cpSeq);
	String menuImageUrl(String cpName, int cpSeq, String menuName);
	int menuUrlUpdate(String menuUrl, String menuName, int cpSeq);
}

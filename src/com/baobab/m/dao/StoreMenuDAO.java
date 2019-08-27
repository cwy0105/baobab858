package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.MenuVO;

public interface StoreMenuDAO {
	List<MenuVO> getMenus(int cpSeq, String menuDiv);
	void updateHits(String cpName, int seqNum);
	void updateNonHits(String cpName, int seqNum, String div);
	List<MenuVO> getOneMenu(String cpName, String menuName, int cpSeq);
	void updateCurHits(String cpName, int seqNum);
	void hitsInitialize();
}

package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.SetMenuInfoVO;
import com.baobab.m.vo.SetMenuVO;

public interface AdminCPDetailDAO {
	CPInfoVO cpInfo(String cpName);
	int poke(String cpName);
	List<SetMenuVO> setMenu(String cpName);
	List<SetMenuInfoVO> setInfo(String cpName);
	List<MenuVO> menu(String cpName);
	List<MenuVO> setLikeMenu(List<SetMenuVO> set, List<SetMenuInfoVO> info);
}

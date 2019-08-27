package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.SetMenuInfoVO;
import com.baobab.m.vo.SetMenuVO;

@Mapper
public interface AdminCPDetailMapper {
	CPInfoVO cpInfo(String cpName);
	List<PokeVO> poke(String cpName);
	List<SetMenuVO> setMenu(String cpName);
	List<SetMenuInfoVO> setInfo(String cpName);
	List<MenuVO> menu(String cpName);
}

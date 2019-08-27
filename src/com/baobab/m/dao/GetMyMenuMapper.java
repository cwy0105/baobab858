package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.MenuVO;

@Mapper
public interface GetMyMenuMapper {
	List<MenuVO> getMenu(int cpSeq);
	List<MenuVO> getThisMenu(int cpSeq);
	List<String> menuImageUrl(MenuVO vo);
	int menuUrlUpdate(MenuVO vo);
}

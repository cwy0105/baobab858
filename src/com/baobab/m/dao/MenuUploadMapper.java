package com.baobab.m.dao;

import com.baobab.m.vo.MenuVO;

@Mapper
public interface MenuUploadMapper {
	public void menuUp(MenuVO mvo);
	void menuDel(MenuVO vo);
	void menuModi(MenuVO vo);
}

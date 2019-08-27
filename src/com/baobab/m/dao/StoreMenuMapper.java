package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.NonBilliardVO;
import com.baobab.m.vo.NonKaraokeVO;
import com.baobab.m.vo.NonPCroomVO;

@Mapper
public interface StoreMenuMapper {
	List<MenuVO> getMenus(String cpName, String menuDiv);
	void updateHits(CPInfoVO vo);
	void updateNonHits(LocalCPInfoVO vo);
	List<MenuVO> getOneMenu(MenuVO vo);
	void updateCurHits(CPInfoVO vo);
	void hitsInitialize();
	void updatePCHits(NonPCroomVO vo);
	void updateBilliHits(NonBilliardVO vo);
	void updateKaraHits(NonKaraokeVO vo);
}

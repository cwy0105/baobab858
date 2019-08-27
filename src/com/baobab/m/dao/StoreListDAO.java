package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.PageSearchVO;

public interface StoreListDAO {
	List<LocalCPInfoVO> getAllinfo(PageSearchVO vo);
	List<LocalCPInfoVO> getLocalinfo(PageSearchVO vo);
	List<LocalCPInfoVO> getMenuinfo(PageSearchVO vo);
	List<LocalCPInfoVO> getNameInfo(PageSearchVO vo);
	List<LocalCPInfoVO> getKindInfo(PageSearchVO vo);
	List<LocalCPInfoVO> selectSurroundings(PageSearchVO vo);
	List<LocalCPInfoVO> selectPopAllinfo(PageSearchVO vo);
	List<LocalCPInfoVO> selectPopLocalinfo(PageSearchVO vo);
	List<LocalCPInfoVO> selectPopMenuinfo(PageSearchVO vo);
	List<LocalCPInfoVO> selectPopNameinfo(PageSearchVO vo);
	List<LocalCPInfoVO> selectPopKindinfo(PageSearchVO vo);
}

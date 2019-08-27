package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.PageSearchVO;

@Mapper
public interface StoreListMapper {
	List<LocalCPInfoVO> selectAllinfo(PageSearchVO vo);
	List<LocalCPInfoVO> selectLocalinfo(PageSearchVO vo);
	List<LocalCPInfoVO> selectMenuinfo(PageSearchVO vo);
	List<LocalCPInfoVO> selectNameinfo(PageSearchVO vo);
	List<LocalCPInfoVO> selectKindinfo(PageSearchVO vo);
	List<LocalCPInfoVO> selectSurroundings(PageSearchVO vo);
	List<LocalCPInfoVO> selectPopAllinfo(PageSearchVO vo);
	List<LocalCPInfoVO> selectPopLocalinfo(PageSearchVO vo);
	List<LocalCPInfoVO> selectPopMenuinfo(PageSearchVO vo);
	List<LocalCPInfoVO> selectPopNameinfo(PageSearchVO vo);
	List<LocalCPInfoVO> selectPopKindinfo(PageSearchVO vo);
}

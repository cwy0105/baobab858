package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.PageSearchVO;

public interface GetOurCPDAO {
	//인기순
	List<CPInfoVO> getOursPopularity(PageSearchVO vo);
	List<CPInfoVO> getOursPopLocation(PageSearchVO vo);
	List<CPInfoVO> getOursPopCpName(PageSearchVO vo);
	List<CPInfoVO> getOursPopMenu(PageSearchVO vo);
	List<CPInfoVO> getOursPopKind(PageSearchVO vo);
	List<CPInfoVO> getOurCouponPopularity(PageSearchVO vo);
	//거리순
	List<CPInfoVO> getOursDistance(PageSearchVO vo);
	List<CPInfoVO> getOursDisLocation(PageSearchVO vo);
	List<CPInfoVO> getOursDisCpName(PageSearchVO vo);
	List<CPInfoVO> getOursDisMenu(PageSearchVO vo);
	List<CPInfoVO> getOursDisKind(PageSearchVO vo);
	List<CPInfoVO> getSurroundingsOur(PageSearchVO vo);
	List<CPInfoVO> getOurCouponDistance(PageSearchVO vo);
}

package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPmainImgVO;
import com.baobab.m.vo.CallHistoryVO;
import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.NonCpImgVO;
import com.baobab.m.vo.NonCpMenuVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.ReviewVO;

@Mapper
public interface NonDataMoveMapper {
	CPInfoVO selectSeq(CPInfoVO vo);
	List<LocalCPInfoVO> nonSelect(CPInfoVO vo);
	void nonDelete(CPInfoVO vo);
	List<NonCpImgVO> selectImg(int nonSeq);
	void insertImg(CPmainImgVO vo);
	void deleteImg(int nonSeq);
	List<NonCpMenuVO> selectMenu(int nonSeq);
	void insertMenu(MenuVO vo);
	void deleteMenu(int nonSeq);
	void updateInfo(LocalCPInfoVO vo);
	void updateCall(CallHistoryVO vo);
	void updatePoke(PokeVO vo);
	void updateReview(ReviewVO vo);
}

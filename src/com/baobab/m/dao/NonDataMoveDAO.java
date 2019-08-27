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

public interface NonDataMoveDAO {
	int selectSeq(CPInfoVO vo);
	List<LocalCPInfoVO> nonSelect(CPInfoVO vo);
	int nonDelete(CPInfoVO vo);
	List<NonCpImgVO> selectImg(int nonSeq);
	int insertImg(CPmainImgVO vo);
	int deleteImg(int nonSeq);
	List<NonCpMenuVO> selectMenu(int nonSeq);
	int insertMenu(MenuVO vo);
	int deleteMenu(int nonSeq);
	void updateInfo(LocalCPInfoVO vo);
	void updateCall(CallHistoryVO vo);
	void updatePoke(PokeVO vo);
	void updateReview(ReviewVO vo);
}

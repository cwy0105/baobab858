package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPmainImgVO;
import com.baobab.m.vo.UserAllVO;

@Mapper
public interface RealTimeReviewMapper {

	void reviewNickName(UserAllVO vo);
	void reviewProfile(UserAllVO vo);
	List<UserAllVO> checkNickName(String nickName);
	List<UserAllVO> userProfile(String email);
	CPInfoVO getCp(int cpSeq);
	List<CPmainImgVO> getImg(int cpSeq);
	void profileDelete(String email);
	void updateNickname(UserAllVO vo);
}

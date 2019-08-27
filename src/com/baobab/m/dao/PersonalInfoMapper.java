package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.UserAllVO;

@Mapper
public interface PersonalInfoMapper {
	List<UserAllVO> findEmail(String phoneNum);
	UserAllVO findPassword(UserAllVO vo);
	void updatePassword(UserAllVO vo);
}

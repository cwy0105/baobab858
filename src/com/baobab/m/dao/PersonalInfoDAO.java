package com.baobab.m.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.UserAllVO;

public interface PersonalInfoDAO {
	List<UserAllVO> findEmail(String phoneNum);
	UserAllVO findPassword(HttpServletRequest request);
	int updatePassword(HttpServletRequest request);
}

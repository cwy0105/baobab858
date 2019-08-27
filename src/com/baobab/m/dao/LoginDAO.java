package com.baobab.m.dao;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.UserAllVO;

public interface LoginDAO {
	UserAllVO loginConfirm(String email, String password);
	CPInfoVO getMyInfo(int cpSeq);
	String getCpUserInfo(String email);
	void getHistory(HttpServletRequest request);
	CPInfoVO getStoreInfo(String cpName, String email);
}

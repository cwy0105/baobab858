package com.baobab.m.dao;

import javax.servlet.http.HttpServletRequest;

public interface UserJoinDAO {
	void userAllJoin(String email, String password, String phoneNum, String pushCheck);
	void userHistoryJoin(String email);
	String getUserPhone(String email);
	String getCpPhone(int cpSeq);
	void userInfoChange(String email, String password, String pushCheck);
	void leaveUserAll(String email);
	void leaveUserHistory(String email);
	int userCodeUpdate(HttpServletRequest request);
	int dupEmail(HttpServletRequest request);
	int emailCheck(HttpServletRequest request);
	int point(String email);
	int nowPoint(String email);
}

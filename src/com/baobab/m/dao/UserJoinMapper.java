package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserHistoryVO;

@Mapper
public interface UserJoinMapper {
	void userAllJoin(UserAllVO vo);
	void userHistoryJoin(UserHistoryVO vo);
	String getUserPhone(String email);
	String getCpPhone(int cpSeq);
	void userInfoChange(UserAllVO vo);
	void leaveUserAll(String email);
	void leaveUserHistory(String email);
	void userCodeUpdate(UserAllVO vo);
	UserAllVO dupEmail(String email);
	List<UserAllVO> emailCheck(UserAllVO vo);
	void userPointUp(String email);
	int userNowPoint(String email);
}

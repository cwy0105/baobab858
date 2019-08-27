package com.baobab.m.dao;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPUserVO;
import com.baobab.m.vo.LoginHistoryVO;
import com.baobab.m.vo.UserAllVO;

@Mapper
public interface LoginMapper {
	UserAllVO loginConfirm(String email, String password);
	CPInfoVO getMyInfo(int cpSeq);
	CPUserVO getCpUserInfo(String email);
	void getHistory(LoginHistoryVO vo);
	CPInfoVO getStoreInfo(CPUserVO vo);
}

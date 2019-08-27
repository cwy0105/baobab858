package com.baobab.m.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.PushPaymentVO;
import com.baobab.m.vo.UserLocationVO;

public interface PushDAO {
	List<UserLocationVO> pushToAll();
	List<UserLocationVO> pushToFan(HttpServletRequest request);
	List<UserLocationVO> pushToNormal(HttpServletRequest request);
	void savePush(HttpServletRequest request);
	List<UserLocationVO> sendToFan(HttpServletRequest request);
	List<UserLocationVO> sendToNormal(HttpServletRequest request);
	UserLocationVO findUser(String pushToken);
	CPInfoVO findCp(HttpServletRequest request);
	int pushPaymentMenu(HttpServletRequest request);
	List<PushPaymentVO> pushPaymentSelect(HttpServletRequest request);
	void pushTidUpdate(HttpServletRequest request);
	void pushPayCancel(HttpServletRequest request);
	void pushEaPlma(HttpServletRequest request);
	
}

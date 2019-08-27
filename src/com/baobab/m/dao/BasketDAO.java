package com.baobab.m.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.BasketVO;
import com.baobab.m.vo.CPInfoVO;

public interface BasketDAO {
	int confRepetition(String email, String cpName, int cpSeq, String menuName, String option, int ea, int price, int totalPrice);
	void inBasket(BasketVO vo);
	void upBasket(BasketVO vo, int seqNum);
	void delBasket(String email, String cpName, int cpSeq);
	List<BasketVO> basketList(String email);
	CPInfoVO basCpInfo(String cpName, int cpSeq);
	List<BasketVO> basDetailInfo(HttpServletRequest request);
}

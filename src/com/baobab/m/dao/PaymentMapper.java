package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.UserLocationVO;

public interface PaymentMapper {
	void payInfoInsert(PaymentVO vo);
	void statusChange(PaymentVO vo);
	List<PaymentVO> payAllSelect(PaymentVO vo);
	PaymentVO payOneSelect(PaymentVO vo);
	void delPayInfo(PaymentVO vo);
	void usedUpdate(PaymentVO vo);
	List<PaymentVO> cpAllSelect(PaymentVO vo);
	PaymentVO payDetail(PaymentVO vo);
	void receiptChange(PaymentVO vo);
	String useCheck(String orderNum);
	void tidUpdate(PaymentVO vo);
	void payCancel(PaymentVO vo);
	List<PaymentVO> payCurDate(String email);
	List<PaymentVO> cancelCurDate(String email);
	UserLocationVO customerPush(String user);
	UserLocationVO cpUserPush(int seq);
	
}

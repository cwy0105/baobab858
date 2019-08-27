package com.baobab.m.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.PaymentVO;

public interface PaymentDAO {
	void payInfoInsert(HttpServletRequest request);
	void statusChange(String oid, String status);
	List<PaymentVO> payAllSelect(HttpServletRequest request);
	PaymentVO payOneSelect(HttpServletRequest request);
	void delPayInfo(HttpServletRequest request);
	void usedUpdate(String orderNum);
	List<PaymentVO> cpAllSelect(String email, String used);
	PaymentVO payDetail(String orderNum);
	void receiptChange(String orderNum);
	String useCheck(String orderNum);
	void tidUpdate(HttpServletRequest request);
	void payCancel(HttpServletRequest request);
	List<PaymentVO> payCurDate(String email);
	List<PaymentVO> cancelCurDate(String email);
	int payPush(HttpServletRequest request) throws IOException;
	
}

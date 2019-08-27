package com.baobab.m.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.PaymentDAO;

@Service
public class PayStatusService {
	@Autowired
	PaymentDAO dao;
	
	public void CNMStatusChange(HttpServletRequest request) {
		String orderNum = request.getParameter("P_OID");
		String payType = request.getParameter("P_TYPE");
		String status = request.getParameter("P_STATUS");
		if(!payType.equals("vbank")) {
			dao.statusChange(orderNum, status);
			dao.tidUpdate(request);
			
		}
	}
}

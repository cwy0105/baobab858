package com.baobab.m.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.VisitantDAO;

@Service
public class VisitantClassifyimpl implements VisitantClassify {
	
	@Autowired
	VisitantDAO visit;

	@Override
	public int visitantDiv(String visitType, String visitDate, String userPhone) throws ParseException {
		if(visitType != null) { //�������ʹ湮��, �����湮��
			System.out.println("�����湮��");
			visit.accumulateVisit(userPhone, visitDate);
			visit.visitHistory(userPhone, visitType, visitDate);
		}else { //���ʹ湮��
			System.out.println("���ʹ湮��");
			visit.firstVisit(userPhone, visitDate);
			visit.visitHistory(userPhone, visitType, visitDate);
		}
		return visit.allVisitant();
	}

}

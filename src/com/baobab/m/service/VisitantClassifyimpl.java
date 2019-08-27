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
		if(visitType != null) { //당일최초방문자, 누적방문자
			System.out.println("기존방문자");
			visit.accumulateVisit(userPhone, visitDate);
			visit.visitHistory(userPhone, visitType, visitDate);
		}else { //최초방문자
			System.out.println("최초방문자");
			visit.firstVisit(userPhone, visitDate);
			visit.visitHistory(userPhone, visitType, visitDate);
		}
		return visit.allVisitant();
	}

}

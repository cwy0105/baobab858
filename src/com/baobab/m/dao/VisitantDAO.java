package com.baobab.m.dao;

import java.text.ParseException;

public interface VisitantDAO {
	void firstVisit(String user_phone, String lastDate);
	void accumulateVisit(String user_phone, String lastDate);
	void visitHistory(String user_phone, String visit_type, String lastDate) throws ParseException;
	int allVisitant();
}

package com.baobab.m.service;

import java.text.ParseException;

public interface VisitantClassify {
	int visitantDiv(String visitType, String visitDate, String userPhone) throws ParseException;
}

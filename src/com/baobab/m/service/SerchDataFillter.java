package com.baobab.m.service;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;

public interface SerchDataFillter {
	List<?> dataFilltering(String selectItem, String serchLoc, String location, int count, int listCount, String sortBy, String menu, 
			double longitude, double latitude, String t1_1);
	
	List<CPInfoVO> ourFillter(String selectItem, String serchLoc, String location, String sortBy, double longitude, double latitude, String menu,
			int listCount, String t1_1);
}

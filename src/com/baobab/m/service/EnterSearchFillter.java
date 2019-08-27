package com.baobab.m.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.CPInfoVO;

public interface EnterSearchFillter {
	List<CPInfoVO> ourFillter(HttpServletRequest request);
	List<?> nonFillter(HttpServletRequest request);
}

package com.baobab.admin.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.ReviewVO;

public interface AdminReviewDAO {
	List<ReviewVO> reviewList(HttpServletRequest request);
	ReviewVO reviewSelect(HttpServletRequest request);
}

package com.baobab.admin.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.CouponListVO;

public interface AdminCouponListDAO {
	
	List<CouponListVO> couponAll(HttpServletRequest request);
	CouponListVO couponSelect(HttpServletRequest request);
	int couponInfoUpdate(HttpServletRequest request);
}

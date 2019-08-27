package com.baobab.m.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.CouponListVO;

public interface CouponListDAO {

	void couponInfoInsert(HttpServletRequest request);
	List<CouponListVO> couponListSelect();
}

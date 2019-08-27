package com.baobab.m.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.CouponHistoryVO;
import com.baobab.m.vo.CouponUserVO;

public interface CouponUserDAO {

	int insertCouponUser(HttpServletRequest request);
	int insertCouponHistroy(HttpServletRequest request);
	int userCouponEa(HttpServletRequest request);
	List<CouponUserVO> getUserCoupon(HttpServletRequest request);
	void getCouponDlUserEa(HttpServletRequest request);
	int userCouponExpiry();
	List<CouponHistoryVO> usedCouponHistory(HttpServletRequest request);
}

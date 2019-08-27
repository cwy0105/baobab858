package com.baobab.admin.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CouponListVO;

@Repository
public class AdminCouponListDAOimpl implements AdminCouponListDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate coupon;
	
	@Override
	public List<CouponListVO> couponAll(HttpServletRequest request) {
		CouponListVO pvo = new CouponListVO();
		pvo.setCouponDiscountPrice(Integer.parseInt(request.getParameter("couponDiscointPrice")));
		pvo.setCouponName(request.getParameter("couponName"));
		pvo.setCouponPrice(Integer.parseInt(request.getParameter("couponPrice")));
		pvo.setEa(Integer.parseInt(request.getParameter("ea")));
		return coupon.selectList("com.baobab.admin.dao.AdminCouponListMapper", pvo);
	}
	
	@Override
	public CouponListVO couponSelect(HttpServletRequest request) {
		return coupon.selectOne("com.baobab.admin.dao.AdminCouponListMapper", request);
	}

	
	@Override
	public int couponInfoUpdate(HttpServletRequest request) {
			
		return coupon.update("com.baobab.admin.dao.AdminCouponListMapper", request);
	}

}

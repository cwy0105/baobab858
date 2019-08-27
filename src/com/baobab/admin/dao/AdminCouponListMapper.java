package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.CouponListVO;

@Mapper
public interface AdminCouponListMapper {
	
	List<CouponListVO> couponAll(CouponListVO vo);
	CouponListVO couponSelect(String couponName);
	void couponInfoUpdate(CouponListVO vo);

}

package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CouponListVO;
@Mapper
public interface CouponListMapper {
	
	void couponInfoInsert(CouponListVO vo);
	List<CouponListVO> couponListSelect(CouponListVO vo);
}

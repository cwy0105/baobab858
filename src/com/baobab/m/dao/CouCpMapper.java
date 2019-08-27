package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CouponCpVO;

@Mapper
public interface CouCpMapper {
	List<CouponCpVO> getCpCouList(CouponCpVO vo);
	void couCpInfoInsert(CouponCpVO vo);
	void couponCpUse(CouponCpVO vo);	
	List<CouponCpVO> couponCpPeriod(CouponCpVO vo);
	List<CouponCpVO> couPayDetail(String orderNum);
	List<CouponCpVO> getCouponMenu(int cp_seq);
	void cpCouponExpiry();
	
}

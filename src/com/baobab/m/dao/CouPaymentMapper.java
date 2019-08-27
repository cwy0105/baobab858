package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CouponPaymentVO;

@Mapper
public interface CouPaymentMapper {

	void couPayInfoInsert(CouponPaymentVO vo);
	List<CouponPaymentVO> couPaySelect(int cpSeq);
	void couTidUpdate(CouponPaymentVO vo);
	
}

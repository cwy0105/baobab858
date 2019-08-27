package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CouponHistoryVO;

@Mapper
public interface CouponHistroyMapper {

	void getCouponHistory(CouponHistoryVO vo);
	List<CouponHistoryVO> showCouponHistory(String dl_user_email);
	void delCouponHistory(int cp_seq);
}

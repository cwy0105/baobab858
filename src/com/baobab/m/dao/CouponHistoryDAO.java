package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CouponHistoryVO;

public interface CouponHistoryDAO {

	void getCouponHistory(String serial_num, String dl_user_email, String status, int cp_seq, String title);
	List<CouponHistoryVO> showCouponHistory(String dl_user_email);
	void delCouponHistory(int cp_seq);
}

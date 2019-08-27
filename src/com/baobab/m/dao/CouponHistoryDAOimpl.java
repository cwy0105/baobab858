package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CouponHistoryVO;

@Repository
public class CouponHistoryDAOimpl implements CouponHistoryDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate coupon;
	
	@Override
	public void getCouponHistory(String serial_num, String dl_user_email, String status, int cp_seq, String title) {
		CouponHistoryVO vo = new CouponHistoryVO();
		vo.setSerial_num(serial_num);
		vo.setCp_seq(cp_seq);
		vo.setDl_user_email(dl_user_email);
		vo.setStatus(status);
		vo.setTitle(title);
		
		coupon.update("com.baobab.m.dao.CouponHistoryMapper.getCouponHistory", vo);
		
	}
	
	@Override
	public List<CouponHistoryVO> showCouponHistory(String dl_user_email) {
		
		return coupon.selectList("com.baobab.m.dao.CouponHistoryMapper.selectCouponHistory", dl_user_email);
	}

	@Override
	public void delCouponHistory(int cp_seq) {
		coupon.update("com.baobab.m.dao.CouponHistoryMapper.delCouponsHistory", cp_seq);
		
	}

	
}

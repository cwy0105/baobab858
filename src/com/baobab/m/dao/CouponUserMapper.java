package com.baobab.m.dao;
import java.util.List;

import com.baobab.m.vo.CouponCpVO;
import com.baobab.m.vo.CouponHistoryVO;
import com.baobab.m.vo.CouponUserVO;
@Mapper
public interface CouponUserMapper {
	
	void insertCouponUser(CouponUserVO vo);
	void insertCouponHistory(CouponHistoryVO vo);
	List<CouponUserVO> userCouponEa(String email);
	List<CouponUserVO> userCouponDup(CouponUserVO vo);
	List<CouponUserVO> getUserCoupon(String email);
	void getCouponDlUserEa(CouponCpVO vo);
	void userCouponExpiry();
	List<CouponHistoryVO> usedCouponHistory(String email);
	
}

package com.baobab.m.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CouponCpVO;
import com.baobab.m.vo.CouponHistoryVO;
import com.baobab.m.vo.CouponUserVO;

@Repository
public class CouponUserDAOimpl implements CouponUserDAO{

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate coupon;

	@Override
	public int insertCouponUser(HttpServletRequest request) {
		CouponUserVO vo = new CouponUserVO();
		vo.setSerial_num(request.getParameter("serial_num"));
		vo.setEmail(request.getParameter("email"));
		vo.setCp_name(request.getParameter("cp_name"));
		vo.setCou_title(request.getParameter("cou_title"));
		vo.setCou_intro(request.getParameter("cou_intro"));
		vo.setCp_seq(Integer.parseInt(request.getParameter("cp_seq")));
		
		getCouponDlUserEa(request);
		return coupon.insert("com.baobab.m.dao.CouponUserMapper.insertCouponUser",vo)+insertCouponHistroy(request);
			   
	}
	
	@Override
	public int insertCouponHistroy(HttpServletRequest request) {
		CouponHistoryVO vo = new CouponHistoryVO();
		vo.setCp_seq(Integer.parseInt(request.getParameter("cp_seq")));
		vo.setSerial_num(request.getParameter("serial_num"));
		vo.setDl_user_email(request.getParameter("email"));
		vo.setTitle(request.getParameter("cou_title"));
		vo.setCp_name(request.getParameter("cp_name"));
		vo.setOption(request.getParameter("cou_intro"));
		
		return coupon.insert("com.baobab.m.dao.CouponUserMapper.insertCouponHistory",vo);
	}
	
	@Override
	public void getCouponDlUserEa(HttpServletRequest request) {
		CouponCpVO vo = new CouponCpVO();
		vo.setSerial_num(request.getParameter("serial_num"));
		
		coupon.update("com.baobab.m.dao.CouponUserMapper.getCouponDlUserEa",vo);
	}
	
	@Override
	public int userCouponEa(HttpServletRequest request) {
		int checkCouEa = coupon.selectList("com.baobab.m.dao.CouponUserMapper.userCouponEa", 
				request.getParameter("email")).size();
		CouponUserVO vo = new CouponUserVO();
		vo.setEmail(request.getParameter("email"));
		vo.setSerial_num(request.getParameter("serialNum"));
		List<CouponUserVO> dupCoupon = coupon.selectList("com.baobab.m.dao.CouponUserMapper.userCouponDup", vo);
		if(checkCouEa >= 3) {
			return 1;
		}else if(!dupCoupon.isEmpty()) {
			return 2;
		}else {
			return 0;
		} 
	}

	@Override
	public List<CouponUserVO> getUserCoupon(HttpServletRequest request) {
		CouponUserVO vo = new CouponUserVO();
		vo.setEmail(request.getParameter("email"));
		
		return coupon.selectList("com.baobab.m.dao.CouponUserMapper.getUserCoupon", vo);
	}

	@Override
	public int userCouponExpiry() {
		return coupon.delete("com.baobab.m.dao.CouponUserMapper.userCouponExpiry");
		
	}

	@Override
	public List<CouponHistoryVO> usedCouponHistory(HttpServletRequest request) {
		
		return coupon.selectList("com.baobab.m.dao.CouponUserMapper.usedCouponHistory", request.getParameter("email"));
	}

}

package com.baobab.m.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CouponCpVO;

@Repository
public class CouCpDAOimpl implements CouCpDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate coupon;

	@Override
	public List<CouponCpVO> getCpCouList(int cp_seq) {
		CouponCpVO vo = new CouponCpVO();
		vo.setCp_seq(cp_seq);
		 return coupon.selectList("com.baobab.m.dao.CouCpMapper.getCpCouList", vo);
	}

	@Override
	public int couCpInfoInsert(HttpServletRequest request) {
		CouponCpVO vo = new CouponCpVO();
		vo.setSerial_num(request.getParameter("serial_num"));
		vo.setCp_seq(Integer.parseInt(request.getParameter("cp_seq")));
		vo.setCp_name(request.getParameter("cp_name"));
		vo.setCou_title(request.getParameter("cou_title"));
		vo.setCou_intro(request.getParameter("cou_intro"));
		vo.setCou_kind(request.getParameter("cou_kind"));
		vo.setBuy_ea(Integer.parseInt(request.getParameter("buy_ea")));
		vo.setDl_user_ea(Integer.parseInt(request.getParameter("dl_user_ea")));
		vo.setStatus("off");
		vo.setOrderNum(request.getParameter("orderNum"));

		return coupon.insert("com.baobab.m.dao.CouCpMapper.couCpInfoInsert", vo);
	}
	
	@Override
	public int couponCpUse(HttpServletRequest request) {
		CouponCpVO vo = new CouponCpVO();
		vo.setStatus(request.getParameter("status"));
		vo.setSerial_num(request.getParameter("serial_num"));
		return coupon.update("com.baobab.m.dao.CouCpMapper.couponCpUse", vo);
	}

	@Override
	public List<CouponCpVO> couponCpPeriod(HttpServletRequest request) {
		CouponCpVO vo = new CouponCpVO();
		vo.setCp_seq(Integer.parseInt(request.getParameter("cp_seq")));
		return coupon.selectList("com.baobab.m.dao.CouCpMapper.couponCpPeriod", vo);
	}

	@Override
	public List<CouponCpVO> couPayDetail(String orderNum) {
		return coupon.selectOne("com.baobab.m.dao.CouCpMapper.couPayDetail", orderNum); 
	}

	@Override
	public List<CouponCpVO> getCouponMenu(int cp_seq) {
		return coupon.selectList("com.baobab.m.dao.CouCpMapper.getCouponMenu", cp_seq);
	}

	@Override
	public void cpCouponExpiry() {
		coupon.delete("com.baobab.m.dao.CouCpMapper.cpCouponExpiry");
	}
}

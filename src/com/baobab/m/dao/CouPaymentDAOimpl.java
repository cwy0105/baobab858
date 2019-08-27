package com.baobab.m.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CouponPaymentVO;


@Repository
public class CouPaymentDAOimpl implements CouPaymentDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate coupon;
	
	@Override
	public int couPayInfoInsert(HttpServletRequest request) {
		CouponPaymentVO vo = new CouponPaymentVO();
		vo.setGoods(request.getParameter("goods"));
		vo.setDisPrice(Integer.parseInt(request.getParameter("disPrice")));
		vo.setOrderNum(request.getParameter("orderNum"));
		vo.setEmail(request.getParameter("email"));
		vo.setUserPhone(request.getParameter("userPhone"));
		vo.setPayCode(request.getParameter("payCode"));
		vo.setStatus(request.getParameter("status"));
		vo.setCpSeq(Integer.parseInt(request.getParameter("cpSeq")));

		return coupon.insert("com.baobab.m.dao.CouPaymentMapper.couPayInfoInsert", vo);
	}

	@Override
	public void couTidUpdate(HttpServletRequest request) {
		CouponPaymentVO vo = new CouponPaymentVO();
		vo.setTid(request.getParameter("P_TID"));
		vo.setOrderNum(request.getParameter("P_OID"));
		
		coupon.update("com.baobab.m.dao.CouPaymentMapper.couTidUpdate", vo);
	}

	@Override
	public List<CouponPaymentVO> couPaySelect(HttpServletRequest request) {
		return coupon.selectList("com.baobab.m.dao.CouPaymentMapper.couPaySelect", Integer.parseInt(request.getParameter("cp_seq")));
	}

}

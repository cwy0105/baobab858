package com.baobab.m.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.service.SendFCM;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PushPaymentVO;

@Repository
public class PaymentDAOimpl implements PaymentDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate pay;
	private SqlSessionTemplate push;
	@Autowired
	BasketDAO bas;

	@Override
	public void payInfoInsert(HttpServletRequest request) {
		delPayInfo(request);
		PaymentVO vo = new PaymentVO();
		vo.setEmail(request.getParameter("email"));
		vo.setCp_name(request.getParameter("cpName"));
		vo.setCp_seq(Integer.parseInt(request.getParameter("cpSeq")));		
		vo.setMenus(request.getParameter("menus"));
		vo.setGoods(request.getParameter("goods"));
		vo.setOrder_num(request.getParameter("orderNum"));
		vo.setStatus(request.getParameter("status"));
		vo.setTotal_dis_price(Integer.parseInt(request.getParameter("disPrice")));
		vo.setTotal_price(Integer.parseInt(request.getParameter("price")));
		vo.setUser_phone(request.getParameter("userPhone"));
		vo.setPrices(request.getParameter("prices"));
		vo.setOwner_receipt(request.getParameter("owner_receipt"));
		System.out.println(vo.toString());
		pay.update("com.baobab.m.dao.PaymentMapper.payInfoInsert", vo);
	}

	@Override
	public void statusChange(String oid, String status) {
		PaymentVO vo = new PaymentVO();
		vo.setOrder_num(oid);//거래고유번호
		vo.setStatus(status);//승인완료
		pay.update("com.baobab.m.dao.PaymentMapper.statusChange", vo);
	}

	@Override
	public List<PaymentVO> payAllSelect(HttpServletRequest request) {
		PaymentVO vo = new PaymentVO();
		vo.setEmail(request.getParameter("email"));
		String used = request.getParameter("used");
		if(used.equals("전체보기")) {
			vo.setUsed("%%");
		}else if(used.equals("미사용")) {
			vo.setUsed("%미사용%");
		}else if(used.equals("사용완료")) {
			vo.setUsed("%사용완료%");
		}
		return pay.selectList("com.baobab.m.dao.PaymentMapper.payAllSelect", vo);
	}

	@Override
	public PaymentVO payOneSelect(HttpServletRequest request) {
		PaymentVO vo = new PaymentVO();
		vo.setEmail(request.getParameter("email"));
		vo.setOrder_num(request.getParameter("orderNum"));
		return pay.selectOne("com.baobab.m.dao.PaymentMapper.payAllSelect", vo);
	}

	@Override
	public void delPayInfo(HttpServletRequest request) {
		PaymentVO vo = new PaymentVO();
		vo.setEmail(request.getParameter("email"));
		vo.setOrder_num(request.getParameter("orderNum"));
		pay.update("com.baobab.m.dao.PaymentMapper.delPayInfo", vo);
	}

	@Override
	public void usedUpdate(String orderNum) {
		PaymentVO vo = new PaymentVO();
		vo.setOrder_num(orderNum);
		pay.update("com.baobab.m.dao.PaymentMapper.usedUpdate", vo);
	}

	@Override
	public List<PaymentVO> cpAllSelect(String email, String used) {
		PaymentVO vo = new PaymentVO();
		vo.setEmail(email);;
		if(used.equals("전체보기")) {
			vo.setUsed("%%");
		}else if(used.equals("미사용")) {
			vo.setUsed("%미사용%");
		}else if(used.equals("사용완료")) {
			vo.setUsed("%사용완료%");
		}
		return pay.selectList("com.baobab.m.dao.PaymentMapper.cpAllSelect", vo);
	}

	@Override
	public PaymentVO payDetail(String orderNum) {
		PaymentVO vo = new PaymentVO();
		vo.setOrder_num(orderNum);
		return pay.selectOne("com.baobab.m.dao.PaymentMapper.payDetail", vo);
	}

	@Override
	public void receiptChange(String orderNum) {
		PaymentVO vo = new PaymentVO();
		vo.setOrder_num(orderNum);
		pay.update("com.baobab.m.dao.PaymentMapper.receiptChange", vo);
	}

	@Override
	public String useCheck(String orderNum) {
		return pay.selectOne("com.baobab.m.dao.PaymentMapper.useCheck", orderNum);
	}

	@Override
	public void tidUpdate(HttpServletRequest request) {
		PaymentVO vo = new PaymentVO();
		PushPaymentVO pvo = new PushPaymentVO();
		
		vo.setOrder_num(request.getParameter("P_OID"));
		vo.setTid(request.getParameter("P_TID"));
		
		pvo.setTu_num(request.getParameter("P_OID"));
		pvo.setTid(request.getParameter("P_TID"));
		
		if(request.getParameter("P_OID").startsWith("G")) {
			pay.update("com.baobab.m.dao.PaymentMapper.tidUpdate", vo);
		}else if(request.getParameter("P_OID").startsWith("P")) {
			push.update("com.baobab.m.dao.PushMapper.pushTidUpdate", pvo);
		}	
	}

	@Override
	public void payCancel(HttpServletRequest request) {
		if(request.getParameter("rsCode").equals("0") || request.getParameter("rsCode").equals("00")) {
			PaymentVO vo = new PaymentVO();
			vo.setTid(request.getParameter("tid"));
			vo.setOrder_num(request.getParameter("oid"));
			pay.update("com.baobab.m.dao.PaymentMapper.payCancel", vo);
		}
	}

	@Override
	public List<PaymentVO> payCurDate(String email) {
		return pay.selectList("com.baobab.m.dao.PaymentMapper.payCurDate", email);
	}

	@Override
	public List<PaymentVO> cancelCurDate(String email) {
		return pay.selectList("com.baobab.m.dao.PaymentMapper.cancelCurDate", email);
	}

	@Override
	public int payPush(HttpServletRequest request) throws IOException {
		SendFCM fcm = new SendFCM();
		if(request.getParameter("div").equals("cp")) {
			return fcm.send(request, pay.selectList("com.baobab.m.dao.PaymentMapper.cpUserPush", Integer.parseInt(request.getParameter("cpSeq"))));
		}else {
			return fcm.send(request, pay.selectList("com.baobab.m.dao.PaymentMapper.customerPush", request.getParameter("userEmail")));
		}
	}

}

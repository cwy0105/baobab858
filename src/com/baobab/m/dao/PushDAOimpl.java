package com.baobab.m.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPUserVO;
import com.baobab.m.vo.CpPushVO;
import com.baobab.m.vo.PushPaymentVO;
import com.baobab.m.vo.UserLocationVO;

@Repository
public class PushDAOimpl implements PushDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate push;

	@Override
	public List<UserLocationVO> pushToAll() {
		return push.selectList("com.baobab.m.dao.PushMapper.pushToAll");
	}

	@Override
	public List<UserLocationVO> pushToFan(HttpServletRequest request) {
		int cpName = Integer.parseInt(request.getParameter("cpSeq"));
		return push.selectList("com.baobab.m.dao.PushMapper.pushToFan", cpName);
	}

	@Override
	public List<UserLocationVO> pushToNormal(HttpServletRequest request) {
		CpPushVO vo = new CpPushVO();
		vo.setCpSeq(Integer.parseInt(request.getParameter("cpSeq")));
		vo.setRadius(Integer.parseInt(request.getParameter("radius")));
		return push.selectList("com.baobab.m.dao.PushMapper.pushToNormal", vo);
	}

	@Override
	public void savePush(HttpServletRequest request) {
		if(!request.getParameter("email").equals("위대한올마이티")) {
			CpPushVO vo = new CpPushVO();
			vo.setCpName(request.getParameter("cpName"));
			vo.setRadius(Integer.parseInt(request.getParameter("radius")));
			vo.setFanEa(Integer.parseInt(request.getParameter("fanEa")));
			vo.setNormalEa(Integer.parseInt(request.getParameter("normalEa")));
			vo.setTitle(request.getParameter("title"));
			vo.setMessage(request.getParameter("message"));
			vo.setCpSeq(Integer.parseInt(request.getParameter("cpSeq")));
			push.update("com.baobab.m.dao.PushMapper.savePush", vo);
		}
	}

	@Override
	public List<UserLocationVO> sendToFan(HttpServletRequest request) {
		CpPushVO vo = new CpPushVO();
		vo.setCpName(request.getParameter("cpName"));
		vo.setFanEa(Integer.parseInt(request.getParameter("fanEa")));
		return push.selectList("com.baobab.m.dao.PushMapper.sendToFan", vo);
	}

	@Override
	public List<UserLocationVO> sendToNormal(HttpServletRequest request) {
		CpPushVO vo = new CpPushVO();
		vo.setCpSeq(Integer.parseInt(request.getParameter("cpSeq")));
		vo.setRadius(Integer.parseInt(request.getParameter("radius")));
		vo.setNormalEa(Integer.parseInt(request.getParameter("normalEa")));
		List<UserLocationVO> result = push.selectList("com.baobab.m.dao.PushMapper.sendToNormal", vo);
		return result;
	}

	@Override
	public UserLocationVO findUser(String pushToken) {
		return push.selectOne("com.baobab.m.dao.PushMapper.findUser", pushToken);
	}

	@Override
	public CPInfoVO findCp(HttpServletRequest request) {
		CpPushVO vo = new CpPushVO();
		vo.setCpName(request.getParameter("cpName"));
		vo.setTitle(request.getParameter("title"));
		vo.setMessage(request.getParameter("message"));
		return push.selectOne("com.baobab.m.dao.PushMapper.findCp", vo);
	}

	@Override
	public int pushPaymentMenu(HttpServletRequest request) {
		PushPaymentVO vo = new PushPaymentVO();
		vo.setMenu_name(request.getParameter("goods"));
		vo.setEa(Integer.parseInt(request.getParameter("ea")));
		vo.setPay(Integer.parseInt(request.getParameter("disPrice")));
		vo.setEmail(request.getParameter("email"));
		vo.setTu_num(request.getParameter("orderNum"));
		vo.setStatus(request.getParameter("status"));
		vo.setCp_seq(Integer.parseInt(request.getParameter("cpSeq")));
		
		
		return push.insert("com.baobab.m.dao.PushMapper.pushPaymentMenu", vo);
	}

	@Override
	public List<PushPaymentVO> pushPaymentSelect(HttpServletRequest request) {
		String email = request.getParameter("email");
		return push.selectList("com.baobab.m.dao.PushMapper.pushPaymentSelect", email);
	}

	@Override
	public void pushTidUpdate(HttpServletRequest request) {
		PushPaymentVO vo = new PushPaymentVO();
		vo.setTu_num(request.getParameter("P_OID"));//거래고유번호
		vo.setTid(request.getParameter("P_TID"));
		push.update("com.baobab.m.dao.PushMapper.pushTidUpdate", vo);
	}

	@Override
	public void pushPayCancel(HttpServletRequest request) {
		if(request.getParameter("rsCode").equals("0") || request.getParameter("rsCode").equals("00")) {
			PushPaymentVO vo = new PushPaymentVO();
			vo.setTid(request.getParameter("tid"));
			vo.setTu_num(request.getParameter("tu_num"));
			push.update("com.baobab.m.dao.PaymentMapper.payCancel", vo);
		}
		
	}

	@Override
	public void pushEaPlma(HttpServletRequest request) {
		CPUserVO vo = new CPUserVO();
		vo.setPush_ea(Integer.parseInt(request.getParameter("pushEa")));
		vo.setEmail(request.getParameter("email"));
		push.update("com.baobab.m.dao.PushMapper.pushEaPlma", vo);
	}
}

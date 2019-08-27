package com.baobab.m.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.BasketVO;
import com.baobab.m.vo.CPInfoVO;

@Repository
public class BasketDAOimpl implements BasketDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate bas;

	@Override
	public int confRepetition(String email, String cpName, int cpSeq, String menuName, String option, int ea, int price,
			int totalPrice) {
		BasketVO vo = new BasketVO();
		vo.setEmail(email);
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
		vo.setMenu_name(menuName);
		vo.setOption(option);
		vo.setEa(ea);
		vo.setMenu_pay(price);
		vo.setDis_price(totalPrice);
		if(bas.selectOne("com.baobab.m.dao.BasketMapper.confRepetition", vo) != null) {
			int seqNum = bas.selectOne("com.baobab.m.dao.BasketMapper.confRepetition", vo);
			upBasket(vo, seqNum);
		}else {
			inBasket(vo);
		}
		return 0;
	}

	@Override
	public void inBasket(BasketVO vo) {
		if(vo.getEa() > 0) {
			bas.update("com.baobab.m.dao.BasketMapper.inBasket", vo);
		}
	}

	@Override
	public void upBasket(BasketVO vo, int seqNum) {
		vo.setSeq_num(seqNum);
		bas.update("com.baobab.m.dao.BasketMapper.upBasket", vo);
	}

	@Override
	public void delBasket(String email, String cpName, int cpSeq) {
		BasketVO vo = new BasketVO();
		vo.setEmail(email);
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
		bas.update("com.baobab.m.dao.BasketMapper.delBasket", vo);
	}

	@Override
	public List<BasketVO> basketList(String email) {
		BasketVO vo = new BasketVO();
		vo.setEmail(email);
		return bas.selectList("com.baobab.m.dao.BasketMapper.basketList", vo);
	}

	@Override
	public CPInfoVO basCpInfo(String cpName, int cpSeq) {
		BasketVO vo = new BasketVO();
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
 		return bas.selectOne("com.baobab.m.dao.BasketMapper.basCpInfo", vo);
	}

	@Override
	public List<BasketVO> basDetailInfo(HttpServletRequest request) {
		BasketVO vo = new BasketVO();
		vo.setCp_name(request.getParameter("cpName"));
		vo.setCp_seq(Integer.parseInt(request.getParameter("cpSeq")));
		vo.setEmail(request.getParameter("email"));
 		return bas.selectList("com.baobab.m.dao.BasketMapper.basDetailInfo", vo);
	}

}

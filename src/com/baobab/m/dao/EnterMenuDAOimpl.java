package com.baobab.m.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPEnterMenuVO;

@Repository
public class EnterMenuDAOimpl implements EnterMenuDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate em;

	@Override
	public int menuInsert(HttpServletRequest request) {
		CPEnterMenuVO vo = new CPEnterMenuVO();
		vo.setCp_name(request.getParameter("cpName"));
		vo.setMenu_name(request.getParameter("menuName"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setDis_price(Integer.parseInt(request.getParameter("disPrice")));
		return em.insert("com.baobab.m.dao.EnterMenuMapper.menuInsert", vo);
	}

	@Override
	public int menuDel(int cpSeq, int seqNum) {
		CPEnterMenuVO vo = new CPEnterMenuVO();
		vo.setCp_seq(cpSeq);
		vo.setSeq_num(seqNum);
		return em.delete("com.baobab.m.dao.EnterMenuMapper.menuDel", vo);
	}

	@Override
	public List<CPEnterMenuVO> menuSelect(int cpSeq) {
		return em.selectList("com.baobab.m.dao.EnterMenuMapper.menuSelect", cpSeq);
	}

	@Override
	public int menuUpdate(HttpServletRequest request) {
		CPEnterMenuVO vo = new CPEnterMenuVO();
		vo.setMenu_name(request.getParameter("menuName"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setDis_price(Integer.parseInt(request.getParameter("disPrice")));
		vo.setCp_seq(Integer.parseInt(request.getParameter("cpSeq")));
		vo.setSeq_num(Integer.parseInt(request.getParameter("seqNum")));
		 return em.update("com.baobab.m.dao.EnterMenuMapper.menuUpdate", vo);
		
	}

}

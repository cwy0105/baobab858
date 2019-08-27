package com.baobab.admin.dao;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.baobab.m.vo.SearchVO;

@Repository
public class AdminCPDAOimpl implements AdminCPDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate cp;

	@Override
	public String search(Model model, HttpServletRequest request) {
		SearchVO vo = new SearchVO();
		vo.setWord("%" + request.getParameter("searchWord") + "%");
		vo.setSelectItem(request.getParameter("kind"));
		model.addAttribute("cpList", cp.selectList("com.baobab.admin.dao.AdminCPMapper.search", vo));
		return "admin/cp";
	}

}

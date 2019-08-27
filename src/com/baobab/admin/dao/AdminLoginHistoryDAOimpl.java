package com.baobab.admin.dao;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.baobab.m.vo.LoginHistoryVO;

@Repository
public class AdminLoginHistoryDAOimpl implements AdminLoginHistoryDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate log;

	@Override
	public String history(Model model, HttpServletRequest request) {
		LoginHistoryVO vo = new LoginHistoryVO();
		vo.setEmail("%" + request.getParameter("searchWord") + "%");
		vo.setDiv_code("%" + request.getParameter("user_div") + "%");
		vo.setState("%" + request.getParameter("log_div") + "%");
		model.addAttribute("loginList", log.selectList("com.baobab.admin.dao.AdminLoginHistoryMapper.history", vo));
		return "admin/loginHistory";
	}

}

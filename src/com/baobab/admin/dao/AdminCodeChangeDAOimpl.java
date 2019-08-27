package com.baobab.admin.dao;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.UserAllVO;

@Repository
public class AdminCodeChangeDAOimpl implements AdminCodeChangeDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate cc;

	@Override
	public int codeChange(HttpServletRequest request) {
		UserAllVO vo = new UserAllVO();
		vo.setEmail(request.getParameter("email"));
		vo.setDiv_code(request.getParameter("divCode"));
		int result = cc.update("com.baobab.admin.dao.AdminCodeChangeMapper.codeChange", vo);
		if(result > 0) {
			insertHistory(vo);
			return result;
		}else {
			return 0;
		}
	}

	@Override
	public void insertHistory(UserAllVO vo) {
		cc.update("com.baobab.admin.dao.AdminCodeChangeMapper.insertHistory", vo);
	}

}

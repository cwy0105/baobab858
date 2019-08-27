package com.baobab.admin.dao;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserSearchVO;

@Repository
public class AdminUserDAOimpl implements AdminUserDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate user;

	@Override
	public List<UserAllVO> searchUser(HttpServletRequest request) throws ParseException {
		UserSearchVO vo = new UserSearchVO();
		vo.setEmail("%" + request.getParameter("user_email") + "%");
		vo.setDiv_code(request.getParameter("div_code"));
		vo.setPush_agree(request.getParameter("push"));
		vo.setJoin_date("%" + request.getParameter("date") + "%");
		return user.selectList("com.baobab.admin.dao.AdminUserMapper.searchUser", vo);
	}

}

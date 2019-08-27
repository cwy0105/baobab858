package com.baobab.admin.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CpPushVO;

@Repository
public class AdminCpPushDAOimpl implements AdminCpPushDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate cpp;

	@Override
	public List<CpPushVO> pushSelect(HttpServletRequest request) {
		return cpp.selectList("com.baobab.admin.dao.AdminCpPushMapper.pushSelect", "%" + request.getParameter("searchWord") + "%");
	}

}

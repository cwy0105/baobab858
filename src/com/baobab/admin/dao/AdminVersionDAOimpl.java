package com.baobab.admin.dao;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class AdminVersionDAOimpl implements AdminVersionDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate ver;

	@Override
	public int getVersion() {
		int curVersion = ver.selectOne("com.baobab.admin.dao.AdminVersionMapper.getVersion");
		System.out.println("현재 DB 등록 버전 : " + curVersion);
		return curVersion;
	}

	@Override
	public int upVersion(HttpServletRequest request) {
		return ver.update("com.baobab.admin.dao.AdminVersionMapper.upVersion", Integer.parseInt(request.getParameter("version")));
	}

	@Override
	public int hitsInitialize() {
		return ver.update("com.baobab.m.dao.StoreMenuMapper.hitsInitialize");
	}

	@Override
	public String getCheckServer() {
		String server = ver.selectOne("com.baobab.admin.dao.AdminVersionMapper.getCheckServer");
		System.out.println("현재 server 상태 : "+server);
		return server;
		
		
	}

	@Override
	public int checkServer(HttpServletRequest request) {
		return ver.update("com.baobab.admin.dao.AdminVersionMapper.checkServer",request.getParameter("server"));
	
	}

}

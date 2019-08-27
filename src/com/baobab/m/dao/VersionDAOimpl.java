package com.baobab.m.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class VersionDAOimpl implements VersionDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate ver;

	@Override
	public int newVersion() {
		return ver.selectOne("com.baobab.m.dao.VersionMapper.newVersion");
	}

	@Override
	public String getStatus() {
		return ver.selectOne("com.baobab.m.dao.VersionMapper.getStatus");
	}

}

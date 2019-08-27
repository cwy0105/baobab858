package com.baobab.admin.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.RankVO;

@Repository
public class AdminSearchWordDAOimpl implements AdminSearchWordDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate rank;

	@Override
	public List<RankVO> kindRank() {
		return rank.selectList("com.baobab.admin.dao.AdminSearchWordMapper.kindRank");
	}

	@Override
	public List<RankVO> wordRank() {
		return rank.selectList("com.baobab.admin.dao.AdminSearchWordMapper.wordRank");
	}

}

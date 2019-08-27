package com.baobab.m.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.SearchHistoryVO;

@Repository
public class SearchHistoryDAOimpl implements SearchHistoryDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sh;

	@Override
	public void getHistory(SearchHistoryVO vo) {
		sh.update("com.baobab.m.dao.SearchHistoryMapper.getHistory", vo);
	}

}

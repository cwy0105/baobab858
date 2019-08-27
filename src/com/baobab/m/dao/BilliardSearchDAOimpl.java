package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.NonBilliardVO;
import com.baobab.m.vo.SearchVO;

@Repository
public class BilliardSearchDAOimpl implements BilliardSearchDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate bi;

	@Override
	public List<NonBilliardVO> disAll(SearchVO vo) {
		return bi.selectList("com.baobab.m.dao.BilliardSearchMapper.disAll", vo);
	}

	@Override
	public List<NonBilliardVO> disLocal(SearchVO vo) {
		return bi.selectList("com.baobab.m.dao.BilliardSearchMapper.disLocal", vo);
	}

	@Override
	public List<NonBilliardVO> disName(SearchVO vo) {
		return bi.selectList("com.baobab.m.dao.BilliardSearchMapper.disName", vo);
	}

	@Override
	public List<NonBilliardVO> surrounding(SearchVO vo) {
		return bi.selectList("com.baobab.m.dao.BilliardSearchMapper.surrounding", vo);
	}

	@Override
	public List<NonBilliardVO> popAll(SearchVO vo) {
		return bi.selectList("com.baobab.m.dao.BilliardSearchMapper.popAll", vo);
	}

	@Override
	public List<NonBilliardVO> popLocal(SearchVO vo) {
		return bi.selectList("com.baobab.m.dao.BilliardSearchMapper.popLocal", vo);
	}

	@Override
	public List<NonBilliardVO> popName(SearchVO vo) {
		return bi.selectList("com.baobab.m.dao.BilliardSearchMapper.popName", vo);
	}

}

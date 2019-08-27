package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.NonKaraokeVO;
import com.baobab.m.vo.SearchVO;

@Repository
public class KaraokeSearchDAOimpl implements KaraokeSearchDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate ka;

	@Override
	public List<NonKaraokeVO> disAll(SearchVO vo) {
		return ka.selectList("com.baobab.m.dao.KaraokeSearchMapper.disAll", vo);
	}

	@Override
	public List<NonKaraokeVO> disLocal(SearchVO vo) {
		return ka.selectList("com.baobab.m.dao.KaraokeSearchMapper.disLocal", vo);
	}

	@Override
	public List<NonKaraokeVO> disName(SearchVO vo) {
		return ka.selectList("com.baobab.m.dao.KaraokeSearchMapper.disName", vo);
	}

	@Override
	public List<NonKaraokeVO> surrounding(SearchVO vo) {
		return ka.selectList("com.baobab.m.dao.KaraokeSearchMapper.surrounding", vo);
	}

	@Override
	public List<NonKaraokeVO> popAll(SearchVO vo) {
		return ka.selectList("com.baobab.m.dao.KaraokeSearchMapper.popAll", vo);
	}

	@Override
	public List<NonKaraokeVO> popLocal(SearchVO vo) {
		return ka.selectList("com.baobab.m.dao.KaraokeSearchMapper.popLocal", vo);
	}

	@Override
	public List<NonKaraokeVO> popName(SearchVO vo) {
		return ka.selectList("com.baobab.m.dao.KaraokeSearchMapper.popName", vo);
	}
}

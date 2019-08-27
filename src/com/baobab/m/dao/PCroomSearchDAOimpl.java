package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.NonPCroomVO;
import com.baobab.m.vo.SearchVO;

@Repository
public class PCroomSearchDAOimpl implements PCroomSearchDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate pc;

	@Override
	public List<NonPCroomVO> disAll(SearchVO vo) {
		return pc.selectList("com.baobab.m.dao.PCroomSearchMapper.disAll", vo);
	}

	@Override
	public List<NonPCroomVO> disLocal(SearchVO vo) {
		return pc.selectList("com.baobab.m.dao.PCroomSearchMapper.disLocal", vo);
	}

	@Override
	public List<NonPCroomVO> disName(SearchVO vo) {
		return pc.selectList("com.baobab.m.dao.PCroomSearchMapper.disName", vo);
	}

	@Override
	public List<NonPCroomVO> surrounding(SearchVO vo) {
		return pc.selectList("com.baobab.m.dao.PCroomSearchMapper.surrounding", vo);
	}

	@Override
	public List<NonPCroomVO> popAll(SearchVO vo) {
		return pc.selectList("com.baobab.m.dao.PCroomSearchMapper.popAll", vo);
	}

	@Override
	public List<NonPCroomVO> popLocal(SearchVO vo) {
		return pc.selectList("com.baobab.m.dao.PCroomSearchMapper.popLocal", vo);
	}

	@Override
	public List<NonPCroomVO> popName(SearchVO vo) {
		return pc.selectList("com.baobab.m.dao.PCroomSearchMapper.popName", vo);
	}

	
}

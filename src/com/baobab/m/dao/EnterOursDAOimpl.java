package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.PageSearchVO;

@Repository
public class EnterOursDAOimpl implements EnterOursDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate eo;

	@Override
	public List<CPInfoVO> getOursPopularity(PageSearchVO vo) {
		return eo.selectList("com.baobab.m.dao.EnterOursMapper.getOursPopularity", vo);
	}

	@Override
	public List<CPInfoVO> getOursPopLocation(PageSearchVO vo) {
		return eo.selectList("com.baobab.m.dao.EnterOursMapper.getOursPopLocation", vo);
	}

	@Override
	public List<CPInfoVO> getOursPopCpName(PageSearchVO vo) {
		return eo.selectList("com.baobab.m.dao.EnterOursMapper.getOursPopCpName", vo);
	}

	@Override
	public List<CPInfoVO> getOursDistance(PageSearchVO vo) {
		return eo.selectList("com.baobab.m.dao.EnterOursMapper.getOursDistance", vo);
	}

	@Override
	public List<CPInfoVO> getOursDisLocation(PageSearchVO vo) {
		return eo.selectList("com.baobab.m.dao.EnterOursMapper.getOursDisLocation", vo);
	}

	@Override
	public List<CPInfoVO> getOursDisCpName(PageSearchVO vo) {
		return eo.selectList("com.baobab.m.dao.EnterOursMapper.getOursDisCpName", vo);
	}

	@Override
	public List<CPInfoVO> getSurroundingsOur(PageSearchVO vo) {
		return eo.selectList("com.baobab.m.dao.EnterOursMapper.getSurroundingsOur", vo);
	}

}

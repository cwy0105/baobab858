package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.NonBilliardVO;

@Repository
public class AddrConversionDAOimpl implements AddrConversionDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate ac;

	@Override
	public List<NonBilliardVO> getList() {
		return ac.selectList("com.baobab.m.dao.AddrConversionMapper.getList");
	}

	@Override
	public void updateGeo(NonBilliardVO vo) {
		ac.update("com.baobab.m.dao.AddrConversionMapper.updateGeo", vo);
	}

}

package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.NonCpImgVO;
import com.baobab.m.vo.NonCpMenuVO;

@Repository
public class NonCPinfoDAOimpl implements NonCPinfoDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate info;

	@Override
	public List<NonCpMenuVO> getMenus(int seq, String cpName) {
		LocalCPInfoVO vo = new LocalCPInfoVO();
		vo.setLoc_seq(seq);
		vo.setCp_name(cpName);
		return info.selectList("com.baobab.m.dao.NonCPinfoMapper.getMenus", vo);
	}

	@Override
	public List<NonCpImgVO> getImg(int seq, String cpName) {
		LocalCPInfoVO vo = new LocalCPInfoVO();
		vo.setLoc_seq(seq);
		vo.setCp_name(cpName);
		return info.selectList("com.baobab.m.dao.NonCPinfoMapper.getImg", vo);
	}

}

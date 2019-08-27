package com.baobab.m.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.service.Sha256;
import com.baobab.m.vo.UserAllVO;

@Repository
public class PersonalInfoDAOimpl implements PersonalInfoDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate per;

	@Override
	public List<UserAllVO> findEmail(String phoneNum) {
		return per.selectList("com.baobab.m.dao.PersonalInfoMapper.findEmail", phoneNum);
	}

	@Override
	public UserAllVO findPassword(HttpServletRequest request) {
		UserAllVO vo = new UserAllVO();
		vo.setEmail(request.getParameter("email"));
		vo.setPhon_num(request.getParameter("phone"));
		return per.selectOne("com.baobab.m.dao.PersonalInfoMapper.findPassword", vo);
	}

	@Override
	public int updatePassword(HttpServletRequest request) {
		UserAllVO vo = new UserAllVO();
		Sha256 sha = new Sha256();
		vo.setEmail(request.getParameter("email"));
		vo.setPhon_num(request.getParameter("phone"));
		vo.setUser_password(sha.sha256(request.getParameter("password")));
		return per.update("com.baobab.m.dao.PersonalInfoMapper.updatePassword", vo);
	}

}

package com.baobab.m.dao;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPUserVO;
import com.baobab.m.vo.LoginHistoryVO;
import com.baobab.m.vo.UserAllVO;

@Repository
public class LoginDAOimpl implements LoginDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate login;

	@Override
	public UserAllVO loginConfirm(String email, String password) {
		UserAllVO uvo = new UserAllVO();
		uvo.setEmail(email);
		uvo.setUser_password(password);
		try {
			return login.selectOne("com.baobab.m.dao.LoginMapper.loginConfirm", uvo);
		}catch(NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CPInfoVO getMyInfo(int cpSeq) {
		return login.selectOne("com.baobab.m.dao.LoginMapper.getMyInfo", cpSeq);
	}

	@Override
	public String getCpUserInfo(String email) {
		return login.selectOne("com.baobab.m.dao.LoginMapper.getCpUserInfo", email);
	}

	@Override
	public void getHistory(HttpServletRequest request) {
		LoginHistoryVO vo = new LoginHistoryVO();
		vo.setEmail(request.getParameter("email"));
		vo.setPw(request.getParameter("pw"));
		vo.setDiv_code(request.getParameter("divCode"));
		vo.setState(request.getParameter("state"));
		login.update("com.baobab.m.dao.LoginMapper.getHistory", vo);
	}

	@Override
	public CPInfoVO getStoreInfo(String cpName, String email) {
		CPUserVO vo = new CPUserVO();
		vo.setCpName(cpName);
		vo.setEmail(email);
		return login.selectOne("com.baobab.m.dao.LoginMapper.getStoreInfo", vo);
	}

}

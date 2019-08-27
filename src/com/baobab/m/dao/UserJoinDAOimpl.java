package com.baobab.m.dao;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserHistoryVO;

@Repository
public class UserJoinDAOimpl implements UserJoinDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate join;

	@Override
	public void userAllJoin(String email, String password, String phoneNum, String pushCheck) {
		UserAllVO vo = new UserAllVO();
		vo.setEmail(email);
		vo.setUser_password(password);
		vo.setPhon_num(phoneNum);
		vo.setPush_agree(pushCheck);
		join.update("com.baobab.m.dao.UserJoinMapper.userAllJoin", vo);
		userHistoryJoin(email);
	}

	@Override
	public void userHistoryJoin(String email) {
		UserHistoryVO vo = new UserHistoryVO();
		vo.setEmail(email);
		join.update("com.baobab.m.dao.UserJoinMapper.userHistoryJoin", vo);
	}

	@Override
	public String getUserPhone(String email) {
		return join.selectOne("com.baobab.m.dao.UserJoinMapper.getUserPhone", email);
	}

	@Override
	public String getCpPhone(int cpSeq) {
		return join.selectOne("com.baobab.m.dao.UserJoinMapper.getCpPhone", cpSeq);
	}

	@Override
	public void userInfoChange(String email, String password, String pushCheck) {
		UserAllVO vo = new UserAllVO();
		vo.setEmail(email);
		vo.setUser_password(password);
		vo.setPush_agree(pushCheck);
		join.update("com.baobab.m.dao.UserJoinMapper.userInfoChange", vo);
	}

	@Override
	public void leaveUserAll(String email) {
		join.update("com.baobab.m.dao.UserJoinMapper.leaveUserAll", email);
		leaveUserHistory(email);
	}

	@Override
	public void leaveUserHistory(String email) {
		join.update("com.baobab.m.dao.UserJoinMapper.leaveUserHistory", email);
	}

	@Override
	public int userCodeUpdate(HttpServletRequest request) {
		UserAllVO vo = new UserAllVO();
		vo.setEmail(request.getParameter("email"));
		vo.setDiv_code(request.getParameter("divCode"));
		return join.update("com.baobab.m.dao.UserJoinMapper.userCodeUpdate", vo);
	}

	@Override
	public int dupEmail(HttpServletRequest request) {
		return join.selectList("com.baobab.m.dao.UserJoinMapper.dupEmail", request.getParameter("email")).size();
	}

	@Override
	public int emailCheck(HttpServletRequest request) {
		UserAllVO vo = new UserAllVO();
		vo.setEmail(request.getParameter("email"));
		vo.setPhon_num(request.getParameter("phone"));
		return join.selectList("com.baobab.m.dao.UserJoinMapper.emailCheck", vo).size();
	}
	
	@Override
	   public int point(String email) {
	      UserAllVO vo = new UserAllVO();
	      vo.setEmail(email);
	      return join.update("com.baobab.m.dao.UserJoinMapper.userPointUp",email);
	}

	@Override
	public int nowPoint(String email) {
		return join.selectOne("com.baobab.m.dao.UserJoinMapper.userNowPoint",email);
	}

}

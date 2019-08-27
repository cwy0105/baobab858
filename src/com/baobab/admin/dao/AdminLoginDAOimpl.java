package com.baobab.admin.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.service.Sha256;
import com.baobab.m.vo.AdminAccountVO;
import com.baobab.m.vo.UserAllVO;

@Repository
public class AdminLoginDAOimpl implements AdminLoginDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate login;

	@Override
	public int login(String id, String password, HttpSession session) {
		Sha256 sha = new Sha256();
		UserAllVO vo = new UserAllVO();
		vo.setEmail(id);
		vo.setUser_password(sha.sha256(password));
		UserAllVO newVo = login.selectOne("com.baobab.admin.dao.AdminLoginMapper.login", vo);
		if(newVo == null) {
			return 0;
		}else {
			List<AdminAccountVO> resultList = adminConfirm(id);
			if(resultList.size() > 0) {
				session.setAttribute("id", id);
				session.setAttribute("pw", sha.sha256(password));
				session.setAttribute("divCode", newVo.getDiv_code());
				session.setAttribute("jobClass", resultList.get(0).getJob_class());
				session.setAttribute("name", resultList.get(0).getName());
				session.setAttribute("department", resultList.get(0).getDepartment());
				loginHistory(id);
				return 1;
			}else {
				session.setAttribute("id", id);
				session.setAttribute("pw", sha.sha256(password));
				session.setAttribute("divCode", newVo.getDiv_code());
				return -1;
			}
		}
	}

	@Override
	public void loginHistory(String email) {
		login.update("com.baobab.admin.dao.AdminLoginMapper.loginHistory", email);
	}

	@Override
	public List<AdminAccountVO> adminConfirm(String id) {
		return login.selectList("com.baobab.admin.dao.AdminLoginMapper.adminConfirm", id);
	}

	@Override
	public int accountInsert(HttpServletRequest request, HttpSession session) {
		AdminAccountVO vo = new AdminAccountVO();
		vo.setId(session.getAttribute("id").toString());
		vo.setPassword(session.getAttribute("pw").toString());
		vo.setName(request.getParameter("name"));
		vo.setJob_class(request.getParameter("jobClass"));
		vo.setDepartment(request.getParameter("department"));
		return login.insert("com.baobab.admin.dao.AdminLoginMapper.accountInsert", vo);
	}

}

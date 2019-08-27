package com.baobab.admin.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.baobab.m.vo.AdminAccountVO;

public interface AdminLoginDAO {
	int login(String id, String password, HttpSession session);
	void loginHistory(String email);
	List<AdminAccountVO> adminConfirm(String id);
	int accountInsert(HttpServletRequest request, HttpSession session);
}

package com.baobab.admin.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.baobab.m.vo.AdminPushVO;
import com.baobab.m.vo.UserLocationVO;

public interface AdminPushDAO {
	int pushHistory(HttpServletRequest request, HttpSession session) throws IOException;
	List<UserLocationVO> getAllPushList();
	List<AdminPushVO> adminSelect(HttpServletRequest request);
}

package com.baobab.admin.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AdminLoginHistoryDAO {
	String history(Model model, HttpServletRequest request);
}

package com.baobab.admin.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AdminCPDAO {
	String search(Model model, HttpServletRequest request);
}

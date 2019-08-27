package com.baobab.admin.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.baobab.m.vo.AdminVisitantVO;

public interface AdminVisitantDAO {
	String visitants(Model model, HttpServletRequest request);
	void visitant(Model model, AdminVisitantVO vo);
}

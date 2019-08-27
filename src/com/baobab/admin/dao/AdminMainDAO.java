package com.baobab.admin.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface AdminMainDAO {
	int userAll();
	int cpAll();
	int menuAll();
	int visitantAll();
	int paymentAll();
	int pushAll();
	List<String> loginHistory(HttpSession session);
	String makeMainPage(Model model, HttpSession session);
}

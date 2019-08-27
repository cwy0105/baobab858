package com.baobab.admin.dao;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.UserAllVO;

public interface AdminUserDAO {
	List<UserAllVO> searchUser(HttpServletRequest request) throws ParseException;
}

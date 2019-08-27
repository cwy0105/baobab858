package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.AdminAccountVO;
import com.baobab.m.vo.UserAllVO;

@Mapper
public interface AdminLoginMapper {
	UserAllVO login(UserAllVO vo);
	void loginHistory(String email);
	List<AdminAccountVO> adminConfirm(String id);
	void accountInsert(AdminAccountVO vo);
}

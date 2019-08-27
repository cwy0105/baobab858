package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.AdminPushVO;
import com.baobab.m.vo.UserLocationVO;

@Mapper
public interface AdminPushMapper {
	void pushHistory(AdminPushVO vo);
	List<UserLocationVO> getAllPushList();
	List<AdminPushVO> adminSelect(AdminPushVO vo);
}

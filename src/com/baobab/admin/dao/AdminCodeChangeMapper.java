package com.baobab.admin.dao;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.UserAllVO;

@Mapper
public interface AdminCodeChangeMapper {
	void codeChange(UserAllVO vo);
	void insertHistory(UserAllVO vo);
}

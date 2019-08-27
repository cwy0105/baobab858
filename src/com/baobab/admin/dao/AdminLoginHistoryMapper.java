package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.LoginHistoryVO;

@Mapper
public interface AdminLoginHistoryMapper {
	List<LoginHistoryVO> history(LoginHistoryVO vo);
}

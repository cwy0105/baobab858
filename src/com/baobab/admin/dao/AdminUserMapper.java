package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserSearchVO;

@Mapper
public interface AdminUserMapper {
	List<UserAllVO> searchUser(UserSearchVO vo);
}

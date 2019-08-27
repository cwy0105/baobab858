package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPUserVO;
import com.baobab.m.vo.CpStaffVO;
import com.baobab.m.vo.UserAllVO;

public interface CpStaffTestDAO {
	List<CPUserVO> testCpUser();
	List<UserAllVO> testUserAll();
	void merge();
	void testInsert(CpStaffVO vo);
}

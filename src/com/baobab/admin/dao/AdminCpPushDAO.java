package com.baobab.admin.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.CpPushVO;

public interface AdminCpPushDAO {
	List<CpPushVO> pushSelect(HttpServletRequest request);
}

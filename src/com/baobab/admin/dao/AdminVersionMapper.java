package com.baobab.admin.dao;

import com.baobab.m.dao.Mapper;

@Mapper
public interface AdminVersionMapper {
	int getVersion();
	void upVersion(int newVersion);
	String getCheckServer();
	void checkServer(String inspection);
}

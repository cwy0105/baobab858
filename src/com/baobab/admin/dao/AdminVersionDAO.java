package com.baobab.admin.dao;

import javax.servlet.http.HttpServletRequest;

public interface AdminVersionDAO {
	int getVersion();
	int upVersion(HttpServletRequest request);
	String getCheckServer();
	int checkServer(HttpServletRequest request);
	
	int hitsInitialize();
}	

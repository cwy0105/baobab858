package com.baobab.m.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.VersionDAO;

@Service
public class VersionCheckimpl implements VersionCheck {
	
	@Autowired
	VersionDAO ver;

	@Override
	public int versionChecking(String versionStr) {
		int version = Integer.parseInt(versionStr);
		if(version < ver.newVersion()) {
			return 0;
		}else {
			return 1;
		}
	}

}

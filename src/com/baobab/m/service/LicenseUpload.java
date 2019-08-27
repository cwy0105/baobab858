package com.baobab.m.service;

import org.springframework.web.multipart.MultipartFile;

public interface LicenseUpload {
	String licenseSaveToServer(MultipartFile cpLicense, String cpName) throws Exception;
}

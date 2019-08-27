package com.baobab.m.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LicenseUploadimpl implements LicenseUpload {
	
	private String saveFolder = "/baobabLicense/";

	@Override
	public String licenseSaveToServer(MultipartFile cpLicense, String email) throws Exception{
		try {
			FtpClient ftp = new FtpClient();
			if(!cpLicense.isEmpty()) {
				String saveName = email+"-license.png";
				if(saveName.contains(" ")) {
					return ftp.ftp(ftp.convert(cpLicense), saveName.replace(" ", "+"), saveFolder);
				}else {
					return ftp.ftp(ftp.convert(cpLicense), saveName, saveFolder);
				}
			}
			return null;
		}catch(NullPointerException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}

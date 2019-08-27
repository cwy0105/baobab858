package com.baobab.m.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

public class FtpClient {
	public String ftp(File file, String fileName, String saveFolder) {
		fileName = fileName.replace(" ", "+");
		String url = "baobabimage.cafe24.com";
		String ftpId = "baobabimage";
		String ftpPw = "baobab0858!@";
		String defaultRoot = "/www";
		FTPClient ftp = null;
	    try {
	        ftp = new FTPClient();
	        ftp.setControlEncoding("euc-kr");
	        
	        ftp.connect(url, 21);
	        ftp.login(ftpId, ftpPw);
	        ftp.changeWorkingDirectory(defaultRoot+saveFolder);
	        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
	        
	        FileInputStream fis = null;
	        try {
	            fis = new FileInputStream(file);
	            boolean isSuccess = ftp.storeFile(fileName, fis);
	            if (isSuccess) {
	                System.out.println(fileName + ": 이미지 업로드 성공");
	            }
	        } catch(IOException ex) {
	            System.out.println(ex.getMessage());
	        } finally {
	            if (fis != null) try { fis.close(); } catch(IOException ex) {}
	        }
	        ftp.logout();
	    } catch (SocketException e) {
	        System.out.println("Socket:"+e.getMessage());
	    } catch (IOException e) {
	        System.out.println("IO:"+e.getMessage());
	    } finally {
	        if (ftp != null && ftp.isConnected()) {
	            try { ftp.disconnect(); } catch (IOException e) {}
	        }
	    }
	    return "https://"+url+saveFolder+fileName;
	}
	
	public int deleteFile(String localFilePath, String fileName) throws Exception{
		fileName = fileName.replace(" ", "+");
		FTPClient ftp = null;
		
		String url = "baobabimage.cafe24.com";
		String ftpId = "baobabimage";
		String ftpPw = "baobab0858!@";
		String defaultRoot = "/www";
		
		int result = -1;
		
		try {
			ftp = new FTPClient();
	        ftp.setControlEncoding("euc-kr");
	        ftp.connect(url, 21);
	        ftp.login(ftpId, ftpPw);
	        ftp.changeWorkingDirectory(defaultRoot+localFilePath);
	        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
	        FileInputStream fis = null;
	        
	        try {
	        	boolean isSuccess = ftp.deleteFile(fileName);
	        	if(isSuccess) {
	        		System.out.println(fileName + " : 삭제완료");
	        		result = 1;
	        	}else {
	        		System.out.println("파일을 삭제 할 수 없습니다.");
	        	}
	        }catch(IOException e) {
	        	System.out.println("IOException : " + e.getMessage());
	        }finally {
	        	if(fis != null) {
	        		try {
	        			fis.close();
	        			return result;
	        		}catch(IOException e) {
	    	        	System.out.println("IOException : " + e.getMessage());
	    	        }
	        	}
	        }
	        ftp.logout();
		}catch(IOException e) {
        	System.out.println("IOException : " + e.getMessage());
        }finally {
        	if(ftp != null && ftp.isConnected()) {
        		try {
        			ftp.disconnect();
        			return result;
        		}catch(IOException e) {
                	System.out.println("IOException : " + e.getMessage());
                }
        	}
        }
		return result;
	}
	
	public String renameFile(String localFilePath, String fileName, String newName) {
		fileName = fileName.replace(" ", "+");
		String url = "baobabimage.cafe24.com";
		String ftpId = "baobabimage";
		String ftpPw = "baobab0858!@";
		String defaultRoot = "/www";
		FTPClient ftp = null;
		
		try {
			ftp = new FTPClient();
			ftp = new FTPClient();
	        ftp.setControlEncoding("euc-kr");
	        ftp.connect(url, 21);
	        ftp.login(ftpId, ftpPw);
	        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
	        
	        try {
	        	boolean isSuccess = ftp.rename(defaultRoot+localFilePath+fileName, defaultRoot+localFilePath+newName);
	      
	        	if(isSuccess) {
	        		System.out.println("파일명 변경 완료");
	        	}else {
	        		System.out.println("파일명 변경 실패");
	        	}
	        }catch(IOException e) {
	        	System.out.println("IOException : " + e.getMessage());
	        }finally {
	        	ftp.logout();
	        }
		}catch(IOException e) {
        	System.out.println("IOException : " + e.getMessage());
        }finally {
        	if(ftp != null && ftp.isConnected()) {
        		try {
        			ftp.disconnect();
        		}catch(IOException e) {
                	System.out.println("IOException : " + e.getMessage());
                }
        	}
        }
		return "https://"+url+localFilePath+newName;
	}
	
	public File convert(MultipartFile file) throws IOException{    
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile); 
        fos.write(file.getBytes());
        fos.close();
        
        return convFile;
    }
	
	public boolean fileCheck(String urlStr) throws IOException{
		URL url = new URL(urlStr);
		HttpURLConnection huc = (HttpURLConnection)url.openConnection();
		int responseCode = huc.getResponseCode();
		if(responseCode == 200) {
			huc.disconnect();
			return true;
		}else {
			huc.disconnect();
			return false;
		}
	}
	
	
	
	
}

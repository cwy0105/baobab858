package com.baobab.m.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.baobab.m.service.FtpClient;
import com.baobab.m.vo.MenuVO;

@Repository
public class MenuUploadDAOimpl implements MenuUploadDAO{

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate upload;
	private String saveFolder = "/baobabMenus/";
	
	@Override
	public void menuUpload(MenuVO mvo, MultipartFile menuImg) throws FileNotFoundException, IOException {
		mvo.setMenu_img(menuUpload(menuImg, mvo.getCp_name().toString()+"-"+mvo.getMenu_name().toString()));
		upload.update("com.baobab.m.dao.MenuUploadMapper.menuUp", mvo);
	}
	
	public String menuUpload(MultipartFile menuImg, String menuName) throws FileNotFoundException, IOException{
		FtpClient ftp = new FtpClient();
		if(menuImg != null) {
			if(!menuImg.isEmpty()) {
				String saveName = menuName+".png";
				if(saveName.contains(" ")) {
					return ftp.ftp(ftp.convert(menuImg), saveName.replace(" ", "+"), saveFolder);
				}else {
					return ftp.ftp(ftp.convert(menuImg), saveName, saveFolder);
				}
			}
			return null;
		}else {
			return "이미지없음";
		}
	}

	@Override
	public void menuDel(String cpName, String menuName, String option) throws Exception {
		MenuVO vo = new MenuVO();
		vo.setCp_name(cpName);
		vo.setMenu_name(menuName);
		vo.setMenu_option(option);
		upload.update("com.baobab.m.dao.MenuUploadMapper.menuDel", vo);
		FtpClient ftp = new FtpClient();
		if(ftp.deleteFile(saveFolder, cpName + "-" + menuName + ".png") != 1) {
			ftp.deleteFile(saveFolder, cpName + "-" + menuName + ".jpg");
		}
	}

	@Override
	public void menuModi(String cpName, String menuName, String option, String upMenuName, String upOption,
			int upDisPrice, int upPrice, String url) {
		MenuVO vo = new MenuVO();
		vo.setCp_name(cpName);
		vo.setMenu_name(menuName);
		vo.setMenu_option(option);
		vo.setUpdate_menuName(upMenuName);
		vo.setUpdate_option(upOption);
		vo.setUpdate_disPrice(upPrice);
		vo.setUpdate_price(upPrice);
		
		if(url.equals("이미지없음")) {
			vo.setMenu_img(url);
		}else {
			FtpClient ftp = new FtpClient();
			vo.setMenu_img(ftp.renameFile(saveFolder, cpName + "-" + menuName.replace(" ", "+") + ".jpg", cpName + "-" + upMenuName + ".png"));
			vo.setMenu_img(ftp.renameFile(saveFolder, cpName + "-" + menuName.replace(" ", "+") + ".png", cpName + "-" + upMenuName + ".png"));
		}
		upload.update("com.baobab.m.dao.MenuUploadMapper.menuModi", vo);
	}

}

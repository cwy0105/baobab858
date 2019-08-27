package com.baobab.m.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.baobab.m.vo.MenuVO;

public interface MenuUploadDAO {
	public void menuUpload(MenuVO mvo, MultipartFile menuImg)throws FileNotFoundException, IOException;
	void menuDel(String cpName, String menuName, String option) throws Exception;
	void menuModi(String cpName, String menuName, String option, String upMenuName, String upOption, int upDisPrice, int upPrice, String url);
}

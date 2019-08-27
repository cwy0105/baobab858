package com.baobab.m.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.baobab.m.vo.SetMenuVO;

public interface SetMenuUploadDAO {
	String setMenus(String menuName, String cpName, String menuPrice, String menuDisPrice, MultipartFile menuImg, String menuDetail, String menu, 
			String option, String ea, int cpSeq) throws Exception;
	List<SetMenuVO> showMetheSetMenu(int cpSeq);
	void delSetMenu(String cpName, String menuName, int cpSeq) throws Exception;
	void delSetMenuInfo(String cpName, String menuName, int cpSeq);
}

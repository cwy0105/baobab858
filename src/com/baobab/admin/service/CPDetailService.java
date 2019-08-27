package com.baobab.admin.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.baobab.admin.dao.AdminCPDetailDAO;
import com.baobab.m.dao.MainImgUploadDAO;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPmainImgVO;
import com.baobab.m.vo.MenuVO;

@Service
public class CPDetailService {
	
	@Autowired
	AdminCPDetailDAO cpd;
	@Autowired
	MainImgUploadDAO miu;
	
	public String makeAttribute(Model model, HttpServletRequest request) {
		model.addAttribute("info", cpd.cpInfo(request.getParameter("cpName")));
		model.addAttribute("imgUrl", imgUrl(cpd.cpInfo(request.getParameter("cpName"))));
		model.addAttribute("poke", cpd.poke(request.getParameter("cpName")));
		model.addAttribute("setMenu", cpd.setLikeMenu(cpd.setMenu(request.getParameter("cpName")), cpd.setInfo(request.getParameter("cpName"))));
		model.addAttribute("mainMenu", divMenus(cpd.menu(request.getParameter("cpName")), "메인"));
		model.addAttribute("sideMenu", divMenus(cpd.menu(request.getParameter("cpName")), "사이드"));
		model.addAttribute("ectMenu", divMenus(cpd.menu(request.getParameter("cpName")), "기타"));
		model.addAttribute("drinkMenu", divMenus(cpd.menu(request.getParameter("cpName")), "주류"));
		return "admin/cpDetail";
	}
	
	public List<MenuVO> divMenus(List<MenuVO> menus, String div){
		List<MenuVO> resultList = new ArrayList<>();
		for(int i=0;i<menus.size();i++) {
			if(menus.get(i).getMenu_div().contains(div)) {
				resultList.add(menus.get(i));
			}
		}
		return resultList;
	}
	
	public List<String> imgUrl(CPInfoVO vo){
		List<String> resultList = new ArrayList<>();
		List<CPmainImgVO> imgList = miu.getMainImg(vo.getSeq_num());
		for(int i=0;i<imgList.size();i++) {
			String url = imgList.get(i).getImg_url();
			if(urlCheck(url)) {
				resultList.add(url);
			}
		}
		return resultList;
	}
	
	public boolean urlCheck(String url) {
		if(url != null && url.startsWith("http")) {
			return true;
		}else {
			return false;
		}
	}
}

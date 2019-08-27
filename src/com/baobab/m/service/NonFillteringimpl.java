package com.baobab.m.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.StoreListDAO;
import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.PageSearchVO;

@Service
public class NonFillteringimpl implements Filltering {

	@Autowired
	StoreListDAO slDao;
	
	@Override
	public List<LocalCPInfoVO> disNoneWord(PageSearchVO vo) {
		System.out.println("두번째 필터 dis"+vo.getSearchWord());
		if(kindFillter(vo.getKind()) != null || !kindFillter(vo.getKind()).equals("")) {
			String kindStr = kindFillter(vo.getKind());
			System.out.println(kindStr);
			vo.setKind(kindStr);
			return slDao.getKindInfo(vo);
		}else {
			return slDao.selectSurroundings(vo);
		}
	}

	@Override
	public List<LocalCPInfoVO> popNoneWord(PageSearchVO vo) {
		System.out.println("두번째 필터 pop"+vo.getSearchWord());
		vo.setSearchWord("%%");
		if(kindFillter(vo.getKind()) != null || !kindFillter(vo.getKind()).equals("")) {
			String kindStr = kindFillter(vo.getKind());
			System.out.println(kindStr);
			vo.setKind(kindStr);
			return slDao.selectPopKindinfo(vo);
		}else {
			return slDao.selectSurroundings(vo);
		}
	}

	@Override
	public String kindFillter(String menu) {
		if(menu.equals("한식")) {
			return "한식";
		}else if(menu.equals("중식")) {
			return "중국식";
		}else if(menu.equals("일식")) {
			return "복어취급|일식|회집";
		}else if(menu.equals("술집/포장마차")) {
			return "감성주점|정종|대포집|소주방";
		}else if(menu.equals("레스토랑")) {
			return "경양식|뷔페식|페밀리레스토랑";
		}else if(menu.equals("카페/디저트")) {
			return "까페|다방|떡카페|라이브카페|아이스크림|전통찻집|커피숍|키즈카페|카페";
		}else if(menu.equals("찜탕")) {
			return "탕류|보신용";
		}else if(menu.equals("고기집")) {
			return "고기|식육|숯불구이|삼겹|곱창|막창";
		}else if(menu.equals("치킨/피자")) {
			return "통닭(치킨)|패스트푸드|호프/치킨|호프/통닭";
		}else if(menu.equals("분식/도시락")) {
			return "김밥(도시락)|분식|일반조리판매";
		}else if(menu.equals("빵/면")) {
			return "냉면집|제과점|제과영업점";
		}else {//주변식당
			return "";
		}
	}

}

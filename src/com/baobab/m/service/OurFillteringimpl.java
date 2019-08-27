package com.baobab.m.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.GetOurCPDAO;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.PageSearchVO;

@Service
public class OurFillteringimpl implements Filltering {
	
	@Autowired
	GetOurCPDAO getOurs;

	@Override
	public List<CPInfoVO> disNoneWord(PageSearchVO vo) {
		System.out.println("두번째 필터 dis"+vo.getSearchWord());
		if(kindFillter(vo.getKind()) != null || !kindFillter(vo.getKind()).equals("")) {
			if(vo.getKind().equals("쿠폰")){
				System.out.println("----------------쿠폰---------------------------로그");
				return getOurs.getOurCouponDistance(vo);
			}else {
				String kindStr = kindFillter(vo.getKind());
				vo.setKind(kindStr);
				return getOurs.getOursDisKind(vo);
			}
		}else {
			return getOurs.getSurroundingsOur(vo);//주변식당
		}
	}

	@Override
	public List<CPInfoVO> popNoneWord(PageSearchVO vo) {
		System.out.println("두번째 필터 pop"+vo.getSearchWord());
		if(kindFillter(vo.getKind()) != null || !kindFillter(vo.getKind()).equals("")) {
			String kindStr = kindFillter(vo.getKind());
			vo.setKind(kindStr);
			return getOurs.getOursPopKind(vo);
		}else if(vo.getKind().equals("쿠폰")){
			System.out.println("----------------쿠폰---------------------------로그");
			return getOurs.getOurCouponPopularity(vo);
		}else {
			return getOurs.getSurroundingsOur(vo);//주변식당
		}
	}

	@Override
	public String kindFillter(String menu) {
		if(menu.equals("한식")) {
			return "한식";
		}else if(menu.equals("중식")) {
			return "중국|중국요리|중식";
		}else if(menu.equals("일식")) {
			return "돈까스|회|일식";
		}else if(menu.equals("술집/포장마차")) {
			return "술집|소주방|호프|포장마차";
		}else if(menu.equals("레스토랑")) {
			return "레스토랑|뷔페식|서양식|스테이크";
		}else if(menu.equals("카페/디저트")) {
			return "카페|디저트|찻집|다방|아이스크림|팥빙수";
		}else if(menu.equals("찜/탕")) {
			return "탕류|건강식";
		}else if(menu.equals("고기집")) {
			return "고기집|족발|보쌈|닭갈비|곱창|막창";
		}else if(menu.equals("치킨/피자")) {
			return "치킨|패스트푸드|피자|햄버거";
		}else if(menu.equals("분식/도시락")) {
			return "분식|도시락|간단식";
		}else if(menu.equals("빵/면")) {
			return "냉면집|면류|제과제빵|제과점|제과영업점";
		}else if(menu.equals("쿠폰")){
			return "쿠폰";
		}else {
			return "";
		}
	}
}

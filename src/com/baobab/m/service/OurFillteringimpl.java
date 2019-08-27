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
		System.out.println("�ι�° ���� dis"+vo.getSearchWord());
		if(kindFillter(vo.getKind()) != null || !kindFillter(vo.getKind()).equals("")) {
			if(vo.getKind().equals("����")){
				System.out.println("----------------����---------------------------�α�");
				return getOurs.getOurCouponDistance(vo);
			}else {
				String kindStr = kindFillter(vo.getKind());
				vo.setKind(kindStr);
				return getOurs.getOursDisKind(vo);
			}
		}else {
			return getOurs.getSurroundingsOur(vo);//�ֺ��Ĵ�
		}
	}

	@Override
	public List<CPInfoVO> popNoneWord(PageSearchVO vo) {
		System.out.println("�ι�° ���� pop"+vo.getSearchWord());
		if(kindFillter(vo.getKind()) != null || !kindFillter(vo.getKind()).equals("")) {
			String kindStr = kindFillter(vo.getKind());
			vo.setKind(kindStr);
			return getOurs.getOursPopKind(vo);
		}else if(vo.getKind().equals("����")){
			System.out.println("----------------����---------------------------�α�");
			return getOurs.getOurCouponPopularity(vo);
		}else {
			return getOurs.getSurroundingsOur(vo);//�ֺ��Ĵ�
		}
	}

	@Override
	public String kindFillter(String menu) {
		if(menu.equals("�ѽ�")) {
			return "�ѽ�";
		}else if(menu.equals("�߽�")) {
			return "�߱�|�߱��丮|�߽�";
		}else if(menu.equals("�Ͻ�")) {
			return "���|ȸ|�Ͻ�";
		}else if(menu.equals("����/���帶��")) {
			return "����|���ֹ�|ȣ��|���帶��";
		}else if(menu.equals("�������")) {
			return "�������|�����|�����|������ũ";
		}else if(menu.equals("ī��/����Ʈ")) {
			return "ī��|����Ʈ|����|�ٹ�|���̽�ũ��|�Ϻ���";
		}else if(menu.equals("��/��")) {
			return "����|�ǰ���";
		}else if(menu.equals("�����")) {
			return "�����|����|����|�߰���|��â|��â";
		}else if(menu.equals("ġŲ/����")) {
			return "ġŲ|�н�ƮǪ��|����|�ܹ���";
		}else if(menu.equals("�н�/���ö�")) {
			return "�н�|���ö�|���ܽ�";
		}else if(menu.equals("��/��")) {
			return "�ø���|���|��������|������|����������";
		}else if(menu.equals("����")){
			return "����";
		}else {
			return "";
		}
	}
}

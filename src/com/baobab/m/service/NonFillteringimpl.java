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
		System.out.println("�ι�° ���� dis"+vo.getSearchWord());
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
		System.out.println("�ι�° ���� pop"+vo.getSearchWord());
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
		if(menu.equals("�ѽ�")) {
			return "�ѽ�";
		}else if(menu.equals("�߽�")) {
			return "�߱���";
		}else if(menu.equals("�Ͻ�")) {
			return "�������|�Ͻ�|ȸ��";
		}else if(menu.equals("����/���帶��")) {
			return "��������|����|������|���ֹ�";
		}else if(menu.equals("�������")) {
			return "����|�����|��и��������";
		}else if(menu.equals("ī��/����Ʈ")) {
			return "����|�ٹ�|��ī��|���̺�ī��|���̽�ũ��|��������|Ŀ�Ǽ�|Ű��ī��|ī��";
		}else if(menu.equals("����")) {
			return "����|���ſ�";
		}else if(menu.equals("�����")) {
			return "���|����|���ұ���|���|��â|��â";
		}else if(menu.equals("ġŲ/����")) {
			return "���(ġŲ)|�н�ƮǪ��|ȣ��/ġŲ|ȣ��/���";
		}else if(menu.equals("�н�/���ö�")) {
			return "���(���ö�)|�н�|�Ϲ������Ǹ�";
		}else if(menu.equals("��/��")) {
			return "�ø���|������|����������";
		}else {//�ֺ��Ĵ�
			return "";
		}
	}

}

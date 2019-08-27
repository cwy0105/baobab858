package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.PageSearchVO;

@Repository
public class GetOurCPDAOimpl implements GetOurCPDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate getCp;

	@Override
	public List<CPInfoVO> getOursPopularity(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("��� �α�� ��ü");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursPopularity", vo);
		}else {
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursPopularity", vo);
		}
	}

	@Override
	public List<CPInfoVO> getOursPopLocation(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("��� �α�� ������");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursPopLocation", vo);
		}else {
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursPopLocation", vo);
		}
	}

	@Override
	public List<CPInfoVO> getOursPopCpName(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("��� �α�� �Ĵ��");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursPopCpName", vo);
		}else {
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursPopCpName", vo);
		}
	}

	@Override
	public List<CPInfoVO> getOursPopMenu(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("��� �α�� �޴���");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursPopMenu", vo);
		}else {
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursPopMenu", vo);
		}
	}

	@Override
	public List<CPInfoVO> getOursPopKind(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("��� �α�� ������");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursPopKind", vo);
		}else {
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursPopKind", vo);
		}
	}

	@Override
	public List<CPInfoVO> getOurCouponPopularity(PageSearchVO vo) {System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
	System.out.println("[���� ��� ��ü] �α�� ");
	if(vo.getSearchWord().equals("%none%")) {
		vo.setSearchWord("%%");
		return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOurCouponPopularity", vo);
	}else {
		return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOurCouponPopularity", vo);
	}
	}

//======�Ÿ���
	@Override
	public List<CPInfoVO> getOursDistance(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("��� �Ÿ��� ��ü");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursDistance", vo);
		}else {
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursDistance", vo);
		}
	}

	@Override
	public List<CPInfoVO> getOursDisLocation(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("��� �Ÿ��� ������");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursDisLocation", vo);
		}else {
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursDisLocation", vo);
		}
	}

	@Override
	public List<CPInfoVO> getOursDisCpName(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("��� �Ÿ��� �Ĵ��");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursDisCpName", vo);
		}else {
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursDisCpName", vo);
		}
	}

	@Override
	public List<CPInfoVO> getOursDisMenu(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("��� �Ÿ��� �޴���");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursDisMenu", vo);
		}else {
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursDisMenu", vo);
		}
	}

	@Override
	public List<CPInfoVO> getOursDisKind(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("��� �Ÿ��� ������");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursDisKind", vo);
		}else {
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursDisKind", vo);
		}
	}

	@Override
	public List<CPInfoVO> getSurroundingsOur(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("��� �Ÿ��� �ֺ�");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getSurroundingsOur", vo);
		}else {
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getSurroundingsOur", vo);
		}
	}

	@Override
	public List<CPInfoVO> getOurCouponDistance(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("[���� ��� ��ü] �Ÿ���");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOurCouponDistance", vo);
		}else {
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOurCouponDistance", vo);
		}
	}
}
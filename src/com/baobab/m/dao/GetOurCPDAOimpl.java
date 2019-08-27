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
		System.out.println("등록 인기순 전체");
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
		System.out.println("등록 인기순 지역명");
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
		System.out.println("등록 인기순 식당명");
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
		System.out.println("등록 인기순 메뉴명");
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
		System.out.println("등록 인기순 업종별");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursPopKind", vo);
		}else {
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOursPopKind", vo);
		}
	}

	@Override
	public List<CPInfoVO> getOurCouponPopularity(PageSearchVO vo) {System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
	System.out.println("[쿠폰 등록 업체] 인기순 ");
	if(vo.getSearchWord().equals("%none%")) {
		vo.setSearchWord("%%");
		return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOurCouponPopularity", vo);
	}else {
		return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOurCouponPopularity", vo);
	}
	}

//======거리별
	@Override
	public List<CPInfoVO> getOursDistance(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("등록 거리순 전체");
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
		System.out.println("등록 거리순 지역별");
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
		System.out.println("등록 거리순 식당명");
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
		System.out.println("등록 거리순 메뉴명");
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
		System.out.println("등록 거리순 업종별");
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
		System.out.println("등록 거리순 주변");
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
		System.out.println("[쿠폰 등록 업체] 거리순");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOurCouponDistance", vo);
		}else {
			return getCp.selectList("com.baobab.m.dao.GetOurCPMapper.getOurCouponDistance", vo);
		}
	}
}
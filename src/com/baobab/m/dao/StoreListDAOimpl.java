package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.PageSearchVO;

@Repository
public class StoreListDAOimpl implements StoreListDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate serch;

	@Override
	public List<LocalCPInfoVO> getAllinfo(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("미등록 전체");
		return serch.selectList("com.baobab.m.dao.StoreListMapper.selectAllinfo", vo);
	}

	@Override
	public List<LocalCPInfoVO> getLocalinfo(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("미등록 지역명");
		return serch.selectList("com.baobab.m.dao.StoreListMapper.selectLocalinfo", vo);
	}

	@Override
	public List<LocalCPInfoVO> getMenuinfo(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("미등록 메뉴명");
		return serch.selectList("com.baobab.m.dao.StoreListMapper.selectMenuinfo", vo);
	}

	@Override
	public List<LocalCPInfoVO> getNameInfo(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("미등록 식당명");
		return serch.selectList("com.baobab.m.dao.StoreListMapper.selectNameinfo", vo);
	}

	@Override
	public List<LocalCPInfoVO> getKindInfo(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("미등록 업종별");
		if(vo.getSearchWord().equals("%none%")) {
			vo.setSearchWord("%%");
			return serch.selectList("com.baobab.m.dao.StoreListMapper.selectKindinfo", vo);
		}else {
			return serch.selectList("com.baobab.m.dao.StoreListMapper.selectKindinfo", vo);
		}
	}

	@Override
	public List<LocalCPInfoVO> selectSurroundings(PageSearchVO vo) {
		System.out.println(vo.getSearchWord() + ", " + vo.getDiv() + ", " + vo.getKind() + ", " + vo.getSortBy() + ", " + vo.getLocation());
		System.out.println("미등록 주변");
		return serch.selectList("com.baobab.m.dao.StoreListMapper.selectSurroundings", vo);
	}

	@Override
	public List<LocalCPInfoVO> selectPopAllinfo(PageSearchVO vo) {
		return serch.selectList("com.baobab.m.dao.StoreListMapper.selectPopAllinfo", vo);
	}

	@Override
	public List<LocalCPInfoVO> selectPopLocalinfo(PageSearchVO vo) {
		return serch.selectList("com.baobab.m.dao.StoreListMapper.selectPopLocalinfo", vo);
	}

	@Override
	public List<LocalCPInfoVO> selectPopMenuinfo(PageSearchVO vo) {
		return serch.selectList("com.baobab.m.dao.StoreListMapper.selectPopMenuinfo", vo);
	}

	@Override
	public List<LocalCPInfoVO> selectPopNameinfo(PageSearchVO vo) {
		return serch.selectList("com.baobab.m.dao.StoreListMapper.selectPopNameinfo", vo);
	}

	@Override
	public List<LocalCPInfoVO> selectPopKindinfo(PageSearchVO vo) {
		return serch.selectList("com.baobab.m.dao.StoreListMapper.selectPopKindinfo", vo);
	}
}

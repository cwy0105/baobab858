package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.MenuVO;

@Repository
public class GetMyMenuDAOimpl implements GetMyMenuDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate get;

	@Override
	public List<MenuVO> getMenu(int cpSeq) {
		return get.selectList("com.baobab.m.dao.getMyMenuMapper.getMenu", cpSeq);
	}

	@Override
	public List<MenuVO> getThisMenu(int cpSeq) {
		return get.selectList("com.baobab.m.dao.getMyMenuMapper.getThisMenu", cpSeq);
	}

	@Override
	public String menuImageUrl(String cpName, int cpSeq, String menuName) {
		MenuVO vo = new MenuVO();
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
		vo.setMenu_name(menuName);
		List<String> list = get.selectList("com.baobab.m.dao.getMyMenuMapper.menuImageUrl", vo);
		if(list.size() >= 1) {
			return list.get(0);
		}else {
			return "";
		}
	}

	@Override
	public int menuUrlUpdate(String menuUrl, String menuName, int cpSeq) {
		MenuVO vo = new MenuVO();
		vo.setCp_seq(cpSeq);
		vo.setMenu_img(menuUrl);
		vo.setMenu_name(menuName);
		return get.update("com.baobab.m.dao.getMyMenuMapper.menuUrlUpdate", vo);
	}

}

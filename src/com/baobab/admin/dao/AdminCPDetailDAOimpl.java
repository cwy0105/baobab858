package com.baobab.admin.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.SetMenuInfoVO;
import com.baobab.m.vo.SetMenuVO;

@Repository
public class AdminCPDetailDAOimpl implements AdminCPDetailDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate cpd;

	@Override
	public CPInfoVO cpInfo(String cpName) {
		return cpd.selectOne("com.baobab.admin.dao.AdminCPDetailMapper.cpInfo", cpName);
	}

	@Override
	public int poke(String cpName) {
		return cpd.selectList("com.baobab.admin.dao.AdminCPDetailMapper.poke", cpName).size();
	}

	@Override
	public List<SetMenuVO> setMenu(String cpName) {
		return cpd.selectList("com.baobab.admin.dao.AdminCPDetailMapper.setMenu", cpName);
	}

	@Override
	public List<SetMenuInfoVO> setInfo(String cpName) {
		return cpd.selectList("com.baobab.admin.dao.AdminCPDetailMapper.setInfo", cpName);
	}

	@Override
	public List<MenuVO> menu(String cpName) {
		return cpd.selectList("com.baobab.admin.dao.AdminCPDetailMapper.menu", cpName);
	}

	@Override
	public List<MenuVO> setLikeMenu(List<SetMenuVO> set, List<SetMenuInfoVO> info) {
		List<MenuVO> resultList = new ArrayList<>();
		for(int i=0;i<set.size();i++) {
			MenuVO vo = new MenuVO();
			String option = "";
			for(int j=0;j<info.size();j++) {
				if(set.get(i).getMenu_name().equals(info.get(j).getSet_menu_name())) {
					option += info.get(j).getMenu() + "(" + info.get(j).getOption() + " " + info.get(j).getEa() + "°³), ";					
				}
			}
			vo.setMenu_name(set.get(i).getMenu_name());
			vo.setMenu_price(Integer.parseInt(set.get(i).getMenu_price()));
			vo.setMenu_dis_price(Integer.parseInt(set.get(i).getMenu_dis_price()));
			vo.setMenu_option(option.substring(0, option.length()-2));
			vo.setMenu_detail(set.get(i).getMenu_detail());
			resultList.add(vo);
		}
		return resultList;
	}

}

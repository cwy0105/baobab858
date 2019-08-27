package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.NonBilliardVO;
import com.baobab.m.vo.NonKaraokeVO;
import com.baobab.m.vo.NonPCroomVO;



@Repository
public class StoreMenuDAOimpl implements StoreMenuDAO {

	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate getMenu;
	
	@Override
	public List<MenuVO> getMenus(int cpSeq, String menuDiv) {
		MenuVO vo = new MenuVO();
		vo.setCp_seq(cpSeq);
		vo.setMenu_div(menuDiv);
		return getMenu.selectList("com.baobab.m.dao.StoreMenuMapper.getMenus", vo);
	}

	@Override
	public void updateHits(String cpName, int seqNum) {
		CPInfoVO vo = new CPInfoVO();
		vo.setCP_name(cpName);
		vo.setSeq_num(seqNum);
		getMenu.update("com.baobab.m.dao.StoreMenuMapper.updateHits", vo);
		updateCurHits(cpName, seqNum);
	}

	@Override
	public List<MenuVO> getOneMenu(String cpName, String menuName, int cpSeq) {
		MenuVO vo = new MenuVO();
		vo.setCp_name(cpName);
		vo.setMenu_name(menuName);
		vo.setCp_seq(cpSeq);
		return getMenu.selectList("com.baobab.m.dao.StoreMenuMapper.getOneMenu", vo);
	}

	@Override
	public void updateNonHits(String cpName, int seqNum, String div) {
		if(div.equals("non")) {
			LocalCPInfoVO vo = new LocalCPInfoVO();
			vo.setCp_name(cpName);
			vo.setLoc_seq(seqNum);
			getMenu.update("com.baobab.m.dao.StoreMenuMapper.updateNonHits", vo);
		}else if(div.equals("PC방")) {
			NonPCroomVO vo = new NonPCroomVO();
			vo.setCp_name(cpName);
			vo.setSeq_num(seqNum);
			getMenu.update("com.baobab.m.dao.StoreMenuMapper.updatePCHits", vo);
		}else if(div.equals("노래방")) {
			NonKaraokeVO vo = new NonKaraokeVO();
			vo.setCp_name(cpName);
			vo.setSeq_num(seqNum);
			getMenu.update("com.baobab.m.dao.StoreMenuMapper.updateKaraHits", vo);
		}else if(div.equals("당구장")) {
			NonBilliardVO vo = new NonBilliardVO();
			vo.setCp_name(cpName);
			vo.setSeq_num(seqNum);
			getMenu.update("com.baobab.m.dao.StoreMenuMapper.updateBilliHits", vo);
		}
	}

	@Override
	public void updateCurHits(String cpName, int seqNum) {
		CPInfoVO vo = new CPInfoVO();
		vo.setCP_name(cpName);
		vo.setSeq_num(seqNum);
		getMenu.update("com.baobab.m.dao.StoreMenuMapper.updateCurHits", vo);
	}

	@Override
	public void hitsInitialize() {
		getMenu.update("com.baobab.m.dao.StoreMenuMapper.hitsInitialize");
		System.out.println("초기화 완료 (DAO)");
	}

}

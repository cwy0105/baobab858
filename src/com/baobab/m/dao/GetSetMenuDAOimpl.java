package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.SetMenuInfoVO;
import com.baobab.m.vo.SetMenuVO;

@Repository
public class GetSetMenuDAOimpl implements GetSetMenuDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate setMenu;

	@Override
	public List<SetMenuVO> getSetMenu(int cpSeq) {
		return setMenu.selectList("com.baobab.m.dao.GetSetMenuMapper.getSetMenu", cpSeq);
	}

	@Override
	public List<SetMenuInfoVO> getSetMenuInfo(int cpSeq) {
		return setMenu.selectList("com.baobab.m.dao.GetSetMenuMapper.getSetMenuInfo", cpSeq);
	}

	@Override
	public SetMenuVO getOneSetMenu(String cpName, String menuName, int cpSeq) {
		SetMenuVO vo = new SetMenuVO();
		vo.setCp_name(cpName);
		vo.setMenu_name(menuName);
		vo.setCp_seq(cpSeq);
		return setMenu.selectOne("com.baobab.m.dao.GetSetMenuMapper.getOneSetMenu", vo);
	}

	@Override
	public int menuConfirm(String cpName, int cpSeq, String menuName) {
		SetMenuVO vo = new SetMenuVO();
		vo.setCp_name(cpName);
		vo.setMenu_name(menuName);
		vo.setCp_seq(cpSeq);
		return setMenu.selectList("com.baobab.m.dao.GetSetMenuMapper.getOneSetMenu", vo).size();
	}

	@Override
	public int setMenuUrlUpdate(String menuUrl, String menuName, int cpSeq) {
		SetMenuVO vo = new SetMenuVO();
		vo.setMenu_img(menuUrl);
		vo.setCp_seq(cpSeq);
		vo.setMenu_name(menuName);
		return setMenu.update("com.baobab.m.dao.GetSetMenuMapper.setMenuUrlUpdate", vo);
	}

}

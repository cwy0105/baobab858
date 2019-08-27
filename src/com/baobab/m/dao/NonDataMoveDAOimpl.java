package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPmainImgVO;
import com.baobab.m.vo.CallHistoryVO;
import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.NonCpImgVO;
import com.baobab.m.vo.NonCpMenuVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.ReviewVO;

@Repository
public class NonDataMoveDAOimpl implements NonDataMoveDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate data;

	@Override
	public List<LocalCPInfoVO> nonSelect(CPInfoVO vo) {
		return data.selectList("com.baobab.m.dao.NonDataMoveMapper.nonSelect", vo);
	}

	@Override
	public int nonDelete(CPInfoVO vo) {
		return data.delete("com.baobab.m.dao.NonDataMoveMapper.nonDelete", vo);
	}

	@Override
	public List<NonCpImgVO> selectImg(int nonSeq) {
		return data.selectList("com.baobab.m.dao.NonDataMoveMapper.selectImg", nonSeq);
	}

	@Override
	public int insertImg(CPmainImgVO vo) {
		return data.insert("com.baobab.m.dao.NonDataMoveMapper.insertImg", vo);
	}

	@Override
	public int deleteImg(int nonSeq) {
		return data.delete("com.baobab.m.dao.NonDataMoveMapper.deleteImg", nonSeq);
	}

	@Override
	public List<NonCpMenuVO> selectMenu(int nonSeq) {
		return data.selectList("com.baobab.m.dao.NonDataMoveMapper.selectMenu", nonSeq);
	}

	@Override
	public int insertMenu(MenuVO vo) {
		return data.insert("com.baobab.m.dao.NonDataMoveMapper.insertMenu", vo);
	}

	@Override
	public int deleteMenu(int nonSeq) {
		return data.delete("com.baobab.m.dao.NonDataMoveMapper.deleteMenu", nonSeq);
	}

	@Override
	public int selectSeq(CPInfoVO vo) {
		return ((CPInfoVO)data.selectOne("com.baobab.m.dao.NonDataMoveMapper.selectSeq", vo)).getSeq_num();
	}

	@Override
	public void updateInfo(LocalCPInfoVO vo) {
		data.update("com.baobab.m.dao.NonDataMoveMapper.updateInfo", vo);
	}

	@Override
	public void updateCall(CallHistoryVO vo) {
		data.update("com.baobab.m.dao.NonDataMoveMapper.updateCall", vo);
	}

	@Override
	public void updatePoke(PokeVO vo) {
		data.update("com.baobab.m.dao.NonDataMoveMapper.updatePoke", vo);
	}

	@Override
	public void updateReview(ReviewVO vo) {
		data.update("com.baobab.m.dao.NonDataMoveMapper.updateReview", vo);
	}

}

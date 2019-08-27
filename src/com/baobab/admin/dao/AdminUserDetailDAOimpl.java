package com.baobab.admin.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CallHistoryVO;
import com.baobab.m.vo.LocationInquHistoryVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.ReviewVO;
import com.baobab.m.vo.UserHistoryVO;
import com.baobab.m.vo.UserLocationVO;

@Repository
public class AdminUserDetailDAOimpl implements AdminUserDetailDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate ud;

	@Override
	public UserLocationVO loctaionInfo(String email) {
		return ud.selectOne("com.baobab.admin.dao.AdminUserDetailMapper.loctaionInfo", email);
	}

	@Override
	public List<PaymentVO> paymentInfo(String email) {
		return ud.selectList("com.baobab.admin.dao.AdminUserDetailMapper.paymentInfo", email);
	}

	@Override
	public List<UserHistoryVO> historyInfo(String email) {
		return ud.selectList("com.baobab.admin.dao.AdminUserDetailMapper.historyInfo", email);
	}

	@Override
	public List<CallHistoryVO> callHistoryInfo(String email) {
		return ud.selectList("com.baobab.admin.dao.AdminUserDetailMapper.callHistoryInfo", email);
	}

	@Override
	public List<PokeVO> pokeInfo(String email) {
		return ud.selectList("com.baobab.admin.dao.AdminUserDetailMapper.pokeInfo", email);
	}

	@Override
	public List<ReviewVO> reviewInfo(String email) {
		return ud.selectList("com.baobab.admin.dao.AdminUserDetailMapper.reviewInfo", email);
	}

	@Override
	public void locationInqu(LocationInquHistoryVO vo) {
		ud.update("com.baobab.admin.dao.AdminUserDetailMapper.locationInqu", vo);		
	}

}

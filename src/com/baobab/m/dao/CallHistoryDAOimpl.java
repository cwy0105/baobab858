package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.CallHistoryVO;
import com.baobab.m.vo.NonPCroomVO;

@Repository
public class CallHistoryDAOimpl implements CallHistoryDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate call;

	@Override
	public void getHistory(String userPhone, String cpPhone, String cpName, String cpAddress, String cpDiv) {
		CallHistoryVO vo = new CallHistoryVO();
		vo.setUser_phone(userPhone);
		vo.setCp_phone(cpPhone);
		vo.setCp_name(cpName);
		vo.setCp_address(cpAddress);
		vo.setCp_div(cpDiv);
		call.update("com.baobab.m.dao.CallHistoryMapper.getHistory", vo);
	}

	@Override
	public List<CallHistoryVO> showHistory(String userPhone) {
		return call.selectList("com.baobab.m.dao.CallHistoryMapper.showHistory", userPhone);
	}

	@Override
	public void delHistory(int seqNum) {
		call.update("com.baobab.m.dao.CallHistoryMapper.delHistory", seqNum);
	}

	@Override
	public NonPCroomVO enterSelect(String cpName, String address) {
		CallHistoryVO vo = new CallHistoryVO();
		vo.setCp_name(cpName);
		vo.setCp_address(address);
		return call.selectOne("com.baobab.m.dao.CallHistoryMapper.enterSelect", vo);
	}

}

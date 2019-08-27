package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CallHistoryVO;
import com.baobab.m.vo.NonPCroomVO;

public interface CallHistoryDAO {
	void getHistory(String userPhone, String cpPhone, String cpName, String cpAddress, String cpDiv);
	List<CallHistoryVO> showHistory(String userPhone);
	void delHistory(int seqNum);
	NonPCroomVO enterSelect(String cpName, String address);
}

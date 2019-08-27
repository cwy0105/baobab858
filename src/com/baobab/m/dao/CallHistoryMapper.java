package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CallHistoryVO;
import com.baobab.m.vo.NonPCroomVO;

public interface CallHistoryMapper {
	void getHistory(CallHistoryVO vo);
	List<CallHistoryVO> showHistory(String userPhone);
	void delHistory(int seqNum);
	NonPCroomVO enterSelect(CallHistoryVO vo);
}

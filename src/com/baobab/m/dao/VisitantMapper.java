package com.baobab.m.dao;

import com.baobab.m.vo.VisitantHistoryVO;
import com.baobab.m.vo.VisitantVO;

@Mapper
public interface VisitantMapper {
	void firstVisit(VisitantVO vo);
	void accumulateVisit(VisitantVO vo);
	void visitHistory(VisitantHistoryVO vo);
	int allVisitant();
}

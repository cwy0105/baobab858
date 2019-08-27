package com.baobab.m.dao;

import com.baobab.m.vo.SearchHistoryVO;

@Mapper
public interface SearchHistoryMapper {
	void getHistory(SearchHistoryVO vo);
}

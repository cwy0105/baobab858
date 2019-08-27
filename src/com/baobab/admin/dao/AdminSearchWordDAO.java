package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.vo.RankVO;

public interface AdminSearchWordDAO {
	List<RankVO> kindRank();
	List<RankVO> wordRank();
}

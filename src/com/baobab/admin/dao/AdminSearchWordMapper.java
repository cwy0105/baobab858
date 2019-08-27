package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.RankVO;

@Mapper
public interface AdminSearchWordMapper {
	List<RankVO> kindRank();
	List<RankVO> wordRank();
}

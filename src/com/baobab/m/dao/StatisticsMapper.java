package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.StatVO;

@Mapper
public interface StatisticsMapper {
	List<PaymentVO> allStat(StatVO vo);
	List<PaymentVO> dayStat(StatVO vo);
}

package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.PaymentVO;

public interface StatisticsDAO {
	List<PaymentVO> allStat(String cpName, String startDate, String endDate);
	List<PaymentVO> dayStat(String cpName, String selDate);
}

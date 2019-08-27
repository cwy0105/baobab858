package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.StatVO;

@Repository
public class StatisticsDAOimpl implements StatisticsDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate stat;

	@Override
	public List<PaymentVO> allStat(String cpName, String startDate, String endDate) {
		StatVO vo = new StatVO();
		vo.setCpName(cpName);
		vo.setStartDate(makeDate(startDate) + " 00:00:00");
		vo.setEndDate(makeDate(endDate) + " 23:59:59");
		return stat.selectList("com.baobab.m.dao.StatisticsMapper.allStat", vo);
	}

	@Override
	public List<PaymentVO> dayStat(String cpName, String selDate) {
		StatVO vo = new StatVO();
		vo.setCpName(cpName);
		vo.setSelDate("%"+makeDate(selDate)+"%");
		return stat.selectList("com.baobab.m.dao.StatisticsMapper.dayStat", vo);
	}
	
	public String makeDate(String date) {
		String[] arr = date.split("-");
		if(arr[1].length() < 2) {
			return arr[0] + "-0" + arr [1] + "-" + makeDay(arr[2]);
		}else {
			return arr[0] + "-" + arr [1] + "-" + makeDay(arr[2]);
		}
	}
	
	public String makeDay(String day) {
		if(day.length() < 2) {
			return "0" + day;
		}else {
			return day;
		}
	}

}

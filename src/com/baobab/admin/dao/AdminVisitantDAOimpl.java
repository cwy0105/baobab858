package com.baobab.admin.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.baobab.m.vo.AdminVisitantVO;

@Repository
public class AdminVisitantDAOimpl implements AdminVisitantDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate vis;

	@Override
	public String visitants(Model model, HttpServletRequest request) {
		AdminVisitantVO vo = new AdminVisitantVO();
		vo.setUser_phone("%" + request.getParameter("searchWord") + "%");
		vo.setEmail("%" + request.getParameter("searchWord") + "%");
		vo.setDiv_code("%" + request.getParameter("divCode") + "%");
		vo.setStartDate(nonStartDate(request.getParameter("startDate")));
		vo.setEndDate(nonEndDate(request.getParameter("endDate")));
		vo.setSeq_num(nonNum(request.getParameter("visitNum")));
		visitant(model, vo);
		model.addAttribute("visitsList", vis.selectList("com.baobab.admin.dao.AdminVisitantMapper.visitants", vo));
		return "admin/visitant";
	}
	
	@Override
	public void visitant(Model model, AdminVisitantVO vo) {
		model.addAttribute("visitList", vis.selectList("com.baobab.admin.dao.AdminVisitantMapper.visitant", vo));
	}
	
	public String nonStartDate(String date) {
		if(date == null || date.length() == 0) {
			return "2018-10-15";
		}else {
			return date;
		}
	}
	
	public String nonEndDate(String date) {
		if(date == null || date.length() == 0) {
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(today);
			c.add(Calendar.DATE, 1);
			return sdf.format(c.getTime());
		}else {
			return date;
		}
	}
	
	public int nonNum(String num) {
		if(num == null || num.equals("0") || num.length() == 0) {
			return 2147483647;
		}else {
			return Integer.parseInt(num);
		}
	}	
}

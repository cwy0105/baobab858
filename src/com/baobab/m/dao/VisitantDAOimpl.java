package com.baobab.m.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.VisitantHistoryVO;
import com.baobab.m.vo.VisitantVO;

@Repository
public class VisitantDAOimpl implements VisitantDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate visit;

	@Override
	public void firstVisit(String user_phone, String lastDate) {
		VisitantVO vo = new VisitantVO();
		vo.setUser_phone(remakeNum(user_phone));
		vo.setLast_visit_date(lastDate);
		visit.update("com.baobab.m.dao.VisitantMapper.firstVisit", vo);
	}

	@Override
	public void accumulateVisit(String user_phone, String lastDate) {
		VisitantVO vo = new VisitantVO();
		vo.setUser_phone(remakeNum(user_phone));
		vo.setLast_visit_date(lastDate);
		visit.update("com.baobab.m.dao.VisitantMapper.accumulateVisit", vo);
	}

	@Override
	public void visitHistory(String user_phone, String visit_type, String lastDate) throws ParseException {
		VisitantHistoryVO vo = new VisitantHistoryVO();
		vo.setUser_phone(remakeNum(user_phone));
		vo.setVisit_type(visit_type);
		String pattern = "";
	      if(lastDate.length() > 11) {
	         pattern = "yyyy-MM-dd HH:mm:ss";
	      }else {
	         pattern = "yyyy-MM-dd";
	      }
	      SimpleDateFormat transFormat = new SimpleDateFormat(pattern);
		vo.setVisit_date(transFormat.parse(lastDate));
		visit.update("com.baobab.m.dao.VisitantMapper.visitHistory", vo);
	}

	@Override
	public int allVisitant() {
		return visit.selectOne("com.baobab.m.dao.VisitantMapper.allVisitant");
	}
	
	public String remakeNum(String userPhone) {
		if(!userPhone.equals("")) {
			return "010" + userPhone.substring(userPhone.length()-8, userPhone.length());
		}else {
			return userPhone;
		}
	}

}

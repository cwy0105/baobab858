package com.baobab.admin.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.vo.ReviewVO;

@Repository
public class AdminReivewDAOimpl implements AdminReviewDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate rev;


	@Override
	public List<ReviewVO> reviewList(HttpServletRequest request) {
		ReviewVO vo = new ReviewVO();
		vo.setDiv_code("%" + request.getParameter("cp_div") + "%");
		vo.setCP_name("%" + request.getParameter("searchWord") + "%");
		vo.setUserPhoneNum("%" + request.getParameter("searchWord") + "%");
		return rev.selectList("com.baobab.admin.dao.AdminReviewMapper.reviewList", vo);
	}

	@Override
	public ReviewVO reviewSelect(HttpServletRequest request) {
		return rev.selectOne("com.baobab.admin.dao.AdminReviewMapper.reviewSelect", Integer.parseInt(request.getParameter("seqNum")));
	}

}

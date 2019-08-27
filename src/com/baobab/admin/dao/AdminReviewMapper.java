package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.ReviewVO;

@Mapper
public interface AdminReviewMapper {
	List<ReviewVO> reviewList(ReviewVO vo);
	ReviewVO reviewSelect(int seqNum);
}

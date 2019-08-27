package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.NonPCroomVO;
import com.baobab.m.vo.ReviewVO;

@Mapper
public interface ReviewMapper {
	void ourReview(ReviewVO vo);
	List<ReviewVO> firstReview(ReviewVO vo);
	List<ReviewVO> moreReview(ReviewVO vo);
	List<ReviewVO> allReview(ReviewVO vo);
	List<ReviewVO> myReview(ReviewVO vo);
	void delReview(ReviewVO vo);
	ReviewVO selectOneRev(int review_num);
	void reviewCount(ReviewVO vo);
	void gradeCalcu(ReviewVO vo);
	void nonReviewCount(ReviewVO vo);
	void nonGradeCalcu(ReviewVO vo);
	List<ReviewVO> allImages(ReviewVO vo);
	NonPCroomVO enterSelect(ReviewVO vo);
	List<ReviewVO> reviewAll();
}

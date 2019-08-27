package com.baobab.m.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.baobab.m.vo.NonPCroomVO;
import com.baobab.m.vo.ReviewVO;

public interface ReviewDAO {
	void ourReview(MultipartFile img1, MultipartFile img2, MultipartFile img3, MultipartFile img4, String email, String phoneNum, String revPwd, 
			String revText, String grade, String cpName, String cpSeq, String divCode, String nickName, String profile)
					 throws FileNotFoundException, IOException ;
	List<ReviewVO> firstReview(String cpName, int seqNum);
	List<ReviewVO> moreReview(String cpName, int seqNum);
	List<ReviewVO> allReview(String cpName, int revCount, int seqNum);
	List<ReviewVO> myReview(String userPhoneNum, int revCount);
	void delReview(String userPhoneNum, String cpName, int reviewNum) throws Exception;
	ReviewVO selectOneRev(int review_num);
	void reviewCount(ReviewVO vo);
	void gradeCalcu(ReviewVO vo);
	void nonReviewCount(ReviewVO vo);
	void nonGradeCalcu(ReviewVO vo);
	List<ReviewVO> allImages(String cpName, int cpSeq);
	NonPCroomVO enterSelect(String cpName, int cpSeq);
	List<ReviewVO> reviewAll();
}

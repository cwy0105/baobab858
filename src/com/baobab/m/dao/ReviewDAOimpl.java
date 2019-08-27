package com.baobab.m.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.baobab.m.service.FtpClient;
import com.baobab.m.vo.NonPCroomVO;
import com.baobab.m.vo.ReviewVO;

@Repository
public class ReviewDAOimpl implements ReviewDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate rev;
	private String saveFolder = "/ourReviews/";
	
	public String imgUpload(MultipartFile img, String cpName, String phoneNum) throws FileNotFoundException, IOException, NullPointerException{
		FtpClient ftp = new FtpClient();
		Date today = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
		if(img == null) {
			return "이미지없음";
		}else {
			String saveName = cpName+phoneNum+"-"+time.format(today)+".png";
			if(saveName.contains(" ")) {
				return ftp.ftp(ftp.convert(img), saveName.replace(" ", "+"), saveFolder);
			}else {
				return ftp.ftp(ftp.convert(img), saveName, saveFolder);
			}
		}
	}

	@Override
	public void ourReview(MultipartFile img1, MultipartFile img2, MultipartFile img3, MultipartFile img4, String email, 
			String phoneNum, String revPwd, String revText, String grade, String cpName, String cpSeq, String divCode, 
			String nickName, String profile) 
					throws FileNotFoundException, IOException {
		ReviewVO vo = new ReviewVO();
		vo.setEmail(email);
		vo.setNickName(nickName);
		vo.setProfile(profile);
		vo.setCP_name(cpName);
		vo.setScore(Integer.parseInt(grade));
		vo.setText(revText);
		vo.setReview_pwd(revPwd);
		vo.setUserPhoneNum(phoneNum);
		vo.setCp_seq(Integer.parseInt(cpSeq));
		vo.setDiv_code(divCode);
		vo.setImg1(imgUpload(img1, cpName, phoneNum + "-1-"));
		vo.setImg2(imgUpload(img2, cpName, phoneNum + "-2-"));
		vo.setImg3(imgUpload(img3, cpName, phoneNum + "-3-"));
		vo.setImg4(imgUpload(img4, cpName, phoneNum + "-4-"));
		
		rev.update("com.baobab.m.dao.ReviewMapper.ourReview", vo);
		if(divCode.equals("our")) {
			reviewCount(vo);
			System.out.println("our 리뷰갯수 업데이트 완료");
			gradeCalcu(vo);
		}else if(divCode.equals("non")) {
			nonReviewCount(vo);
			System.out.println("non 리뷰갯수 업데이트 완료");
			nonGradeCalcu(vo);
		}
	}

	@Override
	public List<ReviewVO> firstReview(String cpName, int seqNum) {
		ReviewVO vo = new ReviewVO();
		vo.setCP_name(cpName);
		vo.setCp_seq(seqNum);
		return rev.selectList("com.baobab.m.dao.ReviewMapper.firstReview", vo);
	}

	@Override
	public List<ReviewVO> moreReview(String cpName, int seqNum) {
		ReviewVO vo = new ReviewVO();
		vo.setCP_name(cpName);
		vo.setCp_seq(seqNum);
		return rev.selectList("com.baobab.m.dao.ReviewMapper.moreReview", vo);
	}

	@Override
	public List<ReviewVO> allReview(String cpName, int revCount, int seqNum) {
		ReviewVO vo = new ReviewVO();
		vo.setCP_name(cpName);
		vo.setRevCount(revCount);
		vo.setCp_seq(seqNum);
		return rev.selectList("com.baobab.m.dao.ReviewMapper.allReview", vo);
	}

	@Override
	public List<ReviewVO> myReview(String userPhoneNum, int revCount) {
		ReviewVO vo = new ReviewVO();
		vo.setUserPhoneNum(userPhoneNum);
		vo.setReview_num(revCount);
		return rev.selectList("com.baobab.m.dao.ReviewMapper.myReview", vo);
	}

	@Override
	public void delReview(String userPhoneNum, String cpName, int reviewNum) throws Exception {
		try {
			//파일삭제
			ReviewVO delVo = selectOneRev(reviewNum);
			FtpClient ftp = new FtpClient();
			ftp.deleteFile(saveFolder, delVo.getImg1().split("/")[delVo.getImg1().split("/").length-1]);
			ftp.deleteFile(saveFolder, delVo.getImg2().split("/")[delVo.getImg2().split("/").length-1]);
			ftp.deleteFile(saveFolder, delVo.getImg3().split("/")[delVo.getImg3().split("/").length-1]);
			ftp.deleteFile(saveFolder, delVo.getImg4().split("/")[delVo.getImg4().split("/").length-1]);
			System.out.println("전체 이미지파일 삭제 완료");
		}catch(NullPointerException e) {
			e.printStackTrace();
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//DB삭제
			ReviewVO vo = new ReviewVO();
			vo.setCP_name(cpName);
			vo.setUserPhoneNum(userPhoneNum);
			vo.setReview_num(reviewNum);
			rev.selectList("com.baobab.m.dao.ReviewMapper.delReview", vo);
			reviewCount(vo);
			gradeCalcu(vo);
			System.out.println("DB데이터 삭제 완료");
		}
	}

	@Override
	public ReviewVO selectOneRev(int review_num) {
		return rev.selectOne("com.baobab.m.dao.ReviewMapper.selectOneRev", review_num);
	}

	@Override
	public void reviewCount(ReviewVO vo) {
		rev.update("com.baobab.m.dao.ReviewMapper.reviewCount", vo);
	}

	@Override
	public void gradeCalcu(ReviewVO vo) {
		rev.update("com.baobab.m.dao.ReviewMapper.gradeCalcu", vo);
	}

	@Override
	public void nonReviewCount(ReviewVO vo) {
		rev.update("com.baobab.m.dao.ReviewMapper.nonReviewCount", vo);
	}
 
	@Override
	public void nonGradeCalcu(ReviewVO vo) {
		rev.update("com.baobab.m.dao.ReviewMapper.nonGradeCalcu", vo);
	}

	@Override
	public List<ReviewVO> allImages(String cpName, int cpSeq) {
		ReviewVO vo = new ReviewVO();
		vo.setCP_name(cpName);
		vo.setCp_seq(cpSeq);
		return rev.selectList("com.baobab.m.dao.ReviewMapper.allImages", vo);
	}

	@Override
	public NonPCroomVO enterSelect(String cpName, int cpSeq) {
		ReviewVO vo = new ReviewVO();
		vo.setCP_name(cpName);
		vo.setCp_seq(cpSeq);
		return rev.selectOne("com.baobab.m.dao.ReviewMapper.enterSelect", vo);
	}

	@Override
	public List<ReviewVO> reviewAll() {
		
		return rev.selectList("com.baobab.m.dao.ReviewMapper.reviewAll");
	}
}

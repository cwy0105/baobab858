package com.baobab.m.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baobab.m.vo.RTRVO;
import com.baobab.m.vo.UserAllVO;

public interface RealTimeReviewDAO {

	int reviewNickName(UserAllVO vo);
	String reviewProfile(MultipartHttpServletRequest request)throws IOException;
	List<UserAllVO> checkNickName(String nickName);
	UserAllVO userProfile(HttpServletRequest request);
	RTRVO rtr(int cpSeq);
	int profileDelete(HttpServletRequest request) throws Exception;
	void updateNickname(UserAllVO vo);
}

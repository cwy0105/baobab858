package com.baobab.admin.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.baobab.m.vo.NoticeVO;
import com.baobab.m.vo.UserLocationVO;

public interface AdminNoticeDAO {
	int insertNotice(HttpServletRequest request, HttpSession session) throws IOException;
	List<NoticeVO> adminSelect(HttpServletRequest request);
	List<NoticeVO> userSelect(String readDiv);
	NoticeVO noticeDetail(HttpServletRequest request);
	int dubNotice(String title);
	List<UserLocationVO> noticePush(String divCode);
	NoticeVO pushClick(String title);
}

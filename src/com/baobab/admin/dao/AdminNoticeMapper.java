package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.NoticeVO;
import com.baobab.m.vo.UserLocationVO;

@Mapper
public interface AdminNoticeMapper {
	void insertNotice(NoticeVO vo);
	List<NoticeVO> adminSelect(NoticeVO vo);
	List<NoticeVO> userSelect(String readDiv);
	NoticeVO noticeDetail(int seqNum);
	List<NoticeVO> dubNotice(String title);
	List<UserLocationVO> noticePush(String divCode);
}

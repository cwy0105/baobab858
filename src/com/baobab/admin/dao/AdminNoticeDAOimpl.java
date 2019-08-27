package com.baobab.admin.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.service.SendNoticeFCM;
import com.baobab.m.vo.NoticeVO;
import com.baobab.m.vo.UserLocationVO;

@Repository
public class AdminNoticeDAOimpl implements AdminNoticeDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate noti;

	@Override
	public int insertNotice(HttpServletRequest request, HttpSession session) throws IOException {
		int result = dubNotice(request.getParameter("noti_title"));
		if(result == 0) {
			NoticeVO vo = new NoticeVO();
			vo.setWriter(session.getAttribute("id").toString());
			vo.setTitle("[공지사항] " + request.getParameter("noti_title").trim());
			vo.setContent(request.getParameter("noti_content").trim());
			vo.setRead_div(request.getParameter("read_div"));
			noti.insert("com.baobab.admin.dao.AdminNoticeMapper.insertNotice", vo);
			SendNoticeFCM fcm = new SendNoticeFCM();
			int fcmresult = fcm.send("[공지사항] " + request.getParameter("noti_title"), makeText(request.getParameter("noti_content"), 50), 
					noticePush(request.getParameter("read_div")));
			System.out.println(fcmresult + "명에게 공지사항 푸시 전송 완료");
			return result;
		}else {
			return result;
		}
	}

	@Override
	public List<NoticeVO> adminSelect(HttpServletRequest request) {
		NoticeVO vo = new NoticeVO();
		vo.setWriter("%" + request.getParameter("searchWord") + "%");
		vo.setTitle("%" + request.getParameter("searchWord") + "%");
		vo.setRead_div(makeDiv(request.getParameter("read_div")));
		return noti.selectList("com.baobab.admin.dao.AdminNoticeMapper.adminSelect", vo);
	}

	@Override
	public List<NoticeVO> userSelect(String readDiv) {
		System.out.println(readDiv);
		return noti.selectList("com.baobab.admin.dao.AdminNoticeMapper.userSelect", readDiv.substring(0, 1).toUpperCase());
	}

	@Override
	public NoticeVO noticeDetail(HttpServletRequest request) {
		return noti.selectOne("com.baobab.admin.dao.AdminNoticeMapper.noticeDetail", Integer.parseInt(request.getParameter("seqNum")));
	}

	@Override
	public int dubNotice(String title) {
		return noti.selectList("com.baobab.admin.dao.AdminNoticeMapper.dubNotice", title).size();
	}
	
	@Override
	public List<UserLocationVO> noticePush(String divCode) {
		String result = "";
		if(divCode.equals("all")) {
			result += "%%";
		}else {
			result += "%" + divCode.toLowerCase() + "%";
		}
		return noti.selectList("com.baobab.admin.dao.AdminNoticeMapper.noticePush", result);
	}
	
	@Override
	public NoticeVO pushClick(String title) {
		return noti.selectOne("com.baobab.admin.dao.AdminNoticeMapper.dubNotice", title);
	}
	
	public String makeText(String str, int cut) {
		if(str.length() > cut) {
			return str.substring(0, cut);
		}else {
			return str;
		}
	}
	
	public String makeDiv(String div) {
		if(div.equals("")) {
			return "%%";
		}else {
			return div;
		}
	}
}

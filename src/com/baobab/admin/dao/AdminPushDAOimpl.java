package com.baobab.admin.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.baobab.m.service.SendFCM;
import com.baobab.m.vo.AdminPushVO;
import com.baobab.m.vo.UserLocationVO;

@Repository
public class AdminPushDAOimpl implements AdminPushDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate push;
	@Autowired
	AdminNoticeDAO noti;

	@Override
	public int pushHistory(HttpServletRequest request, HttpSession session) throws IOException {
		AdminPushVO vo = new AdminPushVO();
		List<UserLocationVO> sendList = makeList(request.getParameter("read_div"));
		sendListTest(sendList);
		System.out.println("���� �� : " + session.getAttribute("id").toString());
		vo.setWriter(session.getAttribute("id").toString());
		vo.setTitle(request.getParameter("title").trim());
		vo.setMessage(request.getParameter("message").trim());
		vo.setPush_div(makeDiv(request.getParameter("push_div")));
		push.insert("com.baobab.admin.dao.AdminPushMapper.pushHistory", vo);
		SendFCM fcm = new SendFCM();
		return fcm.send(request, sendList);
	}
	
	public void sendListTest(List<UserLocationVO> list) {
		if(list.size() > 0) {
			System.out.println(list.toString());
			for(int i=0;i<list.size();i++) {
				System.out.println("����Ʈ �׽�Ʈ : " + list.get(i).getPush_token());
			}
		}else {
			System.out.println("������ 0");
		}
	}

	@Override
	public List<UserLocationVO> getAllPushList() {
		return push.selectList("com.baobab.admin.dao.AdminPushMapper.getAllPushList");
	}
	
	public String makeDiv(String div) {
		if(div.length() > 1) {
			return div.substring(0, div.length()-1);
		}else {
			return div;
		}
	}
	
	public List<UserLocationVO> makeList(String div) {
		if(div.equals("ȸ����ü")) {
			return noti.noticePush("%%");
		}else if(div.equals("�����")) {
			return noti.noticePush("%c%");
		}else if(div.equals("�Ϲ�ȸ��")) {
			return noti.noticePush("%u%");
		}else if(div.equals("������")) {
			return noti.noticePush("%a%");
		}else {
			return getAllPushList();
		}
	}

	@Override
	public List<AdminPushVO> adminSelect(HttpServletRequest request) {
		AdminPushVO vo = new AdminPushVO();
		vo.setPush_div(makePushDiv(request.getParameter("push_div")));
		vo.setTitle("%" + request.getParameter("searchWord") + "%");
		vo.setWriter("%" + request.getParameter("searchWord") + "%");
		return push.selectList("com.baobab.admin.dao.AdminPushMapper.adminSelect", vo);
	}
	
	public String makePushDiv(String div) {
		if(div.equals("��Ÿ")) {
			return "";
		}else if(div.equals("��ü")){
			return "%%";
		}else {
			return "%" + div + "%";
		}
	}

}

package com.baobab.m.dao;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baobab.m.service.FtpClient;
import com.baobab.m.vo.RTRVO;
import com.baobab.m.vo.UserAllVO;

@Repository
public class RealTimeReviewDAOimpl implements RealTimeReviewDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate real;
	
	private static String IMG_FOLDER = "/profileImg/";

	@Override
	public int reviewNickName(UserAllVO vo) {
		updateNickname(vo);
		return real.update("com.baobab.m.dao.RealTimeReviewMapper.reviewNickName", vo);
		
	}

	@Override
	public String reviewProfile(MultipartHttpServletRequest request) {
		try {
			List<UserAllVO> uvo = checkNickName(request.getParameter("nickName")); 
			if(uvo.size() > 0 && !uvo.get(0).getEmail().equals(request.getParameter("email"))) {
				return "dub";
			}else {
				if(request.getFile("profileImg") == null) {
					UserAllVO vo = new UserAllVO();
					vo.setEmail(request.getParameter("email"));
					vo.setNickName(request.getParameter("nickName"));
					reviewNickName(vo);
					return "noImg";
				}else {
					FtpClient ftp = new FtpClient();
					String url = ftp.ftp(ftp.convert(request.getFile("profileImg")), request.getParameter("email")+".png", IMG_FOLDER);
					UserAllVO vo = new UserAllVO();
					
					vo.setEmail(request.getParameter("email"));
					vo.setNickName(request.getParameter("nickName"));
					vo.setProfileImg(url);
					reviewNickName(vo);
					real.update("com.baobab.m.dao.RealTimeReviewMapper.reviewProfile", vo);
					return url;
				
				}
			}
		}catch(Exception e){
			return "dup";
		}
	}

	@Override
	public List<UserAllVO> checkNickName(String nickName) {
		return real.selectList("com.baobab.m.dao.RealTimeReviewMapper.checkNickName", nickName);
	}

	@Override
	public UserAllVO userProfile(HttpServletRequest request) {
		return real.selectOne("com.baobab.m.dao.RealTimeReviewMapper.userProfile", request.getParameter("email"));
	}

	@Override
	public RTRVO rtr(int cpSeq) {
		RTRVO vo = new RTRVO();
		vo.setInfo(real.selectOne("com.baobab.m.dao.RealTimeReviewMapper.getCp", cpSeq));
		vo.setImgvo(real.selectList("com.baobab.m.dao.RealTimeReviewMapper.getImg", cpSeq));
		return vo;
	}

	@Override
	public int profileDelete(HttpServletRequest request) throws Exception {
		FtpClient ftp = new FtpClient();
		String url = request.getParameter("url");
	
		return real.update("com.baobab.m.dao.RealTimeReviewMapper.profileDelete", request.getParameter("email")) +
				ftp.deleteFile(IMG_FOLDER, url.split("/")[url.split("/").length - 1]);
	}

	@Override
	public void updateNickname(UserAllVO vo) {
		real.update("com.baobab.m.dao.RealTimeReviewMapper.updateNickname", vo);
		
	}

}

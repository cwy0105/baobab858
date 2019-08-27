package com.baobab.m.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.baobab.m.service.FtpClient;
import com.baobab.m.vo.CPmainImgVO;

@Repository
public class MainImgUploadDAOimpl implements MainImgUploadDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate imgLoad;
	
	private String saveFolder = "/baobabMainImg/";

	@Override
	public void mainImg(MultipartFile img, String cpName, int cpSeq, String position) throws Exception {
		CPmainImgVO vo = new CPmainImgVO();
		
		String imgUrl = imgUpload(img, cpName + "-main" + String.valueOf(cpSeq) + position);
		if(!imgUrl.equals("이미지없음")) {
			vo.setCp_name(cpName);
			vo.setImg_url(imgUpload(img, cpName + "-main" + String.valueOf(cpSeq) + position));
			vo.setCp_seq(cpSeq);
			imgLoad.update("com.baobab.m.dao.MainImgUploadMapper.mainImgUpload", vo);
		}
		
	}
	
	@Override
	public List<CPmainImgVO> getMainImg(int cpSeq) {
		return imgLoad.selectList("com.baobab.m.dao.MainImgUploadMapper.getMainImg", cpSeq);
	}
	
	@Override
	public String imgUpload(MultipartFile img, String cpName) throws Exception{
		FtpClient ftp = new FtpClient();
		if(img != null) {
			String saveName = cpName.replaceAll(".jpg", "")+".png";
			if(saveName.contains(" ")) {
				saveName.replace(" ", "+");
				String url = ftp.ftp(ftp.convert(img), saveName, saveFolder);
				return url;
			}else {
				String url = ftp.ftp(ftp.convert(img), saveName, saveFolder);
				return url;
			}
		}else {
			return "이미지없음";
		}
	}

	@Override
	public int mainImgDel(String url) throws Exception {
		FtpClient ftp = new FtpClient();
		ftp.deleteFile(saveFolder, url.split("/")[url.split("/").length - 1]);
		return imgLoad.delete("com.baobab.m.dao.MainImgUploadMapper.mainImgDel", url);
	}

	@Override
	public int urlUpdate(String url) {
		String fileName = url.replaceAll(".jpg", "").replaceAll(".png", "");
		fileName = fileName.split("/")[fileName.split("/").length - 1];
		CPmainImgVO vo = new CPmainImgVO();
		vo.setImg_url(url);
		vo.setCp_name("%" + fileName + "%");
		return imgLoad.update("com.baobab.m.dao.MainImgUploadMapper.urlUpdate", vo);
	}
}

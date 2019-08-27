package com.baobab.m.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.baobab.m.vo.CPmainImgVO;

public interface MainImgUploadDAO {
	public void mainImg (MultipartFile img1, String cpName, int cpSeq, String position)throws Exception;
	public List<CPmainImgVO> getMainImg(int cpSeq);
	public int mainImgDel(String url)throws Exception;
	public String imgUpload(MultipartFile img, String cpName) throws Exception;
	public int urlUpdate(String url);
}

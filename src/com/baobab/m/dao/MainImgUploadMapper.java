package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPmainImgVO;

@Mapper
public interface MainImgUploadMapper {
	public void mainImgUpload(CPmainImgVO vo);
	public List<CPmainImgVO> getMainImg(int cpSeq);
	public void mainImgDel(String url);
	public int urlUpdate(CPmainImgVO vo);
}

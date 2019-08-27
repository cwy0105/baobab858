package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.SetMenuInfoVO;
import com.baobab.m.vo.SetMenuVO;

@Mapper
public interface SetMenuUploadMapper {
	void setMenuSave(SetMenuVO smvo);
	void setMenuInfoSave(SetMenuInfoVO smivo);
	String dubConfirm(SetMenuVO smvo);
	List<SetMenuVO> showMetheSetMenu(int cpSeq);
	void delSetMenu(SetMenuVO smvo);
	void delSetMenuInfo(SetMenuInfoVO smivo);
}

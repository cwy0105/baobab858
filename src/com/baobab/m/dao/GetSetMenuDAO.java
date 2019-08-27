package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.SetMenuInfoVO;
import com.baobab.m.vo.SetMenuVO;

public interface GetSetMenuDAO {
	List<SetMenuVO> getSetMenu(int cpSeq);
	List<SetMenuInfoVO> getSetMenuInfo(int cpSeq);
	SetMenuVO getOneSetMenu(String cpName, String menuName, int cpSeq);
	int menuConfirm(String cpName, int cpSeq, String menuName);
	int setMenuUrlUpdate(String menuUrl, String menuName, int cpSeq);
}

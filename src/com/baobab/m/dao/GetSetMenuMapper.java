package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.SetMenuInfoVO;
import com.baobab.m.vo.SetMenuVO;

@Mapper
public interface GetSetMenuMapper {
	List<SetMenuVO> getSetMenu(int cpSeq);
	List<SetMenuInfoVO> getSetMenuInfo(int cpSeq);
	SetMenuVO getOneSetMenu(SetMenuVO vo);
	int menuConfirm(SetMenuVO vo);
	int setMenuUrlUpdate(SetMenuVO vo);
}

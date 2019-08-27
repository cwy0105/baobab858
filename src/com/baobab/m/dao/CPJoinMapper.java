package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.BasketVO;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPUseVO;
import com.baobab.m.vo.CPUserVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.ReviewVO;
import com.baobab.m.vo.SetMenuInfoVO;
import com.baobab.m.vo.SetMenuVO;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserHistoryVO;

@Mapper
public interface CPJoinMapper {
	void cpUserAllJoin(UserAllVO vo);
	void userHistoryJoin(UserHistoryVO vo);
	void cpUserJoin(CPUserVO vo);
	void cpJoin(CPInfoVO vo);
	void cpHistoryJoin(String cpName);
	void cpUpdate(CPInfoVO vo);
	void divCodeChange(String email);
	String dupName(String cpName);
	void cpUserUpdate(CPUserVO vo);
	List<MenuVO> getMenu(MenuVO vo);
	void updateMenu(MenuVO vo);
	void setInfoUpdate(SetMenuInfoVO vo);
	List<SetMenuVO> getSetMenu(SetMenuVO vo);
	void updateSetMenu(SetMenuVO vo);
	List<ReviewVO> getReview(ReviewVO vo);
	void updateReview(ReviewVO vo);
	CPInfoVO getCpInfo(CPInfoVO vo);
	void updateBasket(BasketVO vo);
	void updatePayment(PaymentVO vo);
	void updatePoke(PokeVO vo);
	CPUserVO getCpUserInfo(String email);
	CPUseVO cpUserInfo(String email);
	void changeCpUser(CPUserVO vo);
}

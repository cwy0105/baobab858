package com.baobab.m.dao;

import java.util.List;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPUserVO;
import com.baobab.m.vo.CpPushVO;
import com.baobab.m.vo.PushPaymentVO;
import com.baobab.m.vo.UserLocationVO;

@Mapper
public interface PushMapper {
	List<UserLocationVO> pushToAll();
	List<UserLocationVO> pushToFan(int cpSeq);
	List<UserLocationVO> pushToNormal(CpPushVO vo);
	void savePush(CpPushVO vo);
	List<UserLocationVO> sendToFan(CpPushVO vo);
	List<UserLocationVO> sendToNormal(CpPushVO vo);
	UserLocationVO findUser(String pushToken);
	CPInfoVO findCp(CpPushVO vo);
	void minusVoucher(CPUserVO vo);
	void pushPaymentMenu(PushPaymentVO vo); 
	List<PushPaymentVO> pushPaymentSelect(PushPaymentVO vo);
	void pushTidUpdate(PushPaymentVO vo);
	void pushPayCancel(PushPaymentVO vo);
	void pushEaPlma(CPUserVO vo);
}

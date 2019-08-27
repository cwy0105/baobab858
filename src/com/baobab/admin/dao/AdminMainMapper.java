package com.baobab.admin.dao;

import java.util.List;

import com.baobab.m.dao.Mapper;
import com.baobab.m.vo.AdminLoginHistoryVO;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CpPushVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.SetMenuVO;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.VisitantHistoryVO;

@Mapper
public interface AdminMainMapper {
	List<UserAllVO> userAll();
	List<CPInfoVO> cpAll();
	List<MenuVO> menuAll();
	List<SetMenuVO> setMenuAll();
	List<VisitantHistoryVO> visitantAll();
	List<PaymentVO> paymentAll();
	List<CpPushVO> pushAll();
	List<AdminLoginHistoryVO> loginHistory(String email);
}

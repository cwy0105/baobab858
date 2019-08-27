package com.baobab.m.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baobab.m.vo.CouponHistoryVO;
import com.baobab.m.vo.CpStaffVO;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserLocationVO;


public interface CpStaffDAO {
	List<UserAllVO> staffSearch(HttpServletRequest request);
	List<CpStaffVO> getStaffs(HttpServletRequest request);
	int updateStaff(HttpServletRequest request);
	int staffInfoInsert(HttpServletRequest request);
	int staffHistoryJoin(HttpServletRequest request);
	int userChangeToStaff(String email, String divCode);
	//½ºÄµÀü
	int scanCoupon(HttpServletRequest request);
	List<CouponHistoryVO> scanCouponHistory(HttpServletRequest request);
	//½ºÄµÈÄ
	void couHistoryStatusChange(HttpServletRequest request);
	void cpCouponScan(HttpServletRequest request);
	void userCouponScan(HttpServletRequest request);
	int staffCancelHistory(HttpServletRequest request);
	int staffCancel(HttpServletRequest request);
	List<CouponHistoryVO> usedCoupon(HttpServletRequest request);
	List<UserLocationVO> scanCouponPush(int cpSeq);

}

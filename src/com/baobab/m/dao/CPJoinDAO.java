package com.baobab.m.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPUseVO;
import com.baobab.m.vo.CPUserVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.ReviewVO;
import com.baobab.m.vo.SetMenuVO;

public interface CPJoinDAO {
	void cpUserAllJoin(String email, String password, String phonNum, String divCode, String pushCheck);
	void UserHistoryJoin(String email, String divCode);
	void cpUserJoin(String email, String cpName, String license, String cpLicenseNum, MultipartFile bankbook, String bank, String accountHolder, 
			String accountNumber) throws FileNotFoundException, NullPointerException, IOException;
	void cpJoin(String cpName, String cpPhon, String cpZipcode, String cpAddress, String cpAddrDetails, String cpKind, 
			String cpType, String cpTheme1, String cpTheme2, String parking, String closeDay, String businessStart, String businessEnd, 
			String cpIntro, String cpDiv, String closeEct, String email, String phone, String name);
	void cpHistoryJoin(String cpName);
	void cpUpdate(HttpServletRequest request);
	void divCodeChange(String email);
	String dupName(String cpName);
	void cpUserUpdate(String email, String cpName);
	List<MenuVO> getMenu(int cpSeq);
	void updateMenu(String cpName, String menuImg, String menuName, int cpSeq);
	void setInfoUpdate(String cpName, int cpSeq);
	List<SetMenuVO> getSetMenu(int cpSeq);
	void updateSetMenu(String cpName, String menuImg, String menuName, int cpSeq);
	List<ReviewVO> getReview(int cpSeq);
	void updateReview(String cpName, String img1, String img2, String img3, String img4, int cpSeq);
	CPInfoVO getCpInfo(int cpSeq);
	void updateBasket(String cpName, int cpSeq);
	void updatePayment(String cpName, int cpSeq);
	void updatePoke(String cpName, int cpSeq);
	CPUserVO getCpUserInfo(String email);
	CPUseVO cpUserInfo(String email);	
	int changeCpUser(String email, String licenseNum, String accHolder, String bank, String accNum, 
			MultipartFile license, MultipartFile bankbook)throws Exception;
	
	
}

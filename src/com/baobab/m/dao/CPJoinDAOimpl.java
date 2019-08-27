package com.baobab.m.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.baobab.m.service.FtpClient;
import com.baobab.m.service.LicenseUpload;
import com.baobab.m.service.NaverGeoCoding;
import com.baobab.m.vo.BasketVO;
import com.baobab.m.vo.CPHistoryVO;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPUseVO;
import com.baobab.m.vo.CPUserVO;
import com.baobab.m.vo.CPmainImgVO;
import com.baobab.m.vo.CallHistoryVO;
import com.baobab.m.vo.CpStaffVO;
import com.baobab.m.vo.LocalCPInfoVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.NaverGeocodingVO;
import com.baobab.m.vo.NonCpImgVO;
import com.baobab.m.vo.NonCpMenuVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.ReviewVO;
import com.baobab.m.vo.SetMenuInfoVO;
import com.baobab.m.vo.SetMenuVO;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserHistoryVO;

@Repository
public class CPJoinDAOimpl implements CPJoinDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate join;
	private String saveFolder = "/bankbooks/";
	@Autowired
	private NonDataMoveDAO nonData;
	@Autowired
	private LicenseUpload licenseUpload;
	
	public String imgUpload(MultipartFile img, String email) throws FileNotFoundException, IOException, NullPointerException{
		try {
			FtpClient ftp = new FtpClient();
			if(img == null) {
				return "이미지없음";
			}else {
				String saveName = email+".png";
				if(saveName.contains(" ")) {
					return ftp.ftp(ftp.convert(img), saveName.replace(" ", "+"), saveFolder);
				}else {
					return ftp.ftp(ftp.convert(img), saveName, saveFolder);
				}
			}
		}catch(NullPointerException e) {
			e.printStackTrace();
			return "이미지없음";
		}
	
	}

	@Override
	public void cpUserAllJoin(String email, String password, String phonNum, String divCode, String pushCheck) {		
		UserAllVO vo = new UserAllVO();
		vo.setEmail(email);
		vo.setUser_password(password);
		vo.setPhon_num(phonNum);
		vo.setDiv_code(divCode);
		vo.setPush_agree(pushCheck);
		System.out.println(vo.toString());
		join.update("com.baobab.m.dao.CPJoinMapper.cpUserAllJoin", vo);
	}

	@Override
	public void UserHistoryJoin(String email, String divCode) {
		UserHistoryVO vo = new UserHistoryVO();
		vo.setEmail(email);
		vo.setDiv_code(divCode);
		System.out.println(vo.toString());
		join.update("com.baobab.m.dao.CPJoinMapper.userHistoryJoin", vo);
	}

	@Override
	public void cpUserJoin(String email, String cpName, String license, String cpLicenseNum, MultipartFile bankbook, String bank, String accountHolder, 
			String accountNumber) throws FileNotFoundException, NullPointerException, IOException {		
		CPUserVO vo = new CPUserVO();
		vo.setEmail(email);
		vo.setCpName(cpName);
		vo.setLicense(license);
		vo.setCpLicenseNum(cpLicenseNum);
		vo.setCpBankBookImg(imgUpload(bankbook, email));
		vo.setBank(bank);
		vo.setAccount_holder(accountHolder);
		vo.setAccountNumber(accountNumber);
		System.out.println(vo.toString());
		join.update("com.baobab.m.dao.CPJoinMapper.cpUserJoin", vo);
	}

	@Override
	public void cpJoin(String cpName, String cpPhon, String cpZipcode, String cpAddress, String cpAddrDetails, String cpKind, String cpType, 
			String cpTheme1, String cpTheme2, String parking, String closeDay, String businessStart, String businessEnd, String cpIntro, String cpDiv, 
			String closeEct, String email, String phone, String name) {
		CPInfoVO vo = new CPInfoVO();
		NaverGeocodingVO ngvo = new NaverGeoCoding().trans(cpAddress + " " + cpAddrDetails);
		String x = "";
		String y = "";
		try {
			x = ngvo.getAddresses().get(0).getX();
			y = ngvo.getAddresses().get(0).getY();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("지오코딩 적용 안됨 주소 재확인 필요");
			x = "0";
			y = "0";
		}finally {
			System.out.println("1번 : " + x);
			System.out.println("2번 : " + y);
			vo.setCP_name(cpName);
			vo.setCP_phon(cpPhon);
			vo.setCP_zipcode(cpZipcode);
			vo.setCP_address(cpAddress);
			vo.setCP_addr_details(cpAddrDetails);
			vo.setCP_kind(cpKind);
			vo.setCP_type(cpType);
			vo.setCP_Theme1(cpTheme1);
			vo.setCP_Theme2(cpTheme2);
			vo.setParking(parking);
			vo.setClose_day(makeCloseDay2(makeCloseDay(closeDay)));
			vo.setClose_ect(closeEct);
			vo.setBusiness_start(businessStart);
			vo.setBusiness_end(businessEnd);
			vo.setCP_intro(cpIntro);
			vo.setCp_div(cpDiv);
			vo.setLongitude(Double.parseDouble(x));
			vo.setLatitude(Double.parseDouble(y));
			vo.setOwner_email(email);
			int result = join.update("com.baobab.m.dao.CPJoinMapper.cpJoin", vo);
			if(result > 0) {
				nonDataMerge(vo);
				
				CpStaffVO cvo = new CpStaffVO();
				cvo.setEmail(email);
				cvo.setStaffPhone(phone);
				cvo.setStaffName(name);
				cvo.setCpSeq(nonData.selectSeq(vo));
				cvo.setDivCode("c-01-01");
				join.insert("com.baobab.m.dao.CpStaffMapper.staffInfoInsert", cvo);
			}
		}
	}

	@Override
	public void cpHistoryJoin(String cpName) {
		CPHistoryVO vo = new CPHistoryVO();
		vo.setCpName(cpName);
		System.out.println(vo.toString());
		join.update("com.baobab.m.dao.CPJoinMapper.cpHistoryJoin", vo);
	}

	@Override
	public void cpUpdate(HttpServletRequest request) {
		CPInfoVO vo = new CPInfoVO();
		FtpClient ftp = new FtpClient();
		NaverGeocodingVO ngvo = new NaverGeoCoding().trans(request.getParameter("addr") + " " + request.getParameter("addrDetail"));
		vo.setCP_name(request.getParameter("cpName"));
		vo.setCP_phon(request.getParameter("cpPhone"));
		vo.setCP_zipcode(request.getParameter("zipcode"));
		vo.setCP_address(request.getParameter("addr"));
		vo.setCP_addr_details(request.getParameter("addrDetail"));
		vo.setBusiness_start(request.getParameter("busyStart"));
		vo.setBusiness_end(request.getParameter("busyEnd"));
		vo.setParking(request.getParameter("parking"));
		vo.setCP_intro(request.getParameter("intro"));
		vo.setClose_day(makeCloseDay2(makeCloseDay(request.getParameter("closeDay"))));
		vo.setClose_ect(request.getParameter("close_ect"));
		vo.setCP_Theme1(request.getParameter("theme1"));
		vo.setCP_Theme2(request.getParameter("theme2"));
		vo.setCP_kind(request.getParameter("kind"));
		vo.setCP_type(request.getParameter("type"));
		vo.setSeq_num(Integer.parseInt(request.getParameter("num")));
		vo.setLongitude(Double.parseDouble(ngvo.getAddresses().get(0).getX()));
		vo.setLatitude(Double.parseDouble(ngvo.getAddresses().get(0).getY()));
		join.update("com.baobab.m.dao.CPJoinMapper.cpUpdate", vo);
		cpUserUpdate(request.getParameter("email"), request.getParameter("cpName"));
		List<MenuVO> menus = getMenu(Integer.parseInt(request.getParameter("num")));
		if(menus.size() != 0) {
			String beforeName = menus.get(0).getCp_name();
			for(int i=0;i<menus.size();i++) {
				if(menus.get(i).getMenu_img().startsWith("http")) {
					updateMenu(request.getParameter("cpName"), ftp.renameFile("/baobabMenus/", beforeName + "-" + menus.get(i).getMenu_name()
							+ ".png", request.getParameter("cpName") + "-" + menus.get(i).getMenu_name() + ".png"), menus.get(i).getMenu_name(), 
							Integer.parseInt(request.getParameter("num")));
				}
			}
		}
		setInfoUpdate(request.getParameter("cpName"), Integer.parseInt(request.getParameter("num")));
		List<SetMenuVO> setMenus = getSetMenu(Integer.parseInt(request.getParameter("num")));
		if(setMenus.size() != 0) {
			String beforeName = setMenus.get(0).getCp_name();
			for(int i=0;i<setMenus.size();i++) {
				if(setMenus.get(i).getMenu_img().startsWith("http")) {
					updateSetMenu(request.getParameter("cpName"), ftp.renameFile("/baobabSetMenus/", beforeName + "-" + 
							setMenus.get(i).getMenu_name() + ".png", request.getParameter("cpName") + "-" + setMenus.get(i).getMenu_name() + ".png"), 
							setMenus.get(i).getMenu_name(), Integer.parseInt(request.getParameter("num")));
				}
			}
		}
		List<ReviewVO> reviews = getReview(Integer.parseInt(request.getParameter("num")));
		if(reviews.size() != 0) {
			String beforeName = reviews.get(0).getCP_name();
			for(int i=0;i<reviews.size();i++) {
				updateReview(request.getParameter("cpName"), renameRevImg(request.getParameter("cpName"), beforeName, reviews.get(i).getImg1()), 
						renameRevImg(request.getParameter("cpName"), beforeName, reviews.get(i).getImg2()), renameRevImg(request.getParameter("cpName"), 
								beforeName, reviews.get(i).getImg3()), renameRevImg(request.getParameter("cpName"), beforeName, reviews.get(i).getImg4()), 
						Integer.parseInt(request.getParameter("num")));
			}
		}
		cpHistoryJoin(request.getParameter("cpName"));
		updateBasket(request.getParameter("cpName"), Integer.parseInt(request.getParameter("num")));
		updatePayment(request.getParameter("cpName"), Integer.parseInt(request.getParameter("num")));
		updatePoke(request.getParameter("cpName"), Integer.parseInt(request.getParameter("num")));
	}
	
	public String minute(String endM) {
		if(endM.equals("0")) {
			return "00";
		}else {
			return endM;
		}
	}

	@Override
	public void divCodeChange(String email) {
		join.update("com.baobab.m.dao.CPJoinMapper.divCodeChange", email);
	}

	@Override
	public String dupName(String cpName) {
		List<String> result = join.selectList("com.baobab.m.dao.CPJoinMapper.dupName", cpName);
		if(result.size() == 0) {
			return "ok";
		}else {
			return "dup";
		}
	}

	@Override
	public void cpUserUpdate(String email, String cpName) {
		CPUserVO vo = new CPUserVO();
		vo.setEmail(email);
		vo.setCpName(cpName);
		join.update("com.baobab.m.dao.CPJoinMapper.cpUserUpdate", vo);
	}

	@Override
	public List<MenuVO> getMenu(int cpSeq) {
		MenuVO vo = new MenuVO();
		vo.setCp_seq(cpSeq);
		return join.selectList("com.baobab.m.dao.CPJoinMapper.getMenu", vo);
	}

	@Override
	public void updateMenu(String cpName, String menuImg, String menuName, int cpSeq) {
		MenuVO vo = new MenuVO();
		vo.setCp_name(cpName);
		vo.setMenu_img(menuImg);
		vo.setMenu_name(menuName);
		vo.setCp_seq(cpSeq);
		join.update("com.baobab.m.dao.CPJoinMapper.updateMenu", vo);
	}

	@Override
	public void setInfoUpdate(String cpName, int cpSeq) {
		SetMenuInfoVO vo = new SetMenuInfoVO();
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
		join.update("com.baobab.m.dao.CPJoinMapper.setInfoUpdate", vo);
	}

	@Override
	public List<SetMenuVO> getSetMenu(int cpSeq) {
		SetMenuVO vo = new SetMenuVO();
		vo.setCp_seq(cpSeq);
		return join.selectList("com.baobab.m.dao.CPJoinMapper.getSetMenu", vo);
	}

	@Override
	public void updateSetMenu(String cpName, String menuImg, String menuName, int cpSeq) {
		SetMenuVO vo = new SetMenuVO();
		vo.setCp_name(cpName);
		vo.setMenu_img(menuImg);
		vo.setMenu_name(menuName);
		vo.setCp_seq(cpSeq);
		join.update("com.baobab.m.dao.CPJoinMapper.updateSetMenu", vo);		
	}

	@Override
	public List<ReviewVO> getReview(int cpSeq) {
		ReviewVO vo = new ReviewVO();
		vo.setCp_seq(cpSeq);
		return join.selectList("com.baobab.m.dao.CPJoinMapper.getReview", vo);
	}
	
	public String renameRevImg(String cpName, String beforeName, String imgUrl) {
		if(imgUrl.startsWith("http")) {
			String imgName = imgUrl.split("/")[imgUrl.split("/").length - 1];
			String newName = cpName + imgName.substring(beforeName.length());
			FtpClient ftp = new FtpClient();
			return ftp.renameFile("/ourReviews/", imgName, newName);
		}else {
			return "이미지없음";
		}
	}

	@Override
	public void updateReview(String cpName, String img1, String img2, String img3, String img4, int cpSeq) {
		ReviewVO vo = new ReviewVO();
		vo.setCP_name(cpName);
		vo.setImg1(img1);
		vo.setImg2(img2);
		vo.setImg3(img3);
		vo.setImg4(img4);
		vo.setCp_seq(cpSeq);
		join.update("com.baobab.m.dao.CPJoinMapper.updateReview", vo);	
	}

	@Override
	public CPInfoVO getCpInfo(int cpSeq) {
		CPInfoVO vo = new CPInfoVO();
		vo.setSeq_num(cpSeq);
		return join.selectOne("com.baobab.m.dao.CPJoinMapper.getCpInfo", vo);
	}

	@Override
	public void updateBasket(String cpName, int cpSeq) {
		BasketVO vo = new BasketVO();
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
		join.update("com.baobab.m.dao.CPJoinMapper.updateBasket", vo);
	}

	@Override
	public void updatePayment(String cpName, int cpSeq) {
		PaymentVO vo = new PaymentVO();
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
		join.update("com.baobab.m.dao.CPJoinMapper.updatePayment", vo);
	}

	@Override
	public void updatePoke(String cpName, int cpSeq) {
		PokeVO vo = new PokeVO();
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
		join.update("com.baobab.m.dao.CPJoinMapper.updatePoke", vo);
	}
	
	public void nonDataMerge(CPInfoVO vo) {
		List<LocalCPInfoVO> nonList = nonData.nonSelect(vo);
		if(nonList.size() > 0) {
			int revNum = 0;
			int revGrade = 0;
			int hits = 0;
			int[] seqArr = new int[nonList.size()];
			System.out.println("정리될 데이터가 " + nonList.size() + "개 있습니다.");
			for(int i=0;i<nonList.size();i++) {
				seqArr[i] = nonList.get(i).getLoc_seq();
				nonData.nonDelete(vo);
				List<NonCpImgVO> nonImgList = nonData.selectImg(seqArr[i]);
				if(nonImgList.size() > 0) {
					CPmainImgVO imgVO = new CPmainImgVO();
					FtpClient ftp = new FtpClient();
					for(int j=0;j<nonImgList.size();j++) {
						imgVO.setCp_name(vo.getCP_name());
						imgVO.setImg_url(nonImgList.get(j).getImg_url().replace("/nonMain/", "/baobabMainImg/"));
						String imgName = nonImgList.get(j).getImg_url().split("/")[nonImgList.get(j).getImg_url().split("/").length -1];
						ftp.renameFile("", "/nonMain/" + imgName, "/baobabMainImg/" + imgName);
						imgVO.setCp_seq(nonData.selectSeq(vo));
						nonData.insertImg(imgVO);
						System.out.println(j + "번째 이미지 정리 완료");
					}
					nonData.deleteImg(seqArr[i]);
				}
				
				
				List<NonCpMenuVO> nonMenuList = nonData.selectMenu(seqArr[i]);
				if(nonMenuList.size() > 0) {
					MenuVO menuVO = new MenuVO();
					FtpClient ftp = new FtpClient();
					for(int j=0;j<nonMenuList.size();j++) {
						menuVO.setMenu_name(nonMenuList.get(j).getMenu_name());
						menuVO.setCp_name(vo.getCP_name());
						menuVO.setMenu_img(nonMenuList.get(j).getImg_url().replace("/nonMenu/", "/baobabMenus/"));
						String imgName = nonMenuList.get(j).getImg_url().split("/")[nonMenuList.get(j).getImg_url().split("/").length -1];
						ftp.renameFile("", "/nonMenu/" + imgName, "/baobabMenus/" + imgName);
						menuVO.setMenu_price(Integer.parseInt(nonMenuList.get(j).getPrice()));
						menuVO.setMenu_dis_price(Integer.parseInt(nonMenuList.get(j).getPrice()));
						menuVO.setMenu_option("보통");
						menuVO.setMenu_div("메인메뉴");
						menuVO.setCp_seq(nonData.selectSeq(vo));
						nonData.insertMenu(menuVO);
					}
					nonData.deleteMenu(seqArr[i]);
				}
				revNum = revNum + nonList.get(i).getRev_num();
				revGrade = revGrade + nonList.get(i).getRev_grade();
				hits = hits + nonList.get(i).getHits();
			}
			LocalCPInfoVO newVO = new LocalCPInfoVO();
			newVO.setRev_num(revNum);
			newVO.setRev_grade(revGrade);
			newVO.setHits(hits);
			newVO.setLoc_seq(nonData.selectSeq(vo));
			nonData.updateInfo(newVO);
			
			CallHistoryVO chVO = new CallHistoryVO();
			chVO.setCp_name(vo.getCP_name());
			chVO.setCp_phone(vo.getCP_phon());
			nonData.updateCall(chVO);
			
			for(int i=0;i<seqArr.length;i++) {
				PokeVO pkVO = new PokeVO();
				pkVO.setCp_seq(nonData.selectSeq(vo));
				pkVO.setSeq_num(seqArr[i]);
				pkVO.setScore(revGrade);
				pkVO.setRev_num(revNum);
				pkVO.setCp_name(vo.getCP_name());
				nonData.updatePoke(pkVO);
				
				ReviewVO revVO = new ReviewVO();
				revVO.setCP_name(vo.getCP_name());
				revVO.setCp_seq(nonData.selectSeq(vo));
				revVO.setSeq_num(seqArr[i]);
				nonData.updateReview(revVO);
			}
		}
	}
	
	public String makeCloseDay2(String str) {
		System.out.println("요일 결과 값 : " + str);
		if((str.equals("무"))) {
			return "~~~~~무";
		}else {
			return str;
		}
	}
	
	public String makeCloseDay(String str) {
		System.out.println("요일 결과 값 : " + str);
		if((str.lastIndexOf("~") + 1) == str.length()) {
			return str + "무";
		}else {
			return str;
		}
	}

	@Override
	public CPUserVO getCpUserInfo(String email) {
		return join.selectOne("com.baobab.m.dao.CPJoinMapper.getCpUserInfo", email);
	}
	
	@Override
	public CPUseVO cpUserInfo(String email) {
		return join.selectOne("com.baobab.m.dao.CPJoinMapper.cpUserInfo", email);
	}

	@Override
	public int changeCpUser(String email, String licenseNum, String accHolder, String bank, String accNum, MultipartFile bankbook, MultipartFile license) throws Exception {
		CPUserVO vo = new CPUserVO();
		vo.setEmail(email);
		vo.setLicense(licenseNum);
		vo.setCpBankBookImg(imgUpload(bankbook, email));
		vo.setLicense(licenseUpload.licenseSaveToServer(license, email));
		vo.setBank(bank);
		vo.setAccount_holder(accHolder);
		vo.setAccountNumber(accNum);

		return join.update("com.baobab.m.dao.CPJoinMapper.changeCpUser", vo);
		
	}

	
}

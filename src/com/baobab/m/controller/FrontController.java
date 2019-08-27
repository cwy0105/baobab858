package com.baobab.m.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.DecoderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baobab.admin.dao.AdminNoticeDAO;
import com.baobab.m.dao.BasketDAO;
import com.baobab.m.dao.CPJoinDAO;
import com.baobab.m.dao.CallHistoryDAO;
import com.baobab.m.dao.CouCpDAO;
import com.baobab.m.dao.CouPaymentDAO;
import com.baobab.m.dao.CouponHistoryDAO;
import com.baobab.m.dao.CouponListDAO;
import com.baobab.m.dao.CouponUserDAO;
import com.baobab.m.dao.CpStaffDAO;
import com.baobab.m.dao.CpStaffTestDAO;
import com.baobab.m.dao.DataMergeDAO;
import com.baobab.m.dao.EnterMenuDAO;
import com.baobab.m.dao.GetMyMenuDAO;
import com.baobab.m.dao.GetOurCPDAO;
import com.baobab.m.dao.GetSetMenuDAO;
import com.baobab.m.dao.LoginDAO;
import com.baobab.m.dao.MainImgUploadDAO;
import com.baobab.m.dao.MenuUploadDAO;
import com.baobab.m.dao.NonCPinfoDAO;
import com.baobab.m.dao.PaymentDAO;
import com.baobab.m.dao.PersonalInfoDAO;
import com.baobab.m.dao.PokeDAO;
import com.baobab.m.dao.PushDAO;
import com.baobab.m.dao.RealTimeReviewDAO;
import com.baobab.m.dao.ReviewDAO;
import com.baobab.m.dao.SetMenuUploadDAO;
import com.baobab.m.dao.StatisticsDAO;
import com.baobab.m.dao.StoreMenuDAO;
import com.baobab.m.dao.UserJoinDAO;
import com.baobab.m.dao.UserLocationDAO;
import com.baobab.m.dao.VersionDAO;
import com.baobab.m.service.AddrConversion;
import com.baobab.m.service.Certification;
import com.baobab.m.service.EnterSearchFillter;
import com.baobab.m.service.LicenseUpload;
import com.baobab.m.service.MenuImgModify;
import com.baobab.m.service.NaverGeoCoding;
import com.baobab.m.service.PayStatusService;
import com.baobab.m.service.SendFCM;
import com.baobab.m.service.SerchDataFillter;
import com.baobab.m.service.VersionCheck;
import com.baobab.m.service.VisitantClassify;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.PageSearchVO;
import com.baobab.m.vo.UserLocationVO;
import com.google.gson.Gson;

@Controller
public class FrontController {
	
	@Autowired
	CpStaffTestDAO staffTest;
	@Autowired
	SerchDataFillter sdService;
	@Autowired
	CPJoinDAO cpJdao;
	@Autowired
	LicenseUpload licUpload;
	@Autowired
	MenuUploadDAO menuUp;
	@Autowired
	MainImgUploadDAO mainUp;
	@Autowired
	LoginDAO login;
	@Autowired
	GetMyMenuDAO getMenu;
	@Autowired
	SetMenuUploadDAO setMenuUp;
	@Autowired
	GetOurCPDAO getOurs;
	@Autowired
	StoreMenuDAO storeMenu;
	@Autowired
	GetSetMenuDAO setMenu;
	@Autowired
	ReviewDAO rev;
	@Autowired
	CallHistoryDAO call;
	@Autowired
	PokeDAO poke;
	@Autowired
	NaverGeoCoding trans;
	@Autowired
	DataMergeDAO merge;
	@Autowired
	VisitantClassify visit;
	@Autowired
	VersionCheck ver;
	@Autowired
	UserLocationDAO userLoc;
	@Autowired
	UserJoinDAO join;
	@Autowired
	BasketDAO bas;
	@Autowired
	PaymentDAO pay;
	@Autowired
	PayStatusService pss;
	@Autowired
	MenuImgModify menuImg;
	@Autowired
	StatisticsDAO stat;
	@Autowired
	Certification cert;
	@Autowired
	PushDAO push;
	@Autowired
	SendFCM fcm;
	@Autowired
	AdminNoticeDAO noti;
	@Autowired
	NonCPinfoDAO ninfo;
	@Autowired
	AddrConversion ac;
	@Autowired
	EnterMenuDAO em;
	@Autowired
	EnterSearchFillter esf;
	@Autowired
	VersionDAO status;
	@Autowired
	PersonalInfoDAO personal;
	@Autowired
	CouponUserDAO couUser;
	@Autowired
	CouCpDAO couCp;
	@Autowired
	CouponListDAO couList;
	@Autowired
	CouponHistoryDAO couHistory;
	@Autowired
	CouPaymentDAO couPayment;
	@Autowired
	CpStaffDAO cpStaff;
	@Autowired
	RealTimeReviewDAO real;
	
	@RequestMapping("*/baobabTos.api")
	public String getTosForWeb() {
		return "baobabTos";
	}
	
	@RequestMapping("*/contract.api")
	public String contract() {
		return "contract";
	}
	
	@RequestMapping("*/cert.api")
	public String test(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cert.certResult(request)));
		return "cert";
	}
	
	@RequestMapping("*/merge.api")
	public String merge() {
		merge.merge(merge.localList(), merge.classList());
		return "merge";
	}
	
	@RequestMapping("*/payment.api")
	public String payment(Model model ,HttpServletRequest request) {
		String oid = request.getParameter("orderNum");
		if(oid.startsWith("G")) {
			pay.payInfoInsert(request);
		}else if(oid.startsWith("P")) {
			push.pushPaymentMenu(request);
		}else if(oid.startsWith("C")) {
			couPayment.couPayInfoInsert(request);
		}
		
		//Gson gson = new Gson();
//		model.addAttribute("json",gson.toJson(push.pushPaymentMenu(request)) );
//		model.addAttribute("json",gson.toJson(push.pushPaymentSelect(request)));
		return "payment";
	}
	
	@RequestMapping("*/payNext.api")
	public String payNext(HttpServletRequest request) {
		return "payNext";
	}
	
	@RequestMapping(value="*/payNoti.api", method=RequestMethod.POST)
	public String payNoti(HttpServletRequest request) {
		if(request.getParameter("P_OID").startsWith("G")){
			pay.statusChange(request.getParameter("P_OID"), request.getParameter("P_STATUS"));
			pay.tidUpdate(request);
		}else if(request.getParameter("P_OID").startsWith("P")){
			push.pushTidUpdate(request);
		}else if(request.getParameter("P_OID").startsWith("C")) {
			couPayment.couTidUpdate(request);
		}
		return "payNoti";
//		System.out.println("드디어 노티가 실행이 되었습니다 여러분");
	}
	
	@RequestMapping("*/payReturn.api")
	public String payReturn() {
		return "payReturn";
	}
	
	@RequestMapping("*/payCancel.api")
	public String payCancel() {
		return "payCancel";
	}
	
	@RequestMapping(value="*/payCancelRs.api", method=RequestMethod.POST)
	public String payCancelRs(HttpServletRequest request) {
		pay.payCancel(request);
		return "payCancelRs";
	}
	
	@RequestMapping(value="*/payResult.api", method=RequestMethod.POST)
	public String payResult(HttpServletRequest request) {
		if(request.getParameter("P_OID").startsWith("G")) {
			pss.CNMStatusChange(request);
		}else if(request.getParameter("P_OID").startsWith("P")) {
			push.pushTidUpdate(request);
		}else if(request.getParameter("P_OID").startsWith("C")) {
			couPayment.couTidUpdate(request);
		}
		return "payResult";
	}
	
	@RequestMapping(value="*/addrConversion.api")
	public void addrConversion() {
		ac.workingSave();
	}
	
	@RequestMapping(value="*/geoTest.api", method=RequestMethod.GET)
	public String geoTest(Model model, @RequestParam String addr) {
		model.addAttribute("longitude", trans.trans(addr).getAddresses().get(0).getX());
		model.addAttribute("latitude", trans.trans(addr).getAddresses().get(0).getY());
		return "admin/addrConversion";
	}
	
	/* 위쪽은 웹 아래쪽은 앱 */
	
	@RequestMapping(value="*/getCPlist.api", method=RequestMethod.GET)
	public String getStoreList(Model model, @RequestParam String selectItem, @RequestParam String serchLoc, @RequestParam String location,
			@RequestParam int count, @RequestParam int listCount, @RequestParam String sortBy, @RequestParam String menu,
			@RequestParam double longitude, @RequestParam double latitude, @RequestParam String t1_1) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(sdService.dataFilltering(selectItem, serchLoc, location, count, listCount, sortBy, menu, longitude,
				latitude, t1_1)));
		System.out.println(selectItem + serchLoc + location + sortBy + String.valueOf(longitude) + String.valueOf(latitude) + menu);
		System.out.println("검색구분 : " + selectItem);
		System.out.println("검색어 : " + serchLoc);
		System.out.println("검색지역 : " + location);
		System.out.println("정렬순 : " + sortBy);
		return "storeList";
	}
	
	@RequestMapping(value="*/ourCPlist.api", method=RequestMethod.GET)
	public String getOurCpList(Model model, @RequestParam String selectItem, @RequestParam String serchLoc, @RequestParam String location, 
			@RequestParam String sortBy, @RequestParam double longitude, @RequestParam double latitude, @RequestParam String menu,
			@RequestParam int listCount, @RequestParam String t1_1) {
		Gson gson = new Gson();
		System.out.println(selectItem + serchLoc + location + sortBy + String.valueOf(longitude) + String.valueOf(latitude) + menu);
		model.addAttribute("json", gson.toJson(sdService.ourFillter(selectItem, serchLoc, location, sortBy, longitude, latitude, menu, listCount, t1_1)));
		return "ourCplist";
	}
	
	@RequestMapping(value="*/cpUserJoin.api", method=RequestMethod.POST)
	public void cpJoin(MultipartHttpServletRequest request) throws Exception {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phonNum = request.getParameter("phonNum");
		String cpName = request.getParameter("cpName");
		String cpLicenseNum = request.getParameter("cpLicenseNum");
		String cpPhon = request.getParameter("cpPhon");
		String cpZipcode = request.getParameter("cpZipcode");
		String cpAddress = request.getParameter("cpAddress");
		String cpAddrDetails = request.getParameter("cpAddrDetails");
		String cpKind = request.getParameter("cpKind");
		String cpType = request.getParameter("cpType");
		String cpTheme1 = request.getParameter("cpTheme1");
		String cpTheme2 = request.getParameter("cpTheme2");
		String parking = request.getParameter("parking");
		String closeDay = request.getParameter("closeDay");
		String closeEct = request.getParameter("close_ect");
		String businessStart = request.getParameter("businessStart");
		String businessEnd = request.getParameter("businessEnd");
		MultipartFile license = request.getFile("upload");
		String cpIntro = request.getParameter("cpIntro");
		MultipartFile bankbook = request.getFile("bankbook");
		String bank = request.getParameter("bank");
		String accountHolder = request.getParameter("accountHolder");
		String accountNumber = request.getParameter("accountNumber");
		String divCode = "c-01-01";
		String pushCheck = request.getParameter("pushCheck");
		String cpDiv = request.getParameter("cpDiv");
		
		System.out.println(password);
		
		cpJdao.cpUserAllJoin(email, password, phonNum, divCode, pushCheck);
		cpJdao.UserHistoryJoin(email, divCode);
		cpJdao.cpUserJoin(email, cpName, licUpload.licenseSaveToServer(license, email), cpLicenseNum, bankbook, bank, accountHolder, accountNumber);
		cpJdao.cpJoin(cpName, cpPhon, cpZipcode, cpAddress, cpAddrDetails, cpKind, cpType, cpTheme1, cpTheme2, parking, closeDay, businessStart,
				businessEnd, cpIntro, cpDiv, closeEct, email, phonNum, accountHolder);
		cpJdao.cpHistoryJoin(cpName);
		System.out.println("이메일 : " + email + ", 업체명 : " + cpName + " : 회원가입 완료");
	}
	
	@RequestMapping(value="*/cpMenuJoin.api", method=RequestMethod.POST)
	public void menuJoin(MultipartHttpServletRequest request) throws FileNotFoundException, IOException {
		MenuVO mvo = new MenuVO();
		mvo.setCp_name(request.getParameter("cpName"));
		mvo.setMenu_dis_price(Integer.parseInt(request.getParameter("disPrice")));
		mvo.setMenu_div(request.getParameter("menuDiv"));
		mvo.setMenu_name(request.getParameter("menuName"));
		mvo.setMenu_option(request.getParameter("option"));
		mvo.setMenu_price(Integer.parseInt(request.getParameter("price")));
		MultipartFile menuImg = request.getFile(request.getParameter("menuName"));
		mvo.setMenu_intro(request.getParameter("menuIntro"));
		mvo.setCp_seq(Integer.parseInt(request.getParameter("cpSeq")));
		
		menuUp.menuUpload(mvo, menuImg);
	}

	@RequestMapping(value="*/mainImgUpload.api", method=RequestMethod.POST)
	public void mainImgUpload(MultipartHttpServletRequest request) throws Exception {
		mainUp.mainImg(request.getFile("mainImg"), request.getParameter("cpName"), Integer.parseInt(request.getParameter("cpSeq")), 
				request.getParameter("position"));
		System.out.println("메인이미지 업로드 완료");
	}
	
	@RequestMapping(value="*/getMainImg.api", method=RequestMethod.GET)
	public String getMainImg(Model model, @RequestParam int seq) {
		Gson gson = new Gson();
		model.addAttribute("img", gson.toJson(mainUp.getMainImg(seq)));
		return "imgLoad";
	}
	
	@RequestMapping(value="*/loginService.api", method=RequestMethod.POST)
	public String loginControll(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		String id = request.getParameter("email");
		String pw = request.getParameter("password");
		model.addAttribute("json", gson.toJson(login.loginConfirm(id, pw)));
		return "login";
	}
	
	@RequestMapping(value="*/getMymenu.api", method=RequestMethod.GET)
	public String getCpMyMenu(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(getMenu.getMenu(cpSeq)));
		System.out.println(getMenu.getMenu(cpSeq));
		return "getMenu";
	}
	
	@RequestMapping(value="*/saveSetMenu.api", method=RequestMethod.POST)
	public String setMenuJoin(Model model, MultipartHttpServletRequest request) throws Exception {
		String menuName = request.getParameter("menuName");
		String cpName = request.getParameter("cpName");
		String menuPrice = request.getParameter("menuPrice");
		String menuDisPrice = request.getParameter("menuDisPrice");
		String menuDetail = request.getParameter("menuDetail");
		String menu = request.getParameter("menu");
		String option = request.getParameter("option");
		String ea = request.getParameter("ea");
		int cpSeq = Integer.parseInt(request.getParameter("cpSeq"));
		MultipartFile menuImg = request.getFile(menuName);
		
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(setMenuUp.setMenus(menuName, cpName, menuPrice, menuDisPrice, menuImg, menuDetail, menu, option, ea, cpSeq)));
		return "setMenuRtn";
	}
	
	@RequestMapping(value="*/getStoreMenus.api", method=RequestMethod.GET)
	public String getStoreMenus(Model model, @RequestParam int cpSeq, @RequestParam String menuDiv) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(storeMenu.getMenus(cpSeq, menuDiv)));
		return "storeMenu";
	}
	
	@RequestMapping(value="*/getSetMenu.api", method=RequestMethod.GET)
	public String getSetMenu(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(setMenu.getSetMenu(cpSeq)));
		return "setMenuRtn";
	}
	
	@RequestMapping(value="*/getSetMenuInfo.api", method=RequestMethod.GET)
	public String getSetMenuInfo(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(setMenu.getSetMenuInfo(cpSeq)));
		return "setMenuInfoRtn";
	}
	
	@RequestMapping(value="*/getMyCPInfo.api", method=RequestMethod.GET)
	public String getMyStoreInfo(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(login.getMyInfo(cpSeq)));
		return "getMyStoreInfo";
	}
	
	@RequestMapping(value="*/hitsUp.api", method=RequestMethod.GET)
	public void hitsUp(@RequestParam String cpName, @RequestParam int seqNum) {
		storeMenu.updateHits(cpName, seqNum);
	}
	
	@RequestMapping(value="*/saveOurReview.api", method=RequestMethod.POST)
	public void saveReviewForOur(MultipartHttpServletRequest request) throws FileNotFoundException, IOException  {
		MultipartFile img1 = request.getFile("revImg1");
		MultipartFile img2 = request.getFile("revImg2");
		MultipartFile img3 = request.getFile("revImg3");
		MultipartFile img4 = request.getFile("revImg4");
		String email = request.getParameter("email");
		String phoneNum = request.getParameter("phoneNum");
		String revPwd = request.getParameter("revPwd");
		String revText = request.getParameter("revText");
		String grade = request.getParameter("grade");
		String cpName = request.getParameter("cpName");
		String cpSeq = request.getParameter("cpSeq");
		String divCode = request.getParameter("divCode");
		String nickName = request.getParameter("nickName");
		String profile = request.getParameter("profile");
		System.out.println(img1);
		rev.ourReview(img1, img2, img3, img4, email, phoneNum, revPwd, revText, grade, cpName, cpSeq, divCode, 
				nickName, profile);
	}
	
	@RequestMapping(value="*/firstReview.api", method=RequestMethod.GET)
	public String firstReview(Model model, @RequestParam String cpName, @RequestParam int seqNum) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(rev.firstReview(cpName, seqNum)));
		return "firstReview";
	}
	
	@RequestMapping(value="*/moreReview.api", method=RequestMethod.GET)
	public String moreReview(Model model, @RequestParam String cpName, @RequestParam int seqNum) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(rev.moreReview(cpName, seqNum)));
		return "moreReview";
	}
	
	@RequestMapping(value="*/allReview.api", method=RequestMethod.GET)
	public String allReview(Model model, @RequestParam String cpName, @RequestParam int revCount, @RequestParam int seqNum) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(rev.allReview(cpName, revCount, seqNum)));
		return "allReview";
	}
	
	@RequestMapping(value="*/getCallHistory.api", method=RequestMethod.POST)
	public void getCallHistory(HttpServletRequest request) {
		call.getHistory(request.getParameter("userPhone"), request.getParameter("cpPhone"), request.getParameter("cpName"), 
				request.getParameter("cpAddress"), request.getParameter("cpDiv"));
		System.out.println("CallHistory저장완료");
	}
	
	@RequestMapping(value="*/showCallHistory.api", method=RequestMethod.POST)
	public String showCallHistory(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(call.showHistory(request.getParameter("userPhone"))));
		return "callHistory";
	}
	
	@RequestMapping(value="*/getPoke.api", method=RequestMethod.POST)
	public void getPoke(HttpServletRequest request) {
		poke.getPoke(request.getParameter("userPhone"), request.getParameter("cpName"), request.getParameter("cpAddr"), 
				Integer.parseInt(request.getParameter("score")), Integer.parseInt(request.getParameter("revNum")), request.getParameter("divCode"), 
				Integer.parseInt(request.getParameter("cpSeq")));
	}
	
	@RequestMapping(value="*/delPoke.api", method=RequestMethod.POST)
	public void delPoke(HttpServletRequest request) {
		poke.delPoke(request.getParameter("userPhone"), request.getParameter("cpName"), request.getParameter("divCode"), 
				Integer.parseInt(request.getParameter("cpSeq")));
	}
	
	@RequestMapping(value="*/showPoke.api", method=RequestMethod.POST)
	public String showPoke(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(poke.showPoke(request.getParameter("userPhone"))));
		return "poke";
	}
	
	@RequestMapping(value="*/setLocationOur.api", method=RequestMethod.POST)
	public void setOursLocationInfo(@RequestParam double latitude, @RequestParam double longitude, @RequestParam int seqNum) {
		//??
	}
	
	@RequestMapping(value="*/getUpdateData.api", method=RequestMethod.GET)
	public String getUpdateData(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(login.getMyInfo(cpSeq)));             
		return "cpUpdate";
	}
	
	@RequestMapping(value="*/getStoreInfo.api", method=RequestMethod.GET)
	public String getStoreInfo(Model model, @RequestParam String cpName, @RequestParam String email) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(login.getStoreInfo(cpName, email)));
		return "cpUpdate";
	}
	
	@RequestMapping(value="*/updateCPInfo.api", method=RequestMethod.POST)
	public void updateCPinfo(HttpServletRequest request) {
		cpJdao.cpUpdate(request);
		System.out.println(request.getParameter("cpName") + "수정 완료");
	}
	
	@RequestMapping(value="*/pokeConfirm.api", method=RequestMethod.GET)
	public String pokeConfirm(Model model, @RequestParam String userPhone, @RequestParam String cpName, @RequestParam String divCode, @RequestParam int cpSeq) {
		model.addAttribute("json", poke.pokeConfirm(userPhone, cpName, divCode, cpSeq));
		return "pokeConfirm";
	}
	
	@RequestMapping(value="*/getMyReview.api", method=RequestMethod.GET)
	public String getMyReview(Model model, @RequestParam String userPhoneNum, @RequestParam int revCount) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(rev.myReview(userPhoneNum, revCount)));
		return "getReview";
	}
	
	@RequestMapping(value="*/delMyReview.api", method=RequestMethod.GET)
	public void delMyReview(@RequestParam String userPhoneNum, @RequestParam String cpName, @RequestParam int reviewNum) throws Exception {
		rev.delReview(userPhoneNum, cpName, reviewNum);
	}
	
	@RequestMapping(value="*/updateReview.api", method=RequestMethod.POST)
	public void updateReview(MultipartHttpServletRequest request) throws Exception {
		MultipartFile img1 = request.getFile("revImg1");
		MultipartFile img2 = request.getFile("revImg2");
		MultipartFile img3 = request.getFile("revImg3");
		MultipartFile img4 = request.getFile("revImg4");
		String revText = request.getParameter("revText");
		int grade = (int) Double.parseDouble(request.getParameter("grade"));
		int revNum = Integer.parseInt(request.getParameter("revNum"));
		String email = request.getParameter("email");
		String nickName = request.getParameter("nickName");
		String profile = request.getParameter("profile");
		String cpSeq = request.getParameter("cpSeq");
		String phone = request.getParameter("phone");
		String cpName = request.getParameter("cpName");
		String pwd = request.getParameter("pwd");
		String divCode = request.getParameter("divCode");
		System.out.println("업체명 : " + cpName);
		System.out.println("폰번 : " + phone);
		System.out.println("바뀔곳" + revNum);
		rev.delReview(phone, cpName, revNum);
		rev.ourReview(img1, img2, img3, img4, email, phone, pwd, revText, String.valueOf(grade), cpName, 
				cpSeq, divCode, nickName, profile);
	}
	
	@RequestMapping(value="*/visitant.api", method=RequestMethod.POST)
	public String visitant(Model model, HttpServletRequest request) throws ParseException {
		Gson gson = new Gson();
		System.out.println("받은 타입 : " + request.getParameter("visitType"));
		System.out.println("받은 방문자 : " + request.getParameter("userPhone"));
		System.out.println("받은 날짜 : " + request.getParameter("visitDate"));
		model.addAttribute("json", gson.toJson(visit.visitantDiv(request.getParameter("visitType"), request.getParameter("visitDate"), 
				request.getParameter("userPhone"))));
		return "visitant";
	}
	
	@RequestMapping(value="*/pageSearch.api", method=RequestMethod.GET)
	public void pageSearch(@RequestParam PageSearchVO vo) {
		System.out.println("일단왔니?");
		System.out.println(String.valueOf(vo.getSearchWord()) + "받음");
	}
	
	@RequestMapping(value="*/version.api", method=RequestMethod.POST)
	public String versionCheck(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(ver.versionChecking(request.getParameter("version"))));
		return "version";
	}
	
	@RequestMapping(value="*/userLocUpdate.api", method=RequestMethod.POST)
	public void userLocUpdate(HttpServletRequest request) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException,
	BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, DecoderException {
		UserLocationVO vo = new UserLocationVO();
		vo.setAddr(request.getParameter("addr"));
		vo.setLatitude(request.getParameter("latitude"));
		vo.setLongitude(request.getParameter("longitude"));
		vo.setUser(request.getParameter("user"));
		vo.setPush_token(request.getParameter("pushToken"));
		userLoc.updateLocation(vo);
	}
	
	@RequestMapping(value="*/selectUserLoc.api", method=RequestMethod.POST)
	public String selectUserLoc(Model model, HttpServletRequest request) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException,
	BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, DecoderException {
		UserLocationVO vo = new UserLocationVO();
		vo.setUser(request.getParameter("user"));
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(userLoc.selectLocation(vo)));
		return "userLoc";
	}
	
	@RequestMapping(value="*/getForPoke.api", method=RequestMethod.GET)
	public String getForPoke(Model model, @RequestParam String cpName, @RequestParam String addr) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(userLoc.pokeSelect(cpName, addr)));
		return "getStoreInfo";
	}
	
	@RequestMapping(value="*/getForReview.api", method=RequestMethod.GET)
	public String getForReview(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(userLoc.reviewSelect(cpSeq)));
		return "getStoreInfo";
	}
	
	@RequestMapping(value="*/reviewAll.api", method=RequestMethod.GET)
	public String reivewAll(Model model) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(rev.reviewAll()));
		return "getReview";
	}

	
	
	@RequestMapping(value="*/getNonForCallHis.api", method=RequestMethod.GET)
	public String getNonForCallHis(Model model, @RequestParam String cpName, @RequestParam String addr, @RequestParam String phoneNum) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(userLoc.callNonSelect(cpName, addr, phoneNum)));
		return "getStoreInfo";
	}
	
	@RequestMapping(value="*/menuDetail.api", method=RequestMethod.GET)
	public String menuDetail(Model model, @RequestParam String cpName, @RequestParam String menuName, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(storeMenu.getOneMenu(cpName, menuName, cpSeq)));
		return "storeMenu";
	}
	
	@RequestMapping(value="*/setMenuDetail.api", method=RequestMethod.GET)
	public String setMenuDetail(Model model, @RequestParam String cpName, @RequestParam String menuName, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(setMenu.getOneSetMenu(cpName, menuName, cpSeq)));
		return "setMenuRtn";
	}
	
	@RequestMapping(value="*/nonForPoke.api", method=RequestMethod.GET)
	public String nonForPoke(Model model, @RequestParam String cpName, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(poke.getNonCPone(cpName, cpSeq)));
		return "poke";
	}
	
	@RequestMapping(value="*/updateNonHits.api", method=RequestMethod.GET)
	public void updateNonHits(@RequestParam String cpName, @RequestParam int seqNum, @RequestParam String div) {
		storeMenu.updateNonHits(cpName, seqNum, div);
	}
	
	@RequestMapping(value="*/getForNonRev.api", method=RequestMethod.GET)
	public String getForNonRev(Model model, @RequestParam int locNum) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(userLoc.reviewNonSelect(locNum)));
		return "userLoc";
	}
	
	@RequestMapping(value="*/userJoin.api", method=RequestMethod.POST)
	public void userJoin(HttpServletRequest request) {
		join.userAllJoin(request.getParameter("userEmail"), request.getParameter("userPw"), request.getParameter("userPhone"), request.getParameter("pushCheck"));
		System.out.println("일반회원 회원가입 완료");
	}
	
	@RequestMapping(value="*/getCpUserInfo.api", method=RequestMethod.POST)
	public String getCpUserInfo(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(login.getCpUserInfo(request.getParameter("email"))));
		return "login";
	}
	
	@RequestMapping(value="*/loginHistory.api", method=RequestMethod.POST)
	public void loginHistory(HttpServletRequest request) {
		login.getHistory(request);
	}
	
	@RequestMapping(value="*/reviewImg.api", method=RequestMethod.GET)
	public String reviewImg(Model model, @RequestParam String cpName, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(rev.allImages(cpName, cpSeq)));
		return "getReview";
	}
	
	@RequestMapping(value="*/inBasket.api", method=RequestMethod.GET)
	public void inBasket(@RequestParam String email, @RequestParam String cpName, @RequestParam int cpSeq, @RequestParam String menuName, 
			@RequestParam String option, @RequestParam int ea, @RequestParam int price, @RequestParam int disPrice) {
		bas.confRepetition(email, cpName, cpSeq, menuName, option, ea, price, disPrice);
	}
	
	@RequestMapping(value="*/basketList.api", method=RequestMethod.GET)
	public String basketList(Model model, @RequestParam String email) {
		Gson gson = new Gson();
		String result = bas.basketList(email).toString();
		System.out.println(result);
		model.addAttribute("json", gson.toJson(bas.basketList(email)));
		return "basket";
	}
	
	@RequestMapping(value="*/delBasket.api", method=RequestMethod.GET)
	public void delBasket(@RequestParam String email, @RequestParam String cpName, @RequestParam int cpSeq) {
		bas.delBasket(email, cpName, cpSeq);
	}
	
	@RequestMapping(value="*/basCpInfo.api", method=RequestMethod.GET)
	public String basCpInfo(Model model, @RequestParam String cpName, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		String result = gson.toJson(bas.basCpInfo(cpName, cpSeq));
		System.out.println(result);
		model.addAttribute("json", result);
		return "basket";
	}
	
	@RequestMapping(value="*/basDetailInfo.api", method=RequestMethod.POST)
	public String basDetailInfo(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		String result = gson.toJson(bas.basDetailInfo(request));
		System.out.println(result);
		model.addAttribute("json", result);
		return "basket";
	}
	
	@RequestMapping(value="*/menuConfirm.api", method=RequestMethod.GET)
	public String menuConfirm(Model model, @RequestParam String cpName, @RequestParam int cpSeq, @RequestParam String menuName) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(setMenu.menuConfirm(cpName, cpSeq, menuName)));
		return "setMenuRtn"; 
	}
	
	@RequestMapping(value="*/payHistory.api", method=RequestMethod.POST)
	public String payHistory(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(pay.payAllSelect(request)));
		return "pay";
	}
	
	@RequestMapping(value="*/payUsed.api", method=RequestMethod.GET)
	public void payUsed(@RequestParam String orderNum) {
		pay.usedUpdate(orderNum);
	}
	
	@RequestMapping(value="*/payCpList.api", method=RequestMethod.POST)
	public String payCpList(Model model, @RequestParam String email, @RequestParam String used) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(pay.cpAllSelect(email, used)));
		return "pay";
	}
	
	@RequestMapping(value="*/payDetail.api", method=RequestMethod.POST)
	public String payDetail(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(pay.payDetail(request.getParameter("orderNum"))));
		return "pay";
	}
	
	@RequestMapping(value="*/getUserPhone.api", method=RequestMethod.POST)
	public String getUserPhone(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(join.getUserPhone(request.getParameter("email"))));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/receipt.api", method=RequestMethod.GET)
	public void receipt(@RequestParam String orderNum) {
		pay.receiptChange(orderNum);
	}
	
	@RequestMapping(value="*/useCheck.api", method=RequestMethod.GET)
	public String useCheck(Model model, @RequestParam String orderNum) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(pay.useCheck(orderNum)));
		return "pay";
	}
	
	@RequestMapping(value="*/getCpPhone.api", method=RequestMethod.GET)
	public String getCpPhone(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(join.getCpPhone(cpSeq)));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/deleteCallHis.api", method=RequestMethod.GET)
	public void deleteCallHis(@RequestParam int seqNum) {
		call.delHistory(seqNum);
	}
	
	@RequestMapping(value="*/beingMall.api", method=RequestMethod.POST)
	public void beingMall(MultipartHttpServletRequest request) throws FileNotFoundException, NullPointerException, IOException, Exception {
		String email = request.getParameter("email");
		String cpName = request.getParameter("cpName");
		String cpLicenseNum = request.getParameter("cpLicenseNum");
		String cpPhon = request.getParameter("cpPhon");
		String cpZipcode = request.getParameter("cpZipcode");
		String cpAddress = request.getParameter("cpAddress");
		String cpAddrDetails = request.getParameter("cpAddrDetails");
		String cpKind = request.getParameter("cpKind");
		String cpType = request.getParameter("cpType");
		String cpTheme1 = request.getParameter("cpTheme1");
		String cpTheme2 = request.getParameter("cpTheme2");
		String parking = request.getParameter("parking");
		String closeDay = request.getParameter("closeDay");
		String closeEct = request.getParameter("close_ect");
		String businessStart = request.getParameter("businessStart");
		String businessEnd = request.getParameter("businessEnd");
		MultipartFile license = request.getFile("upload");
		String cpIntro = request.getParameter("cpIntro");
		MultipartFile bankbook = request.getFile("bankbook");
		String bank = request.getParameter("bank");
		String accountHolder = request.getParameter("accountHolder");
		String accountNumber = request.getParameter("accountNumber");
		String divCode = "c-01-01";
		String cpDiv = request.getParameter("cpDiv");		
		
		cpJdao.cpUserJoin(email, cpName, licUpload.licenseSaveToServer(license, cpName), cpLicenseNum, bankbook, bank, accountHolder, accountNumber);
		cpJdao.divCodeChange(email);
		cpJdao.UserHistoryJoin(email, divCode);
		cpJdao.cpJoin(cpName, cpPhon, cpZipcode, cpAddress, cpAddrDetails, cpKind, cpType, cpTheme1, cpTheme2, parking, closeDay, businessStart, 
				businessEnd, cpIntro, cpDiv, closeEct, email, cpPhon, accountHolder);
		cpJdao.cpHistoryJoin(cpName);
	}
	
	@RequestMapping(value="*/cpNameDup.api", method=RequestMethod.GET)
	public String cpNameDup(Model model, @RequestParam String cpName) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpJdao.dupName(cpName)));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/payCurDate.api", method=RequestMethod.POST)
	public String payCurDate(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(pay.payCurDate(request.getParameter("email"))));
		return "pay";
	}
	
	@RequestMapping(value="*/cancelCurDate.api", method=RequestMethod.POST)
	public String cancelCurDate(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(pay.cancelCurDate(request.getParameter("email"))));
		return "pay";
	}
	
	@RequestMapping(value="*/showMetheFan.api", method=RequestMethod.POST)
	public String showMetheFan(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(poke.showMetheFan(request.getParameter("email"))));
		return "poke";
	}
	
	@RequestMapping("*/hitInit.api")
	public String hitInit() {
		storeMenu.hitsInitialize();
		return "version";
	}
	
	@RequestMapping(value="*/menuDel.api", method=RequestMethod.GET)
	public void menuDel(@RequestParam String cpName, @RequestParam String menuName, @RequestParam String option) throws Exception {
		menuUp.menuDel(cpName, menuName, option);
	}
	
	@RequestMapping(value="*/menuModi.api")
	public void menuModi(@RequestParam String cpName, @RequestParam String menuName, @RequestParam String option, @RequestParam String up_menuName, 
			@RequestParam String up_option, @RequestParam int up_disPrice, @RequestParam int up_price, @RequestParam String url) {
		menuUp.menuModi(cpName, menuName, option, up_menuName, up_option, up_disPrice, up_price, url);
	}
	
	@RequestMapping(value="*/showMetheSetMenu.api", method=RequestMethod.GET)
	public String showMetheSetMenu(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(setMenuUp.showMetheSetMenu(cpSeq)));
		return "setMenuRtn";
	}
	
	@RequestMapping(value="*/delSetMenu.api", method=RequestMethod.GET)
	public void delSetMenu(@RequestParam String cpName, @RequestParam String menuName, @RequestParam int cpSeq) throws Exception {
		setMenuUp.delSetMenu(cpName, menuName, cpSeq);
	}
	
	@RequestMapping(value="*/menuImgChange.api", method=RequestMethod.POST)
	public String menuImgChange(Model model, MultipartHttpServletRequest request) throws Exception {
		Gson gson = new Gson();
		model.addAttribute("img", gson.toJson(menuImg.imgModify(request)));
		return "imgLoad";
	}
	
	@RequestMapping(value="*/allStat.api", method=RequestMethod.POST)
	public String allStat(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(stat.allStat(request.getParameter("cpName"), request.getParameter("startDate"), request.getParameter("endDate"))));
		return "stat";
	}
	
	@RequestMapping(value="*/dayStat.api", method=RequestMethod.POST)
	public String dayStat(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(stat.dayStat(request.getParameter("cpName"), request.getParameter("selDate"))));
		return "stat";
	}
	
	@RequestMapping(value="*/userInfoCha.api", method=RequestMethod.POST)
	public void userInfoCha(HttpServletRequest request) {
		join.userInfoChange(request.getParameter("email"), request.getParameter("password"), request.getParameter("pushCheck"));
	}
	
	@RequestMapping(value="*/leaveUser.api", method=RequestMethod.POST)
	public void leaveUser(HttpServletRequest request) {
		join.leaveUserAll(request.getParameter("email"));
	}
	/* 푸시 테스트용*/
	@RequestMapping(value="*/push.api", method=RequestMethod.POST)
	public String push(HttpServletRequest request) throws IOException {
		fcm.send(request, push.pushToAll());
		return "pushTest";
	}
	
	@RequestMapping(value="*/pushTest.api")
	public String pushTest() {
		return "pushTest";
	}
	/* 푸시 테스트용*/
	@RequestMapping(value="*/pushNormal.api", method=RequestMethod.POST)
	public String pushNormal(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(push.pushToNormal(request)));
		return "push";
	}
	
	@RequestMapping(value="*/pushFan.api", method=RequestMethod.POST)
	public String pushFan(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(push.pushToFan(request)));
		return "push";
	}
	
	@RequestMapping(value="*/sendPush.api", method=RequestMethod.POST)
	public String sendPush(Model model, HttpServletRequest request) throws IOException {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(fcm.send(request, push.sendToFan(request)) + fcm.send(request, push.sendToNormal(request))));
		push.savePush(request);
		return "push";
	}
	
	@RequestMapping(value="*/findUserLocation.api")
	public String findUserLocation(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(push.findUser(request.getParameter("pushToken"))));
		return "push";
	}
	
	@RequestMapping(value="*/findCP.api")
	public String findCP(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(push.findCp(request)));
		return "push";
	}
	
	@RequestMapping(value="*/getNoti.api", method=RequestMethod.POST)
	public String getNoti(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(noti.userSelect(request.getParameter("readDiv"))));
		return "notice";
	}
	
	@RequestMapping(value="*/changeUserCode.api", method=RequestMethod.POST)
	public String changeUserCode(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(join.userCodeUpdate(request)));
		return "login";
	}
	
	@RequestMapping(value="*/dupEmail.api", method=RequestMethod.POST)
	public String dubEmail(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(join.dupEmail(request)));
		return "userLoc";
	}
	
	@RequestMapping(value="*/noticePush.api", method=RequestMethod.GET)
	public String noticePush(Model model, @RequestParam String title) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(noti.pushClick(title)));
		return "notice";
	}
	
	@RequestMapping(value="*/reSign.api", method=RequestMethod.POST)
	public String reSign(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(join.emailCheck(request)));
		return "login";
	}
	
	@RequestMapping(value="*/nonCpMenu.api", method=RequestMethod.GET)
	public String nonCpMenu(Model model, @RequestParam int seq, @RequestParam String cpName) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(ninfo.getMenus(seq, cpName)));
		return "getMenu";
	}
	
	@RequestMapping(value="*/nonCpImg.api", method=RequestMethod.GET)
	public String nonCpImg(Model model, @RequestParam int seq, @RequestParam String cpName) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(ninfo.getImg(seq, cpName)));
		return "getMenu";
	}
	
	@RequestMapping(value="*/loclog.api", method=RequestMethod.POST)
	public String loclog(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(userLoc.locationLog(request)));
		return "userLoc";
	}
	
	@RequestMapping(value="*/payPush.api", method=RequestMethod.POST)
	public String payPush(Model model, HttpServletRequest request) throws IOException {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(pay.payPush(request)));
		return "pay";
	}
	
	@RequestMapping(value="*/addrSearch.api")
	public String addrSearch() {
		return "addrSearch";
	}
	
	@RequestMapping(value="*/payCusPush.api", method=RequestMethod.POST)
	public String payCusPush(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(pay.payDetail(request.getParameter("orderNum"))));
		return "pay";
	}
	
	@RequestMapping(value="*/delMainImg.api", method=RequestMethod.GET)
	public String delMainImg(Model model, @RequestParam String url)throws Exception {
		Gson gson = new Gson();
		model.addAttribute("img", gson.toJson(mainUp.mainImgDel(url)));
		return "imgLoad";
	}
	
	@RequestMapping(value="*/enterMenuInsert.api", method=RequestMethod.POST)
	public String enterMenuInsert(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(em.menuInsert(request)));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/enterMenuDel.api", method=RequestMethod.GET)
	public String enterMenuDel(Model model, @RequestParam int cpSeq, @RequestParam int seqNum) {
		Gson gson = new Gson();
		model.addAttribute("json",gson.toJson(em.menuDel(cpSeq, seqNum)));
		return "cpUpdate";
	}
	
	@RequestMapping(value="*/enterMenuUpdate.api", method=RequestMethod.POST)
	public String enterMenuUpdate(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(em.menuUpdate(request)));
		
		return "cpUpdate" ;
		
	}
	
	@RequestMapping(value="*/enterMenuSel.api", method=RequestMethod.GET)
	public String enterMenuSel(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(em.menuSelect(cpSeq)));
		return "getMenu";
	}
	
	@RequestMapping(value="*/enterOurSearch.api", method=RequestMethod.POST)
	public String enterOurSearch(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(esf.ourFillter(request)));
		return "enter";
	}
	
	@RequestMapping(value="*/enterNonSearch.api", method=RequestMethod.POST)
	public String enterNonSearch(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		System.out.println(esf.nonFillter(request).toString());
		model.addAttribute("json", gson.toJson(esf.nonFillter(request)));
		return "enter";
	}
	
	@RequestMapping(value="*/enterPoke.api", method=RequestMethod.GET)
	public String enterPoke(Model model, @RequestParam String cpName, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(poke.enterNonCp(cpName, cpSeq)));
		return "poke";
	}
	
	@RequestMapping(value="*/enterCallHis.api", method=RequestMethod.GET)
	public String enterCallHis(Model model, @RequestParam String cpName, @RequestParam String address) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(call.enterSelect(cpName, address)));
		return "callHistory";
	}
	
	@RequestMapping(value="*/enterRivew.api", method=RequestMethod.GET)
	public String enterRivew(Model model, @RequestParam String cpName, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(rev.enterSelect(cpName, cpSeq)));
		return "allReview";
	}
	
	@RequestMapping(value="*/getThisMenu.api", method=RequestMethod.GET)
	public String getThisMenu(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(getMenu.getThisMenu(cpSeq)));
		return "getMenu";
	}
	
	@RequestMapping(value="*/getStatus.api", method=RequestMethod.POST)
	public String getStatus(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		String result = status.getStatus();
		System.out.println("앱 상태 : " + result);
		model.addAttribute("json", gson.toJson(result));
		return "version";
	}
	
	@RequestMapping(value="*/findEmail.api", method=RequestMethod.POST)
	public String findEmail(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(personal.findEmail(request.getParameter("phoneNum"))));
		return "personal";
	}
	
	@RequestMapping(value="*/findPassword.api", method=RequestMethod.POST)
	public String findPassword(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(personal.findPassword(request)));
		return "personal";
	}
	
	@RequestMapping(value="*/updatePassword.api", method=RequestMethod.POST)
	public String updatePassword(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(personal.updatePassword(request)));
		return "personal";
	}
	
	@RequestMapping(value="*/menuImageUrl.api", method=RequestMethod.GET)
	public String menuImageUrl(Model model, @RequestParam String cpName, @RequestParam int cpSeq, @RequestParam String menuName) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(getMenu.menuImageUrl(cpName, cpSeq, menuName)));
		return "getMenu";
	}
	
	@RequestMapping(value="*/mainImgUpdate.api", method=RequestMethod.POST)
	public String mainImgUpdate(Model model, MultipartHttpServletRequest request) throws Exception {
		Gson gson = new Gson();
		model.addAttribute("img", gson.toJson(mainUp.urlUpdate(mainUp.imgUpload(request.getFile("mainImg"), 
				request.getParameter("url").split("/")[request.getParameter("url").split("/").length-1].replaceAll(".png", "").replaceAll(".jpg", "")))));
		return "imgLoad";
	}
	
	@RequestMapping(value="*/cpUserAllInfo.api", method=RequestMethod.POST)
	public String cpUserAllInfo(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpJdao.getCpUserInfo(request.getParameter("email"))));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/pointUp.api", method=RequestMethod.POST)
	public String pointUp(Model model,HttpServletRequest request) {
	    Gson gson = new Gson();
	    model.addAttribute("json", gson.toJson(join.point(request.getParameter("email"))));
	    return "userLoc";
	      
	}
	
	@RequestMapping(value="*/nowPoint.api", method=RequestMethod.POST)
	public String nowPoint(Model model,HttpServletRequest request) {
		Gson gson = new Gson();
	    model.addAttribute("json", gson.toJson(join.nowPoint(request.getParameter("email"))));
	    return "userLoc";
	}
	
	@RequestMapping(value="*/pushPaySelect.api", method=RequestMethod.POST)
	public String pushPaySelect(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json",gson.toJson(push.pushPaymentSelect(request)) );
		return "push";
	}
	
	@RequestMapping(value="*/pushEaPlma.api", method=RequestMethod.POST)
	public void pushEaPlma(HttpServletRequest request) {
		push.pushEaPlma(request);
	}
	
	@RequestMapping(value="*/cpUserInfo.api", method=RequestMethod.POST)
	public String cpUserInfo(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpJdao.cpUserInfo(request.getParameter("email"))));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/changeCpUser.api", method=RequestMethod.POST)
	public String changeCpUser(Model model, MultipartHttpServletRequest request) throws Exception {
		String email = request.getParameter("email");
		String licenseNum = request.getParameter("licenseNum");
		String accHolder = request.getParameter("accHolder");
		String bank = request.getParameter("bank");
		String accNum = request.getParameter("accNum");
		MultipartFile license = request.getFile("license");
		MultipartFile bankbook = request.getFile("bankbook");
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpJdao.changeCpUser(email, licenseNum, 
				accHolder, bank, accNum, license, bankbook)));
		
		return "cpJoin";
	}
	
	//--------------couponUser---------------
	@RequestMapping(value="*/insertCouponUser.api", method=RequestMethod.POST)
	public String insertcouponUser(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couUser.insertCouponUser(request)));
		return "coupon";
	}
	
	@RequestMapping(value="*/userCouponEa.api", method=RequestMethod.POST)
	public String userCouponEa(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couUser.userCouponEa(request)));
		
		return "coupon";
	}
	
	@RequestMapping(value="*/getUserCoupon.api", method=RequestMethod.POST)
	public String getUserCoupon(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couUser.getUserCoupon(request)));
		return "coupon";
	}
	
	@RequestMapping(value="*/couponExpiry.api")
	public String couponExpiry() {
		couUser.userCouponExpiry();
		couCp.cpCouponExpiry();
		return "coupon";
	}
	
	@RequestMapping(value="*/usedCouponHistory.api", method=RequestMethod.POST)
	public String usedCouponHistory(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couUser.usedCouponHistory(request)));
		return "coupon";
	}
	
	
	//----------couponCP-------------------
	@RequestMapping(value="*/getCpCouList.api", method=RequestMethod.POST)
	public String getCpCouList(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		
		model.addAttribute("json", gson.toJson(couCp.getCpCouList(Integer.parseInt(request.getParameter("cpSeq")))));
		return "coupon";
	}
	
	@RequestMapping(value="*/couponCpPeriod.api", method=RequestMethod.POST)
	public String couponCpPeriod(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couCp.couponCpPeriod(request)));

		return "coupon";
	}
	
	@RequestMapping(value="*/couPayDetail.api", method=RequestMethod.POST)
	public String couPayDetail(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couCp.couPayDetail(request.getParameter("orderNum"))));
		
		return "coupon";
	}
	
	@RequestMapping(value="*/getCouponMenu.api", method=RequestMethod.GET)
	public String getCouponMenu(Model model, @RequestParam int cpSeq) {
		Gson gson= new Gson();
		model.addAttribute("json", gson.toJson(couCp.getCouponMenu(cpSeq)));
		return "coupon";
		
	}
	
//	@RequestMapping(value="*/getCpCouInfo.api",method=RequestMethod.POST)
//	public String getCpCouInfo(Model model, HttpServletRequest request) {
//		Gson gson = new Gson();
//		model.addAttribute("json", gson.toJson(couCp.getCpCouInfo(request)));
//		return "coupon";
//	}
	
	@RequestMapping(value="*/couCpInfoInsert.api", method=RequestMethod.POST)
	public String couCpInfoInsert(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couCp.couCpInfoInsert(request)));
		return "coupon";
	}
	
	@RequestMapping(value="*/couponCpUse.api", method=RequestMethod.POST)
	public String couponCpUse(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couCp.couponCpUse(request)));
		return "coupon";
	}
		
	//couponPayment
	@RequestMapping(value="*/couPaySelect.api", method=RequestMethod.POST)
	public String couPaySelect(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json",gson.toJson(couPayment.couPaySelect(request)) );
		return "coupon";
	}
	
	//couponList
	@RequestMapping(value="*/getCouponList.api", method=RequestMethod.GET)
	public String couponListSelect(Model model) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couList.couponListSelect()));
		return "coupon";
	}
	
	//---------couponHistory.api------------
	@RequestMapping(value="*/getCouponHistory.api", method=RequestMethod.POST)
	public void getCouponHistory(HttpServletRequest request) {
		couHistory.getCouponHistory(request.getParameter("serial_num"), request.getParameter("dl_user_email"),
				request.getParameter("status"),Integer.parseInt(request.getParameter("cp_seq")), request.getParameter("title"));
		System.out.println("쿠폰히스토리 저장완료");
	}
	
//	@RequestMapping(value="*/showCouponHistory.api", method=RequestMethod.POST)
//	public String showCouponHistory(Model model, HttpServletRequest request) {
//		Gson gson = new Gson();
//		model.addAttribute("json", gson.toJson(couHistory.showCouponHistory(request.getParameter("dl_user_email"))));
//		return "coupon";
//	}
//	
//	@RequestMapping(value="*/delCouponHistory.api", method=RequestMethod.GET)
//	public void delCouponHistory(@RequestParam int seqNum) {
//		couHistory.delCouponHistory(seqNum);
//	}
	
	//-----------cpStaff & Scan----------------
	@RequestMapping(value="*/staffSearch.api", method=RequestMethod.POST)
	public String staffSearch(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.staffSearch(request)));
		return "cpStaff";
	}
	
	@RequestMapping(value="*/getStaffs.api", method=RequestMethod.POST)
	public String getStaffs(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.getStaffs(request)));
		return "cpStaff";
	}
	
	@RequestMapping(value="*/cpStaffInfoInsert.api", method=RequestMethod.POST)
	public String cpStaffInfoInsert(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.staffInfoInsert(request)));
		return "cpStaff";
	}
	
	@RequestMapping(value="*/updateStaff.api", method=RequestMethod.POST)
	public String updateStaff(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.updateStaff(request)));
		return "cpStaff";
	}
	
	@RequestMapping(value="*/scanCoupon.api", method=RequestMethod.POST)
	public String scanCoupon(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.scanCoupon(request)));
		return "cpStaff";
	}
	
	@RequestMapping(value="*/staffCancel.api", method=RequestMethod.POST)
	public String staffCancel(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.staffCancel(request)));
		return "cpStaff";
	}
	
	@RequestMapping(value="*/cpStaffTest.api", method=RequestMethod.GET)
	public String test() {
		staffTest.merge();
		return "test";
	}
	
	@RequestMapping(value="*/couponScanHistory.api", method=RequestMethod.POST)
	public String couponScanHistory(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.usedCoupon(request)));
		return "cpStaff";
	}
	
	//-----------RTR-------------
	@RequestMapping(value="*/realTimeReview.api", method=RequestMethod.POST)
	public String reviewUpdate(Model model, MultipartHttpServletRequest request) throws IOException {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(real.reviewProfile(request)));
		
		return "allReview";
	}
	
	@RequestMapping(value="*/userProfile.api", method=RequestMethod.POST)
	public String userProfile(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(real.userProfile(request)));
		return "allReview";
	}
	
	@RequestMapping(value="*/profileDelete.api", method=RequestMethod.POST)
	public String profileDelete(Model model, HttpServletRequest request) throws Exception {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(real.profileDelete(request)));
		return "allReview";
	}
	
	@RequestMapping(value="*/getCpForRTR.api", method=RequestMethod.GET)
	public String getCpForRTR(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(real.rtr(cpSeq)));
		return "allReview";
	}
}
package com.baobab.m.controller;

import java.io.IOException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.baobab.admin.dao.AdminCPDAO;
import com.baobab.admin.dao.AdminCodeChangeDAO;
import com.baobab.admin.dao.AdminCouponListDAO;
import com.baobab.admin.dao.AdminCpPushDAO;
import com.baobab.admin.dao.AdminLoginDAO;
import com.baobab.admin.dao.AdminLoginHistoryDAO;
import com.baobab.admin.dao.AdminMainDAO;
import com.baobab.admin.dao.AdminNoticeDAO;
import com.baobab.admin.dao.AdminPushDAO;
import com.baobab.admin.dao.AdminReviewDAO;
import com.baobab.admin.dao.AdminSearchWordDAO;
import com.baobab.admin.dao.AdminUserDAO;
import com.baobab.admin.dao.AdminVersionDAO;
import com.baobab.admin.dao.AdminVisitantDAO;
import com.baobab.admin.dao.AlmightyDAO;
import com.baobab.admin.service.CPDetailService;
import com.baobab.admin.service.UserDetailService;
import com.google.gson.Gson;

@Controller
public class AdminController {
	
	@Autowired
	AdminLoginDAO login;
	@Autowired
	AdminMainDAO main;
	@Autowired
	AdminUserDAO user;
	@Autowired
	UserDetailService uds;
	@Autowired
	AdminCPDAO cp;
	@Autowired
	CPDetailService cpd;
	@Autowired
	AdminNoticeDAO noti;
	@Autowired
	AdminPushDAO push;
	@Autowired
	AdminVersionDAO ver;
	@Autowired
	AdminCodeChangeDAO cc;
	@Autowired
	AdminCpPushDAO cpp;
	@Autowired
	AdminReviewDAO rev;
	@Autowired
	AdminSearchWordDAO rank;
	@Autowired
	AdminLoginHistoryDAO log;
	@Autowired
	AdminVisitantDAO visit;
	@Autowired
	AdminCouponListDAO coupon;
	@Autowired
	AlmightyDAO alm;
	
	@RequestMapping("*/admin/home.api")
	public String admin(HttpSession session) {
		session.setAttribute("id", null);
		session.setAttribute("pw", null);
		return "admin/home";
	}
	
	@RequestMapping("*/error/error.api")
	public String error() {
		return "admin/error";
	}
	
	@RequestMapping(value="*/admin/loginConfirm.api", method=RequestMethod.POST)
	public String login(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("logResult", login.login(request.getParameter("id"), request.getParameter("password"), session));
		return "admin/loginConfirm";
	}
	
	@RequestMapping("*/admin/main.api")
	public String main(Model model, HttpSession session) {
		return main.makeMainPage(model, session);
	}
	
	@RequestMapping(value="*/admin/user.api", method=RequestMethod.POST)
	public String user(Model model, HttpSession session, HttpServletRequest request) throws ParseException {
		model.addAttribute("loginHistory", main.loginHistory(session));
		model.addAttribute("userList", user.searchUser(request));
		return "admin/user";
	}
	
	@RequestMapping(value="*/admin/userDetail.api", method=RequestMethod.POST)
	public String userDetail(Model model, HttpServletRequest request, HttpSession session) {
		uds.insertData(session, request);
		return uds.sendData(model, request);
	}
	
	@RequestMapping(value="*/admin/cp.api", method=RequestMethod.POST)
	public String cp(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("loginHistory", main.loginHistory(session));
		return cp.search(model, request);
	}
	
	@RequestMapping(value="*/admin/cpDetail.api", method=RequestMethod.POST)
	public String cpDetail(Model model, HttpServletRequest request) {
		return cpd.makeAttribute(model, request);
	}
	
	@RequestMapping("*/admin/noticeInput.api")
	public String noticeInput(Model model, HttpSession session) {
		model.addAttribute("loginHistory", main.loginHistory(session));
		return "admin/noticeInput";
	}
	
	@RequestMapping(value="*/admin/noticeInsert.api", method=RequestMethod.POST)
	public String noticeInsert(Model model, HttpServletRequest request, HttpSession session) throws IOException {
		model.addAttribute("result", noti.insertNotice(request, session));
		return "admin/noticeCheck";
	}
	
	@RequestMapping(value="*/admin/noticeList.api", method=RequestMethod.POST)
	public String noticeList(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("loginHistory", main.loginHistory(session));
		model.addAttribute("noticeList", noti.adminSelect(request));
		return "admin/noticeList";
	}
	
	@RequestMapping(value="*/admin/noticeDetail.api", method=RequestMethod.POST)
	public String noticeDetail(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("loginHistory", main.loginHistory(session));
		model.addAttribute("notice", noti.noticeDetail(request));
		return "admin/noticeDetail";
	}
	
	@RequestMapping(value="*/admin/pushInput.api", method=RequestMethod.GET)
	public String pushInput(Model model, HttpSession session) {
		model.addAttribute("loginHistory", main.loginHistory(session));
		return "admin/pushInsert";
	}
	
	@RequestMapping(value="*/admin/sendPush.api", method=RequestMethod.POST)
	public String sendPush(Model model, HttpServletRequest request, HttpSession session) throws IOException {
		model.addAttribute("result", push.pushHistory(request, session));
		return "admin/pushCheck";
	}
	
	@RequestMapping(value="*/admin/pushList.api", method=RequestMethod.POST)
	public String pushList(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("loginHistory", main.loginHistory(session));
		model.addAttribute("pushList", push.adminSelect(request));
		return "admin/pushList";
	}
	
	@RequestMapping(value="*/admin/pushDetail.api", method=RequestMethod.POST)
	public String pushDetail() {
		return "admin/pushDetail";
	}
	
	@RequestMapping(value="*/admin/version.api")
	public String version(Model model) {
		model.addAttribute("curVersion", String.valueOf(ver.getVersion()));
		return "admin/versionUp";
	}
	
	@RequestMapping(value="*/admin/versionUp.api", method=RequestMethod.POST)
	public String versionUp(Model model, HttpServletRequest request) {
		model.addAttribute("version", ver.upVersion(request));
		return "admin/versionCheck";
	}
	
	@RequestMapping(value="*/admin/account.api")
	public String account() {
		return "admin/account";
	}
	
	@RequestMapping(value="*/admin/accountInsert.api", method=RequestMethod.POST)
	public String accountInsert(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("result", login.accountInsert(request, session));
		return "admin/accountCheck";
	}
	
	@RequestMapping(value="*/admin/hitsUpdate.api")
	public String hitsUpdate(Model model) {
		model.addAttribute("result", ver.hitsInitialize());
		return "admin/hitsUp";
	}
	
	@RequestMapping(value="*/admin/codeChange.api")
	public String codeChange() {
		return "admin/codeChange";
	}
	
	@RequestMapping(value="*/admin/codeChangeInit.api", method=RequestMethod.POST)
	public String codeChangeInit(Model model, HttpServletRequest request) {
		model.addAttribute("result", cc.codeChange(request));
		return "admin/codeChangeInit";
	}
	
	@RequestMapping(value="*/admin/cpPushList.api", method=RequestMethod.POST)
	public String cpPushList(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("loginHistory", main.loginHistory(session));
		model.addAttribute("pushList", cpp.pushSelect(request));
		return "admin/cpPushList";
	}

	@RequestMapping(value="*/admin/reviewList.api", method=RequestMethod.POST)
	public String reviewList(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("reviewList", rev.reviewList(request));
		model.addAttribute("loginHistory", main.loginHistory(session));
		return "admin/reviewList";
	}
	
	@RequestMapping(value="*/admin/reviewDetail.api", method=RequestMethod.POST)
	public String reviewDetail(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("review", rev.reviewSelect(request));
		model.addAttribute("loginHistory", main.loginHistory(session));
		return "admin/reviewDetail";
	}
	
	@RequestMapping(value="*/admin/searchWord.api", method=RequestMethod.POST)
	public String searchWord(Model model) {
		model.addAttribute("kindList", rank.kindRank());
		model.addAttribute("wordList", rank.wordRank());
		return "admin/searchWord";
	}
	
	@RequestMapping(value="*/admin/loginHistory.api", method=RequestMethod.POST)
	public String loginHistory(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("loginHistory", main.loginHistory(session));
		return log.history(model, request);
	}
	
	@RequestMapping(value="*/admin/visitant.api", method=RequestMethod.POST)
	public String visitant(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("loginHistory", main.loginHistory(session));
		return visit.visitants(model, request);
	}
	
	@RequestMapping(value="*/admin/addrConversion.api")
	public String addrConversion() {
		return "admin/addrConversion";
	}
	
	@RequestMapping(value="*/admin/checkServer.api")
	public String getCheckServer(Model model) {
		model.addAttribute("curServer",ver.getCheckServer());
		return "admin/checkServerUp";
	}
	
	@RequestMapping(value="*/admin/checkServerUp.api", method=RequestMethod.POST)
	public String checkServer(Model model, HttpServletRequest request) {
		model.addAttribute("server", ver.checkServer(request));
		return "admin/checkingServer";
	}
	
	@RequestMapping(value="*/admin/couponList.api", method=RequestMethod.POST)
	public String couponList(Model model, HttpSession session, HttpServletRequest request){
		model.addAttribute("couponList", coupon.couponAll(request));
		model.addAttribute("loginHistory", main.loginHistory(session));
		return "admin/couponList";
	}
	
	@RequestMapping(value="*/admin/couponUpdate.api", method=RequestMethod.POST)
	public String couponList(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("couponUpdate",coupon.couponSelect(request));
		model.addAttribute("loginHistory", main.loginHistory(session));
		return "admin/couponUpdate";
	}
	
	@RequestMapping(value="*/admin/couponInfoUpdate.api", method=RequestMethod.POST)
	public String couponInfoUpdate(Model model, HttpServletRequest request) {
		model.addAttribute("couponInfoUpdate", coupon.couponInfoUpdate(request));
		return "admin/couponList";
	}
	
	@RequestMapping(value="*/admin/almightySearch.api", method=RequestMethod.POST)
	public String almightySearch(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(alm.cpSearch(request.getParameter("searchWord"))));
		return "getMyStoreInfo";
	}
	
	@RequestMapping(value="*/admin/almightyLogin.api", method=RequestMethod.POST)
	public String almightyLogin(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(alm.almightyLogin(request)));
		return "getMyStoreInfo";	
	}
}
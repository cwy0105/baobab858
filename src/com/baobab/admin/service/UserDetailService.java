package com.baobab.admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.baobab.admin.dao.AdminUserDetailDAO;
import com.baobab.m.vo.LocationInquHistoryVO;

@Service
public class UserDetailService {
	
	@Autowired
	AdminUserDetailDAO aud;
	
	public String sendData(Model model, HttpServletRequest request) {
		model.addAttribute("location", aud.loctaionInfo(request.getParameter("email")));
		model.addAttribute("payment", aud.paymentInfo(request.getParameter("email")));
		model.addAttribute("history", aud.historyInfo(request.getParameter("email")));
		model.addAttribute("poke", aud.pokeInfo(request.getParameter("email")));
		model.addAttribute("callHistory", aud.callHistoryInfo(request.getParameter("email")));
		model.addAttribute("review", aud.reviewInfo(request.getParameter("email")));
		return "admin/userDetail";
	}
	
	public void insertData(HttpSession session, HttpServletRequest request) {
		LocationInquHistoryVO vo = new LocationInquHistoryVO();
		vo.setEmail(session.getAttribute("id").toString());
		vo.setIp(getIp(request));
		aud.locationInqu(vo);
	}
	
	public String getIp(HttpServletRequest request) {
		String ip = null;
        ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("Proxy-Client-IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("WL-Proxy-Client-IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("HTTP_CLIENT_IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("X-Real-IP"); 
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("X-RealIP"); 
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("REMOTE_ADDR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getRemoteAddr(); 
        }
        return ip;
	}
}

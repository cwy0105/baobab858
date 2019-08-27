package com.baobab.m.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Service;

@WebServlet(name="CouponInitiallize", urlPatterns= {"/couponExpiry"}, loadOnStartup=1)
public class CouponInitiallize extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void init()throws ServletException{
		Date curDate = new Date();
		DateFormat dateFormatter = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat dateFormatter2 = new  SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = dateFormatter.parse(dateFormatter2.format(curDate) + " 24:00:00");
			Timer timer = new Timer();
			timer.schedule(new CouponTimerTask(), date, 86400000);
//			timer.cancel();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Service
	private static class CouponTimerTask extends TimerTask{

		@Override
		public void run() {
			BufferedReader in = null;
			try {
				URL url = new URL("http://192.168.0.12/baobab/jsp/couponExpiry.api");
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				
				con.setRequestMethod("GET");
				
				in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(in != null) try {in.close();}catch(Exception e) {e.printStackTrace();}
			}
			System.out.println("----------로그 찍히는 시간-----------" + new Date());
		}
		
	}
}

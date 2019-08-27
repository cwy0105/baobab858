package com.baobab.m.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.baobab.m.vo.NaverGeocodingVO;
import com.google.gson.Gson;

@Service
public class NaverGeoCoding {

	public NaverGeocodingVO trans(String address) {
		try {
			URL url = new URL("https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + URLEncoder.encode(address, "UTF-8"));
			String clientId = "6riynply1r";
			String clientSecret = "zlghtLyNNZaLMnZNjlW84MHGItgCtvaLrUtia1Z2";
				
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
			con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if(responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			
			Gson gson = new Gson();
			NaverGeocodingVO vo = gson.fromJson(response.toString(), NaverGeocodingVO.class);
			return vo;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

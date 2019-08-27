package com.baobab.m.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baobab.m.vo.UserLocationVO;

@Service
public class SendNoticeFCM {
	
private static final String API_KEY = "AIzaSyAuiJvz-MnCawXfkixcJHijXBArIyv4zsI";
	
	public int send(String title, String content, List<UserLocationVO> list) throws IOException {
		if(list.size() != 0) {
			for(int i=0;i<list.size();i++) {
				URL url = new URL("https://fcm.googleapis.com/fcm/send");
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setDoOutput(true);
				con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				con.setRequestProperty("Authorization", "key=" + API_KEY);
				
				con.setDoOutput(true);
				
				String input = "{\"data\" : {\"title\" : \""+ title + 
						"\", \"body\" : \"" + content + "\"}, \"to\":\"" + list.get(i).getPush_token() + "\"}";
				
				OutputStream os = con.getOutputStream();
				
				os.write(input.getBytes("UTF-8"));
				os.flush();
				os.close();
				
				int responseCode = con.getResponseCode();
				System.out.println("\nSending Push 'POST' request to URL : " + url);
				System.out.println("Post parameter : " + input);
				System.out.println("Response Code : " + responseCode);
				
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				
				while((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				
				System.out.println(response.toString());			
			}
			return list.size();
		}else {
			return 0;
		}
	}

}

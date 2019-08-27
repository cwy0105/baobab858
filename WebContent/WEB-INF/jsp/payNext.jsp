<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.httpclient.HttpException"%>
<%@page import="org.apache.commons.httpclient.HttpStatus"%>
<%@page import="org.apache.commons.httpclient.DefaultHttpMethodRetryHandler"%>
<%@page import="org.apache.commons.httpclient.params.HttpMethodParams"%>
<%@page import="org.apache.commons.httpclient.methods.GetMethod"%>
<%@page import="org.apache.commons.httpclient.HttpClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="java.io.*" %>
<%@page import="java.util.HashMap"%>

<%
	request.setCharacterEncoding("euc-kr");

	String status = request.getParameter("P_STATUS");
	String reqUrl = request.getParameter("P_REQ_URL");
	String tid = request.getParameter("P_TID");
	String rmesg1 = request.getParameter("P_RMESG1");
	String noti = request.getParameter("P_NOTI");
	String mid = "INIpayTest";
	
	HashMap<String, String> map = new HashMap<String, String>();
	
	String statusTxt = "";
	
	if(status.equals("00")){
		reqUrl = reqUrl + "?P_TID=" + tid + "&P_MID=" + mid;
		
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(reqUrl);
		
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		
		
		try{
			int statusCode = client.executeMethod(method);
			if(statusCode != HttpStatus.SC_OK){
				out.print("Method failed: " + method.getStatusLine());
			}
			
			byte[] responseBody = method.getResponseBody();
			String[] values = new String(responseBody).split("&"); 
			
			for( int x = 0; x < values.length; x++ ) 
			  {
				//out.print(values[x]);  // 승인결과를 출력
				//out.print("<br>");
				
				// 승인결과를 파싱값 잘라 hashmap에 저장
				int i = values[x].indexOf("=");			
				String key1 = values[x].substring(0, i);
				String value1 = values[x].substring(i+1);
				map.put(key1, value1);
			  }
		} catch (HttpException e) {
		      ////System.err.println("Fatal protocol violation: " + e.getMessage());
		    out.print("Fatal protocol violation: " + e.getMessage());
	      e.printStackTrace();
	    } catch (IOException e) {
	      ////System.err.println("Fatal transport error: " + e.getMessage());
		    out.print("Fatal transport error: " + e.getMessage());
	      e.printStackTrace();
	    } finally {
	      // Release the connection.
	      method.releaseConnection();
	    }  
	}
%>
<html>
	<head>
		<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
		<script type="text/javascript">
			window.onload = function goResult(){
				document.getElementById("payResult").submit();
			}
			
		</script>
	</head>
	<body>
		<form id="payResult" name="payResult" action="https://www.baobab858.com/jsp/payResult.api" method="post">
			<input type="hidden" name="oldStatus" value="<%=request.getParameter("P_STATUS") %>" />
			<input type="hidden" name="rmesg" value="<%=request.getParameter("P_RMESG1") %>" />
			<input type="hidden" name="P_TID" value="<%=map.get("P_TID") %>" />
			<input type="hidden" name="P_OID" value="<%=map.get("P_OID") %>" />
			<input type="hidden" name="P_STATUS" value="<%=map.get("P_STATUS") %>" />
			<input type="hidden" name="P_TYPE" value="<%=map.get("P_TYPE") %>" />
			<input type="hidden" name="P_VACT_DATE" value="<%=map.get("P_VACT_DATE") %>" />
			<input type="hidden" name="P_VACT_TIME" value="<%=map.get("P_VACT_TIME") %>" />
			<input type="hidden" name="P_VACT_BANK_CODE" value="<%=map.get("P_VACT_BANK_CODE") %>" />
			<input type="hidden" name="P_VACT_NUM" value="<%=map.get("P_VACT_NUM") %>" />
		</form>
	</body>
</html>
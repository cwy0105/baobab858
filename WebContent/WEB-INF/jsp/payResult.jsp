<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String statusTxt = "";
String status = request.getParameter("oldStatus");
if(status.equals("00")){
	if(request.getParameter("P_TYPE").equals("CARD") || request.getParameter("P_TYPE").equals("EWALLET") || request.getParameter("P_TYPE").startsWith("ETC_") ||
			request.getParameter("P_TYPE").equals("MOBILE")){
		statusTxt = "결제완료되었습니다. 완료 버튼을 눌러주세요.";
		out.print("<header><div id=\"logoFather\">" + 
		"<img id=\"logo\" src=\"https://www.baobab858.com/resources/webImages/logo.png\" alt=\"logo\" title=\"baobab858.com\"/><br/><h1>" + statusTxt + 
		"</h1></div></header>");
	}else if(request.getParameter("P_TYPE").equals("VBANK")){
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = format.parse(request.getParameter("P_VACT_DATE"));
		format = new SimpleDateFormat("yyyy년 MM월 dd일");
		String dateStr = format.format(date);
		
		format = new SimpleDateFormat("hhmmss");
		Date time = format.parse(request.getParameter("P_VACT_TIME"));
		format = new SimpleDateFormat("hh시 mm분");
		String timeStr = format.format(time);
		
		statusTxt = "결제완료되었습니다. 아래 계좌로 입금 해주세요.";
		out.print("<header><div id=\"logoFather\">" + 
				"<img id=\"logo\" src=\"https://www.baobab858.com/resources/webImages/logo.png\" alt=\"logo\" title=\"baobab858.com\"/><br/><h1>" + statusTxt + 
				"</h1></div></header>");
		out.print("<section><div><h3>" + request.getParameter("P_VACT_BANK_CODE") + " : " + request.getParameter("P_VACT_NUM") + "</h3><br/>");
		out.print("<p>" + dateStr + " " + timeStr + "까지 입금해주세요.</p></div></section>");
	}
}else{
	statusTxt = "결제에 실패했습니다. 다시 시도해 주십시오.";
	out.print("<header><div id=\"logoFather\">" + 
			"<img id=\"logo\" src=\"https://www.baobab858.com/resources/webImages/logo.png\" alt=\"logo\" title=\"baobab858.com\"/><br/><h1>" + statusTxt + 
			"</h1></div></header>");
	out.print("인증 실패");
	out.print("<br>");	
	out.print(request.getParameter("rmesg"));
}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<title>바오밥 결제완료</title>
<style type="text/css">
			body{
				width: 400px;
				height: 550px;
			}
			#logoFather{
				margin-bottom: 30px;
			}
			#logo{
				height: 100px;
			}
		</style>
		<script type="text/javascript">
			window.onload = function getResult(){
				var status = <%=status %>
				window.getResult.getResult(status);
			}
		</script>
</head>
<body>

</body>
</html>
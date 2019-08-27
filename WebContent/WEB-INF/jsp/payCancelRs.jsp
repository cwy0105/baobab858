<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	out.print("<header><div id=\"logoFather\"><img id=\"logo\" src=\"https://www.baobab858.com/resources/webImages/logo.png\" alt=\"logo\" title=\"" + 
		"baobab858.com\"/></div></header>");
	if(request.getParameter("rsCode").equals("0") || request.getParameter("rsCode").equals("00")){
		out.print("결제 취소가 성공적으로 완료되었습니다.");
	}else{
		out.print("결제 취소 실패 : " + request.getParameter("rsMsg"));
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	window.onload = function makeText(){
		
	}
</script>
<style type="text/css">
	body{
		width: 400px;
		height: 550px;
	}
	#logoFather{
		margin-bottom: 80px;
	}
	#logo{
		height: 100px;
	}
</style>
<script type="text/javascript">
	window.onload = function getCode(){
		var status = <%=request.getParameter("rsCode") %>
		window.getResult.getCode(status);
	}
</script>
<title>바오밥 결제취소 결과</title>
</head>
<body>

</body>
</html>
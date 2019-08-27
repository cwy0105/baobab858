<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>바오밥 관리자</title>
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<script type="text/javascript">
window.onload = function logResult(){
	var loginResult = <%=Integer.parseInt(request.getAttribute("logResult").toString())%>
	if(loginResult == 0){
		alert("아이디와 비밀번호를 다시 확인하십시오.");
		history.back();
	}else if(loginResult > 0){
		window.location.href = "https://www.baobab858.com/jsp/admin/main.api";
	}else{
		alert("관리자 등록이 필요합니다.");
		window.open('https://www.baobab858.com/jsp/admin/account.api', '관리자등록', 'width=500px, height=600px, toolbars=no, scrollbars=no, top=150px, left=600px');
	}
}
</script>
</head>
<body>

</body>
</html>
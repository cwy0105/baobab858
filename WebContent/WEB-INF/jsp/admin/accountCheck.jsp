<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<title>관리자 등록</title>
<script type="text/javascript">
window.onload = function accountResult(){
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
	}
	
	var loginResult = <%=Integer.parseInt(request.getAttribute("result").toString())%>
	if(loginResult <= 0){
		alert("관리자 등록에 실패하였습니다. 계속되면 담당자를 통해 문의하시기 바랍니다.");
		history.back();
	}else{
		alert("관리자 등록이 완료되었습니다. 관리자 페이지에서 다시 로그인 하시기 바랍니다.");
		window.opener.location.replace("https://www.baobab858.com/jsp/admin/home.api");
		window.close();
	}
}
</script>
</head>
<body>

</body>
</html>
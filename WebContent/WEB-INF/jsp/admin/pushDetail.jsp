<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="https://www.baobab858.com/resources/webImages/favicon.ico">
<link href="<c:url value="https://www.baobab858.com/resources/css/popupDefault.css" />" rel="stylesheet">
<script src="<c:url value="https://www.baobab858.com/resources/js/popupDefault.js"/>" type="text/javascript"/></script>
<script type="text/javascript">
window.onload = function(){
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
	}
}
</script>
<title>푸시내용확인</title>
</head>
<body>
	<div id="main_div">
		<div>
			<img src="https://www.baobab858.com/resources/webImages/logo.png">
			<h1><%=request.getParameter("title") %></h1>
		</div>
		<div id="content">
			<p><%=request.getParameter("content") %></p>
		</div>
	</div>
	<button onclick="closePopup()">X</button>
</body>
</html>
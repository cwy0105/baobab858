<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="https://www.baobab858.com/resources/css/popupDefault.css" />" rel="stylesheet">
<link href="<c:url value="https://www.baobab858.com/resources/css/account.css" />" rel="stylesheet">
<script src="<c:url value="https://www.baobab858.com/resources/js/popupDefault.js"/>" type="text/javascript"/></script>
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<title>관리자 등록</title>
<script type="text/javascript">
	function accountSubmit() {
		var form = document.getElementById('account');
		form.submit();
	}
	window.onload = function() {
		var id = "<%=session.getAttribute("id")%>";
		if (id == "null") {
			window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
		}
	}
</script>
</head>
<body>
	<div id="main_div">
		<div>
			<img src="https://www.baobab858.com/resources/webImages/logo.png">
			<h1>관리자 등록</h1>
		</div>
		<div id="content">
			<form id="account" action="https://www.baobab858.com/jsp/admin/accountInsert.api" method="post">
				<input type="text" name="name" placeholder="이름"> 
				<input type="text" name="department" placeholder="부서명">
				<input type="text" name="jobClass" placeholder="직급">
			</form>
			<input type="button" value="등록" onclick="accountSubmit()">
		</div>
	</div>
	<button onclick="closePopup()">X</button>
</body>
</html>
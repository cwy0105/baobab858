<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="kr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>바오밥 관리자</title>
<link href="<c:url value="https://www.baobab858.com/resources/css/adminHome.css" />" rel="stylesheet">
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<script src="<c:url value="https://www.baobab858.com/resources/js/adminHome.js"/>" type="text/javascript"/></script>
</head>
<body>
	<div id="main_div">
		<img alt="logo" title="logo" src="https://www.baobab858.com/resources/webImages/logo.png">
		<div id="second">
			<form action="https://www.baobab858.com/jsp/admin/loginConfirm.api" method="post">
				<input class="account" name="id" type="text" placeholder="관리자 아이디"><br>
				<input class="account" name="password" type="password" placeholder="패스워드"><br>
				<input id="login" type="submit" value="Login">
			</form>
		</div>
	</div>
</body>
</html>
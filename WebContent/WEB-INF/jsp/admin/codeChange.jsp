<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<link href="<c:url value="https://www.baobab858.com/resources/css/codeChange.css" />" rel="stylesheet">
<link href="<c:url value="https://www.baobab858.com/resources/css/popupDefault.css" />" rel="stylesheet">
<script src="<c:url value="https://www.baobab858.com/resources/js/popupDefault.js"/>" type="text/javascript"/></script>
<title>권한변경</title>
<script type="text/javascript">
	function codeSubmit() {
		var form = document.getElementById('codeChange');
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
			<h1>권한변경</h1>
		</div>
		<div id="content">
			<form id="codeChange" action="https://www.baobab858.com/jsp/admin/codeChangeInit.api" method="post">
				<input type="text" name="divCode" placeholder="권한명을 정확하게 입력하세요." maxlength="7" value="<%=request.getParameter("code") %>">
				<input type="hidden" name="email" value="<%=request.getParameter("email") %>">
			</form>
			<input type="button" value="수정" onclick="codeSubmit()">
		</div>
	</div>
	<button onclick="closePopup()">X</button>
</body>
</html>
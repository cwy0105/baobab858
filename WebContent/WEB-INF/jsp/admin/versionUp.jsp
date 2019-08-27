<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="https://www.baobab858.com/resources/webImages/favicon.ico">
<link href="<c:url value="https://www.baobab858.com/resources/css/versionUp.css" />" rel="stylesheet">
<link href="<c:url value="https://www.baobab858.com/resources/css/popupDefault.css" />" rel="stylesheet">
<script src="<c:url value="https://www.baobab858.com/resources/js/popupDefault.js"/>" type="text/javascript"/></script>
<script type="text/javascript">
	window.onload = function(){
		var id = "<%=session.getAttribute("id")%>";
		if (id == "null") {
			window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
		}
	}

	function update() {
		var form = document.getElementById('update');
		form.submit();
	}
</script>
<title>바오밥 버전수정</title>
</head>
<body>
	<div id="main_div">
		<div>
			<img src="https://www.baobab858.com/resources/webImages/logo.png">
			<h1>현재버전 : <%=request.getAttribute("curVersion").toString() %></h1>
		</div>
		<div id="content">
			<form id="update" action="https://www.baobab858.com/jsp/admin/versionUp.api" method="post">
				<input type="number" name="version" value="<%=request.getAttribute("curVersion").toString() %>" min="1">
				<input type="button" value="수정" onclick="update()">
			</form>
			<p>※DB에 저장되어있는 버전값을 변경시키는 것으로 실질적으로 앱내 버전은 변경되지 않습니다.</p>
		</div>
	</div>
	<button onclick="closePopup()">X</button>
</body>
</html>
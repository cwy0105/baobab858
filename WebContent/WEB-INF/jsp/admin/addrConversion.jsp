<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="https://www.baobab858.com/resources/webImages/favicon.ico">
<link href="<c:url value="https://www.baobab858.com/resources/css/addrConversion.css" />" rel="stylesheet">
<link href="<c:url value="https://www.baobab858.com/resources/css/popupDefault.css" />" rel="stylesheet">
<script src="<c:url value="https://www.baobab858.com/resources/js/popupDefault.js"/>" type="text/javascript"/></script>
<script type="text/javascript">
	function conversion() {
		var form = document.getElementById('conversion');
		form.submit();
	}
	window.onload = function() {
		var id = "<%=session.getAttribute("id")%>";
		if (id == "null") {
			window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
		}
	}
</script>
<title>바오밥 주소변환</title>
</head>
<%
	String longitude = "";
	String latitude = "";
	try{
		longitude = request.getAttribute("longitude").toString();
		latitude = request.getAttribute("latitude").toString();
	}catch(Exception e){
		longitude = "정보없음";
		latitude = "정보없음";
	}
%>
<body>
	<div id="main_div">
		<div>
			<img src="https://www.baobab858.com/resources/webImages/logo.png">
			<h1>주소를 입력해 주세요.</h1>
		</div>
		<div id="content">
			<form id="conversion" action="https://www.baobab858.com/jsp/geoTest.api" method="get">
				<input type="text" name="addr" placeholder="변환할 주소 입력"><br>
				<input type="button" value="수정" onclick="conversion()">
			</form>
			<div id="result">
				<p>경도 : <%=longitude %></p>
				<p>위도 : <%=latitude %></p>
			</div>
		</div>
	</div>
	<button onclick="closePopup()">X</button>
</body>
</html>
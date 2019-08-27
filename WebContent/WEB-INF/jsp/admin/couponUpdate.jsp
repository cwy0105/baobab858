<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.baobab.m.vo.CouponListVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="https://www.baobab858.com/resources/webImages/favicon.ico">
<link
	href="<c:url value="https://www.baobab858.com/resources/css/artDefault.css" />"
	rel="stylesheet">
<link href="<c:url value="https://www.baobab858.com/resources/css/couponList.css" />" rel="stylesheet">
<script
	src="<c:url value="https://www.baobab858.com/resources/js/default.js"/>"
	type="text/javascript" /></script>
<title>바오밥 관리자</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnUpdate").click(function() {
			document.form1.action = "${path}/couponListUpdate"
			document.form1.submit();
		});
	});
	$(document).ready(function() {
		$("#btnDelete").click(function() {
			document.form1.action = "${path}/adminDelete"
			document.form1.submit();
		});
	});
	
	window.onload = function(){
		makeIndex(1);
		var id = "<%=session.getAttribute("id")%>";
		if (id == "null") {
			window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div>
		<div id="header">
			<ul>
				<li><a href="#" onclick="javascript:page_notice();">공지사항</a>
					<ul>
						<li><a class="small_menu"
							href="https://www.baobab858.com/jsp/admin/noticeInput.api">공지사항
								작성</a></li>
					</ul></li>
				<li><a href="#">푸시내역</a>
					<ul>
						<li><a class="small_menu"
							href="https://www.baobab858.com/jsp/admin/pushInput.api">푸시작성</a></li>
					</ul></li>
				<li><a href="#" onclick="javascript:page_user();">회원정보</a></li>
				<li><a href="#" onclick="javascript:page_cp();">업체정보</a></li>
				<li><a href="#">결제내역</a></li>
				<li><a href="#" onclick="javascript:page_review();">리뷰조회</a></li>
				<li><a href="#">기타</a>
					<ul>
						<li><a class="small_menu" href="#" onclick="javascript:page_visitant();">방문자 조회</a></li>
						<li><a class="small_menu" href="#" onclick="javascript:page_search();">검색어 조회</a></li>
						<li><a class="small_menu" href="#">사장님 푸시 조회</a></li>
						<li><a class="small_menu" href="#" onclick="hitsUp()">당일 조회수 강제 초기화</a></li>
						<li><a class="small_menu" href="#" onclick="javascript:page_logHistory()">로그인 기록 조회</a></li>
						<li><a class="small_menu" href="#" onclick="version()">버전 업데이트</a></li>
						<li><a class="small_menu" href="#" onclick="couponList()">쿠폰 관리</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div id="section">
			<div id="article">
				<div id="main_article">
					<div>
						<a href="https://www.baobab858.com/jsp/admin/main.api"> <img
							src="https://www.baobab858.com/resources/webImages/logo.png"
							alt="logo" title="logo">
						</a>
					</div>
					<div id="admin_session">
						<h1><%=session.getAttribute("department")%></h1>
						<h3><%=session.getAttribute("name")%>
							<%=session.getAttribute("jobClass")%>님
						</h3>
						<p>오늘도 즐거운 업무 되시길 바랍니다.</p>
					</div>
				</div>
				<div id="sub_article">
					<h1>최근 접속 내역</h1>
					<div>
						<c:forEach var="item" items="${loginHistory}" step="1"
							varStatus="status">
							<p class="history">${item}</p>
						</c:forEach>
					</div>
				</div>
			</div>
			<form method="post" name="form1">
				<div id="main_section">
					<h1>쿠폰 목록</h1>
					<div>
						<div>
							<div>
								<label for="name"> 쿠폰 이름</label> <input name="couponName"
									class="form-control" value="${couponUpdate.couponName}">
								<label for="price"> 쿠폰 가격</label> <input name="couponPrice"
									class="form-control" value="${couponUpdate.couponPrice}">
								<label for="discount"> 쿠폰 할인 가격</label> <input
									name="couponDiscountPrice" class="form-control"
									value="${couponUpdate.couponDiscountPrice}">
								<label for="ea"> 쿠폰 개수</label> <input name="couponEa"
									class="form-control" value="${couponUpdate.ea}">
								<input type="button" value="수정" id="btnUpdate"> 
								<input type="button" value="삭제" id="btnDelete">
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
</div>
</body>
</html>
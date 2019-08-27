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
<link
	href="<c:url value="https://www.baobab858.com/resources/css/artDefault.css" />"
	rel="stylesheet">
<link
	href="<c:url value="https://www.baobab858.com/resources/css/user.css" />"
	rel="stylesheet">
<link rel="shortcut icon"
	href="https://www.baobab858.com/resources/webImages/favicon.ico">
<script
	src="<c:url value="https://www.baobab858.com/resources/js/default.js"/>"
	type="text/javascript" /></script>
<title>바오밥 관리자</title>
<script type="text/javascript">
function makeList(startIndex, endIndex){
	var userList = [];
	var loop = 0;
	
	<%List<CouponListVO> couponList = (List<CouponListVO>) request.getAttribute("couponList");
			//	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (int i = 0; i < couponList.size(); i++) {%>
		couponList[loop] = {
				couponName: "<%=couponList.get(i).getCouponName()%>",
				couponDiscountPrice: "<%=couponList.get(i).getCouponDiscountPrice()%>",
				couponPrice: "<%=couponList.get(i).getCouponPrice()%>",
				ea: "<%=couponList.get(i).getEa()%>",
		};
		loop++;
<%}%>
// 	var text = '<tr>' + '<th>쿠폰이름</th>' + '<th>쿠폰할인금액</th>'
// 				+ '<th>쿠폰가격</th>' + '<th>쿠폰개수</th>' + '</tr>';

// 		if (endIndex > couponList.length) {
// 			endIndex = couponList.length;
// 		}
// 		for (i = startIndex; i < endIndex; i++) {
// 			text += '<tr>' + '<td onclick="showDetail(' + '\''
// 					+ userList[i].couponName + '\'' + ')">' + couponList[i].couponName
// 					+ '</td>' + '<td onclick="showDetail(' + '\''
// 					+ couponList[i].couponName + '\'' + ')">' + couponList[i].couponDiscountPrice
// 					+ '</td>' + '<td onclick="sohwDetail(' + '\''
// 					+ couponList[i].couponName + '\'' + ',' + '\''
// 					+ couponList[i].code + '\'' + ')">' + couponList[i].code
// 					+ '</td>' + '<td onclick="showDetail(' + '\''
// 					+ couponList[i].couponName + '\'' + ')">' + couponList[i].push
// 					+ '</td>' + '<td onclick="showDetail(' + '\''
// 					+ couponList[i].couponName + '\'' + ')">' + '</td>' + '</tr>';
// 		}

// 		document.getElementById('couponList').innerHTML = text;
// 	}
</script>
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
				<li><a href="#" onclick="javascript:page_push();">푸시내역</a>
					<ul>
						<li><a class="small_menu"
							href="https://www.baobab858.com/jsp/admin/pushInput.api">푸시작성</a></li>
					</ul></li>
				<li><a href="#">회원정보</a></li>
				<li><a href="#" onclick="javascript:page_cp();">업체정보</a></li>
				<li><a href="#">결제내역</a></li>
				<li><a href="#" onclick="javascript:page_review();">리뷰조회</a></li>
				<li><a href="#">기타</a>
					<ul>
						<li><a class="small_menu" href="#"
							onclick="javascript:page_visitant();">방문자 조회</a></li>
						<li><a class="small_menu" href="#"
							onclick="javascript:page_search();">검색어 조회</a></li>
						<li><a class="small_menu" href="#"
							onclick="javascript:page_cpPush();">사장님 푸시 조회</a></li>
						<li><a class="small_menu" href="#" onclick="hitsUp()">당일
								조회수 강제 초기화</a></li>
						<li><a class="small_menu" href="#"
							onclick="javascript:page_logHistory()">로그인 기록 조회</a></li>
						<li><a class="small_menu" href="#" onclick="version()">버전
								업데이트</a></li>
						<li><a class="small_menu" href="#" onclick="addrConversion()">경위도
								찾기</a></li>
						<li><a class="small_menu" href="#" onclick="checkServer()">점검
								수정</a></li>
						<li><a class="small_menu" href="#" onclick="couponList()">쿠폰
								관리</a></li>
					</ul></li>
			</ul>
		</div>
		<div id="section">
			<div id="article">
				<div id="main_article">
					<div>
						<a href="https://www.baobab858.com/jsp/admin/main.api"><img
							src="https://www.baobab858.com/resources/webImages/logo.png"
							alt="logo" title="logo"></a>
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
			<div id="main_section">
				<h1>쿠폰변경</h1>
				<!-- 				<div> -->
				<!-- 					<div> -->
				<!-- 						<div> -->
				<!-- 							<form id="search" action="https://www.baobab858.com/jsp/admin/couponList.api" method="post"> -->
				<!-- 								<select name="div_code"> -->
				<!-- 									<option value="%%" selected="selected">전체 (권한코드)</option> -->
				<!-- 									<option value="u%">일반회원</option> -->
				<!-- 									<option value="c%">입점주</option> -->
				<!-- 									<option value="a%">바오밥직원</option> -->
				<!-- 									<option value="%u-01-02%">탈퇴회원</option> -->
				<!-- 								</select> -->
				<!-- 								<select name="push"> -->
				<!-- 									<option value="%%" selected="selected">전체 (푸시)</option> -->
				<!-- 									<option value="%o%">동의</option> -->
				<!-- 									<option value="%x%">미동의</option> -->
				<!-- 								</select> -->
				<!-- 								<input type="date" name="date" /> -->
				<!-- 								<input type="text" name="user_email" placeholder="이메일" /> -->
				<!-- 								<input type="button" value="검색" onclick="search()" /> -->
				<!-- 							</form> -->
				<!-- 						</div> -->
				<!-- 						<table id="user_table"> -->
				<!-- 						</table> -->
				<!-- 						<div id="page_div"> -->
				<!-- 							<button id="prev" onclick="pageNum(this)">◀</button> -->
				<!-- 							<a id="page_num">1</a> -->
				<!-- 							<button id="next" onclick="pageNum(this)">▶</button> -->
				<!-- 						</div> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
			</div>
		</div>
	</div>
</body>
</html>
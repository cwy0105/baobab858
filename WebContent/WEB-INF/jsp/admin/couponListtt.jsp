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
<link
	href="<c:url value="https://www.baobab858.com/resources/css/couponList.css" />"
	rel="stylesheet">
<script
	src="<c:url value="https://www.baobab858.com/resources/js/default.js"/>"
	type="text/javascript" /></script>
<title>바오밥 관리자</title>
<script type="text/javascript">
window.onload = function(){
	makeIndex(1);
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
	}
}
// function pageNum(btn){
// 	var id = btn.getAttribute('id');
// 	var listLen = ${fn:length(pushList)};
// 	var pageNum = document.getElementById('page_num').innerText;
// 	if(id == 'prev' && pageNum > 1){
// 		pageNum--;
// 	}else if(id == 'next' && (listLen/15) > 1 && pageNum < (listLen/15)){
// 		pageNum++;
// 	}
// 	document.getElementById('page_num').innerText = pageNum;
	
// 	makeIndex(pageNum);
// }

// function makeIndex(pageNum){
// 	var startIndex = ((pageNum - 1) * 15);
// 	var endIndex = (startIndex + 15);
	
// 	makeList(startIndex, endIndex);
// }

// function makeList(startIndex, endIndex){
// 	var couponList = [];
// 	var loop = 0;
	
<%-- 	<%List<CouponListVO> couponList = (List<CouponListVO>) request.getAttribute("couponList"); --%>
// 			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
<%-- 			for (int i = 0; i < couponList.size(); i++) {%> --%>
// 			couponList[loop] = {
<%-- 				couponName: "<%=couponList.get(i).getCouponName()%>", --%>
<%-- 				couponPrice: "<%=String.valueOf(couponList.get(i).getCouponPrice())%>", --%>
<%-- 				couponDiscountPrice: "<%=String.valueOf(couponList.get(i).getCouponDiscountPrice())%>", --%>
<%-- 				ea: "<%=String.valueOf(couponList.get(i).getEa())%>" --%>
			
// 		};
// 		loop++;
<%-- 	<%}%> --%>
// 	var text =  '<tr>' + '<th>쿠폰 이름</th>' + '<th>쿠폰 가격</th>' + '<th>할인 가격</th>' + '<th>개수</th>' + '</tr>';
	
// 	if(endIndex > couponList.length){
// 		endIndex = couponList.length;
// 	}
	
// 	for(i=startIndex;i<endIndex;i++){
// 		text += '<tr>' + '<td>' + couponList[i].cpName + '</td>' + '<td>' + couponList[i].couponPrice + '원' + '</td>' + '<td>' + couponList[i].couponDiscountPrice + '원 할인' + '</td>' 
// 		+ '<td>' + couponList[i].ea + '개' + '</td>' + '</tr>';
// 	}
	
// 	document.getElementById('coupon_table').innerHTML = text;
// }

// function search(){
// 	var form = document.getElementById('search');
// 	form.submit();
// }

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
			<form action="couponUpdate" method="post">
				<div id="main_section">
					<h1>쿠폰 목록</h1>
					<div>
						<div>
							<div>
								<table>
									<thead>
										<tr>
											<th>쿠폰 종류</th>
											<th>쿠폰 가격</th>
											<th>쿠폰 할인가격</th>
											<th>쿠폰 개수</th>
										</tr>
									</thead>
									<c:forEach var="row" items="${couponList }">
										<tbody>
											<tr>
												<td>${row.couponName}</td>
												<td>${row.couponPrice}</td>
												<td>${row.couponDiscountPrice}</td>
												<td>${row.ea}</td>
												<td><input type="submit">수정</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
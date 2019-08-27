<%@page import="com.baobab.m.vo.CPInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="https://www.baobab858.com/resources/css/default.css" />" rel="stylesheet">
<link href="<c:url value="https://www.baobab858.com/resources/css/cpDetail.css" />" rel="stylesheet">
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="<c:url value="https://www.baobab858.com/resources/js/default.js"/>" type="text/javascript"/></script>
<script type="text/javascript">
window.onload = function() {
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
	}
}

$(document).ready(function() {
	var $banner = $("#banner").find("ul");
	var imgArr = new Array;

	<%
		List<String> imgUrl = (List<String>)request.getAttribute("imgUrl");
		if(imgUrl.size() > 0){
			for(int i=0;i<imgUrl.size();i++){
	%>
				imgArr.push('<%=imgUrl.get(i)%>');
	<%
			}
		}
	%>
	
	
	var text = '';
	if(imgArr.length > 1){
		for (i = 0; i < imgArr.length; i++) {
		text += '<li>'
		  		+ '<img src="' + imgArr[i] + '" onerror="this.src=\'https://www.baobab858.com/resources/webImages/sample_img.jpg\'"'
		  		+ ' width="600px" height="265px">'
				+ '</li>';
		}
	}else if(imgArr.length == 1){
		text = '<li>'
	  			+ '<img src="' + imgArr[0] + '" width="600px" height="265px">'
				+ '</li>'
				+'<li>'
	  			+ '<img src="' + 'https://www.baobab858.com/resources/webImages/sample_img.jpg'
	  			+ '" width="600px" height="265px">'
				+ '</li>';
	}else{
		text = '<li>'
	  			+ '<img src="' + 'https://www.baobab858.com/resources/webImages/sample_img.jpg' + '" width="600px" height="265px">'
				+ '</li>'
				+'<li>'
	  			+ '<img src="' + 'https://www.baobab858.com/resources/webImages/sample_img.jpg' + '" width="600px" height="265px">'
				+ '</li>';
	}

	$banner.append(text);
	
	var $bannerWidth = $banner.children().outerWidth();
	var $bannerHeight = $banner.children().outerHeight();
	var $bannerLength = $banner.children().length;
	var rollingId;

	rollingId = setInterval(function() {rollingStart();}, 3000);

	function rollingStart() {
		$banner.css("width", $bannerWidth * $bannerLength + "px");
		$banner.css("height", $bannerHeight + "px");

		$banner.animate({left : -$bannerWidth + "px"}, 1500, function() {
			$(this).append("<li>" + $(this).find("li:first").html() + "</li>");
			$(this).find("li:first").remove();
			$(this).css("left", 0);
		});
	}
});
</script>
<title>바오밥 관리자</title>
</head>
<body>
	<div>
		<div id="header">
			<ul>
				<li><a href="#" onclick="javascript:page_notice();">공지사항</a>
					<ul>
						<li><a class="small_menu" href="https://www.baobab858.com/jsp/admin/noticeInput.api">공지사항 작성</a></li>
					</ul>
				</li>
				<li><a href="#" onclick="javascript:page_push();">푸시내역</a>
					<ul>
						<li><a class="small_menu" href="https://www.baobab858.com/jsp/admin/pushInput.api">푸시작성</a></li>
					</ul>
				</li>
				<li><a href="#" onclick="javascript:page_user();">회원정보</a></li>
				<li><a href="#" onclick="javascript:page_cp();">업체정보</a></li>
				<li><a href="#">결제내역</a></li>
				<li><a href="#" onclick="javascript:page_review();">리뷰조회</a></li>
				<li><a href="#">기타</a>
					<ul>
						<li><a class="small_menu" href="#" onclick="javascript:page_visitant();">방문자 조회</a></li>
						<li><a class="small_menu" href="#" onclick="javascript:page_search();">검색어 조회</a></li>
						<li><a class="small_menu" href="#" onclick="javascript:page_cpPush();">사장님 푸시 조회</a></li>
						<li><a class="small_menu" href="#" onclick="hitsUp()">당일 조회수 강제 초기화</a></li>
						<li><a class="small_menu" href="#" onclick="javascript:page_logHistory()">로그인 기록 조회</a></li>
						<li><a class="small_menu" href="https://www.baobab858.com/jsp/admin/version.api">버전 업데이트</a></li>
						<li><a class="small_menu" href="#" onclick="addrConversion()">경위도 찾기</a></li>
						<li><a class="small_menu" href="#" onclick="checkServer()">점검 수정</a></li>
						<li><a class="small_menu" href="#" onclick="couponList()">쿠폰 관리</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div id="section">
			<h1>업체 상세 정보</h1>
			<h2>${info.CP_name}</h2>
			<p>${info.CP_intro}</p>
			<div id="banner">
				<ul>
				</ul>
			</div>
			<div id="infomation">
				<div id="kind">
					<h3>${info.CP_kind}, ${info.CP_type}</h3>
				</div>
				<div id="location">
					<p><b>${info.CP_address} ${info.CP_addr_details}</b>  (${info.longitude}), (${info.latitude})</p>
				</div>
				<div id="time">
				<%
					CPInfoVO vo = (CPInfoVO)request.getAttribute("info");
				%>
					<p><b><%=vo.getBusiness_start() %> ~ <%=vo.getBusiness_end() %>0</b></p>
					<p>휴무일 : <b>${fn:substring(info.close_day, 1, fn:length(info.close_day)-1)}</b></p>
					<p>주차공간 : <b>${info.parking}</b></p>
				</div>
				<div id="theme">
					<p>테마 1 : <b>${fn:substring(info.CP_Theme1, 1, fn:length(info.CP_Theme1)-1)}</b></p>
					<p>테마 2 : <b>${fn:substring(info.CP_Theme1, 1, fn:length(info.CP_Theme1)-1)}</b></p>
				</div>
				<div id="score">
					<p>누적 조회수 : <b>${info.CP_hits}</b></p>
					<p>금일 조회수 : <b>${info.cur_hits}</b></p>
					<p>콜수 : <b>${info.CP_calls}</b></p>
					<p>팬수 : <b>${poke}</b></p>
					<p>리뷰수 : <b>${info.CP_rev_num}</b></p>
				</div>
			</div>
		</div>
		<div id="second_section">
			<div class="menu_section">
				<h1>세트메뉴</h1>
				<table>
					<tr>
						<th>메뉴이미지</th>
						<th>메뉴명</th>
						<th>원가(원)</th>
						<th>할인가(원)</th>
						<th>옵션</th>
						<th>소개</th>
					</tr>
					<c:forEach var="item" items="${setMenu}" step="1" varStatus="status">
						<tr>
							<td width="210px" height="140px"><img id="menuImg" src="${item.menu_img}" 
							onerror="this.src='https://www.baobab858.com/resources/webImages/sample_img.jpg'" width="210px" height="140px"></td>
							<td>${item.menu_name}</td>
							<td>${item.menu_price}</td>
							<td>${item.menu_dis_price}</td>
							<td>${item.menu_option}</td>
							<td>${item.menu_detail}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="menu_section">
				<h1>메인메뉴</h1>
				<table>
					<tr>
						<th>메뉴이미지</th>
						<th>메뉴명</th>
						<th>원가(원)</th>
						<th>할인가(원)</th>
						<th>옵션</th>
						<th>소개</th>
					</tr>
					<c:forEach var="item" items="${mainMenu}" step="1" varStatus="status">
						<tr>
							<td width="210px" height="140px"><img id="menuImg" src="${item.menu_img}"
							onerror="this.src='https://www.baobab858.com/resources/webImages/sample_img.jpg'" width="210px" height="140px"></td>
							<td>${item.menu_name}</td>
							<td>${item.menu_price}</td>
							<td>${item.menu_dis_price}</td>
							<td>${item.menu_option}</td>
							<td>${item.menu_detail}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="menu_section">
				<h1>사이드메뉴</h1>
				<table>
					<tr>
						<th>메뉴이미지</th>
						<th>메뉴명</th>
						<th>원가(원)</th>
						<th>할인가(원)</th>
						<th>옵션</th>
						<th>소개</th>
					</tr>
					<c:forEach var="item" items="${sideMenu}" step="1" varStatus="status">
						<tr>
							<td width="210px" height="140px"><img id="menuImg" src="${item.menu_img}"
							onerror="this.src='https://www.baobab858.com/resources/webImages/sample_img.jpg'" width="210px" height="140px"></td>
							<td>${item.menu_name}</td>
							<td>${item.menu_price}</td>
							<td>${item.menu_dis_price}</td>
							<td>${item.menu_option}</td>
							<td>${item.menu_detail}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="menu_section">
				<h1>기타메뉴</h1>
				<table>
					<tr>
						<th>메뉴이미지</th>
						<th>메뉴명</th>
						<th>원가(원)</th>
						<th>할인가(원)</th>
						<th>옵션</th>
						<th>소개</th>
					</tr>
					<c:forEach var="item" items="${ectMenu}" step="1" varStatus="status">
						<tr>
							<td width="210px" height="140px"><img id="menuImg" src="${item.menu_img}"
							onerror="this.src='https://www.baobab858.com/resources/webImages/sample_img.jpg'" width="210px" height="140px"></td>
							<td>${item.menu_name}</td>
							<td>${item.menu_price}</td>
							<td>${item.menu_dis_price}</td>
							<td>${item.menu_option}</td>
							<td>${item.menu_detail}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="menu_section">
				<h1>주류/음료</h1>
				<table>
					<tr>
						<th>메뉴이미지</th>
						<th>메뉴명</th>
						<th>원가(원)</th>
						<th>할인가(원)</th>
						<th>옵션</th>
						<th>소개</th>
					</tr>
					<c:forEach var="item" items="${drinkMenu}" step="1" varStatus="status">
						<tr>
							<td width="210px" height="140px"><img id="menuImg" src="${item.menu_img}"
							onerror="this.src='https://www.baobab858.com/resources/webImages/sample_img.jpg'" width="210px" height="140px"></td>
							<td>${item.menu_name}</td>
							<td>${item.menu_price}</td>
							<td>${item.menu_dis_price}</td>
							<td>${item.menu_option}</td>
							<td>${item.menu_detail}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
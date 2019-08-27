<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="https://www.baobab858.com/resources/webImages/favicon.ico">
	<link href="<c:url value="https://www.baobab858.com/resources/css/artDefault.css" />" rel="stylesheet">
<link href="<c:url value="https://www.baobab858.com/resources/css/pushInsert.css" />" rel="stylesheet">
<title>바오밥 관리자</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="<c:url value="https://www.baobab858.com/resources/js/default.js"/>" type="text/javascript"/></script>
<script type="text/javascript">
window.onload = function(){
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
	}
}

$(function() {
	$('.content').keyup(function(e) {
		var content = $(this).val();
		$('#counter').html(content.length + '/300');
	});
	$('.content').keyup();
});

function send() {
	var form = document.getElementById('insert');
	form.submit();
}
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
						<li><a class="small_menu" href="#">푸시작성</a></li>
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
						<li><a class="small_menu" href="#" onclick="version()">버전 업데이트</a></li>
						<li><a class="small_menu" href="#" onclick="addrConversion()">경위도 찾기</a></li>
						<li><a class="small_menu" href="#" onclick="checkServer()">점검 수정</a></li>
						<li><a class="small_menu" href="#" onclick="couponList()">쿠폰 관리</a></li>
					</ul></li>
			</ul>
		</div>
		<div id="section">
			<div id="article">
				<div id="main_article">
					<div>
						<a href="https://www.baobab858.com/jsp/admin/main.api">
						<img src="https://www.baobab858.com/resources/webImages/logo.png" alt="logo" title="logo">
						</a>
					</div>
					<div id="admin_session">
						<h1><%=session.getAttribute("department") %></h1>
						<h3><%=session.getAttribute("name") %> <%=session.getAttribute("jobClass") %>님</h3>
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
				<h1>푸시작성</h1>
				<form id="insert" action="https://www.baobab858.com/jsp/admin/sendPush.api" method="post">
					<input type="text" name="title" placeholder=" 제목(20자 미만)"
						maxlength="20">
					<select name="push_div">
						<option value="" selected="selected">기타(메인화면)</option>
						<option value="[이벤트] ">이벤트(메인화면)</option>
					</select>
					<select name="read_div">
						<option value="전체" selected="selected">전체(비회원포함)</option>
						<option value="회원전체">회원전체</option>
						<option value="사장님">사장님</option>
						<option value="일반회원">일반회원</option>
						<option value="관리자">관리자</option>
					</select>
					<textarea class="content" name="message" cols="50" rows="16"
						style="resize: none" maxlength="300"
						placeholder=" 내용(300자 미만), ※이벤트 내용은 앱내 이벤트 페이지 완성 전까지 메인화면으로 이동합니다."></textarea>
					<span id="counter">###</span> <input type="button" value="작성완료"
						onclick="send()">
				</form>
			</div>
		</div>
	</div>
</body>
</html>
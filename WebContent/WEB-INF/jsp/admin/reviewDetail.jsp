<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<link href="<c:url value="https://www.baobab858.com/resources/css/artDefault.css" />" rel="stylesheet">
<script src="<c:url value="https://www.baobab858.com/resources/js/default.js"/>" type="text/javascript"/></script>
<link href="<c:url value="https://www.baobab858.com/resources/css/reviewDetail.css" />" rel="stylesheet">
<script type="text/javascript">
window.onload = function() {
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
	}
	scoreImg(${review.score});
}

function scoreImg(score) {
	var scoreDiv = document.getElementById('score');
	var text = '';
	for(i=0;i<score;i++){
		text += '<img src="https://www.baobab858.com/resources/webImages/star_p.png" align="center">';
	}
	for(i=0;i<5-score;i++){
		text += '<img src="https://www.baobab858.com/resources/webImages/star_n.png" align="center">';
	}

	scoreDiv.innerHTML = text;
}
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
						<li><a class="small_menu" href="#">로그인 기록 조회</a></li>
						<li><a class="small_menu" href="#" onclick="version()">버전 업데이트</a></li>
						<li><a class="small_menu" href="#" onclick="addrConversion()">경위도 찾기</a></li>
						<li><a class="small_menu" href="#" onclick="checkServer()">점검 수정</a></li>
						<li><a class="small_menu" href="#" onclick="couponList()">쿠폰 관리</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div id="section">
			<div id="article">
				<div id="main_article">
					<div>
						<a href="#"><img src="https://www.baobab858.com/resources/webImages/logo.png" alt="logo" title="logo"></a>
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
						<c:forEach var="item" items="${loginHistory}" step="1" varStatus="status">
							<p class="history">${item}</p>
						</c:forEach>
					</div>
				</div>
			</div>
			<div id="main_section">
				<h1>${review.CP_name}</h1>
				<div id="img_div">
					<img src="${review.img1}" align="center" onerror="javascript:this.style.display='none'">
					<img src="${review.img2}" align="center" onerror="javascript:this.style.display='none'">
					<img src="${review.img3}" align="center" onerror="javascript:this.style.display='none'">
					<img src="${review.img4}" align="center" onerror="javascript:this.style.display='none'">
				</div>
				<div id="user">
					<h2>${review.userPhoneNum}</h2>
					<div id="score">
					</div>
				</div>
				<div id="content">
					<p>${review.text}</p>
				</div>
				<div id="rev_info">
					<p>비밀번호 : ${review.review_pwd}</p><br>
					<p><fmt:formatDate value="${review.post_date}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
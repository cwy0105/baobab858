<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.baobab.m.vo.CpPushVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="https://www.baobab858.com/resources/css/artDefault.css" />" rel="stylesheet">
<link href="<c:url value="https://www.baobab858.com/resources/css/cpPushList.css" />" rel="stylesheet">
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<script src="<c:url value="https://www.baobab858.com/resources/js/default.js"/>" type="text/javascript"/></script>
<title>바오밥 관리자</title>
<script type="text/javascript">
window.onload = function(){
	makeIndex(1);
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
	}
}

function pageNum(btn){
	var id = btn.getAttribute('id');
	var listLen = ${fn:length(pushList)};
	var pageNum = document.getElementById('page_num').innerText;
	if(id == 'prev' && pageNum > 1){
		pageNum--;
	}else if(id == 'next' && (listLen/15) > 1 && pageNum < (listLen/15)){
		pageNum++;
	}
	document.getElementById('page_num').innerText = pageNum;
	
	makeIndex(pageNum);
}

function makeIndex(pageNum){
	var startIndex = ((pageNum - 1) * 15);
	var endIndex = (startIndex + 15);
	
	makeList(startIndex, endIndex);
}

function makeList(startIndex, endIndex){
	var pushList = [];
	var loop = 0;
	
	<%List<CpPushVO> pushList = (List<CpPushVO>) request.getAttribute("pushList");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (int i = 0; i < pushList.size(); i++) {%>
			pushList[loop] = {
				cpName: "<%=pushList.get(i).getCpName()%>",
				distance: "<%=String.valueOf(pushList.get(i).getRadius())%>",
				fan: "<%=String.valueOf(pushList.get(i).getFanEa())%>",
				normal: "<%=String.valueOf(pushList.get(i).getNormalEa())%>",
				title: "<%=pushList.get(i).getTitle().replace(System.getProperty("line.separator"), "")%>",
				date: "<%=format.format(pushList.get(i).getSendDate())%>",
				content: "<%=pushList.get(i).getMessage().replace(System.getProperty("line.separator"), "")%>"			
		};
		loop++;
	<%}%>
	var text =  '<tr>' + '<th>업체명</th>' + '<th>거리</th>' + '<th>팬 인원</th>' + '<th>일반 인원</th>' + '<th>제목</th>' + '<th>작성일</th>' + '</tr>';
	
	if(endIndex > pushList.length){
		endIndex = pushList.length;
	}
	
	for(i=startIndex;i<endIndex;i++){
		text += '<tr onclick="contentPopup(' + '\'' + pushList[i].title + '\', \'' + pushList[i].content + '\'' + ')">' + '<td>' + 
		pushList[i].cpName + '</td>' + '<td>' + pushList[i].distance + 'km' + '</td>' + '<td>' + pushList[i].fan + '명' + '</td>' + '<td>' + 
		pushList[i].normal + '명' + '</td>' + '<td>' + pushList[i].title + '</td>' + '<td>' + pushList[i].date + '</td>' + '</tr>';
	}
	
	document.getElementById('push_table').innerHTML = text;
}

function search(){
	var form = document.getElementById('search');
	form.submit();
}

function contentPopup(title, content) {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	window.open('', '푸시내용', 'width=500px, height=600px, toolbars=no, scrollbars=no, top=150px, left=600px');

	form.target = '푸시내용';
	form.action = 'https://www.baobab858.com/jsp/admin/pushDetail.api';
	form.method = 'post';

	param.push([ 'title', title ]);
	param.push([ 'content', content ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
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
			<div id="main_section">
				<h1>업체 푸시내역</h1>
				<div>
					<div>
						<div>
							<form id="search"
								action="https://www.baobab858.com/jsp/admin/cpPushList.api"
								method="post">
								<input type="text" name="searchWord" placeholder="제목/업체명" /> <input
									type="button" value="검색" onclick="search()" />
							</form>
						</div>
						<table id="push_table">
						</table>
						<div id="page_div">
							<button id="prev" onclick="pageNum(this)">◀</button>
							<a id="page_num">1</a>
							<button id="next" onclick="pageNum(this)">▶</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
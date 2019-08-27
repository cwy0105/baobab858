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
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<link href="<c:url value="https://www.baobab858.com/resources/css/artDefault.css" />" rel="stylesheet">
<link href="<c:url value="https://www.baobab858.com/resources/css/cp.css" />" rel="stylesheet">
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
	var listLen = ${fn:length(cpList)};
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
	var cpList = [];
	var loop = 0;
	
	<%List<CPInfoVO> cpList = (List<CPInfoVO>) request.getAttribute("cpList");
			for (int i = 0; i < cpList.size(); i++) {%>
		cpList[loop] = {
				cpName: "<%=cpList.get(i).getCP_name()%>",
				addr: "<%=cpList.get(i).getCP_address()%>",
				addrDetail: "<%=cpList.get(i).getCP_addr_details()%>",
				phone: "<%=cpList.get(i).getCP_phon()%>",
				kind: "<%=cpList.get(i).getCP_kind()%>"
		};
		loop++;
	<%}%>
	var text =  '<tr>' + '<th>업체명</th>' + '<th>주소</th>' + '<th>연락처</th>' + '<th>업종</th>' + '</tr>';
	
	if(endIndex > cpList.length){
		endIndex = cpList.length;
	}
	
	for(i=startIndex;i<endIndex;i++){
		text += '<tr onclick="showDetail(' + '\'' + cpList[i].cpName + '\'' + ')">' + '<td>' + cpList[i].cpName + '</td>' + '<td>' + cpList[i].addr + 
		' ' + cpList[i].addrDetail + '</td>' + '<td>' + cpList[i].phone + '</td>' + '<td>' + cpList[i].kind + '</td>' + '</tr>';
	}
	
	document.getElementById('cp_table').innerHTML = text;
}

function search(){
	var form = document.getElementById('search');
	form.submit();
}

function showDetail(cpName){
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();
	
	form.action = 'https://www.baobab858.com/jsp/admin/cpDetail.api';
	form.method = 'post';
	
	param.push(['cpName', cpName]);
	
	for(var i=0;i<param.length;i++){
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
						<li><a class="small_menu" href="https://www.baobab858.com/jsp/admin/noticeInput.api">공지사항 작성</a></li>
					</ul>
				</li>
				<li><a href="#" onclick="javascript:page_push();">푸시내역</a>
					<ul>
						<li><a class="small_menu" href="https://www.baobab858.com/jsp/admin/pushInput.api">푸시작성</a></li>
					</ul>
				</li>
				<li><a href="#" onclick="javascript:page_user();">회원정보</a></li>
				<li><a href="#">업체정보</a></li>
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
				<h1>업체정보</h1>
				<div>
					<div>
						<div>
							<form id="search"
								action="https://www.baobab858.com/jsp/admin/cp.api" method="post">
								<select name="kind">
									<option value="%%" selected="selected">전체 (업종)</option>
									<option value="%한식%">한식</option>
									<option value="%일식%">일식</option>
									<option value="%중식%">중식</option>
									<option value="%술집%">술집</option>
									<option value="%포장마차%">포장마차</option>
									<option value="%레스토랑%">레스토랑</option>
									<option value="%카페%">카페</option>
									<option value="%디저트%">디저트</option>
									<option value="%찜%">찜</option>
									<option value="%탕%">탕</option>
									<option value="%고기집%">고기집</option>
									<option value="%치킨%">치킨</option>
									<option value="%피자%">피자</option>
									<option value="%햄버거%">햄버거</option>
									<option value="%분식%">분식</option>
									<option value="%도시락%">도시락</option>
									<option value="%빵%">빵</option>
									<option value="%면%">면</option>
								</select> <input type="text" name="searchWord"
									placeholder="업체명/이메일/번호/주소" /> <input type="button" value="검색"
									onclick="search()" />
							</form>
						</div>
						<table id="cp_table">
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
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.baobab.m.vo.AdminVisitantVO"%>
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
<link href="<c:url value="https://www.baobab858.com/resources/css/visitant.css" />" rel="stylesheet">
<script src="<c:url value="https://www.baobab858.com/resources/js/default.js"/>" type="text/javascript"/></script>
<title>바오밥 관리자</title>
<script type="text/javascript">
var radio;

window.onload = function(){
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
	}
	
	setting();
	makeIndex(1);
}

function radioCheck(label) {
	var labels = document.getElementsByClassName('label');
	for(var i=0;i<labels.length;i++){
		labels[i].style.backgroundColor = 'white';
		labels[i].style.color = 'black';
	}
	label.style.backgroundColor = '#FF8224';
	label.style.color = 'white';
	
	radio = label.getAttribute('for');
	
	document.getElementById('visit_table').innerHTML = '';
	document.getElementById('page_num').innerText = '1';
	makeIndex(1);
}

function setting(){
	var visitDiv = "<%=request.getParameter("visitDiv") %>";
	var idName = '';
	if(visitDiv == '누적'){
		idName = 'cumulative';
	}else{
		idName = 'NonCumulative';
	}
	radio = idName;
	document.getElementById(idName).checked = true;
	
	var labels = document.getElementsByClassName('label');
	for(var i=0;i<labels.length;i++){
		if(labels[i].getAttribute('for') == idName){
			labels[i].style.backgroundColor = '#FF8224';
			labels[i].style.color = 'white';
		}
	}
	
	var divCode = "<%=request.getParameter("divCode") %>";
	for(var i=0;i<document.getElementById("divCode").options.length;i++){
		if(divCode == document.getElementById("divCode").options[i].value){
			document.getElementById("divCode").options[i].selected = true;
		}
	}	
}

function pageNum(btn){
	var id = btn.getAttribute('id');
	var listLen = 0;
	
	var radioBtn = document.getElementsByName('visitDiv');
	var radioValue = '';
	for(var i=0;i<radioBtn.length;i++){
		if(radioBtn[i].checked == true){
			radioValue = radioBtn[i].value;
		}
	}
	
	if(radioValue == '누적'){
		listLen = ${fn:length(visitsList)};
	}else{
		listLen = ${fn:length(visitList)};
	}
	
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
	var visitList = [];
	var loop = 0;
	
	if(radio == 'cumulative'){
		loop = 0;
		<%List<AdminVisitantVO> visitsList = (List<AdminVisitantVO>) request.getAttribute("visitsList");
		SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (int i = 0; i < visitsList.size(); i++) {%>
			visitList[loop] = {
				seqNum: "<%=String.valueOf(visitsList.get(i).getSeq_num())%>",
				email: "<%=visitsList.get(i).getEmail()%>",
				phone: "<%=visitsList.get(i).getUser_phone()%>",
				divCode: "<%=visitsList.get(i).getDiv_code()%>",
				cnt: "<%=String.valueOf(visitsList.get(i).getCnt())%>",
				date: "<%=formats.format(visitsList.get(i).getVisit_date())%>"
		};
		loop++;
	<%}%>
	}else if(radio == 'NonCumulative'){
		loop = 0;
		<%List<AdminVisitantVO> visitList = (List<AdminVisitantVO>) request.getAttribute("visitList");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (int i = 0; i < visitList.size(); i++) {%>
			visitList[loop] = {
				seqNum: "<%=String.valueOf(visitList.get(i).getSeq_num())%>",
				email: "<%=visitList.get(i).getEmail()%>",
				phone: "<%=visitList.get(i).getUser_phone()%>",
				divCode: "<%=visitList.get(i).getDiv_code()%>",
				cnt: "<%=String.valueOf(visitList.get(i).getCnt())%>",
				date: "<%=format.format(visitList.get(i).getVisit_date())%>"
		};
		loop++;
	<%}%>
	}
	
	var text =  '<tr>' + '<th>방문번호</th>' + '<th>이메일</th>' + '<th>사용자번호</th>' + '<th>권한</th>' + '<th>방문횟수</th>' + '<th>방문일</th>' + '</tr>';
	
	if(endIndex > visitList.length){
		endIndex = visitList.length;
	}
	
	for(var j=startIndex;j<endIndex;j++){
		text += '<tr>' + '<td>' + visitList[j].seqNum + '</td>' + '<td>' + nullCheck(visitList[j].email) + 
		'</td>' + '<td>' + visitList[j].phone + '</td>' + '<td>' + nullCheck(visitList[j].divCode) + '</td>' + '<td>' + visitList[j].cnt + '</td>' + 
		'<td>' + visitList[j].date + '</td>' + '</tr>';
	}
	
	document.getElementById('visit_table').innerHTML = text;
}

function search(){
	var form = document.getElementById('search');
	form.submit();
}

function nullCheck(str){
	if(str == null || str == undefined || str == 'null' || str.length <= 4){
		return "-";
	}else{
		return str;
	}
}

function numCheck(text){
	var str = text.value;
	if(isNan(str)){
		alert('숫자만 입력하세요.');
		text.value = str.substring(0, str.length - 1);
	}
}

function numTwoCheck(textatio){
	var sta = text.value;
	alert("ㅋㅋ내 엡략")
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
				<li><a href="#" onclick="javascript:page_cp();">업체정보</a></li>
				<li><a href="#">결제내역</a></li>
				<li><a href="#" onclick="javascript:page_review();">리뷰조회</a></li>
				<li><a href="#">기타</a>
					<ul>
						<li><a class="small_menu" href="#">방문자 조회</a></li>
						<li><a class="small_menu" href="#" onclick="javascript:page_search();">검색어 조회</a></li>
						<li><a class="small_menu" href="#" onclick="javascript:page_cpPush();">사장님 푸시 조회</a></li>
						<li><a class="small_menu" href="#" onclick="hitsUp()">당일 조회수 강제 초기화</a></li>
						<li><a class="small_menu" href="#" onclick="javascript:page_logHistory()">로그인 기록 조회</a></li>
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
				<h1>방문자 조회</h1>
				<div>
					<div>
						<div>
							<form id="search" action="https://www.baobab858.com/jsp/admin/visitant.api" method="post">
								<div>
									<label class="label" for="cumulative" onclick="radioCheck(this)">누적</label>
									<label class="label" for="NonCumulative" onclick="radioCheck(this)">비누적</label>
								</div>
								<input type="radio" id="cumulative" name="visitDiv" value="누적">
								<input type="radio" id="NonCumulative" name="visitDiv" value="비누적"><br/>
								<select id="divCode" name="divCode">
									<option value="">전체(권한)</option>
									<option value="c">사장님</option>
									<option value="u">일반회원</option>
									<option value="a">관리자</option>
								</select>
								<input type="number" name="visitNum" placeholder="방문회수" value="<%=request.getParameter("visitNum") %>">
								<input type="date" name="startDate" value="<%=request.getParameter("startDate") %>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~
								<input type="date" name="endDate" value="<%=request.getParameter("endDate") %>">
								<input type="text" name="searchWord" placeholder="사용자번호" value="<%=request.getParameter("searchWord") %>" onkeypress="numCheck(this)" onblur="numCheck(this)">
								<input type="button" value="검색" onclick="search()" />
							</form>
						</div>
						<table id="visit_table">
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
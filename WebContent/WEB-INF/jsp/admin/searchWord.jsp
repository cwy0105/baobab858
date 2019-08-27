<%@page import="com.baobab.m.vo.RankVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<link href="<c:url value="https://www.baobab858.com/resources/css/default.css" />" rel="stylesheet">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="<c:url value="https://www.baobab858.com/resources/js/default.js"/>" type="text/javascript"/></script>
<link href="<c:url value="https://www.baobab858.com/resources/css/searchWord.css" />" rel="stylesheet">
<script type="text/javascript">
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
	var data = google.visualization.arrayToDataTable([
			['Task', 'Search Time'],
			["<%=((List<RankVO>)request.getAttribute("kindList")).get(0).getThing() %>", <%=((List<RankVO>)request.getAttribute("kindList")).get(0).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("kindList")).get(1).getThing() %>", <%=((List<RankVO>)request.getAttribute("kindList")).get(1).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("kindList")).get(2).getThing() %>", <%=((List<RankVO>)request.getAttribute("kindList")).get(2).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("kindList")).get(3).getThing() %>", <%=((List<RankVO>)request.getAttribute("kindList")).get(3).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("kindList")).get(4).getThing() %>", <%=((List<RankVO>)request.getAttribute("kindList")).get(4).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("kindList")).get(5).getThing() %>", <%=((List<RankVO>)request.getAttribute("kindList")).get(5).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("kindList")).get(6).getThing() %>", <%=((List<RankVO>)request.getAttribute("kindList")).get(6).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("kindList")).get(7).getThing() %>", <%=((List<RankVO>)request.getAttribute("kindList")).get(7).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("kindList")).get(8).getThing() %>", <%=((List<RankVO>)request.getAttribute("kindList")).get(8).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("kindList")).get(9).getThing() %>", <%=((List<RankVO>)request.getAttribute("kindList")).get(9).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("kindList")).get(10).getThing() %>", <%=((List<RankVO>)request.getAttribute("kindList")).get(10).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("kindList")).get(11).getThing() %>", <%=((List<RankVO>)request.getAttribute("kindList")).get(11).getCnt() %>]
		]);

	var options = {
		title: '카테고리 검색율',
	}

	var chart = new google.visualization.PieChart(document.getElementById('piechart'));
	chart.draw(data, options);
}

google.charts.setOnLoadCallback(drawChart2);
function drawChart2() {
	var data = google.visualization.arrayToDataTable([
	        ["Element", "Density"],
	        ["<%=((List<RankVO>)request.getAttribute("wordList")).get(0).getThing() %>", <%=((List<RankVO>)request.getAttribute("wordList")).get(0).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("wordList")).get(1).getThing() %>", <%=((List<RankVO>)request.getAttribute("wordList")).get(1).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("wordList")).get(2).getThing() %>", <%=((List<RankVO>)request.getAttribute("wordList")).get(2).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("wordList")).get(3).getThing() %>", <%=((List<RankVO>)request.getAttribute("wordList")).get(3).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("wordList")).get(4).getThing() %>", <%=((List<RankVO>)request.getAttribute("wordList")).get(4).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("wordList")).get(5).getThing() %>", <%=((List<RankVO>)request.getAttribute("wordList")).get(5).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("wordList")).get(6).getThing() %>", <%=((List<RankVO>)request.getAttribute("wordList")).get(6).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("wordList")).get(7).getThing() %>", <%=((List<RankVO>)request.getAttribute("wordList")).get(7).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("wordList")).get(8).getThing() %>", <%=((List<RankVO>)request.getAttribute("wordList")).get(8).getCnt() %>],
			["<%=((List<RankVO>)request.getAttribute("wordList")).get(9).getThing() %>", <%=((List<RankVO>)request.getAttribute("wordList")).get(9).getCnt() %>]
        ]);

	var view = new google.visualization.DataView(data);
	view.setColumns([0, 1, {
		calc: "stringify",
		sourceColumn: 1,
		type: "string",
		role: "annotation"
	}]);

	var options = {
	    title: "검색어 TOP10(검색된 횟수)",
	    width: {width: "100%"},
	    height: {height: "100vh"},
	    bar: {groupWidth: "95%"},
	    legend: { position: "none" },
	};

	var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
	chart.draw(view, options);
}

window.onload = function(){
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
	}
	
	makeTables(1);
	makePageTag();
}

function makePageTag(){
	var listLen = ${fn:length(wordList)};
	var pageNum = 0;
	if(listLen % 100 > 0){
		pageNum = listLen / 100 + 1;
	}else{
		pageNum = listLen / 100;
	}
	
	var tagText = '';
	for(i=1;i<=pageNum;i++){
		tagText += '<a href="#" onclick="makePage(this)">' + i + '</a>';
	}
	document.getElementById('paging').innerHTML = tagText;
}

function makePage(pageTag){
	var page = pageTag.innerHTML * 1;
	makeTables(page);
}

function makeTables(page){
	document.getElementById('tables').innerHTML = '';
	document.getElementById('tables').innerHTML += makeOutSide(page);
}

function makeOutSide(page){
	var text = '';
	for(var i=page;i<page+10;i++){
		console.log("전" + i);
		if(i > page){
			var num = i + ((i - 1) * 9) + ((page - 1) * 100);
			text += makeInside(num);
			console.log("아닐때" + i);
		}else{
			var num = page + ((page - 1) * 100) - (page - 1);
			text += makeInside(num);
			console.log("같을때" + i);
		}
		console.log("후" + i);
	}
	console.log(text);
	return text;
}

function makeInside(index){
	var th = '<tr>' + '<th>no</th>' + '<th>word</th>' + '<th>cnt</th>' + '</tr>';
	var text = '';
	
	var wordList = [];
	var loop = 0;
	<%
	List<RankVO> wordList = (List<RankVO>)request.getAttribute("wordList");
	for(int i=0;i<wordList.size();i++){
	%>
		wordList[loop] = {
			word: "<%=wordList.get(i).getThing() %>",
			count: "<%=wordList.get(i).getCnt() %>",
			rank: "<%=i+1 %>"
		};
		loop++;
	<%
	}
	%>
	for(i=index-1;i<index+9;i++){
		if(wordList[i] == undefined || wordList[i] == null){
			text += '<tr>' + '<td>' + '-' + '</td>' + '<td>' + '-' + '</td>' + '<td>' + '-' + '</td>' + '</tr>';
		}else{
			text += '<tr>' + '<td>' + wordList[i].rank + '</td>' + '<td>' + makeString(wordList[i].word) + '</td>' + '<td>' + wordList[i].count + '</td>' + '</tr>';
		}
	}
	return '<table>' + th + text + '</table>';
}

function makeString(str){
	if(str.length > 20){
		return str.substring(0, 20) + "..";
	}else{
		return str;
	}
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
						<li><a class="small_menu" href="#">검색어 조회</a></li>
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
			<div>
				<div id="table">
					<h1>검색어 순위</h1>
					<div id="tables">
					</div>
				</div>
				<div id="paging">
				</div>
				<div id="chart">
					<div id="piechart" style="width: 50%; height: 54vh;"></div>
    				<div id="columnchart_values" style="width: 50%; height: 54vh;"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@page import="com.baobab.m.vo.UserLocationVO"%>
<%@page import="com.baobab.m.service.AESUtil"%>
<%@page import="com.baobab.m.vo.ReviewVO"%>
<%@page import="com.baobab.m.vo.CallHistoryVO"%>
<%@page import="com.baobab.m.vo.PokeVO"%>
<%@page import="com.baobab.m.vo.UserHistoryVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.baobab.m.vo.PaymentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<link href="<c:url value="https://www.baobab858.com/resources/css/default.css" />" rel="stylesheet">
<link href="<c:url value="https://www.baobab858.com/resources/css/userDetail.css" />" rel="stylesheet">
<script src="<c:url value="https://www.baobab858.com/resources/js/default.js"/>" type="text/javascript"/></script>
<title>바오밥 관리자</title>
<script type="text/javascript">
	var payList = [];
	var hisList = [];
	var pokeList = [];
	var callList = [];
	var revList = [];
	
	window.onload = function makeList(){
		var id = "<%=session.getAttribute("id")%>";
		if (id == "null") {
			window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
		}
		
		var payLoop = 0;
		var hisLoop = 0;
		var pokeLoop = 0;
		var callLoop = 0;
		var revLoop = 0;
		
		<%
		List<PaymentVO> payList = (List<PaymentVO>)request.getAttribute("payment");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i=0;i<payList.size();i++){
		%>
			payList[payLoop] = {
					cpName: "<%=payList.get(i).getCp_name() %>",
					goods: "<%=payList.get(i).getGoods() %>",
					pay: "<%=payList.get(i).getTotal_dis_price() %>",
					date: "<%=format.format(payList.get(i).getPay_date()) %>"
			};
			payLoop++;
		<%
		}
		%>
		
		<%
		List<UserHistoryVO> hisList = (List<UserHistoryVO>)request.getAttribute("history");
		for(int i=0;i<hisList.size();i++){
		%>
			hisList[hisLoop] = {
					code: "<%=hisList.get(i).getDiv_code() %>",
					date: "<%=format.format(hisList.get(i).getChange_date()) %>"
			};
			hisLoop++;
		<%
		}
		%>
		
		<%
		List<PokeVO> pokeList = (List<PokeVO>)request.getAttribute("poke");
		for(int i=0;i<pokeList.size();i++){
		%>
			pokeList[pokeLoop] = {
					cpName: "<%=pokeList.get(i).getCp_name() %>",
					addr: "<%=pokeList.get(i).getCp_address() %>",
					code: "<%=pokeList.get(i).getDiv_code() %>",
					date: "<%=format.format(pokeList.get(i).getPoke_date()) %>"
			};
			pokeLoop++;
		<%
		}
		%>
		
		<%
		List<CallHistoryVO> callList = (List<CallHistoryVO>)request.getAttribute("callHistory");
		for(int i=0;i<callList.size();i++){
		%>
			callList[callLoop] = {
					cpName: "<%=callList.get(i).getCp_name() %>",
					addr: "<%=callList.get(i).getCp_address() %>",
					code: "<%=callList.get(i).getCp_div() %>",
					date: "<%=format.format(callList.get(i).getCall_date()) %>"
			};
			callLoop++;
		<%
		}
		%>
		
		<%
		List<ReviewVO> revList = (List<ReviewVO>)request.getAttribute("review");
		for(int i=0;i<revList.size();i++){
		%>
			revList[revLoop] = {
					cpName: "<%=revList.get(i).getCP_name() %>",
					score: "<%=revList.get(i).getScore() %>",
					text: "<%=revList.get(i).getText() %>",
					code: "<%=revList.get(i).getDiv_code() %>",
					date: "<%=format.format(revList.get(i).getPost_date()) %>"
			};
			revLoop++;
		<%
		}
		%>
	}

	function setMore(btn) {
		var table;
		var strong;
		var text = '';
		var id = btn.id;
		
		if (id == 'payBtn') {
			table = document.getElementById('payTable');
			strong = document.getElementById('payMorebtn');
			if(payList.length > 10){
				for(i=11;i<payList.length;i++){
					text += '<tr>' + '<td>' + payList[i].cpName + '</td>' + '<td>' + payList[i].goods + '</td>' + '<td>' + payList[i].pay + '</td>'
					+ '<td>' + payList[i].date + '</td>' + '</tr>';	
				}	
			}
		} else if (id == 'hisBtn') {
			table = document.getElementById('hisTable');
			strong = document.getElementById('hisMorebtn');
			if(hisList.length > 10){
				for(i=11;i<hisList.length;i++){
					text += '<tr>' + '<td>' + hisList[i].code + '</td>' + '<td>' + hisList[i].date + '</td>' + '</tr>';	
				}	
			}
		} else if (id == 'pokeBtn') {
			table = document.getElementById('pokeTable');
			strong = document.getElementById('pokeMorebtn');
			if(pokeList.length > 10){
				for(i=11;i<pokeList.length;i++){
					text += '<tr>' + '<td>' + pokeList[i].cpName + '</td>' + '<td>' + pokeList[i].addr + '</td>' + '<td>' + pokeList[i].code + '</td>'
					 + '<td>' + pokeList[i].date + '</td>' + '</tr>';	
				}	
			}
		} else if (id == 'callBtn') {
			table = document.getElementById('callTable');
			strong = document.getElementById('callMorebtn');
			if(callList.length > 10){
				for(i=11;i<callList.length;i++){
					text += '<tr>' + '<td>' + callList[i].cpName + '</td>' + '<td>' + callList[i].addr + '</td>' + '<td>' + callList[i].code + '</td>'
					 + '<td>' + callList[i].date + '</td>' + '</tr>';	
				}	
			}
		} else if (id == 'revBtn') {
			table = document.getElementById('revTable');
			strong = document.getElementById('revMorebtn');
			if(revList.length > 10){
				for(i=11;i<revList.length;i++){
					text += '<tr>' + '<td>' + revList[i].cpName + '</td>' + '<td>' + revList[i].score + '</td>' + '<td>' + revList[i].text + '</td>'
					 + '<td>' + revList[i].code + '</td>' + '<td>' + revList[i].date + '</td>' + '</tr>';	
				}	
			}
		}
		more(table, strong, text);
	}

	function more(table, strong, text) {
		if (strong.innerHTML == '더보기') {
			table.innerHTML += '<div></div>' + text;
			strong.innerHTML = '접기';
		} else if (strong.innerHTML == '접기') {
			var sampleText = table.innerHTML.split('<div></div>')[0];
			table.innerHTML = sampleText + '<div></div>';
			strong.innerHTML = '더보기';
		}
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
			<div id="section_header">
				<h1>회원 상세 정보</h1>
			</div>
			<div id="section_body">
				<div id="location">
					<table>
						<tr>
							<th>경위도</th>
							<%
								AESUtil aes = new AESUtil();
								String addr = ((UserLocationVO)request.getAttribute("location")).getAddr();
								String decAddr = "위치 추적 불가";
								if(addr != null){
									decAddr = aes.decrypt(addr);
								}
								String lat = ((UserLocationVO)request.getAttribute("location")).getLatitude();
								String decLat = "위치 추적 불가";
								if(lat != null){
									decLat = aes.decrypt(lat);
								}
								String lon = ((UserLocationVO)request.getAttribute("location")).getLongitude();
								String decLon = "위치 추적 불가";
								if(addr != null){
									decLon = aes.decrypt(lon);
								}
							%>
							<td><%=decLat %>, <%=decLon %></td>
							<th>주소</th>
							<td><%=decAddr %></td>
						</tr>
					</table>
				</div>
				<h2>결제내역</h2>
				<div id="payment">
					<table id='payTable'>
						<tr>
							<th>업체명</th>
							<th>상품</th>
							<th>결제금액</th>
							<th>결제날짜</th>
						</tr>
						<c:forEach	var="pay" items="${payment}" begin="0" end="10" step="1" varStatus="status">
							<tr>
								<td>${pay.cp_name}</td>
								<td>${pay.goods}</td>
								<td>${pay.total_dis_price}</td>
								<td><fmt:formatDate value="${pay.pay_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
						</c:forEach>
					</table>
					<button id="payBtn" onclick="setMore(this)">
						<strong id="payMorebtn">더보기</strong>
					</button>
				</div>
				<h2>히스토리</h2>
				<div id="history">
					<table id="hisTable">
						<tr>
							<th>권한코드</th>
							<th>변경날짜</th>
						</tr>
						<c:forEach	var="his" items="${history}" begin="0" end="10" step="1" varStatus="status">
							<tr>
								<td>${his.div_code}</td>
								<td><fmt:formatDate value="${his.change_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
						</c:forEach>
					</table>
					<button id="hisBtn" onclick="setMore(this)">
						<strong id="hisMorebtn">더보기</strong>
					</button>
				</div>
				<h2>찜하기 내역</h2>
				<div id="poke">
					<table id="pokeTable">
						<tr>
							<th>업체명</th>
							<th>업체주소</th>
							<th>업체구분</th>
							<th>찜한 날짜</th>
						</tr>
						<c:forEach	var="poke" items="${poke}" begin="0" end="10" step="1" varStatus="status">
							<tr>
								<td>${poke.cp_name}</td>
								<td>${poke.cp_address}</td>
								<td>${poke.div_code}</td>
								<td><fmt:formatDate value="${poke.poke_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
						</c:forEach>
					</table>
					<button id="pokeBtn" onclick="setMore(this)">
						<strong id="pokeMorebtn">더보기</strong>
					</button>
				</div>
				<h2>전화내역</h2>
				<div id="callHistory">
					<table id="callTable">
						<tr>
							<th>업체명</th>
							<th>업체주소</th>
							<th>업체구분</th>
							<th>통화 날짜</th>
						</tr>
						<c:forEach	var="call" items="${callHistory}" begin="0" end="10" step="1" varStatus="status">
							<tr>
								<td>${call.cp_name}</td>
								<td>${call.cp_address}</td>
								<td>${call.cp_div}</td>
								<td><fmt:formatDate value="${call.call_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
						</c:forEach>
					</table>
					<button id="callBtn" onclick="setMore(this)">
						<strong id="callMorebtn">더보기</strong>
					</button>
				</div>
				<h2>리뷰내역</h2>
				<div id="review">
					<table id="revTable">
						<tr>
							<th>업체명</th>
							<th>평점</th>
							<th>내용</th>
							<th>업체구분</th>
							<th>글쓴 날짜</th>
						</tr>
						<c:forEach	var="rev" items="${review}" begin="0" end="10" step="1" varStatus="status">
							<tr>
								<td>${rev.CP_name}</td>
								<td>${rev.score}</td>
								<td>${rev.text}</td>
								<td>${rev.div_code}</td>
								<td><fmt:formatDate value="${rev.post_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
						</c:forEach>
					</table>
					<button id="revBtn" onclick="setMore(this)">
						<strong id="revMorebtn">더보기</strong>
					</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="kr">
<head>
	<title>바오밥</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="<c:url value="https://www.baobab858.com/resources/js/index.js"/>" type="text/javascript"></script>
	<link href="<c:url value="https://www.baobab858.com/resources/css/index.css" />" rel="stylesheet">
	<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
	<script type="text/javascript">
		<%
			System.out.println("접속됨");
		%>
		window.location.replace("https://wedaehanbaobab.com");
	</script>
</head>
<body>
	<div id="allView">
		<div>
			<header class="section">
				<img id="main_img" src="https://www.baobab858.com/resources/webImages/main.png" alt="메인" title="메인이미지">
			</header>
		</div>
		<div>
			<section class="section">
				<img id="first_main" src="https://www.baobab858.com/resources/webImages/10.png" alt="첫번째메인" title="첫번째메인">
				<div class="slide_div" id="slide_one">
					<img class="slide_img1" src="https://www.baobab858.com/resources/webImages/15.png" alt="첫번째" title="1">
					<img class="slide_img1" src="https://www.baobab858.com/resources/webImages/16.png" alt="첫번째" title="2">
					<img class="slide_img1" src="https://www.baobab858.com/resources/webImages/17.png" alt="첫번째" title="3">
				</div>
			</section>
			<section class="section">
				<img id="second_main" src="https://www.baobab858.com/resources/webImages/7-1.png" alt="두번째메인" title="두번째메인">
				<div class="slide_div" id="slide_one">
					<img class="slide_img2" src="https://www.baobab858.com/resources/webImages/3.png" alt="두번째" title="1">
					<img class="slide_img2" src="https://www.baobab858.com/resources/webImages/4.png" alt="두번째" title="2">
					<img class="slide_img2" src="https://www.baobab858.com/resources/webImages/6.png" alt="두번째" title="3">
				</div>
			</section class="section">
			<section>
				<img id="third_main" src="https://www.baobab858.com/resources/webImages/21.png" alt="세번째메인" title="세번째메인">
				<div class="slide_div" id="slide_one">
					<img class="slide_img3" src="https://www.baobab858.com/resources/webImages/18.png" alt="세번째" title="1">
					<img class="slide_img3" src="https://www.baobab858.com/resources/webImages/19.png" alt="세번째" title="2">
					<img class="slide_img3" src="https://www.baobab858.com/resources/webImages/20.png" alt="세번째" title="3">
				</div>
			</section>
			<section class="section">
				<img id="fourth_main" src="https://www.baobab858.com/resources/webImages/9.png" alt="네번째메인" title="네번째메인">
				<div class="slide_div" id="slide_one">
					<img class="slide_img4" src="https://www.baobab858.com/resources/webImages/12.png" alt="네번째" title="1">
					<img class="slide_img4" src="https://www.baobab858.com/resources/webImages/13.png" alt="네번째" title="2">
					<img class="slide_img4" src="https://www.baobab858.com/resources/webImages/14.png" alt="네번째" title="3">
				</div>
			</section>
			<section class="section">
				<img id="fifth_main" src="https://www.baobab858.com/resources/webImages/11.png" alt="다섯번째메인" title="다섯번째메인">
			</section>
		</div>
		<div>
			<footer class="section">
				<div id="footer">
					<div>
						<h1>바오밥</h1>
						<p>주소 : 경기도 용인시 기흥구 동백3로 11번길 33, 801-107호</p>
						<p>대표 : 강병진</p>
						<p>이메일 : baobab@naver.com</p>
						<p>고객문의 : 010-9793-4005</p>
						<p>사업자등록번호 : 705-06-01144</p>
						<p>바오밥은 통신판매중개자이며 통신판매의 당사자가 아닙니다. 따라서 상품/거래정보 및 거래와 관련하여 바오밥에 등록된 판매자의 고의 또는 과실로 소비자에게 발생하는 손해에 대해 주식회사 위대한 컴퍼니는 책임을 지지 않습니다. 상품 및 거래에 관하여 보다 정확한 정보는 해당 판매자 에게 직접 확인 하여 주시기 바랍니다.</p>
						<p>Copyright BAOBAB. All Rights Reserved.</p>
					</div>
				</div>
			</footer>
		</div>
	</div>
</body>
</html>
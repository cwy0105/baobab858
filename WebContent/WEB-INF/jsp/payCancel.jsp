<%@page import="com.inicis.inipay.INIpay50"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("euc-kr");

String payCode = request.getParameter("payCode");
String cancelRsUrl = "";

if(payCode.equals("product")){
	cancelRsUrl = "https://baobab858.com/jsp/payCancelRs.api";
}else if(payCode.equals("push")){
	cancelRsUrl = "https://baobab858.com/jsp/pushPayCancelRs.api";
}else if(payCode.equals("coupon")){
	cancelRsUrl = "https://baobab858.com/jsp/CounponPayCancelRs.api";
}


/***************************************
* 1. INIpay 클래스의 인스턴스 생성 *
***************************************/
INIpay50 inipay = new INIpay50();

/*********************
* 2. 취소 정보 설정 *
*********************/
inipay.SetField("inipayhome", request.getParameter("inipayhome"));		// INIpay50 절대경로 (key / log 디렉토리)
inipay.SetField("debug", request.getParameter("debug"));								// 로그모드  (true / false)
inipay.SetField("type", request.getParameter("type"));								// type (고정)
inipay.SetField("crypto", request.getParameter("crypto"));						    // 암복호화모듈 (고정)

inipay.SetField("mid", request.getParameter("mid") );			// 상점아이디
inipay.SetField("admin", request.getParameter("admin"));								// 키파일 비밀번호

inipay.SetField("tid", request.getParameter("tid") );
inipay.SetField("cancelmsg", request.getParameter("msg") );
inipay.SetField("cancelreason", request.getParameter("cancelreason") );
String orderNum = request.getParameter("orderNum");

/****************
* 3. 취소 요청 *
****************/
inipay.startAction();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>바오밥 결제취소</title>
<script type="text/javascript">
	window.onload = function cancelComplete(){
		document.getElementById("cancelResult").submit();
	}
</script>
</head>
<body>
	<form id="cancelResult" name="cancelResult" action="<%=cancelRsUrl %>" method="post">
		<input type="hidden" name="rsCode" value="<%=inipay.GetResult("ResultCode") %>" />
		<input type="hidden" name="rsMsg" value="<%=inipay.GetResult("ResultMsg") %>" />
		<input type="hidden" name="tid" value="<%=request.getParameter("tid") %>" />
		<input type="hidden" name="oid" value="<%=orderNum %>" />
		<input type="hidden" name="canDate" value="<%=inipay.GetResult("CancelDate") %>" />
		<input type="hidden" name="canTime" value="<%=inipay.GetResult("CancelTime") %>" />
		<input type="hidden" name="CSHR_CanNum" value="<%=inipay.GetResult("CSHR_CancelNum") %>" />
	</form>
</body>
</html>
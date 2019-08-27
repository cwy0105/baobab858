<%@page import="com.baobab.m.vo.PaymentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<% 
	StringBuffer sb = new StringBuffer(request.getParameter("userPhone"));
	sb.insert(3, "-");
	sb.insert(8, "-");
	String phoneNum = sb.toString();
	String payDiv;
	
	String payCode = request.getParameter("payCode");
// 	String nextUrl = "";
// 	String notiUrl = "";
// 	String rtnUrl = "";
	
	//실서버때는 ip 회사 도메인으로 바꿔야함 
// 	if(payCode.equals("coupon")){
// 		 nextUrl = "http://192.168.0.12/baobab/jsp/payNext.api";
// 		 notiUrl = "http://192.168.0.12/baobab/jsp/payNoti.api";
// 		 rtnUrl = "http://192.168.0.12/baobab/jsp/payReturn.api";
// 	}else{
// 		nextUrl = "https://www.baobab858.com/jsp/payNext.api";
// 		notiUrl = "https://www.baobab858.com/jsp/payNoti.api";
// 		rtnUrl = "https://www.baobab858.com/jsp/payReturn.api";
// 	}
%>
<script type="text/javascript">
	function formSubmit(){
		var reserved = "apprun_check=Y&useescrow=Y&below1000=Y&";
		var payDiv = document.getElementsByName("payDiv");
		var payStr;
		for(var i=0;i<payDiv.length;i++){
			if(payDiv[i].checked){
				payStr = payDiv[i].value;
				if(i == 0){
					reserved += "twotrs_isp=Y&block_isp=Y&twotrs_isp_noti=N&cp_yn=";
					var cp = document.getElementsByName("cardPoint");
					for(var j=0;j<cp.length;j++){
						if(cp[j].checked){
							reserved += cp[j].value;
						}
					}
					<%payDiv = "card"; %>
				}else if(i == 1){
					reserved += "vbank_receipt=";
					var cr = document.getElementsByName("cashReceipt");
					for(var j=0;j<cr.length;j++){
						if(cr[j].checked){
							reserved += cr[j].value;
						}
					}
					<%payDiv = "vbank"; %>
				}else if(i == 2){
					reserved += "hpp_corp=";
					var hr = document.getElementsByName("hppCorpDiv");
					for(var j=0;j<hr.length;j++){
						if(hr[j].checked){
							reserved += hr[j].value;
						}
					}
					<%payDiv = "mobile"; %>
				}
			}
		}
		document.getElementById("reserved").value = reserved;
		var path = "https://mobile.inicis.com:8443/smart/" + payStr;
		var form = document.getElementById("form1");
		form.setAttribute("action", path);
		document.getElementById("form1").submit();
		return payStr;
	}

	function emulAcceptCharset(form){
		if(form.canHaveHTML){
			document.charset = form.accept-charset;
		}
		return true;
	}

	window.onload = function cardPay(){/* 
		for(var i=0;i<=36;i++){
			if(i<10){
				var optionTxt = "<option value='0" + i + "'/>";
				document.getElementById("number").innerHTML += optionTxt;
			}else{
				var optionTxt = "<option value='" + i + "'/>";
				document.getElementById("number").innerHTML += optionTxt;
			}
		} */
		
		formSubmit();
	}
</script>
<style type="text/css">
	section{
		display : none;
	}
</style>
<title>바오밥결제</title>
</head>
<body>
	<div id="allView">
		<section>
			<div id="secDiv">
				<form id="form1" name="form1" accept-charset="euc-kr" onsubmit="return validate(this) && emulAcceptCharset(this)" method="post">
					<div class="payDivDiv">
						<input type="radio" class="payDay" name="payDiv" value="wcard/" checked="checked" id="wcard" onclick="setCard()"/>
						<label for="wcard">신용카드</label>
					</div>
					<div class="payDivDiv">
						<!-- <input type="radio" class="payDay" name="payDiv" value="vbank/" id="vbank" onclick="setBanks()"/>
						<label for="vbank">가상계좌</label> -->
						<!-- <input type="radio" class="payDay" name="payDiv" value="mobile/" id="mobile" onclick="setMobile()"/>
						<label for="mobile">휴대폰결제</label> -->
					</div>
					<input type="hidden" name="P_GOODS" value="<%=request.getParameter("goods") %>" /> 
					<input type="hidden" name="P_MID" value="INIpayTest" />
					<input type="hidden" name="P_AMT" value="<%=request.getParameter("disPrice") %>" /> 
					<input type="hidden" name="P_OID" value="<%=request.getParameter("orderNum") %>"/>
					<input type="hidden" name="P_NOTI" value="<%=request.getParameter("orderNum") %>,<%=payDiv %>"/>
					<input type="hidden" name="P_MOBILE" value="<%=phoneNum %>"/>
					<input type="hidden" name="P_EMAIL" value="<%=request.getParameter("email") %>" /><br/>
					<input type="hidden" name="P_NEXT_URL" value="<%="https://www.baobab858.com/jsp/payNext.api" %>" />
					<input type="hidden" name="P_NOTI_URL" value="<%="https://www.baobab858.com/jsp/payNext.api" %>" />
					<input type="hidden" name="P_RETURN_URL" value="<%="https://www.baobab858.com/jsp/payReturn.api" %>" />
					<input type="hidden" name="P_CHARSET" value="utf8" />
					<input type="hidden" name="P_HPP_METHOD" value="1" />
					<!-- <input type="text" placeholder="이름" name="P_UNAME"/>
					<input id="selNumber" type="number" list="number" name="P_QUOTABASE" placeholder="할부개월"/>
					<datalist id="number">
					</datalist>
					<div id="pointDiv">
						<input type="radio" name="cardPoint" class="cardPoint" id="pointY" value="Y">
						<label for="pointY">포인트 사용</label>
						<input type="radio" name="cardPoint" class="cardPoint" id="pointN" value="N">
						<label for="pointN">포인트 미사용</label>
					</div>
					<div id="receiptDiv">
						<input type="radio" name="cashReceipt" class="cashReceipt" id="receiptY" value="Y">
						<label for="receiptY">현금영수증 발행</label>
						<input type="radio" name="cashReceipt" class="cashReceipt" id="receiptN" value="N">
						<label for="receiptN">현금영수증 미발행</label>
					</div>
					<div id="hppCorpDiv">
						<input type="radio" name="hppCorpDiv" class="hppCorpDiv" id="skt" value="SKT">
						<label for="skt">SKT</label>
						<input type="radio" name="hppCorpDiv" class="hppCorpDiv" id="ktf" value="KTF">
						<label for="ktf">KTF</label>
						<input type="radio" name="hppCorpDiv" class="hppCorpDiv" id="lgt" value="LGT">
						<label for="lgt">LGT</label>
					</div> -->
					<input type="hidden" name="P_RESERVED" id="reserved">
					<input type="button" onclick="formSubmit()" value="확인"/>
				</form>
			</div>
		</section>
	</div>
</body>
</html>
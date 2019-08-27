<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>바오밥 관리자</title>
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<script type="text/javascript">
window.onload = function result(){
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
	}
	
	var result = <%=Integer.parseInt(request.getAttribute("result").toString())%>
	if(result <= 0){
		alert("푸시를 받을 수 있는 유저가 존재하지 않거나 보내는중 오류가 발생하였습니다. 다시 시도해 주십시오.");
		history.back();
	}else{
		var form = document.createElement('form');
		var param = new Array();
		var input = new Array();
		
		form.action = 'https://www.baobab858.com/jsp/admin/pushList.api';
		form.method = 'post';
		
		param.push(['push_div', '']);
		param.push(['searchWord', '']);
		
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
}
</script>
</head>
<body>

</body>
</html>
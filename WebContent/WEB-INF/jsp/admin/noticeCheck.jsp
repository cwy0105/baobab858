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
	if(result != 0){
		alert("중복된 제목입니다. 제목을 다시 입력해주세요.");
		history.back();
	}else{
		var form = document.createElement('form');
		var param = new Array();
		var input = new Array();
		
		form.action = 'https://www.baobab858.com/jsp/admin/noticeList.api';
		form.method = 'post';
		
		param.push(['read_div', '']);
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
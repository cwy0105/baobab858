<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<title>바오밥 관리자</title>
<script type="text/javascript">
	window.onload = function(){
		var id = "<%=session.getAttribute("id")%>";
		if (id == "null") {
			window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
		}
		
		var result = <%=Integer.parseInt(request.getAttribute("result").toString()) %>;
		alert('총' + result + '개의 업체가 업데이트 되었습니다.');
		history.back();
	}
</script>
</head>
<body>

</body>
</html>
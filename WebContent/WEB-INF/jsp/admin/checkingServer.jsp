<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="https://www.baobab858.com/resources/webImages/favicon.ico">
<title>바오밥 점검 수정</title>
<script type="text/javascript">
	window.onload = function checking() {
		var result = <%=request.getParameter("server") %>;
		if(result == "점검"){
			alert('서버 점검이 시작되었습니다.');
			self.close();
		}else{
			alert('서버가 정상화 되었습니다.');
			history.back();
		}
	}
</script>
</head>
<body>

</body>
</html>
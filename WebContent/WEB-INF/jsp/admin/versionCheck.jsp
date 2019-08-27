<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="https://www.baobab858.com/resources/webImages/favicon.ico">
<title>바오밥 버전수정</title>
<script type="text/javascript">
	window.onload = function checking() {
		var id = "<%=session.getAttribute("id")%>";
		if (id == "null") {
			window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
		}
		
		var result = <%=request.getParameter("version") %>;
		if(result > 0){
			alert('버전 수정이 성공적으로 완료되었습니다.');
			self.close();
		}else{
			alert('버전 수정이 이루어지지 않았습니다. 다시 시도해주세요.');
			history.back();
		}
	}
</script>
</head>
<body>

</body>
</html>
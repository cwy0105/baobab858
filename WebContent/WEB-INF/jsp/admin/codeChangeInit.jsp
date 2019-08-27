<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<title>권한변경</title>
<script type="text/javascript">
window.onload = function result(){
	var result = <%=Integer.parseInt(request.getAttribute("result").toString())%>;
	if(result <= 0){
		alert("권한변경중 오류가 발생하였습니다. 다시 시도해주세요.");
		history.back();
	}else{
		alert("권한변경이 완료되었습니다.");
		window.opener.location.reload();
		self.close();
	}
	window.onload = function() {
		var id = "<%=session.getAttribute("id")%>";
		if (id == "null") {
			window.location.href = "https://www.baobab858.com/jsp/admin/home.api";
		}
	}
}
</script>
</head>
<body>

</body>
</html>
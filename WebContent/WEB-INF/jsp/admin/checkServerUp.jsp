<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<link href="<c:url value="https://www.baobab858.com/resources/css/versionUp.css" />" rel="stylesheet">
<link href="<c:url value="https://www.baobab858.com/resources/css/popupDefault.css" />" rel="stylesheet">
<script src="<c:url value="https://www.baobab858.com/resources/js/popupDefault.js"/>" type="text/javascript"/></script>
<script type="text/javascript">
     function statusChange() {
        var form = document.getElementById('statusChange');
        form.submit();
     }
     
//      window.onload = function(){
<%-- 		var p = <%=request.getParameter("status") %>; --%>
// 		p = document.getElementByClassName("status");
// 		}
	
   </script>
</head>
<body>
   <div id="main_div">
      <div>
         <img src="https://www.baobab858.com/resources/webImages/logo.png">
         <h1>현재서버상태 : <%=request.getAttribute("curServer").toString() %></h1>
      </div>
      <div id="content">
         <form id="statusChange" action="https://www.baobab858.com/jsp/admin/checkServer.api" method="post">
            <select name="server">
               <option class="status1" value="정상">정상</option>
               <option class="status2" value="점검">점검</option>
            </select><br>
            <input type="button" value="수정" onclick="statusChange()">
            <p>※DB에 저장되어있는 서버상태를 변경시키는 것으로 실질적으로 앱내 버전은 변경되지 않습니다.</p>
         </form>
      </div>
   </div>
   <button onclick="closePopup()">X</button>
</body>
</html>
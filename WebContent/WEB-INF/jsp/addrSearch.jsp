<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	<title>바오밥 주소 찾기</title>
	<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
	<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js?autoload=false"></script>
	<script>
		daum.postcode.load(function(){
	        new daum.Postcode({
	            oncomplete: function(data) {
	            	if(data.userSelectedType=="R"){		
		                window.BaobabApp.setAddress(data.zonecode, data.roadAddress, data.buildingName);
		            }else{
		                window.BaobabApp.setAddress(data.zonecode, data.jibunAddress, data.buildingName);
		            }
	            }
	        }).open();
	    });
	</script>
</head>
<body>
	잠시만 기다려 주세요...
</body>

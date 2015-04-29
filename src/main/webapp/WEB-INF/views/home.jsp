<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./resources/sockjs-0.3.4.min.js"></script>
<script src="./resources/board.js"></script>
<script src="./resources/chat.js"></script>
<title>Insert title here</title>
<html>
<style>
	#chatArea{
		width: 300px; height: 200px; overflow-y: auto; border: 1px solid black;
	}
</style>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P id="demo" ></P>
<sec:authorize access="isAuthenticated()">
<sec:authentication property="name"/>님 환영합니다.
</sec:authorize>
	<sec:authorize access="isAuthenticated()">
	<%-- <li><a href="<c:url value='/j_spring_security_logout' />">/j_spring_security_logout</a></li> --%>
	<input type="button"  value="로그아웃" onClick="location.href='<c:url value='/j_spring_security_logout' />'"/>
	</sec:authorize>
새글 : <input type="text" id="new" value=""/>

<div id="boardList" style="border: 2px solid; width: 500px; margin-bottom: 8px;">
	<input id="boardListGo" type="button" value="게시판으로 이동" onclick="setInterval(function(){myTimer()},1000);"/> 
</div>
<!-- <table id="boardList" style="border: 2px solid; width: 500px; margin-bottom: 8px;">
	<input id="boardListGo" type="button" value="게시판으로 이동" onclick="setInterval(function(){myTimer()},1000);"/> 
	<div id="pjmap"></div>
</table> -->
<div id = "pager"></div>
<div id="chat" style="border: 2px solid;width: 500px;">
		이름:<input type="text" id="nickname" value="<sec:authentication property="name"/>" disabled="disabled">
		<input type="button" id="enterBtn" value="입장">
		<input type="button" id="exitBtn" value="나가기">
	    
	    <h1>Websocket (SockJS) 채팅</h1>
	    <div id="chatArea"><div id="chatMessageArea"></div></div>
	    <br/>
	    <input type="text" id="message">
	    <input type="button" id="sendBtn" value="전송">
</div>
</body>
</html>
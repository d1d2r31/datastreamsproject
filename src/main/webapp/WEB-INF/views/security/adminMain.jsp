<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>어드민 메인</title>
</head>
<body>
	<body>
	어드민(연결 계정: <sec:authentication property="name"/>) 메인 화면입니다.
	<br/>
	<a href="<c:url value='/index'/>">[/index로 가기]</a>
</body>
</html>
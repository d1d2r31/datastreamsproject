<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>홈 메인</title>
</head>
<body>
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="name" />님,
	</sec:authorize>
	홈 메인 화면입니다.
	<a href="<c:url value='/index'/>">[/index로 가기]</a>
</body>
</html>
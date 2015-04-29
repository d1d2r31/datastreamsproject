<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./resources/board.js"  ></script>
<title>Insert title here</title>
</head>
<body>
<h1> 게시판 Detail </h1>
	<table width="500px" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td> 글번호 </td>
				<td> ${boardDetail.test} </td>
			</tr>
			<tr>
				<td> 조회수 </td>
				<td> ${boardDetail.hit} </td>
			</tr>
			<tr>
				<td> 이름 </td>
				<td> ${boardDetail.name}</td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> ${boardDetail.title}</td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> ${boardDetail.content}</td>
			</tr>
			<tr >
				<td colspan="2"> 
				<c:if test="${sessionScope.user == boardDetail.name }">
					<input id="boardUpdate" type="button" value="수정"> &nbsp;&nbsp;
				</c:if>
					<input type="hidden" name="updateCheck" value="1">
					<input type="button" id="boardListGo" value="목록보기" >	
				<c:if test="${sessionScope.user == boardDetail.name }">
					<input type="button" id="boardDelete" value="글삭제" onclick="boardDelete(${boardDetail.test})">		
				</c:if>		
				</td>
			</tr>
	</table>
</body>
</html>
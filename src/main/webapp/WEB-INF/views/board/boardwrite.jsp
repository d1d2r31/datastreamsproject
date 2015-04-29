<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./resources/board.js"  ></script>
<title>Insert title here</title>
<style type="text/css">
	span {	
    font-size: 7px;
    color: red;	
}
</style>
</head>
<body>

<h1> 게시판 Write </h1>

	<form:form commandName="boardVO">
	<table width="500" cellpadding="0" cellspacing="0" border="1">
	
			<tr>
				<td> 글번호 </td>
				<td>  </td>
			</tr>
			<tr>
				<td> 조회수 </td>
				<td>  </td>
			</tr>
			<tr>
				<td> 이름 </td>
				<td> <input name="name" type="text" value="${sessionScope.user}" disabled="disabled"/></td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input name="title" type="text" value="${boardDetail.title}"/><form:errors path="title"/> </td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <input name="content" type="text" value="${boardDetail.content}"/><form:errors path="content"/></td>
			</tr>
			<tr >
				<td colspan="2"> 
					<input id="boardInsertOK" type="button" value="글작성"> &nbsp;&nbsp;
					<input type="hidden" name="insertCheck" value="1">
					<input type="button" id="boardListGo" value="목록보기" > 
				</td>
			</tr>	
	</table>
</form:form>
</body>
</html>
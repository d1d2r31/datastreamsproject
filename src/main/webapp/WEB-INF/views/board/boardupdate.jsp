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
<h1> 게시판 Update </h1>

	
	<table width="500" cellpadding="0" cellspacing="0" border="1">
	
			<input type="hidden" name="test" value="${boardDetail.test}"/>
			<input type="hidden" name="hit" value="${boardDetail.hit}"/>
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
				<td> <input name="name" type="text" value="${boardDetail.name}"/></td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input name="title" type="text" value="${boardDetail.title}"/></td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <input name="content" type="text" value="${boardDetail.content}"/></td>
			</tr>
			<tr >
				<td colspan="2"> 
					<input id="boardUpdateOK" type="button" value="수정완료"> &nbsp;&nbsp;
					<input type="hidden" name="updateCheck1" value="0">
					<input type="button" id="boardListGo" value="목록보기" > 
				</td>
			</tr>	
	</table>

</body>
</html>
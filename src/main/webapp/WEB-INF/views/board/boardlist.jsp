<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./resources/board.js"  ></script>
<link rel="stylesheet" type="text/css" href="./resources/css/css.css" />
<style type="text/css">
.currentPage{
	font-size: 17px; 
	padding-left: 10px; 
	padding-right: 10px;
	font-weight: bold;
	border-right: 1px solid black;
}
.notCurrentPage{
	font-size: 17px; 
	padding-left: 10px; 
	padding-right: 10px;
	border-right: 1px solid black;
}
.endPage{
	border-right: 0px;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<%-- 새글 : <p id="new">${new1}</p> --%>
	
	<h1> 게시판 List </h1>
	
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>글번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>날짜</td>
			<td>조회수</td> 
		</tr>
		<c:forEach items="${boardList}" var="boardList" begin="0" step="1" varStatus="status">
		<tr>
			<td>
				<div onclick="name(${boardList.test})">
					<a href="#" class="asdasd">
						${boardList.test}
					<input type="hidden" id ="${boardList.test}" name="boardListGo11" value="${boardList.test}">
					</a>
				</div>
			</td>
			<td>${boardList.name}</td>
			<td>${boardList.title}</td>
			<td>${boardList.bDate}</td>
			<td>${boardList.hit}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"> 
				<input type="button" id="boardInsertGo" value="글작성" >
			</td>
		</tr>
		<tr>
	<c:forEach begin="${pagingVO.start_page }" end="${pagingVO.end_page }" var="num" step="1">
		<c:if test="${pagingVO.current_page == num }">
			<c:if test="${pagingVO.end_page == num }">
				<span class="currentPage endPage" >${num }</span>
			</c:if>
			<c:if test="${pagingVO.end_page != num }">
				<span class="currentPage" >${num }</span>
			</c:if>
		</c:if>
		<c:if test="${pagingVO.current_page != num }">
			<c:if test="${pagingVO.end_page == num }">
				<span class="notCurrentPage endPage" onclick = "movePage(${num})">${num }</span>
			</c:if>
			<c:if test="${pagingVO.end_page != num }">
				<span class="notCurrentPage"  onclick = "movePage(${num})">${num }</span>
			</c:if>
		</c:if>
	</c:forEach>
	</table>
	
</body>
</html>
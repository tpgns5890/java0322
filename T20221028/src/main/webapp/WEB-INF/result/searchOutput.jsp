<%@page import="co.test.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	BookVO result = (BookVO) request.getAttribute("book");
	%>
	<%
	if (result != null) {
	%>
	<h3>조회결과페이지</h3>
	<table border="1">
		<tr>
			<th>책번호</th>
			<td>${book.bookCode }</td>
		</tr>
		<tr>
			<th>책제목</th>
			<td>${book.bookTitle }</td>
		</tr>
		<tr>
			<th>저자</th>
			<td>${book.bookAuthor }</td>
		</tr>
		<tr>
			<th>출판사</th>
			<td>${book.bookPress }</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${book.bookPrice }</td>
		</tr>
	</table>
	<%
	}else{
	%>
	<p> 조회된 결과가 없습니다!.</p>
	<%
	}
	%>
	<a href="main.do">첫페이지</a>

</body>
</html>
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

	<h3>${error }</h3>

	<h3>도서수정조회</h3>
	<form action="./modifyBookForm.do" method="get">
		<input type="text" name="bookCode"><br> <input
			type="hidden" name="job" value="modify"> <input type="submit"
			value="조회">
	</form>

	<!-- 도서수정을 위한 화면 작성코드를 입력하세요. -->
	<%
	BookVO result = (BookVO) request.getAttribute("bookInfo");
	%>
	<%
	if (result != null) {
	%><h3>회원수정</h3>
	<form action="./modifyBook.do" method="post">
		책번호: <input type="text" name="bookCode"
			value="<%=result.getBookCode()%>" readonly><br> 책제목: <input
			type="text" name="bookTitle" value="<%=result.getBookTitle()%>"><br>
		저자: <input type="text" name="bookAuthor"
			value="<%=result.getBookAuthor()%>"><br> 출판사: <input
			type="text" name="bookPress" value="<%=result.getBookPress()%>"><br>
		가격: <input type="text" name="bookPrice"
			value="<%=result.getBookPrice()%>"><br> <input
			type="submit" value="수정">
	</form>
	<%
	} else {
	%>
	<p>조회된 결과가 없습니다!</p>
	<%
	}
	%>
	<a href="main.do">첫페이지</a>

</body>

</html>
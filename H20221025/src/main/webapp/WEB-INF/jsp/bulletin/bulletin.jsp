<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- bulletin/bulletin.jsp -->
<h3>게시판 페이지입니다.</h3>
<table border='1'>
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${bList }">
		<tr>
			<td><a href = "searchBoard.do?bno=${vo.boardNo }">${vo.boardNo }</a></td>
			<td>${vo.title }</td>
			<td>${vo.writer }</td>
			<td>${ }</td>
		</tr>
		</c:forEach>
		<tr>
			<td><a href="searchBoard.do?bno=<%=vo.getBoardNo() %>"><%=vo.getBoardNo() %></a></td>
			<td><%=vo.getTitle() %></td>
			<td><%=vo.getWriter() %></td>
			<td><%=vo.getWriteDate() %></td>
		</tr>
		<%
	}
%>
	</tbody>
</table>

${page }
<p />
<div class='pagination'>
	<c:if test = "${page.prev }">
		 <a href="bulletin.do?page=${paging.getStartPage-1}">&lt;&lt;</a>
	</c:if>
	<%

<c:forEach var="i" begin="${page.startPage}" end ="${page.endPage}" step ="1">
	<c:choose>
		<c:when test="">
			<a class = 'active' href="bulletin.do?page=${i}">${i}</a>
		</c:when>
		<c:otherwise>
			<a href="bulletin.do?page=${i}">${i}</a>
		</c:otherwise>
	</c:choose>
</c:forEach>
<c:if test = "${page.next}">
	<a href="bulletin.do?page=${page.endPage+1}">&gt;&gt;</a>
for(int i = paging.getStartPage; i< paging.getEndPage();i++){
		if(paging.getPageNum() == 1 ){
			<a class= "active" href = "bulletin.do?page=<%=i%>"></a><
		}
	}
%>

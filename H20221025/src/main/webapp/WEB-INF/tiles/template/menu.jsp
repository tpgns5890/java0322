<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="border-end bg-white" id="sidebar-wrapper">
	<div class="sidebar-heading border-bottom bg-light">
	
	
	<!-- 아이디가 없으면 손님, 있으면 아이디출력 -->
	<c:choose> 
		<c:when test="${empty id}"> <p>손님</p> </c:when>
		<c:otherwise><p>${id }</p></c:otherwise>
	</c:choose>
	
	</div>
	<div class="list-group list-group-flush">
		<a
			class="list-group-item list-group-item-action list-group-item-light p-3"
			href="bulletin.do?">게시판</a> <a
			class="list-group-item list-group-item-action list-group-item-light p-3"
			href="writeBoardForm.do">글등록</a>  <a
			class="list-group-item list-group-item-action list-group-item-light p-3"
			href="signupFrom.do">회원가입</a>  <a
			class="list-group-item list-group-item-action list-group-item-light p-3"
			href="memberList.do">회원목록</a>  <a
			class="list-group-item list-group-item-action list-group-item-light p-3"
			href="signInForm.do">로그인</a>  <a
			class="list-group-item list-group-item-action list-group-item-light p-3"
			href="signOut.do">로그아웃</a>  <a
			class="list-group-item list-group-item-action list-group-item-light p-3"
			href="questionBoard.do">Q&A</a> <a
			class="list-group-item list-group-item-action list-group-item-light p-3"
			href="questionForm.do">문의글
			</a>
	</div>
</div>
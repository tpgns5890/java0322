<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인화면(signInForm.do)</title>
</head>
<body>
<h3>회원로그인</h3>
	<form action="signIn.do" method="post">
	아이디: <input type="text" name="id"><br>
	비밀번호: <input type="password" name="pw"><br>
	<input type="submit" value="로그인">
	<input type="reset" value="초기화">
	</form>
	
	<a href="passwdReConfirmForm.do">비밀번호재전송</a>
	<!-- passwdReConfirm.jsp : 아이디를 입력하고 재전송 : 메일주소로 변경된 비번이 전송
		 passwdReConfirm.do : 아이디를 받아서 이메일정보로 메일을 발송.
	 -->
	 
	 <script>
	 	document.forms.frm.addEventListener('submit', function (e){
	 		console.log(frm.id)
	 		if(!frm.id.value || !frm.passwd.value){
	 			alert('필수입력항목입니다.');
	 			e.preventDefault();
	 			return;
	 		}
	 	});
	 </script>
	 
</body>
</html>
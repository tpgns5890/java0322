<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인화면(signInForm)</title>
</head>
<body>
	<h3>로그인 화면 작성하세요</h3>
	<form action="signIn.do" method="post" name ="frm">
	ID: <input type="text" name="id"><br>
	PW: <input type="password" name = "passwd"><br>
	<input type = "submit" value= "로그인">
	<input type = "reset" value= "초기화">
	
	</form>
	
	<script>
		document.forms.frm.addEventListener('submit', function (e)){
			console.log(frm.id)	
			if(!frm.id.value|| !frm.passwd.value){
				alert('필수입력항목입니다.');
				e.preventDefault();
				return;
			}
			e.preventDefault();
		}
	</script>
</body>
</html>
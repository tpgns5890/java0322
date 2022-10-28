<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록 페이지</title>
</head>
<body>
	<h3>회원가입</h3>
    <form action="signUp.do" method="post"> 
        아이디: <input type="text" name="id"><br>
        비밀번호: <input type="password" name="pw"><br>
        이름: <input type="text" name="name"><br>    
        이메일: <input type="email" name="email"><br>   
        <input type="submit" value="가입">
        <input type="reset" value="취소">
    </form>
</body>
</html>
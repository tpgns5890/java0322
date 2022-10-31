<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index.jsp</title>
<script src="object.js"></script>
</head>
<body>
	<form action="index.html" onsubmit="submitFunc()">
		id: <input type="text" id="uid" value="user1"><br>
		pw: <input type="password" id ="upw" value="1234"><br>
		<input type="submit" value="로그인">
	</form>

	<div id="show"></div>

	<script>
		function saveFnc(){
		// document.write('<p>Hello, World</p>');
		//DOM요소생성.
		let pTag = document.createElement('p'); //<p></p>
		let txt = document.createTextNode();
		pTag.appendChild(txt); // <p>Hello, World</p>
		console.log(pTag);

		let show = document.getElementById('show');
		show.appendChild(pTag);
		console.log(show);
		}

		function submitFunc(){
			event.preventDefault(); // form이 가지고 있는 기본 기능을 차단
			console.log('submitFunc() called');

			// 엘리먼트 선택하는데 id속성으로 엘리먼트를 선택
			let id = document.getElementById('uid').value;
			let pw = document.getElementById('upw').value;

			let pTag = document.createElement('p');
			let txt = document.createTextNode('id는 ' + id + ', 비번은 ' + pw);
			pTag.appendChild(txt);

			pTag.onclick = function(){
				console.log(this.remove());

			}

			document.getElementById('show').appendChild(pTag);
		}
	</script>
</body>

</html>
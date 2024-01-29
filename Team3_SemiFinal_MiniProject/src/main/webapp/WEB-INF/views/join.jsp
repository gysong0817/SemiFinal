<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/css/layout.css" rel="stylesheet" type="text/css" />
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>

<form action="join" method="POST" id="join" onsubmit="checkData()">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
	    <tr>
	        <td width="1220" height="20" colspan="2" bgcolor="#336699">
	            <p align="center">
	            	<font color="white" size="3">
		           		<b>회원가입</b>
	            	</font>
	            </p>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">아이디</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			<input id="userId" type="text" name="userId" size="30" autocomplete="off">
	        		</span>
	        		<br/>
	        		<span style="color:red; font-size:10pt;">※ 영문자, 소문자 입력가능, 최대 10자 까지 입력</span>
	        		<div id="show-msg"/>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">비밀번호</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			<input type="password" name="password" size="30">
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">성    함</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			<input type="text" name="name" size="30" autocomplete="off">
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">성    별</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			<input type="text" name="gender" size="30" autocomplete="off">
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">전화번호</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			<input type="text" name="phone" size="30" placeholder="-을 포함하여 입력해주세요." autocomplete="off">
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p><b><span style="font-size:12pt;">&nbsp;</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			<input type="submit" value="회원가입">
						&nbsp;&nbsp;
						<input type="reset" value="다시작성">
						&nbsp;&nbsp;
						<input type="button" value="메인으로" onclick="location.href='/main'">
					</span>
				</b>
			</td>
	    </tr>
	</table>
</form>

<script>
const inputUserId = document.getElementById('userId');
	inputUserId.addEventListener('blur', (e) => {
		e.preventDefault();
		const showMsg = document.getElementById('show-msg');
		axios.get('http://localhost:8080/api/user', {params : {userId : inputUserId.value}})
			.then(response => response.data)
			.then(result => {
				if(result.msg === '존재') {
					showMsg.innerHTML = '존재하는 아이디입니다.';
				} else {
					showMsg.innerHTML = '사용 가능한 아이디입니다.';
				}
			})
	})
</script>

<script type="text/javascript">
function checkData() {
	let joinForm = document.getElementById('');
	
	if(joinForm.userId.value == "") {
		
		return;
	}
	if(joinForm.password.value == "") {
		
		return;
	}
	if(joinForm.name.value == "") {
		
		return;
	}
	if(joinForm.gender.value == "") {
		
		return;
	}
	if(joinForm.phone.value == "") {
		
		return;
	}
	
}
</script>

</body>
</html>
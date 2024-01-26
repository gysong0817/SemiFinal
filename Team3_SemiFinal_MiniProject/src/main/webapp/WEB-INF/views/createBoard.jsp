<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

<h1>게시판 생성</h1>
<h2>${sessionScope.userId}</h2>
<form action="/board" method="POST" enctype="multipart/form-data">
	<input type="hidden" name="userId" value="${sessionScope.userId}">
    <label for="boardNo">boardNo<label>
    <input type="number" id="boardNo" name="boardNo" required/><br/>
    <label for="title">title</label>
    <input type="text" id="title" name="title" required/><br/>
    <label for="content">content</label>
    <input type="text" id="content" name="content" required/><br/>
<!--     <label for="userId">userId</label>
    <input type="text" id="userId" name="userId" required/><br/> -->
    
<!-- 	<label for="regDate">regDate</label>
    <input type="date" id="regDate" name="regDate" required/><br/>
    <label for="modDate">modDate</label>
    <input type="date" id="modDate" name="modDate" required/><br/> -->
<!--     <label for="viewCnt">viewCnt</label>
    <input type="number" id="viewCnt" name="viewCnt" required/><br/>
    <label for="categoryIdx">categoryIdx</label>
    <input type="number" id="categoryIdx" name="categoryIdx" required/><br/> -->
   	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">첨부파일</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			<!-- input 박스 -->
	        			<input type="file" name="file" size="30">
	        		</span>
	        	</b>
	        </td>
	    </tr>
    
    
    <input type="submit" value="생성"/>
</form>

</body>
</html>

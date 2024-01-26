<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 수정</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 20px;
        }
        h1 {
            text-align: center;
            color: #343a40;
        }
        form {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input, textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
        }
    </style>
</head>
<body>

<h1>게시물 수정</h1>

<c:if test="${not empty board}">
    <!-- 게시물 수정 폼 -->
	<form:form method="post" action="/board/${board.boardNo}" modelAttribute="board">
	    <label for="title">Title:</label>
	    <form:input type="text" id="title" path="title" value="${board.title}" required="true"/>
	    <label for="content">Content:</label>
	    <form:textarea id="content" path="content" rows="5" required="true"></form:textarea><br/>
	    <input type="submit" value="수정 완료"/>
	</form:form>

</c:if>

<a href="<c:url value='/board/${board.boardNo}'/>">게시물 상세 내용으로 돌아가기</a>

</body>
</html>

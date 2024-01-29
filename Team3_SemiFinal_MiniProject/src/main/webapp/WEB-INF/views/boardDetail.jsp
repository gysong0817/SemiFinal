<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 상세 내용</title>

</head>
<body>

<h1>게시물 상세 내용</h1>

<c:if test="${not empty board}">
    <table>
        <tr>
            <th>Board No</th>
            <td>${board.boardNo}</td>
        </tr>
        <tr>
            <th>Title</th>
            <td>${board.title}</td>
        </tr>
        <tr>
            <th>Content</th>
            <td>${board.content}</td>
        </tr>
        <tr>
            <th>User ID</th>
            <td>${board.userId}</td>
        </tr>
        <tr>
            <th>Reg Date</th>
            <td>${board.regDate}</td>
        </tr>
        <tr>
            <th>Mod Date</th>
            <td>${board.modDate}</td>
        </tr>
        <tr>
            <th>View Count</th>
            <td>${board.viewCnt}</td>
        </tr>
        <tr>
            <th>Category Index</th>
            <td>${board.categoryIdx}</td>
        </tr>
	    <tr>
	        <th>file:</th>
	        <td>${file.fileOriginalName}</td>
	    </tr>
    </table>

    <div>
        <strong>Content:</strong>
        <p>${board.content}</p>
    </div>

	<c:if test="${not empty userId and userId eq board.userId}">
	        <form:form method="POST" action="<c:url value='/board/${board.boardNo}'/>" modelAttribute="board" id="deleteForm">
	            <form:hidden path="_method" value="DELETE" />
	            <button type="button" class="delete-btn" onclick="confirmDelete('${board.boardNo}', '${userId}')">삭제</button>
	        </form:form>
	        <a href="<c:url value='/modify/board/${board.boardNo}'/>">게시물 수정</a>
	</c:if>
</c:if>
<a href="<c:url value='/main'/>">목록으로 돌아가기</a>

<script>

</script>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 상세 내용</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #F8F9FA;
            margin: 20px;
        }
        h1 {
            text-align: center;
            color: #343A40;
        }
        table {
            width: 60%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #007BFF;
            color: #fff;
        }
        .content {
            margin-top: 20px;
        }
        .delete-btn {
            margin-top: 10px;
            background-color: #DC3545;
            color: #fff;
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
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
    </table>
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
document.getElementById("commentForm").addEventListener("submit", function(event) {
    event.preventDefault();
    var formData = new FormData(this);
    fetch("/comment/insert", {
        method: "POST",
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        alert(data.message);
        if (data.message === "댓글 작성 성공") {
            refreshComments(${board.boardNo});
            // 댓글 작성 성공 시 필요한 추가 작업을 수행
        }
    })
    .catch(error => {
        console.error("Error inserting comment:", error);
        alert("댓글 작성에 실패했습니다.");
    });
});
function loadComments(boardNo) {
    $.ajax({
        url: "/api/comments/" + boardNo,
        method: "GET",
        success: function(comments) {
            // 받아온 댓글 목록을 화면에 표시하는 로직을 작성
            // 예를 들어, 특정 영역에 댓글 목록을 추가하는 등의 동적인 처리를 수행
            console.log(comments);
        },
        error: function(error) {
            console.error("Error loading comments:", error);
        }
    });
}
function refreshComments(boardNo) {
    // 댓글 목록을 가져오는 함수 호출
    loadComments(boardNo);
}
</script>
	<div class="container">
	<div class="form-group">
		<form method="post" action="<c:url value='/comment/insert'/>">
			<input type="hidden" name="boardNo" value="${board.boardNo}">
			<table class="table table-striped" style="text-align: center; border: 1px solid #DDDDDD">
				<tr>
					
					<td style="border-bottom:none;" valign="middle"><br><br>userId</td>
					<td><input type="text" style="height:100px;" class="form-control" placeholder="댓글을 작성해 주세요" name = "content"></td>
					<td><br>
					<br>
					<div>
					<button type="submit" class="insert">댓글 작성</button>
					<button type="submit" class="update">댓글 수정</button>
					<button type="submit" class="delete">댓글 삭제</button></td>
					</div>
				</tr>
			</table>
		</form>
	</div>
	</div>
	
	<div class="comment-section">
    <h2>댓글 목록</h2>
    <c:forEach var="comment" items="${comments}">
        <div class="comment">
            <p><strong>${comment.userId}</strong>: ${comment.content}</p>
            <p>작성일: ${comment.regDate}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>
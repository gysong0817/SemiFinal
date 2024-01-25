<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>맛집 게시판</title>
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #dee2e6;
            text-align: center;
        }
        thead {
            background-color: #343a40;
            color: white;
        }
        tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .board-link {
            color: #007bff;
            text-decoration: underline;
            cursor: pointer;
        }
        .new-post-btn {
            display: block;
            width: 150px;
            margin: 20px auto;
            padding: 10px;
            background-color: #007bff;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
        }
        .signup-btn, .login-btn {
            display: block;
            margin-top: 10px;
            width: 150px;
            padding: 10px;
            background-color: #28a745;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
        }
        .login-btn {
            margin-left: 10px;
        }
    </style>
</head>
<body>

<h1>맛집 게시판</h1>

<c:if test="${not empty boardList}">
    <table>
        <thead>
            <tr>
                <th style="width: 5%;">Board No</th>
                <th style="width: 30%;">Title</th>
                <th style="display: none;">Content</th>
                <th style="width: 10%;">User ID</th>
                <th style="width: 10%;">Reg Date</th>
                <th style="width: 10%;">Mod Date</th>
                <th style="width: 10%;">View Count</th>
                <th style="width: 5%;">Category Index</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${boardList}" var="board">
                <tr>
                    <td>${board.boardNo}</td>
                    <td><a class="board-link" href="<c:url value='/board/${board.boardNo}'/>">${board.title}</a></td>
                    <td style="display: none;">${board.content}</td>
                    <td>${board.userId}</td>
                    <td>${board.regDate}</td>
                    <td>${board.modDate}</td>
                    <td>${board.viewCnt}</td>
                    <td>${board.categoryIdx}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<a class="new-post-btn" href="<c:url value='/new-post'/>">새로운 글 작성</a>
<c:if test="${empty userId}">
    <a class="signup-btn" href="<c:url value='/signup'/>">Sign Up</a>
    <a class="login-btn" href="<c:url value='/login'/>">Login</a>
</c:if>
<c:if test="${not empty userId}">
    <a class="logout-btn" href="<c:url value='/logout'/>">Logout</a>
</c:if>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        var boardLinks = document.querySelectorAll('.board-link');

        boardLinks.forEach(function (link) {
            link.addEventListener('click', function (event) {
                event.preventDefault();

                var boardNo = link.getAttribute('href').split('/').pop();

                window.location.href = "<c:url value='/boardDetail'/>?boardNo=" + boardNo;
            });
        });
    });
</script>


</body>
</html>

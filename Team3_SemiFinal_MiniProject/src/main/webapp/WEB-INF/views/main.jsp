<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<div>
					<form id="mainForm" class="row justify-content-center g-3"
						action="/main" method="GET" onsubmit="checkKeyword()">
						<div class="col-auto">
							<label for="keyword" class="visually-hidden">Search</label> <input
								type="text" class="form-control" id="searchKeyword"
								placeholder="SearchKeyword" name="searchKeyword"
								value="${pageInfo.pageRequest.searchKeyword}">
							<!-- hidden -->
							<input name="pageNum" type="hidden"
								value="${pageInfo.pageRequest.pageNum}"> <input
								name="amount" type="hidden"
								value="${pageInfo.pageRequest.amount}">
						</div>
						<div class="col-auto">
							<input type="submit" class="btn btn-primary mb-3" value="Search" />
						</div>
					</form>
				</div>
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td>${board.boardNo}</td>
						<td><a class="board-link"
							href="<c:url value='/board/${board.boardNo}'/>">${board.title}</a></td>
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
	<div class="row justify-content-center">
		<div class="col-auto">
			<nav class="page navigation">
				<ul class="pagination">
					<c:if test="${pageInfo.prev}">
						<li class="page-item"><a class="page-link"
							aria-label="Previous"
							href="/main?pageNum=${pageInfo.startPage - 1}&amount=${pageInfo.pageRequest.amount}">Prev</a>
						</li>
					</c:if>
					<c:forEach var="num" begin="${pageInfo.startPage}"
						end="${pageInfo.endPage}">
						<li class="page-item ${pageInfo.pageRequest.pageNum == num ? "active" : "" } ">
							<a class="page-link"
							href="/main?pageNum=${num}&amount=${pageInfo.pageRequest.amount}&searchKeyword=${pageInfo.pageRequest.searchKeyword}">${num}</a>
						</li>
					</c:forEach>
					<c:if test="${pageInfo.next}">
						<li class="page-item next"><a class="page-link"
							aria-label="next"
							href="/main?pageNum=${pageInfo.endPage + 1}&amount=${pageInfo.pageRequest.amount}">Next</a>
						</li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
	<a class="new-post-btn" href="<c:url value='/new-post'/>">새로운 글 작성</a>
	<c:if test="${empty userId}">
		<a class="signup-btn" href="<c:url value='/signup'/>">Sign Up</a>
		<a class="login-btn" href="<c:url value='/login'/>">Login</a>
	</c:if>
	<c:if test="${not empty userId}">
		<a class="logout-btn" href="<c:url value='/logout'/>">Logout</a>
	</c:if>

	<script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function () {
        var boardLinks = document.querySelectorAll('.board-link');

        boardLinks.forEach(function (link) {
            link.addEventListener('click', function (event) {
                event.preventDefault();
                var contentElement = event.target.parentNode.nextElementSibling;
                var content = contentElement.innerText;

                // Redirect to the board detail page with the board No
                var boardNo = link.getAttribute('href').split('/').pop();
                window.location.href = "/board/" + boardNo;
            });
        });
    });
    
	Array.from(document.getElementsByClassName('page-link'))
	.forEach((pagingButton) => {
		pagingButton.addEventListener('click', function(e) {
			e.preventDefault();
			// step02 : 등록 후, action : '/main' 으로 요청 시, keyword 값 유무에 따라 queryString 변경
			// step03 : 요청
			let mainForm = document.getElementById('mainForm');
			
			// 현재 페이지 값으로 변경하여 /main 요청하도록 지정
			mainForm.pageNum.value = e.target.innerHTML;
			
			if(mainForm.searchKeyword.value === '' || mainForm.searchKeyword.value === null) {
				mainForm.searchKeyword.remove();
			}
			
			mainForm.action = '/main';
			mainForm.method = 'GET';
			mainForm.submit();
		})
})

function checkKeyword() {
	let mainForm = document.getElementById('mainForm');
	if(mainForm.searchKeyword.value === null || mainForm.searchKeyword.value === '') {
		mainForm.searchKeyword.remove();
	}
}
</script>

</body>
</html>

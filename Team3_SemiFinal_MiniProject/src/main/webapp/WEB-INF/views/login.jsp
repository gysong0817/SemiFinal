<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

<h1>Login</h1>

<form action="<c:url value='/login'/>" method="post">
    <label for="userId">User ID:</label>
    <input type="text" id="userId" name="userId" required/><br/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required/><br/>
    
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    
    <input type="submit" value="Login"/>
</form>

</body>
</html>

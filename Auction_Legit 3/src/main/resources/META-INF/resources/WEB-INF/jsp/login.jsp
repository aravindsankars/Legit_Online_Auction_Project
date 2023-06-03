<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
<style>
.card {
	margin-top: 80px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	max-width: 400px;
	margin: auto;
	text-align: center;
	font-family: arial;
}

.card-title {
	color: #333;
	font-weight: bold;
	font-size: 24px;
	margin-top: 20px;
}

.form-group {
	text-align: left;
	margin-top: 30px;
}

.form-control {
	height: 50px;
	border-radius: 20px;
}

.btn {
	border-radius: 20px;
	font-size: 18px;
	font-weight: bold;
	background-color: #3f51b5;
	color: #fff;
	width: 100%;
	height: 50px;
	margin-top: 30px;
}

.btn:hover {
	background-color: #283593;
}
</style>
</head>
<body>

<%-- 	<c:choose>
		<c:when test="${mode=='MODE_LOGIN'}";> --%>
			<div class="container">
				<div class="card">
					<div class="card-body">
						<h3 class="card-title">Login</h3>

						<div class="form-group">
							<form action="/loginVal" method="post">
								<label for="username">Username:</label> <input type="text"
									id="username" class="form-control" name="username"
									placeholder="Username"><br>
								<label for="password">Password:</label> <input type="password"
									id="password" class="form-control" name="password"
									placeholder="Password"><br>
								 <input type="hidden" id="id" class="form-control" name="id" value="${user.id}"><br>
								<button type="submit" class="btn btn-primary" value="Submit">Submit</button>
							</form><br><br>
<%-- 		</c:when>

		<c:when test="${mode=='MODE_REGISTER'}";> --%>
			<a href="/register">New user? You can register here</a><br><br>

<%-- 		</c:when>
 --%>		</div>
		</div>
		</div>
		</div>
	<%-- 	</c:choose>
 --%>
</body>
</html>
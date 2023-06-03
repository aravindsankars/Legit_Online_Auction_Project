<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
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

	<div class="container">
		<div class="card">
			<div class="card-body">
				<h3 class="card-title">Register</h3>

				<div class="form-group">
					<form method="post" action="/save-user">
						<label for="username">Username:</label> <input type="text"
							id="username" class="form-control" name="username"
							value="${user.username}"><br> <label for="password">Password:</label>
						<input type="password" id="password" class="form-control"
							name="password" value="${user.password}"><br> <label
							for="confirmPassword">Confirm Password:</label> <input
							type="password" id="confirmPassword" class="form-control"
							name="confirmPassword"><br> <label for="email">Email:</label>
						<input type="text" id="email" name="email" class="form-control"
							value="${user.email}"><br> <label for="role">Role:</label>
						<select id="role" name="role">
							<option value="buyer">Buyer</option>
							<option value="seller">Seller</option>
						</select><br>
						<button type="submit" class="btn btn-primary" value="Submit">Submit</button>
					</form>

				</div>
			</div>
		</div>
	</div>

</body>
</html>
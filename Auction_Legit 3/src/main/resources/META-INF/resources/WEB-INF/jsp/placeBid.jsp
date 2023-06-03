<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Place Bid</h1>

	<form method="post" action="submitBid.jsp">
		<input type="hidden" name="itemId" value="<%-- <%= item.getId() %> --%>">
		<label for="bidAmount">Bid amount:</label> <input type="number"
			name="bidAmount" step="0.01" min="<%-- <%= minimumBid %> --%>">
		<button type="submit">Place Bid</button>
	</form>

</body>
</html>
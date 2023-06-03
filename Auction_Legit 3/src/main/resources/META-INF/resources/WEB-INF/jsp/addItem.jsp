<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Add Item</h1>

	<form action="/add-item" method="post">
		<label for="item-name">Item Name:</label> 
		<input type="text" name="itemName" id="itemName"><br> <br> 
		<label for="starting-bid">Starting Bid:</label> 
		<input type="number" name="startingBid" id="startingBid"><br> 
		<input type="hidden" name="id" value="${seller_id}">
		<br> 
		<input type="submit" value="Add Item">
	</form>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mycompany.auction.model.Items"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seller Page</title>
</head>
<body>

	<h1>Welcome Seller!</h1>
	<form action="/seller-items" method="post">
		<input type="hidden" name="id" value="${user.id}">
		<input type="submit" value="Get Items">
	</form>

	<h3>Add Item</h3>
	<form action="/seller-add" method="get">
		<input type="hidden" name="id" value="${user.id}">
		<input type="submit" value="Add Item">
	</form>
	
 
	<h3>Remove Item</h3>
	<form action="/remove-item" method="post">
		<label for="item-name">Item Name:</label> 
		<input type="text" name="itemName" id="itemName"><br> <br> 
 
		<input type="submit" value="Remove Item">
	</form>

    	<h3>Edit Item</h3>
	<form action="/edit-item" method="post">
		<label for="item-name">Item Name:</label> 
		<input type="text" name="itemName" id="itemName"><br> <br> 
		<label for="starting-bid">Starting Bid:</label> 
		<input type="number" name="startingBid" id="startingBid"><br> <br>
		<label for="item-id">Item Id:</label> 
		<input type="text" name="item_id" id="item_id">
		<br> 
		<input type="submit" value="Edit Item">
	</form>


</body>
</html>

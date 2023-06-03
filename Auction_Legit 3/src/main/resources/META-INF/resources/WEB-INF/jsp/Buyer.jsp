<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mycompany.auction.model.Items"%>
<%@ page import="com.mycompany.auction.controller.BuyerController"%>
<%@ page import="com.mycompany.auction.model.Bid"%>
<%@ page import="com.mycompany.auction.model.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Legit Buyer</title>
</head>
<body>

	<h1>Welcome Buyer!</h1>
	<br>
	<br>

	<h2>Search and Select an Item to Bid For:</h2>
	<form action="/searchitem" method="get">
		<label for="searchTerm">Search:</label> <input type="text"
			id="searchTerm" name="searchTerm" required> <input
			type="submit" value="Search">
	</form>
	<br>
	<br>

	<h2>Place Bid</h2>
	<form action="/place-bid" method="post">

		<label for="itemId">Item ID:</label> <br> <input type="text"
			id="itemId" name="itemId"> <br> <label for="bidAmount">Bid:</label>
		<br> <input type="number" id="bidAmount" name="bidAmount">
		<br> <br> <input type="hidden" id="buyer_id" name="buyer_id"
			value="${user.id}"> <input type="submit" value="Place Bid">
	</form>


	<h2>History</h2>
    	<form action="/history" method="get">
		<input type="hidden" name="buyer_id" value="${user.id}">
		<input type="submit" value="History">
	</form>

            <h2>Update Bid</h2>
			<form action="/update-bid" method="post">

				<label for="itemId">Item ID:</label> <br> 
				<input type="text" id="itemId" name="itemId"> <br> 
				<label for="bidId">Bid ID:</label> <br> 
				<input type="text" id="bidId" name="bidId"> <br>
				<label for="newBidAmount">New Bid:</label> <br> 
				<input type="number" id="newBidAmount" name="newBidAmount"> <br> <br> 
				<input type="submit" value="Update Bid">
			</form>
			
			<h2>Withdraw Bid</h2>
			<form action="/withdraw-bid" method="post">
				<label for="bidId">Bid ID:</label> <br> 
				<input type="text" id="bidId" name="bidId"> <br> <br>
				<input type="submit" value="Withdraw Bid">
			</form> 

</body>
</html>
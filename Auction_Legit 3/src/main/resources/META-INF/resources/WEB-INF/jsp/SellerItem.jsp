<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mycompany.auction.model.Items"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Items page</title>
</head>
<body>

     <h1>Your items:</h1>
<table>
    <thead>
        <tr>
            <th>Item:</th>
            <th>Starting Bid:</th>
            <th>Item ID:</th>
            <th>Bids:</th>

        </tr>
    </thead>
    <tbody>
        <% for (Items item : (List<Items>)request.getAttribute("items")) { %>
            <tr>
                <td><%= item.getItemName() %></td>
                <td><%= item.getStartingBid() %></td>
                <td><%= item.getItem_id() %></td>
                <td>
    	<form action="/All-Bids" method="get">
    	<label for="itemId">Item ID:</label>
		<input type="text" name="itemId">
		<input type="submit" value="All-Bids">  
		</form>              
		</td>
            </tr>
        <% } %>
    </tbody>
</table>
<br> <br> <br> <br>

<a href="/login">LogOut</a>

</body>
</html>
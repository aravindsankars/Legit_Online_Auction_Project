<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mycompany.auction.model.Bid"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Bids</title>
</head>
<body>

     <h1>Bids:</h1>
<table>
    <thead>
        <tr>
            <th>Bid ID:</th>
            <th>Amount:</th>

        </tr>
    </thead>
    <tbody>
        <% for (Bid bid : (List<Bid>)request.getAttribute("bids")) { %>
            <tr>
                <td><%= bid.getBidId() %></td>
                <td><%= bid.getAmount() %></td>
            </tr>
        <% } %>
    </tbody>
</table>
<br> <br> <br> <br>

<a href="/login">LogOut</a>

</body>
</html>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.auction.model.Items" %>
<%@ page import="com.mycompany.auction.model.User" %>

<!DOCTYPE html>
<html>
<head>
  <title>Admin Page</title>
</head>
<body>
  <h1>Admin Page</h1>
  
  <h2>Items</h2>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      <% List<Items> items = (List<Items>) request.getAttribute("items"); %>
      <% if (items != null && items.size() > 0) { %>
        <% for (Items item : items) { %>
          <tr>
            <td><%= item.getItem_id() %></td>
            <td><%= item.getItemName() %></td>
            <td><%= item.getStartingBid() %></td>
            <td>
              <a href="editItem?id=<%= item.getItem_id() %>">Edit</a>
              <a href="deleteItem?id=<%= item.getItem_id() %>">Delete</a>
            </td>
          </tr>
        <% } %>
      <% } else { %>
        <tr>
          <td colspan="5">No items found</td>
        </tr>
      <% } %>
    </tbody>
  </table>
  
  <h2>Users</h2>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      <% List<User> users = (List<User>) request.getAttribute("users"); %>
      <% if (users != null && users.size() > 0) { %>
        <% for (User user : users) { %>
          <tr>
            <td><%= user.getId() %></td>
            <td><%= user.getName() %></td>
            <td><%= user.getEmail() %></td>
            <td>
              <a href="editUser?id=<%= user.getId() %>">Edit</a>
              <a href="deleteUser?id=<%= user.getId() %>">Delete</a>
            </td>
          </tr>
        <% } %>
      <% } else { %>
        <tr>
          <td colspan="4">No users found</td>
        </tr>
      <% } %>
    </tbody>
  </table>
  
  <h2>Add Item</h2>
  <form method="post" action="addItem">
    <label>Name:</label>
    <input type="text" name="name"><br>
    <label>Description:</label>
    <textarea name="description"></textarea><br>
    <label>Price:</label>
    <input type="number" name="price"><br>
    <input type="submit" value="Add">
  </form> 
  
  <h2>Add User</h2>
  <form method="post" action="addUser">
    <label>Name:</label>
    <input type="text" name="name"><br>
    <label>Email:</label>
    <input type="email" name="email"><br>
    <input type="submit" value="Add">
  </form>
</body>
</html>

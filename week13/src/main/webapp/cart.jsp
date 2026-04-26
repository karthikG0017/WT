<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<html>
<head>
<title>Cart</title>
<meta charset="UTF-8">
<style>
body {
font-family: Arial;
background-color: #f4f4f4;
text-align: center;
}
.container {
width: 60%;
margin: auto;
}
.item {
background: white;
padding: 15px;
margin: 10px;
border-radius: 10px;
box-shadow: 0 0 5px gray;
}
.total {
font-size: 20px;
font-weight: bold;
margin-top: 20px;
}

button {
padding: 10px 20px;
background: blue;
color: white;
border: none;
border-radius: 5px;
cursor: pointer;
}
button:hover {
background: darkblue;
}
</style>
</head>
<body>
<div class="container">
<h2>Your Cart</h2>
<%
List<Map<String, Object>> cart = 
(List<Map<String, Object>>) session.getAttribute("cart");
double total = 0;
if(cart != null && !cart.isEmpty()){
for(Map<String, Object> item : cart){
String name = (String) item.get("name");
double price = (Double) item.get("price");
total += price;
%>
<div class="item">
<h3><%= name %></h3>
<p>Price: ₹<%= price %></p>
</div>
<%
}
%>
<div class="total">
Total Cost: ₹<%= total %>
</div>
<%
} else {
%>
<p>Cart is empty</p>
<%
}
%>
<br><br>
<form action="checkout.jsp" method="get">
<button type="submit">Proceed to Checkout</button>
</form>
</div>
</body>
</html>

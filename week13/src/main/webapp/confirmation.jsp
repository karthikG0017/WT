<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<html>
<head>
<title>Order Confirmation</title>
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
    font-size: 22px;
    font-weight: bold;
    margin-top: 20px;
    color: green;
}
</style>
</head>
<body>
<div class="container">
<h2>Order Confirmed</h2>
<p><b>Name:</b> ${name}</p>
<p><b>Address:</b> ${address}</p>
<p><b>Phone:</b> ${phone}</p>
<h3>Items Ordered:</h3>
<%
List<Map<String, Object>> cart =
    (List<Map<String, Object>>) request.getAttribute("cart");
if(cart != null){
    for(Map<String, Object> item : cart){
        String name = (String) item.get("name");
        double price = (Double) item.get("price");
%>
<div class="item">
    <p><%= name %> - Rs.<%= price %></p>
</div>
<%
    }
}
%>
<div class="total">
    Total Paid: Rs.${total}
</div>
</div>
</body>
</html>

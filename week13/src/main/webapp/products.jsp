<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<html>
<head>
<title>Products</title>
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
.product {
    background: white;
    padding: 15px;
    margin: 10px;
    border-radius: 10px;
    box-shadow: 0 0 5px gray;
}
button {
    padding: 8px 15px;
    background: green;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
button:hover {
    background: darkgreen;
}
a {
    display: inline-block;
    margin-top: 20px;
    text-decoration: none;
    font-weight: bold;
}
</style>
<script>
function addToCart(name, price) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "addToCart?name=" + name + "&price=" + price, true);
    xhttp.send();
    alert(name + " added to cart");
}
</script>
</head>
<body>
<div class="container">
<h2>Products</h2>
<%
List<Map<String, Object>> products =
    (List<Map<String, Object>>) request.getAttribute("products");
if(products != null){
    for(Map<String, Object> p : products){
        String name = (String) p.get("name");
        double price = (Double) p.get("price");
%>
<div class="product">
    <h3><%= name %></h3>
    <p>Price: Rs.<%= price %></p>
    <button onclick="addToCart('<%= name %>', <%= price %>)">Add to Cart</button>
</div>
<%
    }
} else {
%>
<p>No products available</p>
<%
}
%>
<a href="cart.jsp">Go to Cart</a>
</div>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Checkout</title>
<meta charset="UTF-8">
<style>
body {
font-family: Arial;
background-color: #f4f4f4;
text-align: center;
}
.container {
width: 40%;
margin: auto;
background: white;
padding: 20px;
border-radius: 10px;
box-shadow: 0 0 10px gray;
}
input {
width: 90%;
padding: 10px;
margin: 10px 0;
border-radius: 5px;
border: 1px solid #ccc;
}
button {
padding: 10px 20px;
background: green;
color: white;
border: none;
border-radius: 5px;
cursor: pointer;
}
button:hover {
background: darkgreen;
}
</style>
</head>
<body>
<div class="container">
<h2>Checkout</h2>
<form action="processCheckout" method="post">
<input type="text" name="name" placeholder="Enter Name" required><br>
<input type="text" name="address" placeholder="Enter Address" required><br>
<input type="text" name="phone" placeholder="Enter Phone" required><br>
<button type="submit">Place Order</button>
</form>
</div>
</body>
</html>

package com.user;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.*;
@WebServlet("/processCheckout")
public class CheckoutServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
// 1. Get form data
String name = request.getParameter("name");
String address = request.getParameter("address");
String phone = request.getParameter("phone");
// 2. Get cart from session
HttpSession session = request.getSession();
List<Map<String, Object>> cart = 
(List<Map<String, Object>>) session.getAttribute("cart");
double total = 0;
if(cart != null){
for(Map<String, Object> item : cart){
total += (Double) item.get("price");
}
}
// 3. Send data to next page
request.setAttribute("name", name);
request.setAttribute("address", address);
request.setAttribute("phone", phone);
request.setAttribute("cart", cart);
request.setAttribute("total", total);
// 4. Forward to confirmation page
RequestDispatcher rd = request.getRequestDispatcher("confirmation.jsp");
rd.forward(request, response);
}
}
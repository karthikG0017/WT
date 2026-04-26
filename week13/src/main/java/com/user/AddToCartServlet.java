package com.user;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.*;
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        HttpSession session = request.getSession();
        List<Map<String, Object>> cart =
            (List<Map<String, Object>>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        Map<String, Object> product = new HashMap<>();
        product.put("name", name);
        product.put("price", price);
        cart.add(product);
        session.setAttribute("cart", cart);
    }
}

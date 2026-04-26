package com.user;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.*;
import com.user.DBConnection;
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Map<String, Object>> products = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT name, price FROM products";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> product = new HashMap<>();
                product.put("name", rs.getString("name"));
                product.put("price", rs.getDouble("price"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
        rd.forward(request, response);
    }
}

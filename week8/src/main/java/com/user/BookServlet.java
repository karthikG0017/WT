package com.user;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookstore",
                "root",
                "Sharath@123"
            );

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            out.println("<h2>Book Details</h2>");

            while(rs.next()) {
                out.println("Title: " + rs.getString("title") + "<br>");
                out.println("Author: " + rs.getString("author") + "<br>");
                out.println("Price: " + rs.getInt("price") + "<br><br>");
            }

            con.close();

        } catch(Exception e) {
            out.println(e);
        }
    }
}
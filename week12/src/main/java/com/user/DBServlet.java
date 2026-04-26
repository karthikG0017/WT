package com.user;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/dbtest")
public class DBServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookstore",
                "root",
                "Sharath@123"
            );

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            PrintWriter out = res.getWriter();

            while(rs.next()) {
                out.println(rs.getString("title") + "<br>");
            }

            con.close();

        } catch(Exception e) {
            res.getWriter().println(e);
        }
    }
}
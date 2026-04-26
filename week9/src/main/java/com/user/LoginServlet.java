package com.user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")   // ✅ THIS LINE IS KEY
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String u = req.getParameter("user");
        String p = req.getParameter("pass");

        if("admin".equals(u) && "1234".equals(p)) {
            res.sendRedirect("home.jsp");
        } else {
            res.getWriter().println("Invalid Login");
        }
    }
}
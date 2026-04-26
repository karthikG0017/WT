package com.user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String book = req.getParameter("book");

        HttpSession session = req.getSession();

        String cart = (String) session.getAttribute("cart");

        if(cart == null) cart = "";

        cart += book + "<br>";

        session.setAttribute("cart", cart);

        res.setContentType("text/html");
        res.getWriter().println(cart);
    }
}
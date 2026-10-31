package com.itshaala.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/write")
public class CookieWriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        Cookie cookie1 = new Cookie("mobile","Iphone");
        Cookie cookie2 = new Cookie("model","17");

        resp.addCookie(cookie1);
        resp.addCookie(cookie2);

        writer.println("Cookies Added");
    }
}

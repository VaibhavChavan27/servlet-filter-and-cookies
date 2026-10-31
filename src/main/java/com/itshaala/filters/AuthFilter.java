package com.itshaala.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


@WebFilter(urlPatterns = {"/create","/update"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init Filter Method");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter dofilter Method");

        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");

        if("admin".equals(username) && "admin".equals(password)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            servletResponse.getWriter().println("Invalid Credentials");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Destroy Filter Method");
    }
}

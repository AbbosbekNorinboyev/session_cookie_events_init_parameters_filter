package com.example.lesson6tasks.task2.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Filter implements jakarta.servlet.Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var request = (HttpServletRequest) servletRequest;
        var response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println("username: " + username);
        String requestURI = request.getRequestURI();
        System.out.println("requestURI: " + requestURI);
        if (!requestURI.equals("/login") && username == null) {
            response.sendRedirect("/login");
        } else {
            filterChain.doFilter(request, response);
        }
//        filterChain.doFilter(request, response);
    }
}

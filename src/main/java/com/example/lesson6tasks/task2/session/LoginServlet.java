package com.example.lesson6tasks.task2.session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.postgresql.Driver;

import java.io.IOException;
import java.sql.*;

@WebServlet(
        name = "com.example.lesson6tasks.task2.session.LoginServlet",
        value = "/login"
)
public class LoginServlet extends HttpServlet {
    public static Integer databaseUserId;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getSession().getCreationTime());
        System.out.println(req.getSession().getMaxInactiveInterval());

        String username = req.getParameter("username");
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lesson6_task?currentSchema=public",
                    "postgres",
                    "2210");
            var preparedStatement = connection.prepareStatement("select u.id from users u where u.username = ?;");
            preparedStatement.setString(1, username);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                req.getSession().setAttribute("username", username);
                databaseUserId = resultSet.getInt("id");
            }
            System.out.println("user id (db): " + databaseUserId);
            resp.sendRedirect("/views/home.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

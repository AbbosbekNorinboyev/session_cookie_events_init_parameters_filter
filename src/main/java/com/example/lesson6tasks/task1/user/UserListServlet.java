package com.example.lesson6tasks.task1.user;

import com.example.lesson6tasks.task1.classes.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.postgresql.Driver;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "com.example.lesson6tasks.task1.user.UserListServlet",
        urlPatterns = "/user/list"
)
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = new ArrayList<>();
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lesson6_task?currentSchema=public",
                    "postgres",
                    "2210");
            var preparedStatement = connection.prepareStatement("select * from users;");
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User build = User.builder()
                        .id(resultSet.getInt("id"))
                        .username(resultSet.getString("username"))
                        .build();
                userList.add(build);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/userList.jsp");
        req.setAttribute("userList", userList);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

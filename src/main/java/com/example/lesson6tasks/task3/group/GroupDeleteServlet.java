package com.example.lesson6tasks.task3.group;

import com.example.lesson6tasks.task1.classes.Groups;
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
        name = "com.example.lesson6tasks.task3.group.GroupDeleteServlet",
        value = "/delete/group/*"
)
public class GroupDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        int id = Integer.parseInt(pathInfo.substring(1));
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lesson6_task?currentSchema=public",
                    "postgres",
                    "2210");
            var preparedStatement = connection.prepareStatement("select * from groups g where g.id = ?;");
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Groups build = Groups.builder()
                        .id(resultSet.getInt("id"))
                        .group_name(resultSet.getString("group_name"))
                        .created_at(resultSet.getTimestamp("created_at").toLocalDateTime())
                        .count(resultSet.getInt("count"))
                        .build();
                req.setAttribute("build", build);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/group/delete.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        int id = Integer.parseInt(pathInfo.substring(1));
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lesson6_task?currentSchema=public",
                    "postgres",
                    "2210");
            var preparedStatement = connection.prepareStatement("delete from groups g where g.id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resp.sendRedirect("/group/list");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

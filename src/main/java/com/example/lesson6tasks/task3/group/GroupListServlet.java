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
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "com.example.lesson6tasks.task3.group.GroupListServlet",
        value = "/group/list"
)
public class GroupListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Groups> groupsList = new ArrayList<>();
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lesson6_task?currentSchema=public",
                    "postgres",
                    "2210");
            var preparedStatement = connection.prepareStatement("select * from groups g order by g.id");
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Groups build = Groups.builder()
                        .id(resultSet.getInt("id"))
                        .group_name(resultSet.getString("group_name"))
                        .created_at(resultSet.getTimestamp("created_at").toLocalDateTime())
                        .count(resultSet.getInt("count"))
                        .created_by(resultSet.getInt("created_by"))
                        .build();
                groupsList.add(build);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/group/groupList.jsp");
        req.setAttribute("groupsList", groupsList);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

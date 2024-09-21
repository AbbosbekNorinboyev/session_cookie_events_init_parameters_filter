package com.example.lesson6tasks.task3.student;

import com.example.lesson6tasks.task1.classes.Student;
import com.example.lesson6tasks.task2.session.LoginServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.postgresql.Driver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;

@WebServlet(
        name = "com.example.lesson6_task.task3.StudentUpdateServlet",
        value = "/update/student/*"
)
public class StudentUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        int id = Integer.parseInt(pathInfo.substring(1));
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lesson6_task?currentSchema=public",
                    "postgres",
                    "2210");
            var preparedStatement = connection.prepareStatement("select * from student s where s.id = ?;");
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Student build = Student.builder()
                        .id(resultSet.getInt("id"))
                        .full_name(resultSet.getString("full_name"))
                        .created_at(resultSet.getTimestamp("created_at").toLocalDateTime())
                        .age(resultSet.getInt("age"))
                        .group_id(resultSet.getInt("group_id"))
                        .created_by(resultSet.getInt("created_by"))
                        .build();
                req.setAttribute("build", build);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/student/update.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        int id = Integer.parseInt(pathInfo.substring(1));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        int groupId = Integer.parseInt(req.getParameter("id"));
        int databaseUserId = LoginServlet.databaseUserId;
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lesson6_task?currentSchema=public",
                    "postgres",
                    "2210");
            var preparedStatement = connection.prepareStatement("update student s set full_name = ?, age = ?, group_id = ?, created_by = ? where s.id = ?;");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, groupId);
            preparedStatement.setInt(4, databaseUserId);
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
            resp.sendRedirect("/student/list");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.example.lesson6tasks.task3.student;

import com.example.lesson6tasks.task1.classes.Student;
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

@WebServlet(
        name = "com.example.lesson6tasks.task3.StudentDeleteServlet",
        value = "/delete/student/*"
)
public class StudentDeleteServlet extends HttpServlet {
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
                        .build();
                req.setAttribute("build", build);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/student/delete.jsp");
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
            var preparedStatement = connection.prepareStatement("delete from student s where s.id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resp.sendRedirect("/student/list");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

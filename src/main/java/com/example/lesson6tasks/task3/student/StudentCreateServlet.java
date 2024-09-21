package com.example.lesson6tasks.task3.student;

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

@WebServlet(
        name = "com.example.lesson6tasks.task3.student.StudentCreateServlet",
        value = "/create/student"
)
public class StudentCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/student/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        int groupId = Integer.parseInt(req.getParameter("id"));
        int databaseUserId = LoginServlet.databaseUserId;
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lesson6_task?currentSchema=public",
                    "postgres",
                    "2210");
            var preparedStatement = connection.prepareStatement("insert into student(full_name, age, group_id, created_by) values (?,?,?,?);");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, groupId);
            preparedStatement.setInt(4, databaseUserId);
            preparedStatement.execute();
            resp.sendRedirect("/student/list");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

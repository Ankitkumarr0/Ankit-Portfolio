package com.portfolio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    private static final String INSERT_SQL =
        "INSERT INTO contacts (name, email, message) VALUES (?, ?, ?)";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        if (name == null || email == null || message == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "All fields are required.");
            return;
        }

        name = name.trim();
        email = email.trim();
        message = message.trim();

        if (name.length() < 2 || name.length() > 100 ||
            email.length() > 150 || !email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$") ||
            message.length() < 10 || message.length() > 5000) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Please enter valid form details.");
            return;
        }

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, message);

            if (statement.executeUpdate() == 1) {
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Message could not be saved.");
            }
        } catch (Exception exception) {
            throw new ServletException("Unable to save contact message. Check MySQL settings and server status.", exception);
        }
    }
}

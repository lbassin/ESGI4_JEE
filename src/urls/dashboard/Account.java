package urls.dashboard;

import utils.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/dashboard/account")
public class Account extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/dashboard/account.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = Database.getConnection();

        String username = req.getParameter("username");
        String usernameBDD = "";
        String email = req.getParameter("email");
        String emailBDD = "";
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm-password");
        String passwordBDD = "";

        HttpSession session = req.getSession();
        Integer id_account = (Integer) session.getAttribute("id_account");

        String querySelect = "SELECT * FROM `user` WHERE id = ? LIMIT 1";

        PreparedStatement statementSelect;
        ResultSet rsSelect;
        try {
            statementSelect = connection.prepareStatement(querySelect);
            statementSelect.setInt(1, id_account);
            rsSelect = statementSelect.executeQuery();

            if (rsSelect.next()) {
                usernameBDD = rsSelect.getString("username");
                emailBDD = rsSelect.getString("email");
                passwordBDD = rsSelect.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String queryUpdate = "UPDATE `user` SET username = ?, password = ?, email = ? WHERE id = ?";

        if (username.isEmpty()) {
            username = usernameBDD;
        }
        if (password.isEmpty() || !password.equals(confirmPassword)) {
            password = passwordBDD;
        }
        if (email.isEmpty()) {
            email = emailBDD;
        }

        PreparedStatement statementUpdate;
        try {
            statementUpdate = connection.prepareStatement(queryUpdate);
            statementUpdate.setString(1, username);
            statementUpdate.setString(2, password);
            statementUpdate.setString(3, email);
            statementUpdate.setInt(4, id_account);
            statementUpdate.executeUpdate();

            resp.sendRedirect("/login");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

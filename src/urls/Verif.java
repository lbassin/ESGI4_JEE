package urls;

import utils.Database;
import utils.Mail;
import utils.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/verif/*")
public class Verif extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Verif Get");

        this.getServletContext().getRequestDispatcher("/verif.jsp").forward(request, response);

        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String verif_id = pathParts[1];

        Connection connection = Database.getConnection();

        String querySelect = "SELECT id FROM `user` WHERE verif_id = ?  LIMIT 1";

        PreparedStatement statementSelect;
        ResultSet rs;
        try {
            statementSelect = connection.prepareStatement(querySelect);
            statementSelect.setString(1, verif_id);
            rs = statementSelect.executeQuery();

            while (rs.next()) {
                String queryUpdate = "UPDATE `user` SET verified = ? WHERE id = ?";

                PreparedStatement statementUpdate;
                try {
                    statementUpdate = connection.prepareStatement(queryUpdate);
                    statementUpdate.setInt(1, 1);
                    statementUpdate.setInt(2, rs.getInt("id"));
                    statementUpdate.executeUpdate();

                    response.sendRedirect("/login");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

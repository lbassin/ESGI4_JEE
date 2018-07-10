package urls;

import utils.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Register Get");
        this.getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm-password");

        try {
            this.validateEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            this.validationPassword(password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            this.validationPassword(confirmPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        User.registerUser(username, email, password);

        resp.sendRedirect("/login");
    }

    private void validateEmail(String email) throws Exception {
        if (email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    private void validationPassword(String password) throws Exception {
        if (password != null) {
            if (password.length() < 3) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }
}

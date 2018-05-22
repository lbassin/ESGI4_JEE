package urls;

import utils.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login Get");
        this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

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

        User user = new User(email, password);

        if (user.checkUser()) {
            req.getSession().setAttribute("email", email);
            resp.sendRedirect("/dashboard");
        } else {
            resp.sendRedirect("/login");
        }
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

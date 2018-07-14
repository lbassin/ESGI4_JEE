package urls.dashboard.url;

import utils.Mail;
import utils.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dashboard/url/new")
public class New extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/dashboard/url/new.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String longUrl = request.getParameter("url");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String availableAt = request.getParameter("startDate");
        String expiredAt = request.getParameter("endDate");

        int userId = Integer.parseInt(request.getSession().getAttribute("id_account").toString());
        User user = User.getUser(userId);

        utils.Url url = utils.Url.createShortUrl(longUrl, password, user, availableAt, expiredAt);

        if (email != null && email.length() > 0) {
            String message = "This is a link : " + url.getFullUrlShort();
            Mail.send(email, "Someone send you a link", message);
        }

        response.getWriter().write("{\"url\": \"" + url.getFullUrlShort() + "\"}");
    }
}

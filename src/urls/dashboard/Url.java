package urls.dashboard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/dashboard/url")
public class Url extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<utils.Url> urls = utils.Url.getAllByUser(1);

        request.setAttribute("urls", urls);
        this.getServletContext().getRequestDispatcher("/dashboard/url.jsp").forward(request, response);
    }
}

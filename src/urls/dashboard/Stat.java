package urls.dashboard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dashboard/url/*")
public class Stat extends HttpServlet {

    private int getUrlIdRequested(HttpServletRequest request) {
        String[] requestedUrl = request.getRequestURI().split("/");
        return Integer.parseInt(requestedUrl[requestedUrl.length - 1]);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        utils.Url url = utils.Url.getById(this.getUrlIdRequested(request));

        request.setAttribute("url", url);
        this.getServletContext().getRequestDispatcher("/dashboard/stat.jsp").forward(request, response);
    }
}

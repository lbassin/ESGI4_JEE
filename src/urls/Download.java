package urls;

import utils.Url;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dl/*")
public class Download extends HttpServlet {

    private String getShortUrlRequested(HttpServletRequest request) {
        String[] requestedUrl = request.getRequestURI().split("/");
        return requestedUrl[requestedUrl.length - 1];
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shortUrl = this.getShortUrlRequested(request);

        Url url = Url.getByShortUrl(shortUrl);
        String longUrl = url.getUrlLong();

        if (longUrl.length() > 0 && url.isProtected()) {
            this.getServletContext().getRequestDispatcher("/download_password.jsp").forward(request, response);
            return;
        }

        request.setAttribute("longUrl", longUrl);
        this.getServletContext().getRequestDispatcher("/download.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shortUrl = this.getShortUrlRequested(request);
        String password = request.getParameter("password");

        Url url = Url.getByShortUrl(shortUrl);
        boolean allowed = url.checkPassword(password);

        if (!allowed) {
            request.setAttribute("error", "Wrong password");
            this.getServletContext().getRequestDispatcher("/download_password.jsp").forward(request, response);
            return;
        }

        request.setAttribute("longUrl", url.getUrlLong());
        this.getServletContext().getRequestDispatcher("/download.jsp").forward(request, response);
    }
}

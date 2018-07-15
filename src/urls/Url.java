package urls;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet("/url")
public class Url extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String longUrl = req.getParameter("url");
        String password = req.getParameter("password");

        try {
            utils.Url url = utils.Url.createShortUrl(longUrl, password, null, null, null);
            resp.getWriter().write("{\"url\": \"" + url.getFullUrlShort() + "\"}");
        } catch (ParseException e) {
            e.printStackTrace();
            resp.getWriter().write("{\"url\": \"An error occured\"}");
        }
    }
}

package urls;

import utils.Url;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/url")
public class URL extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String url = req.getParameter("url");
        String password = req.getParameter("password");

        System.out.println(url + " " + password);

        Url.createShortUrl(url, password);

        resp.getWriter().write("{url: '" + url + "', password: '" + password + "'}");

//        Database.getConnection().prepareStatement()
    }
}

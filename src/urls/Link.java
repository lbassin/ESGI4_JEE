package urls;

import utils.Url;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lk/*")
public class Link extends HttpServlet {

    private String getShortUrlRequested(HttpServletRequest request) {
        String[] requestedUrl = request.getRequestURI().split("/");
        return requestedUrl[requestedUrl.length - 1];
    }

    private String generateCaptcha() {
        return "abcd";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Url url = Url.getByShortUrl(this.getShortUrlRequested(request));

        if (request.getSession().getAttribute("error") != null) {
            request.setAttribute("error", request.getSession().getAttribute("error"));
            request.getSession().removeAttribute("error");
        }

        request.removeAttribute("captcha");
        if (!url.isProtected()) {
            String captcha = this.generateCaptcha();

            request.getSession().setAttribute("captcha", captcha);
            request.setAttribute("captcha", captcha);
        }

        request.setAttribute("url", url);
        this.getServletContext().getRequestDispatcher("/link_password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shortUrl = this.getShortUrlRequested(request);

        String captcha = (String) request.getSession().getAttribute("captcha");
        request.getSession().removeAttribute("captcha");

        String passwordInput = request.getParameter("password");
        String captchaInput = request.getParameter("captcha");

        Url url = Url.getByShortUrl(shortUrl);

        String error = null;
        if (captcha == null && !url.checkPassword(passwordInput)) {
            error = "Wrong password";
        }

        if (captcha != null && !captcha.equals(captchaInput)) {
            error = "Wrong captcha";
        }

        if (error != null) {
            request.getSession().setAttribute("error", error);
            response.sendRedirect(request.getRequestURI());

            return;
        }

        url.addHistory(request.getRemoteAddr());
        response.sendRedirect(url.getUrlLong());
    }
}

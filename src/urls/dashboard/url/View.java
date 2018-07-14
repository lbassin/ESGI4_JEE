package urls.dashboard.url;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/dashboard/url/view/*")
public class View extends HttpServlet {

    private int getUrlIdRequested(HttpServletRequest request) {
        String[] requestedUrl = request.getRequestURI().split("/");
        return Integer.parseInt(requestedUrl[requestedUrl.length - 1]);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        utils.Url url = utils.Url.getById(this.getUrlIdRequested(request));

        ArrayList<Integer> history = url.getHistoryByMonth();
        String chartData = "";
        for (Integer value : history) {
            chartData = chartData.concat(value.toString()).concat(",");
        }
        chartData = chartData.substring(0, chartData.length() - 1);

        request.setAttribute("chartData", chartData);
        request.setAttribute("url", url);
        this.getServletContext().getRequestDispatcher("/dashboard/url/view.jsp").forward(request, response);
    }
}

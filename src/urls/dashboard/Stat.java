package urls.dashboard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/dashboard/url/*")
public class Stat extends HttpServlet {

    private int getUrlIdRequested(HttpServletRequest request) {
        String[] requestedUrl = request.getRequestURI().split("/");
        return Integer.parseInt(requestedUrl[requestedUrl.length - 1]);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        utils.Url url = utils.Url.getById(this.getUrlIdRequested(request));

        request.setAttribute("chartData", "1,2,3,2,3,2,5,1");
        ArrayList<Integer> history = url.getHistoryByMonth();
        String chartData = "";
        for (Integer value : history) {
            chartData = chartData.concat(value.toString()).concat(",");
        }
        chartData = chartData.substring(0, chartData.length() - 1);

        request.setAttribute("chartData", chartData);
        request.setAttribute("url", url);
        this.getServletContext().getRequestDispatcher("/dashboard/stat.jsp").forward(request, response);
    }
}

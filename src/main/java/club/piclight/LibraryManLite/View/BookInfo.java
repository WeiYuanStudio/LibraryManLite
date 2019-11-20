package club.piclight.LibraryManLite.View;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/bookinfo")
public class BookInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("isbn") != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("./WEB-INF/bookinfo.jsp");
            dispatcher.forward(req, resp);
        }
    }
}

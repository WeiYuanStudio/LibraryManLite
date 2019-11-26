package club.piclight.LibraryManLite.View;

import club.piclight.LibraryManLite.DAO.BookDAO;
import club.piclight.LibraryManLite.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/managebook")
public class ManageBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/managebook.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "storage":
                //获取参数信息
                String bookSN = req.getParameter("book_sn");
                String isbn = req.getParameter("isbn");
                int adminUID = ((User) req.getSession().getAttribute("user")).getUid();

                BookDAO.registerRealBook(bookSN, isbn);
                BookDAO.registerBookRecord(adminUID, bookSN);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/successpage.html");
                dispatcher.forward(req, resp);
                break;
            case "borrow":
                break;
            case "return":
                break;
        }
    }
}

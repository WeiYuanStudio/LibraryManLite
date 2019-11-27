package club.piclight.LibraryManLite.View;

import club.piclight.LibraryManLite.DAO.BookDAO;
import club.piclight.LibraryManLite.DAO.RecordDAO;
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
        try {
            //获取参数信息
            String action = req.getParameter("action");

            String bookSN = req.getParameter("book_sn");
            String isbn = req.getParameter("isbn");
            String uidStr = req.getParameter("uid"); //这里parse可能会导致Exception，因为表单提交不完整
            int adminUID = ((User) req.getSession().getAttribute("user")).getUid();

            switch (action) {
                case "storage":
                    BookDAO.registerRealBook(bookSN, isbn);
                    BookDAO.registerBookRecord(adminUID, bookSN);
                    break;

                case "borrow":
                    if (!RecordDAO.bookBorrowable(bookSN)) { //如果不可借，抛错
                        throw new RuntimeException("Book not borrowable");
                    }
                    RecordDAO.borrowBookRecord(Integer.parseInt(uidStr), adminUID, bookSN);
                    break;

                case "return":
                    break;
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/successpage.html");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/errorpage.html");
            dispatcher.forward(req, resp);
        }
    }
}

package club.piclight.LibraryManLite.View;

import club.piclight.LibraryManLite.DAO.LMSessionFactory;
import club.piclight.LibraryManLite.Model.Book;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/bookregister")
public class BookRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/registerbook.html");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取POST请求数据
        String isbn = req.getParameter("isbn");
        String title = req.getParameter("title");
        String publisher = req.getParameter("publisher");
        String author = req.getParameter("author");
        String publishDate = req.getParameter("publish_date");
        String coverImg = req.getParameter("cover_img");
        String intro = req.getParameter("intro");
        //检查表单提交
        if (isbn.equals("") || title.equals("") || publisher.equals("") || author.equals("") || publishDate.equals("") || coverImg.equals("") || intro.equals("")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/errorpage.html");
            dispatcher.forward(req, resp);
        } else {
            Book book = new Book( //实例化表单提交数据
                    isbn,
                    title,
                    publisher,
                    author,
                    publishDate,
                    coverImg,
                    intro
            );
            SqlSession session = LMSessionFactory.getSession(); //请求SqlSession
            session.insert("addBook", book); //执行SQL语句
            session.commit(); //提交
            session.close(); //关闭session
            //转发成功提示
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/successpage.html");
            dispatcher.forward(req, resp);
        }
    }
}

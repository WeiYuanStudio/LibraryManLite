package club.piclight.LibraryManLite.View;

import club.piclight.LibraryManLite.DAO.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/signup")
public class UserRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/registeruser.html");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //取POST请求数据
            String userName = req.getParameter("username");
            String gender = req.getParameter("gender");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            //检查表单提交，非法抛错
            if (userName.equals("") || gender.equals("") || email.equals("") || password.equals(""))
                throw new IllegalArgumentException("Post Parameter Illegal");

            UserDAO.Register(userName, gender.charAt(0), email, password);
            
            //操作成功提示转发
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/successpage.html");
            dispatcher.forward(req, resp);
        } catch (Exception e) { //异常提示转发
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/errorpage.html");
            dispatcher.forward(req, resp);
        }
    }
}

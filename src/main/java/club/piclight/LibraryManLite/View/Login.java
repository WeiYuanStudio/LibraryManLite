package club.piclight.LibraryManLite.View;

import club.piclight.LibraryManLite.DAO.UserDAO;
import club.piclight.LibraryManLite.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/login.html");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username"); //取请求参数用户名
        String password = req.getParameter("password"); //取请求参数密码
        if (!username.equals("") || !password.equals("")) {
            User loginUser = UserDAO.login(username, password); //数据库请求登录
            if (loginUser != null) { //如果登录成功
                req.getSession().setAttribute("user", loginUser); //设置Session
                //转发到成功登录页，该页面js控制登录后跳转
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/loginsuccess.html");
                dispatcher.forward(req, resp);
            }
        }
        //登录失败转发到失败页
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/loginfailed.html");
        dispatcher.forward(req, resp);
    }
}

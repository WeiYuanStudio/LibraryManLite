package club.piclight.LibraryManLite.View;

import club.piclight.LibraryManLite.DAO.LMSessionFactory;
import club.piclight.LibraryManLite.Model.User;
import org.apache.ibatis.session.SqlSession;

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
        //取POST请求数据
        String userName = req.getParameter("username");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        //检查表单提交
        if (userName.equals("") || gender.equals("") || email.equals("") || password.equals("")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/errorpage.html");
            dispatcher.forward(req, resp);
        } else {
            User user = new User(-1, //实例化表单提交数据
                    userName,
                    gender.charAt(0),
                    email,
                    password);
            SqlSession session = LMSessionFactory.getSession(); //获取SqlSession
            session.insert("registerUser", user); //执行Sql语句
            session.commit(); //提交
            session.close(); //关闭Session
            //转发成功提示
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/successpage.html");
            dispatcher.forward(req, resp);
        }
    }
}

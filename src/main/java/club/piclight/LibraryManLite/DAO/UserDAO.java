package club.piclight.LibraryManLite.DAO;

import club.piclight.LibraryManLite.Model.User;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class UserDAO {
    public static User login(String username, String password) throws IOException {
        try {
            SqlSession session = LMSessionFactory.getSession();
            List<User> userList = session.selectList("getUserByName", username);
            if (password.equals(userList.get(0).getPassword())) { //比对第一个匹配用户名的用户的密码
                return userList.get(0);
            } else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static void Register(String userName, char gender, String email, String password) throws IOException {
        User user = new User(-1, //实例化表单提交数据
                userName,
                gender,
                email,
                password);

        SqlSession session = LMSessionFactory.getSession(); //获取SqlSession
        session.insert("registerUser", user); //执行Sql语句
        session.commit(); //提交
        session.close(); //关闭Session
    }
}

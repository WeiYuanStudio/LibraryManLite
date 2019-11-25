package club.piclight.LibraryManLite.DAO;

import club.piclight.LibraryManLite.Model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
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
}

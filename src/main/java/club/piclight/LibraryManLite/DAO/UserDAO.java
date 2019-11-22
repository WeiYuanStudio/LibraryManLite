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
        String resource = "./mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        List<User> userList = session.selectList("getUserByName", username);
        User user = userList.get(0); //获取查询到的第一个用户
        if (password.equals(userList.get(0).getPassword())) {
            return userList.get(0);
        }
        return null;
    }
}

package club.piclight.LibraryManLite.DAO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class LMSessionFactory {
    private static LMSessionFactory lmSessionFactory;
    private static SqlSessionFactory sqlSessionFactory;
    private LMSessionFactory() throws IOException {
        String resource = "./mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    private SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

    public static SqlSession getSession() throws IOException {
        if (lmSessionFactory == null) {
            lmSessionFactory = new LMSessionFactory();
        }
        return lmSessionFactory.openSession();
    }
}

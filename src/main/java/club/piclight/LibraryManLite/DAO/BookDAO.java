package club.piclight.LibraryManLite.DAO;

import club.piclight.LibraryManLite.Model.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BookDAO {
    public static List<Book> getBooksByName(String bookName) throws IOException {
        String resource = "./mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        List<Book> books = session.selectList("getBooksByTitle", bookName);
        return books;
    }

    public static Book getBookByISBN(String isbn) {
        if (isbn.equals("9780321714114")) {
            Book tmpBook = new Book("9780321714114",
                    "C++ Primer (5th Edition)",
                    "Addison-Wesley Professional",
                    "Stanley B.",
                    "2012",
                    "https://s1.ax1x.com/2019/11/19/MRSjh9.jpg",
                    "C++ Primer Book");
            return tmpBook;
        } else
            return null;
    }
}

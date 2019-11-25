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
        SqlSession session = LMSessionFactory.getSession();
        List<Book> books = session.selectList("getBooksByTitle", bookName);
        session.close();
        return books;
    }

    public static Book getBookByISBN(String isbn) throws IOException {
        SqlSession session = LMSessionFactory.getSession();
        try {
            List<Book> books = session.selectList("getBookByISBN", isbn);
            session.close();
            return books.get(0); //Todo:MyBatis查询结果不要返回List
        } catch (Exception e) {
            return null;
        }
    }
}

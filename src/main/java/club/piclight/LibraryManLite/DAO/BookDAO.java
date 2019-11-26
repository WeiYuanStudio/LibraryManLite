package club.piclight.LibraryManLite.DAO;

import club.piclight.LibraryManLite.Model.Book;
import club.piclight.LibraryManLite.Model.RealBook;
import club.piclight.LibraryManLite.Model.Record;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class BookDAO {
    /**
     * 通过书名获取书本List
     * @param bookName
     * @return
     * @throws IOException
     */
    public static List<Book> getBooksByName(String bookName) throws IOException {
        SqlSession session = LMSessionFactory.getSession();
        List<Book> books = session.selectList("getBooksByTitle", bookName);
        session.close();
        return books;
    }

    /**
     * 通过ISBN查询该书信息
     * @param isbn
     * @return
     * @throws IOException
     */
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

    /**
     * 注册BookSN到数据库
     * @param bookSN
     * @param isbn
     * @throws IOException
     */
    public static void registerRealBook(String bookSN, String isbn) throws IOException {
        SqlSession session = LMSessionFactory.getSession();
        RealBook realBook = new RealBook(bookSN, isbn);
        session.insert("addRealBook", realBook);
        session.commit();
        session.close();
    }

    /**
     * 注册书且记录Record表
     * @param adminUID
     * @param bookSN
     * @throws IOException
     */
    public static void registerBookRecord(int adminUID, String bookSN) throws IOException {
        SqlSession session = LMSessionFactory.getSession();
        Record record = new Record(-1,
                -1,
                adminUID,
                bookSN,
                3,
                null
        );
        session.insert("purchaseBook", record);
        session.commit();
        session.close();
    }
}

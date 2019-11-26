package club.piclight.LibraryManLite.DAO;

import club.piclight.LibraryManLite.Model.RealBook;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RealBookDAO {
    public static List<RealBook> getRealBooks() {
        SqlSession sqlsession = null;
        try {
            sqlsession = LMSessionFactory.getSession();
            List<RealBook> realBooks = sqlsession.selectList("listRealBooks");
            return realBooks;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<RealBook> getRealBooksByISBN(String isbn) {
        SqlSession sqlsession = null;
        try {
            sqlsession = LMSessionFactory.getSession();
            List<RealBook> realBooks = sqlsession.selectList("listRealBooksByISBN", isbn);
            return realBooks;
        } catch (Exception e) {
            return null;
        }
    }
}

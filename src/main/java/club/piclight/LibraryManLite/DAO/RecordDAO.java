package club.piclight.LibraryManLite.DAO;

import club.piclight.LibraryManLite.Model.Record;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class RecordDAO {
    public static final int OPERATE_BORROW = 1;
    public static final int OPERATE_RETURN = 2;
    public static final int OPERATE_PURCHASE = 3;

    public static void borrowBookRecord(int customerUID, int adminUID, String bookSN) throws IOException {
        SqlSession session = LMSessionFactory.getSession();
        Record record = new Record(-1,
                customerUID,
                adminUID,
                bookSN,
                OPERATE_BORROW,
                null);
        session.insert("borrowBook", record);
        session.commit();
        session.close();
    }
}

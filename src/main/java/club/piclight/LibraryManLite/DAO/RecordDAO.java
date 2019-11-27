package club.piclight.LibraryManLite.DAO;

import club.piclight.LibraryManLite.Model.Record;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

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

    /**
     * 判断该书是否可借
     * @return
     * @throws IOException
     */
    public static boolean bookBorrowable(String bookSN) throws IOException {
        SqlSession session = LMSessionFactory.getSession();
        List<Record> recordList = session.selectList("getDescRecordByBookSN", bookSN);
        int lastestOperate = recordList.get(0).getOperateID(); //获取最后一次记录的operateID
        return lastestOperate == OPERATE_RETURN || lastestOperate == OPERATE_PURCHASE;
    }

    public static int bookLastestOperate(String bookSN) throws IOException {
        SqlSession session = LMSessionFactory.getSession();
        List<Record> recordList = session.selectList("getDescRecordByBookSN", bookSN);
        int lastestOperate = recordList.get(0).getOperateID(); //获取最后一次记录的operateID
        return lastestOperate;
    }

    public static void returnBookRecord(int adminUID, String bookSN) throws IOException {
        SqlSession session = LMSessionFactory.getSession();
        Record record = new Record(-1,
                -1,
                adminUID,
                bookSN,
                OPERATE_RETURN,
                null
                );
        session.insert("returnBook", record);
        session.commit();
        session.close();
    }
}

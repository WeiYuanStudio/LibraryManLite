package club.piclight.LibraryManLite.Model;

import java.sql.Timestamp;

public class Record {
    private int recordID;
    private int customerUID;
    private int adminUID;
    private String bookSN;
    private int operateID;
    private Timestamp operateDate;

    public Record(int recordID, int customerUID, int adminUID, String bookSN, int oprateID, Timestamp oprateDate) {
        this.recordID = recordID;
        this.customerUID = customerUID;
        this.adminUID = adminUID;
        this.bookSN = bookSN;
        this.operateID = oprateID;
        this.operateDate = oprateDate;
    }

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public int getCustomerUID() {
        return customerUID;
    }

    public void setCustomerUID(int customerUID) {
        this.customerUID = customerUID;
    }

    public int getAdminUID() {
        return adminUID;
    }

    public void setAdminUID(int adminUID) {
        this.adminUID = adminUID;
    }

    public String getBookSN() {
        return bookSN;
    }

    public void setBookSN(String bookSN) {
        this.bookSN = bookSN;
    }

    public int getOperateID() {
        return operateID;
    }

    public void setOperateID(int operateID) {
        this.operateID = operateID;
    }

    public Timestamp getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Timestamp operateDate) {
        this.operateDate = operateDate;
    }
}

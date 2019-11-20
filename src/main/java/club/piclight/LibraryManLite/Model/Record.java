package club.piclight.LibraryManLite.Model;

import java.sql.Date;

public class Record {
    private int recordID;
    private String customerUID;
    private String adminUID;
    private String bookSN;
    private int oprateID;
    private Date oprateDate;

    public Record(int recordID, String customerUID, String adminUID, String bookSN, int oprateID, Date oprateDate) {
        this.recordID = recordID;
        this.customerUID = customerUID;
        this.adminUID = adminUID;
        this.bookSN = bookSN;
        this.oprateID = oprateID;
        this.oprateDate = oprateDate;
    }

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public String getCustomerUID() {
        return customerUID;
    }

    public void setCustomerUID(String customerUID) {
        this.customerUID = customerUID;
    }

    public String getAdminUID() {
        return adminUID;
    }

    public void setAdminUID(String adminUID) {
        this.adminUID = adminUID;
    }

    public String getBookSN() {
        return bookSN;
    }

    public void setBookSN(String bookSN) {
        this.bookSN = bookSN;
    }

    public int getOprateID() {
        return oprateID;
    }

    public void setOprateID(int oprateID) {
        this.oprateID = oprateID;
    }

    public Date getOprateDate() {
        return oprateDate;
    }

    public void setOprateDate(Date oprateDate) {
        this.oprateDate = oprateDate;
    }
}

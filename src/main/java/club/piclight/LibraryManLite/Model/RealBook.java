package club.piclight.LibraryManLite.Model;

public class RealBook {
    private String bookSN;
    private String isbn;

    public RealBook(String bookSN, String isbn) {
        this.bookSN = bookSN;
        this.isbn = isbn;
    }

    public String getBookSN() {
        return bookSN;
    }

    public void setBookSN(String bookSN) {
        this.bookSN = bookSN;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

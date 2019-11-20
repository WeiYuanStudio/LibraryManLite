package club.piclight.LibraryManLite.DAO;

import club.piclight.LibraryManLite.Model.Book;

import java.util.ArrayList;

public class BookDAO {
    public static ArrayList<Book> getBooksByName(String bookName) {
        if (bookName.equals("C++")) {
            ArrayList<Book> books = new ArrayList<Book>();
            books.add(new Book("9780321714114",
                    "C++ Primer (5th Edition)",
                    "Addison-Wesley Professional",
                    "Stanley B.",
                    "2012",
                    "https://s1.ax1x.com/2019/11/19/MRSjh9.jpg",
                    "C++ Primer Book"));
            books.add(new Book("9780321714114",
                    "C++ Primer (5th Edition)",
                    "Addison-Wesley Professional",
                    "Stanley B.",
                    "2012",
                    "https://pictures.abebooks.com/isbn/9780321714114-us.jpg",
                    "C++ Primer Book"));
            return books;
        } else
            return null;
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

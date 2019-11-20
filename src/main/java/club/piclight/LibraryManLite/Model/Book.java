package club.piclight.LibraryManLite.Model;

public class Book {
    private String isbn;
    private String title;
    private String publisher;
    private String author;
    private String publishDate;
    private String coverImg;
    private String intro;

    public Book(String isbn, String title, String publisher, String author, String publishDate, String coverImg, String intro) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.publishDate = publishDate;
        this.coverImg = coverImg;
        this.intro = intro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}

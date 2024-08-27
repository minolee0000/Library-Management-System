package dto;

public class BookDto {
    private String bookID;
    private String  bookName;
    private String author;
    private Boolean availability;
    
    public BookDto() {
    }

    public BookDto(String bookID, String bookName, String author, Boolean availability) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.availability = availability;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "BookDto [bookID=" + bookID + ", bookName=" + bookName + ", author=" + author + ", availability="
                + availability + "]";
    }

    
}

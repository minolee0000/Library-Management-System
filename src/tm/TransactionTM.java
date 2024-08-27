package tm;

import java.util.Date;

public class TransactionTM {
    private String transactionID;
    private String bookID;
    private String userID;
    private String releasedDate ;
    private double fine;
    
    public TransactionTM() {
    }

    public TransactionTM(String transactionID, String bookID, String userID, String releasedDate, double fine) {
        this.transactionID = transactionID;
        this.bookID = bookID;
        this.userID = userID;
        this.releasedDate = releasedDate;
        this.fine = fine;
    }

    public TransactionTM(String transactionID, String bookID, String userID, String releasedDate) {
        this.transactionID = transactionID;
        this.bookID = bookID;
        this.userID = userID;
        this.releasedDate = releasedDate;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "TransactionTM [transactionID=" + transactionID + ", bookID=" + bookID + ", userID=" + userID
                + ", releasedDate=" + releasedDate + ", fine=" + fine + "]";
    }

}

package com.company;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class of borrows
 */
public class Borrow implements Serializable {

    private User user;
    private Book book;
    private String dateBegin;
    private String dateEnd;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Method constructor of Borrow
     * @param user is an Object User
     * @param book is an Objet Book
     */
    public Borrow(User user, Book book) {
        this.user = user;
        this.book = book;
        this.dateBegin = sdf.format(new Date());
        this.dateEnd = null;

    }

    @Override
    public String toString() {
        return "Borrow{" +
                "user=" + user +
                ", book=" + book +
                ", dateBegin='" + dateBegin + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                '}';
    }
    public void setReturnDate(){
        this.dateEnd = sdf.format(new Date());
    }


    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

}

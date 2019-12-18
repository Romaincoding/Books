package com.company;

import java.util.ArrayList;
import java.util.List;
/**
 * Class which manages the books
 */
public class BookMgt {

    private static ArrayList<Book> booksList = new ArrayList<Book>();

    /**
     * Function which creates a new book if it did not exist in the list
     *
     * @param title title of the book
     * @param ref unique String reference for a book
     * @param year parution date of the book
     * @param editorName name of the editor of the book
     */
    public static void addBook(String title, String ref, int year, String editorName) {
        for (Book book : booksList) {
            if (book.getRef().equals(ref)) {
                System.out.println("Book  already exists!");
                return;
            }
        }
        Book book = new Book(title, ref, year, editorName);
        booksList.add(book);
    }

    /**
     * Function that allows to find a book if it exists in the list
     * @param ref unique String reference for a book
     * @return an Object Book
     */
    static Book findBook(String ref) {
        for (Book book : booksList) {
            if (book.getRef().equals(ref)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Function that allows to delete a book
     * @param ref unique String reference for a book
     */
    static void removeBook(String ref) {
        for (Book book : booksList) {
            if (book.getRef().equals(ref)) {
                booksList.remove(book); }
        }
    }
            /**
             * Function that allows to display the list of all the books
             * @return list of all the books
             */
            public static ArrayList<Book> getBooksList () {
                return booksList;
            }
}


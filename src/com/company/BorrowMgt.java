package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class which manages the borrows
 */

public class BorrowMgt {

    public static final ArrayList<Borrow> borrowList = new ArrayList<Borrow>();
    private BorrowLogger logger;

    BorrowMgt() {

    }

   public static void createBorrow(String firstName, String lastName, String bookRef) {
       User user = UserMgt.findUser(firstName, lastName);
       Book book = null;
       if (user != null) {
           book = BookMgt.findBook(bookRef);
           if (book != null) {
               if (getBorrow(book) != null) {
                   CommandMenu.myPrint("Red", "Book already borrowed");
               } else {
                   borrowList.add(new Borrow(user,book));
                   CommandMenu.myPrint("Green", firstName + " " + lastName + " has borrowed " + "Book " + bookRef);
               }
           }
           else {
               CommandMenu.myPrint("Red", "Book does not exist");
           }
       } else {
           CommandMenu.myPrint("Red", "User does not exist"); //- si l'utilisateur n'existe pas on affiche une erreur.
       }
   }

   static Borrow getBorrow(Book book) {
       for (Borrow borrow : borrowList) {
           if (borrow.getBook().equals(book)) {
               return borrow;
           }
       }
       return null;
   }

    /**
     * Function that allows to signal the ends of a book's borrowing
     * @param bookRef unique String reference for a book
     * @return the recap of the borrow
     */
  public static void returnBook (String bookRef) {
        Book book = BookMgt.findBook(bookRef);
         if(book != null){
             Borrow borrow = getBorrow(book);
             if(borrow != null){
                 borrow.setReturnDate();
             }
             else{
                 System.out.println("Borrow not found!");
             }
         }else{
             System.out.println("Bookref not found!");
         }
   }

    /**
     * Function that display the list the borrows
     * @return a list of borrows
     */
    public static void listBorrows() {
        for (Borrow borrow: borrowList){
            System.out.println(borrow.toString());
        }
    }
}

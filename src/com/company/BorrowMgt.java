package com.company;


import java.util.ArrayList;


/**
 * Class which manages the borrows
 */

public class BorrowMgt {

    private static ArrayList<Borrow> borrowList = new ArrayList<Borrow>();


    BorrowMgt() {

    }

    /**
     * Function that allows to create a borrow
     * @param firstName of the user
     * @param lastName of the suer
     * @param bookRef unique String reference for a book
     */
   public static void createBorrow(String firstName, String lastName, String bookRef) {
       User user = UserMgt.findUser(firstName, lastName);
       Borrow borrow;
       Book book;
       if (user != null) {
           book = BookMgt.findBook(bookRef);
           if (book != null) {
               borrow = getBorrow(book);
               if (borrow != null && borrow.getDateEnd() == null) {
                   CommandMenu.myPrint("Red", "Book already borrowed");
               } else {
                   borrowList.add(borrow = new Borrow(user, book));

                   CommandMenu.myPrint("Green", firstName + " " + lastName + " has borrowed " + "Book " + bookRef + " " +borrow.getDateBegin());
               }
           } else {
               CommandMenu.myPrint("Red", "Book does not exist");

           }

       } else {
           CommandMenu.myPrint("Red", "User does not exist"); //- si l'utilisateur n'existe pas on affiche une erreur.
       }
   }


    /**
     * Function that allows to get a borrow from a book
     * @param book is an Object Book
     * @return an Oject Borrow
     */
   static Borrow getBorrow(Book book) {
       for (Borrow borrow : borrowList) {
           if (borrow.getBook().equals(book)) {
               return borrow;
           }
       }
       return null;
   }

    /**
     * Function that allows to get a borrow from a user
     * @param user is an Object Book
     * @return an Oject Borrow
     */
    static Borrow getBorrow(User user) {
        for (Borrow borrow : borrowList) {
            if (borrow.getUser().equals(user)) {
                return borrow;
            }
        }
        return null;
    }

    /**
     * Function that allows to signal the ends of a book's borrowing
     * @param bookRef unique String reference for a book
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
     * Function that displays the list the borrows
     * @return a list of borrows
     */
    public static void listBorrows() {
        for (Borrow borrow: borrowList){
            System.out.println(borrow.toString());
        }
    }
    public static ArrayList<Borrow> getBorrowList() {
        return borrowList;
    }

    public static void setBorrowList(ArrayList<Borrow> borrowList) {
        BorrowMgt.borrowList = borrowList;
    }
}


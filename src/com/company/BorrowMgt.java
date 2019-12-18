package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class qui gère l'emprunt
 */

public class BorrowMgt {

    public static final ArrayList<Borrow> borrowList = new ArrayList<Borrow>();
    private BorrowLogger logger;


    BorrowMgt() {


    }

   public static void addBorrow(String firstName, String lastName, String bookRef) {
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



//
//   static User getUser(String bookRef) {
//       User b = borrowMap.get(bookRef);
//        if (b == null) {
//            System.out.println("Book not found for key=" + bookRef);
//        }
//        return b;
//    }


    /**
     * Function that allows to signal the ends of a book's borrowing
     * @param bookref unique String reference for a book
     * @return the recap of the loan
     */
   static  void returnBook (String bookRef) {
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

//- cette commande prend en paramètre la référence d'un livre
//            - si cette référence n'existe pas, alors on affiche une erreur
//            - si ce livre n'a pas été emprunté, on affiche une erreur
//            - si ce livre est actuellement emprunté, alors on met a jour l'objet emprunt associé pour mettre la date du rendu (mettre une date aléatoire mais qui soit supérieure à la date d'emprunt)
//            - afficher le récapitulatif de l'emprunt (utilisateur, ref livre, date d'emprunt, date de rendu)
//

    /**
     * Function that display the list of books that are borrowed
     * @return a list of books that are borrows
     */
    public static void listBorrows() {
        for (Borrow borrow: borrowList){
            System.out.println(borrow.toString());
        }
    }
}

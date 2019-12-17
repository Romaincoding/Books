package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Class qui gère l'emprunt
 */

public class Borrow {


    private static  Map<String, User> borrowMap = new HashMap<>(); ;
    private BorrowLogger logger;


    Borrow() {


    }

   public static void  addBorrow(String firstName, String lastName, String bookRef) {
        for(User user:UserMgt.getUserList()) {
           if(user.getFirstName().equals(firstName)  && user.getLastName().equals(lastName)) {

           }else{
               System.out.println("User does not exist"); //- si l'utilisateur n'existe pas on affiche une erreur.
           }
          for(Book book:BookMgt.getBooksList()) {
              if(book.getRef().equals(bookRef)){
                  if(borrowMap.containsKey(bookRef)) {
                      System.out.println("Book is already borrowed");
                  }else {
                      borrowMap.put(bookRef,user);
                  }

              }else {
                  System.out.println("Book does not exist"); // si la référence du livre n'existe pas on affiche une erreur.
              }
              }
          }
          }
//       if (borrowMap.containsKey(bookRef)) {
//           System.out.println("The book is already borrowed");
//       }
//      borrowMap.forEach(bookRef, User );
//
//        }
//       }
       Borrow b = new Borrow();
       borrowMap.put(bookRef, user);
        System.out.println("Add a borrow=" + b);


    }

   static User getUser(String bookRef) {
       User b = borrowMap.get(bookRef);
        if (b == null) {
            System.out.println("Book not found for key=" + bookRef);
        }
        return b;
    }

    public static Map<String, User> getBorrowMap() {
        return borrowMap;
    }
    /**
     * Function that allows to signal the ends of a book's borrowing
     * @param ref unique String reference for a book
     * @return the recap of the loan
     */
   static  void returnBook (String bookRef) {
       if(borrowMap.containsKey(bookRef)) {
           borrowMap.remove(bookRef);
       }else {
           System.out.println("This book is not borrowed");
       }
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
//    static ArrayList listBorrows() {
//- cette commande affiche la liste des emprunts
//- vous êtes libres du formalisme d'affichage mais toutes les informations doivent apparaitre
//            - nom et prénom de l'utilisateur, titre du livre + référence (il faut donc aller chercher le titre à partir de la référence stockée dans l'emprunt), date de début d'emprunt, date de rendu ou vide si pas encore rendu.
//}
//
//
//    [>] Les emprunts
//- nom de l'utilisateur (chaine de caractères)
//            - le prénom de l'utilisateur (chaine de caractères)
//            - la référence du livre (chaine de caractères)
//- la date du jour de l'emprunt (vous êtes libres du format exact à implémenter)
//            - la date de rendu (vous êtes libres du format exact à implémenter. N'oubliez pas de spécifier la valeur à utiliser pour un livre qui n'a pas encore été rendu)


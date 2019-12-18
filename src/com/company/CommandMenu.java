package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class qui gère les commandes
 */

public class CommandMenu {


    Boolean programIsOn;


    static void myPrint(String color, String message) {
        switch (color) {
            case "Blue":
                System.out.println("\033[34m" + message + "\033[0m");
                break;
            case "Green":
                System.out.println("\033[32m" + message + "\033[0m");
                break;
            case "Red":
                System.out.println("\033[31m" + message + "\033[0m");
                break;
            case "Yellow":
                System.out.println("\033[33m" + message + "\033[0m");
                break;
            default:
                System.out.println("Error Unknown Color");
        }
    }

    static void addUser() {
       try{ System.out.println("Format to addUser : firstname, lastname, daybirth, monthbirth, yearofbirth:");
        Scanner sc = new Scanner(System.in);
        String entry = sc.nextLine();
        String [] split = entry.split(" ");
       // String outputEntry = split[0] +" "+ split [1] + " " + split[2] + " " + split[3] + " " + split[4];
        UserMgt.addUser(split[0], split[1], setToInt(split[2]), setToInt(split[3]), setToInt(split[4]));
       }catch (Exception e){
           e.getStackTrace();
       }

       }

//        try {
//            String firstName = getLine("What is your first name? :");
//            String lastName = getLine("What is your last name? :");
//            int dayBirth = getInt("What is your day of birth?:",1,31);
//            int monthBirth = getInt("What is your month of birth?:", 1, 12);
//            int yearBirth = getInt("What is your year of birth?:",1900,2021);
//
//            UserMgt.addUser(firstName, lastName, dayBirth, monthBirth, yearBirth);
//
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//    }

    static void editUser(){
        String firstName = getLine("What is your first name? :");
        String lastName = getLine("What is your last name? :");
        User user = UserMgt.findUser(firstName, lastName);
        if(user != null){
           firstName = getLine("What is your new first name? :");
           if(firstName.equals("") == false){
               user.setFirstName(firstName);
           }

           lastName = getLine("What is your new last name? :");
            if(lastName.equals("") == false){
                user.setLastName(lastName);
            }

            int dayBirth = getInt("What is your new day of birth?:",1,31);
            if(dayBirth != -1){
                user.setDayBirth(dayBirth);
            }
            int monthBirth = getInt("What is your new month of birth?:",1,31);
            if(monthBirth != -1){
                user.setMonthBirth(monthBirth);
            }
            int yearBirth = getInt("What is your new year of birth?:",1900,2020);
            if(yearBirth != -1){
                user.setYearBirth(yearBirth);
            }
        }else{
            System.out.println("User does not exist!");
        }
    }

    static void removeUser(){
       UserMgt.removeUser("toto","beau");
    }
    static void removeBook(){
        BookMgt.removeBook("3");
    }

    static void addBorrow(){
         BorrowMgt.addBorrow("Michel","Polna","2");
    }
    static void endBorrow(){
       BorrowMgt.returnBook("2");
    }
    static void listBorrows(){
        BorrowMgt.listBorrows();
    }

    static boolean processCmd( String choice) throws Exception {
        boolean programIsOn = true;



        switch (choice) {
            default:
                System.out.println("Command not supported");
                break;
            case "help":
                displayHelp();
                break;

            case "quit":
                programIsOn = false;
                break;

            case "addUser":
                addUser();
                break;

            case "editUser":
                editUser();
                break;

            case "removeUser":
                 removeUser();
                 break;


            case "UsersList":
                System.out.println( UserMgt.getUserList());
                break;

            case "addBook":
               BookMgt.addBook("Le seigneur des anneaux","4356",1937,"Terre du milieu");

                break;
            case "editBook":

                editBook();
                break;

            case "removeBook":
                removeBook();
                break;

            case "BooksList":
                System.out.println(BookMgt.getBooksList());
                break;
            case "addBorrow":

                addBorrow();
                break;
            case "endBorrow":
                  endBorrow();           //  System.out.println(Borrow.getBorrowMap());
                break;
            case "listBorrows":
               listBorrows();
                break;
            case "save":
//                save();
                break;
            case "restore":
//                restore();
                break;
            case "test":
                BookMgt.addBook("Le seigneur des anneaux","1",1937,"Terre du milieu");
                BookMgt.addBook("Le seigneur des anus","2",1937,"Trou du milieu");
                BookMgt.addBook("Le seigneur des anales","3",1937,"Trous des milieux");
                UserMgt.addUser("toto", "beau", 2 ,7, 1982);
                UserMgt.addUser("tata", "yoyo", 3 ,11, 1984);
                UserMgt.addUser("titi", "grominet", 3 ,11, 1984);
                BorrowMgt.addBorrow("toto", "beau","1");
                BorrowMgt.addBorrow("tata", "yoyo","2");
                BorrowMgt.addBorrow("titi", "grominet","2");
                BorrowMgt.listBorrows();
                BorrowMgt.returnBook("1");
                BorrowMgt.listBorrows();



        }
        return programIsOn;
    }

    /**
     * Function that displays the menu
     */
    static void displayHelp() {
        myPrint("Blue", "**********************************");
        myPrint("Blue", "*       Menu                     *");
        myPrint("Blue", "*  1-Help                        *");
        myPrint("Blue", "*  2-Exit                        *");
        myPrint("Blue", "*  3-addUser                     *");
        myPrint("Blue", "*  4-editUser                    *");
        myPrint("Blue", "*  5-removeUser                  *");
        myPrint("Blue", "*  6-listUser                    *");
        myPrint("Blue", "*  7-addBook                     *");
        myPrint("Blue", "*  8-editBook                    *");
        myPrint("Blue", "*  9-removeBook                  *");
        myPrint("Blue", "*  10-listBooks                  *");
        myPrint("Blue", "*  11-borrowBook                 *");
        myPrint("Blue", "*  12-returnBook                 *");
        myPrint("Blue", "*  13-listBorrows                *");
        myPrint("Blue", "*  14-save                       *");
        myPrint("Blue", "*  15-restore                    *");
        myPrint("Blue", "**********************************");

    }

    static void editBook() {
        String bookRef = getLine("What is the book reference? :");
       Book book = BookMgt.findBook(bookRef);
        if (book != null) {
            String title = getLine("What is the book's title? :");
            if (bookRef.equals("") == false) {
                book.setTitle(title);

            }
        }
    }
//    [#1] help
//- cette commande doit afficher toutes les commandes possibles de votre application ainsi que le formalisme (décrit ci-dessous pour chaque commande)
//
//[#2] exit
//- cette commande permet de sortir de la boucle infinie de votre application, et donc de terminer son exécution. C'est grâce à cette commmande exit que vous pouvez quitter votre application normalement.
//
//


//
//
//

    /**
     * Function that reads integer input
      * @param message to display
     * @return int
     */
   private static int getInt(String message,int min, int max) {
       try {
           System.out.println(message);
           Scanner sc = new Scanner(System.in);
          int number =  Integer.parseInt(sc.nextLine());
           if (number <= min || number >= max) {
               System.out.println("Please enter an integer value");
               return -1;
           }
           return number;
       } catch (Exception e) {
           System.out.println(e);
           System.out.println("Please enter an integer value");
           return -1;
       }
   }


    private static int getInt(String message){
      try{  System.out.println(message);
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        return number;
      }catch (Exception e) {

          System.out.println(e);
          return -1;
      }
    }

    private static int setToInt(String entry){
        int entryInt = Integer.parseInt(entry);
        return entryInt;
    }

    /**
     * Function that reads string input
     * @param message to display
     * @return string
     */
    private static String getLine(String message){
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        return string;

   }

    static void borrowBook(String firstName, String lastname, String ref) {
    }

    public static String getUserChoice() {
        return getLine("Enter your choice");
    }
//- cette commande prend en paramètre le prénom et le nom d'un utilisateur ainsi que la référence du livre à emprunter
//            - si l'utilisateur n'existe pas on affiche une erreur.
//            - si la référence du livre n'existe pas on affiche une erreur.
//            - si le livre a déjà été emprunté par qqun on affiche une erreur.
//- dans tous les autres cas, on stocke l'emprunt de ce livre par cet utilisateur avec la date du jour (mettre une valeur aléatoire pour le jour, le mois et l'année histoire d'avoir des dates différentes par emprunt)
//            - afficher le récapitulatif de l'emprunt (utilisateur, ref livre, date d'emprunt)
}



    /**
     * Function that save all the informations stored
     */
//    static void save() {
//- cette commande va sauvegarder toutes vos données liés aux utilisateurs, livres et emprunts sur le disque dur dans des fichiers.
//- vous êtes libres de sauvegarder un seul fichier qui contient toutes les données ou bien un fichier par utilisateur, un fichier par livre, un fichier par emprunt, ou bien toute combinaison intermédiaire.
//- le format des données à l'intérieur des fichiers peut etre du texte pur ou tout autre format qui vous semble plus pratique à manipuler.
//            - vous aurez un bonus sur l'évaluation si vous sauvegardez dans vos fichiers les objets RAM sérialisés (cf. sérialisation et désérialisation des objets Java)
//}

    /**
     * Function that restore all the informations of the last save
//     */
//     static void restore(){
//- cette commande va détecter la présence des fichiers sauvegardés précédemment (si ils existent) et va les ouvrir en lecture et récupérer les informations contenues dedans pour créer de nouveaux objets en mémoire (utilisateur, livre, emprunt).
//        }
//    }



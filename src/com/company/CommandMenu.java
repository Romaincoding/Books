package com.company;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
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

    /**Function that takes input of the user and process it
     *
     */
    static boolean getUserCommand() {
        myPrint("Yellow", "> Enter a command");
        Boolean programIsOn = true;
        Scanner sc = new Scanner(System.in);
        String entry = sc.nextLine();
        String[] split = entry.split(" ");
        String cmdName = split[0];

        switch (cmdName ) {

            default:
                System.out.println("Command " + cmdName + " not valid");
                break;

            case "adduser":
                addUser(entry);
                break;

            case "addbook":
                addBook(entry);
                break;

            case "createborrow":
                if (split.length < 3) {
                    myPrint("Red", "Missing attributes");
                } else {
                    BorrowMgt.addBorrow(split[1], split[2], split[3]);
                }
                break;

            case "help":
                displayHelp();
                break;

            case "exit":
                programIsOn = false;
                break;

            case "edituser":
                    editUser(entry);
                break;

            case "editbook":
                editBook(entry);
                break;

            case "removeuser":
              removeUser(entry);
              break;

            case "removebook":
               removeBook(entry);
                break;

            case "listusers":
                System.out.println( UserMgt.getUserList());
                break;

            case "listbooks":
                System.out.println(BookMgt.getBooksList());
                break;

            case "listborrow":
                listBorrows();
                break;

            case "save":
               save();
                break;

            case "restore":
                restore();
                break;

        }
        return programIsOn;
    }

    private static void restore() {
        System.out.println("To do");
    }

    private static void save() {
        System.out.println("To do");
    }


//    static void addUser() {
//        try{ System.out.println("Format to addUser : firstname, lastname, daybirth, monthbirth, yearofbirth:");
//            Scanner sc = new Scanner(System.in);
//            String entry = sc.nextLine();
//            String [] split = entry.split(" ");
//            if(split.length < 5){
//                myPrint("Red", "Missing attributes");
//            }
//            // String outputEntry = split[0] +" "+ split [1] + " " + split[2] + " " + split[3] + " " + split[4];
//            UserMgt.addUser(split[0], split[1], setToInt(split[2]), setToInt(split[3]), setToInt(split[4]));
//
//        }catch (Exception e){
//            e.getStackTrace();
//        }
//
//    }


    static void editUser(String message) {
        String[] split = message.split(" ");
        String firstName = "";
        String lastName = "";
        if (split.length == 3) {
            try {
               firstName = getString(split[1]);
               lastName = getString(split[2]);
            } catch (CliException e) {
                System.out.println(e.getMessage());
                return;
            }
        } else {
            myPrint("Red", "Missing attributes");
        }
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
            System.out.println("What is your new day of birth?");
            Scanner sc = new Scanner(System.in);
            int dayBirth = getInt(sc.nextLine(),1,31);
            if(dayBirth != -1){
                user.setDayBirth(dayBirth);
            }
            System.out.println("What is your new month of birth?");
            int monthBirth = getInt(sc.nextLine(),1,12);
            if(monthBirth != -1){
                user.setMonthBirth(monthBirth);
            }
            System.out.println("What is your new Year of birth?");
            int yearBirth = getInt(sc.nextLine(),1900,2020);
            if(yearBirth != -1){
                user.setYearBirth(yearBirth);
            }
        }else{
            System.out.println("User does not exist!");
        }
    }

    static void removeUser(String message){
        String[] split = message.split(" ");
        String firstName = "";
        String lastName = "";
        if (split.length == 3) {
            try {
                firstName = getString(split[1]);
                lastName = getString(split[2]);
            } catch (CliException e) {

                System.out.println(e.getMessage());
                return;
            }
        } else {
            myPrint("Red", "Missing attributes");
        }
        UserMgt.removeUser(firstName,lastName);
    }

    static void removeBook(String message)  {
        String[] split = message.split(" ");
        String bookRef = "";
        if (split.length == 2) {
            try {
                bookRef= (split[1]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        } else {
            myPrint("Red", "Missing attributes");
        }
        BookMgt.removeBook(bookRef);
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

    /**
     * Function that displays the menu
     */
    static void displayHelp() {

        System.out.println("adduser <firstName> <lastName> <dayOfBirth> <monthOfBirth> <yearOfBirth>");
        System.out.println("edituser <firstName> <lastName>");
        System.out.println("removeuser <firstName> <lastName>");
        System.out.println("listusers\n");

        System.out.println("addbook <title> <bookRef> <dateOfParution> <editorName>");
        System.out.println("editbook <bookRef>");
        System.out.println("removebook <bookRef");
        System.out.println("listbooks\n");

        System.out.println("createborrow <firstName> <lastName> <bookRef>");
        System.out.println("endborrow <bookRef>");
        System.out.println("listborrow\n");

        System.out.println("save");
        System.out.println("restore");
        System.out.println("help");
        System.out.println("exit");

    }

    static void addBook(String message) {
        String[] split = message.split(" ");

        if (split.length == 5) {
            try{
            String title = getString(split[1]);
            String bookRef = (split[2]);
            int dateOfParution = getInt(split[3], 1, 2019);
            String editorName = getString(split[4]);
            BookMgt.addBook(title,bookRef,dateOfParution,editorName);
            }
            catch (CliException e){
                System.out.println(e.getMessage());
            }
            } else {
            myPrint("Red", "Missing attributes");
            }
        }


    static void editBook(String message) {
        String [] split = message.split(" ");
        String bookRef ="";

        if (split.length == 2) {
            try {
                 bookRef = (split[1]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
          } else {
            myPrint("Red", "Missing attributes");
        }
        System.out.println("bookref=" + bookRef);
        Book book = BookMgt.findBook(bookRef);
        if (book != null) {
            String title = getLine("What is the book's title? :");
            if (bookRef.equals("") == false) {
                book.setTitle(title);
            }

                 bookRef = getLine("What is the book's reference? :");

            if (bookRef.equals("") == false && BookMgt.getBooksList().contains(book.getRef()) == false) {
                book.setRef(bookRef);
            }

            String dateOfParution = getLine("What's the date of parution?");
            if (dateOfParution.equals("") == false) {
                book.setDateOfParution(getInt(dateOfParution,0,2019));
            }
            String editorName= getLine("What's the name of editor?");
            if (editorName.equals("") == false) {
                book.setEditorName(editorName);
            }

        }
    }

   private static void addUser(String message){
        String [] split = message.split(" ");

       if (split.length == 6 ) {
          try {
              String firstName = getString(split[1]);
              String lastName = getString(split[2]);
              int dayBirth = getInt(split[3], 1, 31);
              int monthBirth = getInt(split[4], 1, 12);
              int yearBirth = getInt(split[5], 1900, 2019);
              UserMgt.addUser(firstName, lastName, dayBirth, monthBirth, yearBirth);
          } catch(CliException e){
              System.out.println(e.getMessage());
          }
       } else {
           myPrint("Red", "Missing attributes");

       }

   }

    private static String getString(String s) throws CliException{
        if (s.equals("") == true) {
            throw new CliException("Error,String is empty ");
        }
        if(isAlpha(s) == false) {
            throw new CliException("Error,not a String");
        }
        return s;
        }



    public static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    /**
     * Function that reads integer input
     * @param message to display
     * @return int
     */
    private static int getInt(String message,int min, int max) {
        if(message.equals("") == true){
            System.out.println("Found an empty field!");
            return -1;
        }
        try {
            int number = Integer.parseInt(message);
            if (number < min || number > max) {
                System.out.println("Please enter an integer value " + number);
                return -1;
            }
            return number;

        } catch(Exception e){
            System.out.println(e);
            System.out.println("Please enter an integer value");
            return -1;
        }
    }


//    private static int getInt(String message){
//        if(message.equals("")) {
//            System.out.println("VIDE");
//        }
//        try {
//            System.out.println(message);
//            Scanner sc = new Scanner(System.in);
//            int number = Integer.parseInt(sc.nextLine());
//            return number;
//        } catch (Exception e) {
//
//            System.out.println(e);
//            return -1;
//        }
//    }

//    private static int setToInt(String entry) {
//
//        if (entry.equals("")) {
//            return -1;
//        }
//        else{
//
//            try {
//                int entryInt = Integer.parseInt(entry);
//                return entryInt;
//            } catch (NumberFormatException f) {
//                // myPrint("Red", "Wait an integer's value and found " + entry);
//            }
//            return -1;
//        }
//    }

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
}


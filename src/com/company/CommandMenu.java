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

    /**Function that takes input of the user and process it
     *
     */
    static void getUserCommand() {
        Boolean programIsOn = true;
        Scanner sc = new Scanner(System.in);
        String entry = sc.nextLine();
        String[] split = entry.split(",");
        String firstSplit = split[0];

        switch (firstSplit ) {

            default:
                System.out.println("Command not valid");
                break;

            case "addUser":
                if (split.length < 5) {
                    myPrint("Red", "Missing attributes");
                } else {
                    System.out.println("J'arrive là?");
                    UserMgt.addUser(split[1], split[2], getInt(split[3], 1, 31), getInt(split[4], 1, 12), getInt(split[5], 1900, 2030));
                }
                break;

            case "addBook":
                if (split.length < 4) {
                    myPrint("Red", "Missing attributes");
                } else {
                    BookMgt.addBook(split[1], split[2], setToInt(split[3]), split[4]);
                }
                break;

            case "addBorrow":
                if (split.length < 3) {
                    myPrint("Red", "Missing attributes");
                } else {
                    BorrowMgt.addBorrow(split[1], split[2], split[3]);
                    break;
                }



            case "help":
                displayHelp();
                break;

            case "quit":
                programIsOn = false;
                break;

            case "editUser":
                if (split.length < 2) {
                    myPrint("Red", "Missing attributes");
                } else {
                    UserMgt.addUser("tata", "yoyo", 12, 12, 1987);
                    editUser(split[1], split[2]);
                }

                break;

            case "editBook":

                if (split.length < 1) {
                    myPrint("Red", "Missing attributes");
                } else {
                    editBook(split[1]);
                }
                break;

            case "removeUser":
                if (split.length < 2) {
                    myPrint("Red", "Missing attributes");
                } else {
                    UserMgt.removeUser(split[1], split[2]);
                }
                break;

            case "removeBook":
                if (split.length < 1) {
                    myPrint("Red", "Missing attributes");
                } else {
                    BookMgt.removeBook(split[1]);
                }
                break;

            case "UsersList":
                System.out.println( UserMgt.getUserList());
                break;

            case "BooksList":
                System.out.println(BookMgt.getBooksList());
                break;

            case "listBorrows":
                listBorrows();
                break;

        }
    }


    static void addUser() {
        try{ System.out.println("Format to addUser : firstname, lastname, daybirth, monthbirth, yearofbirth:");
            Scanner sc = new Scanner(System.in);
            String entry = sc.nextLine();
            String [] split = entry.split(" ");
            if(split.length < 5){
                myPrint("Red", "Missing attributes");
            }
            // String outputEntry = split[0] +" "+ split [1] + " " + split[2] + " " + split[3] + " " + split[4];
            UserMgt.addUser(split[0], split[1], setToInt(split[2]), setToInt(split[3]), setToInt(split[4]));

        }catch (Exception e){
            e.getStackTrace();
        }

    }


    static void editUser(String firstName,String lastName){
//        String firstName = getLine("What is your first name? :");
//        String lastName = getLine("What is your last name? :");
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

    static void addBook(){
        System.out.println("à faire");
    }

    static void editBook(String bookRef) {
        // bookRef = getLine("What is the book reference? :");
        Book book = BookMgt.findBook(bookRef);
        if (book != null) {
            String title = getLine("What is the book's title? :");
            if (bookRef.equals("") == false) {
                book.setTitle(title);
            }

                 bookRef = getLine("What is the book's reference? :");
            if (bookRef.equals("") == false) {
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

    /**
     * Function that reads integer input
     * @param message to display
     * @return int
     */
    private static int getInt(String message,int min, int max) {
        if(message.equals("") == true){
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


    private static int getInt(String message){
        if(message.equals("")) {
            System.out.println("VIDE");
        }
        try {
            System.out.println(message);
            Scanner sc = new Scanner(System.in);
            int number = Integer.parseInt(sc.nextLine());
            return number;
        } catch (Exception e) {

            System.out.println(e);
            return -1;
        }
    }

    private static int setToInt(String entry) {

        if (entry.equals("")) {
            return -1;
        }
        else{

            try {
                int entryInt = Integer.parseInt(entry);
                return entryInt;
            } catch (NumberFormatException f) {
                // myPrint("Red", "Wait an integer's value and found " + entry);
            }
            return -1;
        }
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


package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class which manages the CLI
 */

public class CommandMenu {

    Boolean programIsOn;

    /**
     * Function that allows to add color to a String
     * @param color to use
     * @param message to color
     */
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

    /**
     * Function that takes input of the user and process it
     * @return a boolean
     */
    static boolean getUserCommand() throws IOException, ClassNotFoundException {
        myPrint("Yellow", "> Enter a command");
        Boolean programIsOn = true;
        String cmdName = "";
        Scanner sc = new Scanner(System.in);
        String entry = sc.nextLine();
        String[] split = entry.split("\\s+");
        if (split.length > 0) {
            cmdName = split[0];
        } else {
            return programIsOn;
        }

        switch (cmdName ) {

            default:
                myPrint("Red","Command " + cmdName + " not valid, Please enter a valid command or try help");
                break;

            case "adduser":
                addUser(entry);
                break;

            case "addbook":
                addBook(entry);
                break;

            case "createborrow":
                addBorrow(entry);
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

            case "endborrow":
                endBorrow(entry);
                break;

            case "listusers":
                listUsers();
                break;

            case "listbooks":
                listBooks();
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

    /**
     * Function that displays command's format to apply
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

    /**
     * Function that add an user in a list if he did not exist before
     * @param message String which represents input of the user
     */
    private static void addUser(String message){
        String [] split = message.split("\\s+");

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
            myPrint("Red", "Wrong attributes");
        }
    }

    /**
     * Function that allows to update informations of an existing user
     * @param message String which represents input of the user
     */
    static void editUser(String message) {
        String[] split = message.split("\\s+");
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
            myPrint("Red", "Wrong attributes");
        }

        try {
            User user = UserMgt.findUser(firstName, lastName);
            if (user != null) {
                Borrow borrow = BorrowMgt.getBorrow(user);
                if (borrow != null) {
                    myPrint("Red", "Edit not possible, User is present in borrow's list");
                    return;
                }
                firstName = getLine("What is your new first name? :");
                if (firstName.equals("") == false) {
                    user.setFirstName(firstName);
                }

                lastName = getLine("What is your new last name? :");
                if (lastName.equals("") == false) {
                    user.setLastName(lastName);
                }
                System.out.println("What is your new day of birth?");
                Scanner sc = new Scanner(System.in);
                int dayBirth = getInt(sc.nextLine(), 1, 31);
                if (dayBirth != -1) {
                    user.setDayBirth(dayBirth);
                }
                System.out.println("What is your new month of birth?");
                int monthBirth = getInt(sc.nextLine(), 1, 12);
                if (monthBirth != -1) {
                    user.setMonthBirth(monthBirth);
                }
                System.out.println("What is your new Year of birth?");
                int yearBirth = getInt(sc.nextLine(), 1900, 2020);
                if (yearBirth != -1) {
                    user.setYearBirth(yearBirth);
                }
            } else {
                System.out.println("User does not exist!");
            }
        }catch (Exception e){
            System.out.println("Date exception" + e.getMessage());
        }
    }

    /**
     * Function that allows to delete a user with commandline
     * @param message String which represents input of the user
     */
    static void removeUser(String message){
        String[] split = message.split("\\s+");
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
            myPrint("Red", "Wrong attributes");
        }
        UserMgt.removeUser(firstName,lastName);
    }

    /**
     * Function that displays the list of users
     */
    static void listUsers(){
        System.out.println(UserMgt.getUserList());
    }
// methods for borrow

    /**
     *Function that allows to create a borrow with commandline
     * @param message String which represents input of the user
     */
    static void addBorrow(String message){
        String[] split = message.split("\\s+");
        if (split.length == 4) {
            try{
                String firstName = getString(split[1]);
                String lastName = getString(split[2]);
                String bookRef = (split[3]);
                BorrowMgt.createBorrow(firstName,lastName, bookRef);
            }
            catch (CliException e){
                System.out.println(e.getMessage());
            }
        } else {
            myPrint("Red", "Wrong attributes");
        }
    }

    /**
     *Function that allows to signal the ends of a book's borrowing
     * @param message String which represents input of the user
     */
    static void endBorrow(String message){
        String[] split = message.split("\\s+");
        String bookRef = "";
        if (split.length == 2) {
            try{
                bookRef = (split[1]);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                return;
            }
        } else {
            myPrint("Red", "Missing attributes");
        }
        BorrowMgt.returnBook(bookRef);
    }

    /**
     *Function that displays the list the borrows
     */
    static void listBorrows(){
        BorrowMgt.listBorrows();
    }

// methods for books

    /**
     *Function that allows to add a book with commandline
     * @param message String which represents input of  the user
     */
    static void addBook(String message) {
        String[] split = message.split("\\s+");

        if (split.length == 5) {
            try{
                String title = getString(split[1]);
                String bookRef = (split[2]);
                int dateOfParution = getInt(split[3], 1, 2019);
                String editorName = getString(split[4]);

                BookMgt.addBook(title,bookRef,dateOfParution,editorName);

            }
            catch (CliException e){
                System.out.println("Date issue : " + e.getMessage());
            }
        } else {
            myPrint("Red", "Wrong attributes");
        }
    }

    /**
     *Function that allows to update informations of a book with commandline
     * @param message String which represents input of  the user
     */
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
            myPrint("Red", "Wrong attributes");
        }
        try {
            Book book = BookMgt.findBook(bookRef);
            if (book != null) {
                Borrow borrow = BorrowMgt.getBorrow(book);
                if (borrow != null) {
                    myPrint("Red", "Edit not possible, Book is stored in borrow's list");
                    return;
                }
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
                    book.setDateOfParution(getInt(dateOfParution, 0, 2019));
                }
                String editorName = getLine("What's the name of editor?");
                if (editorName.equals("") == false) {
                    book.setEditorName(editorName);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     *Function that allows to delete a book with commandline
     * @param message String which represents input of  the user
     */
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
            myPrint("Red", "Wrong attributes");
        }
        BookMgt.removeBook(bookRef);
    }

    /**
     * function that allows to display the book's list with commandline
     */
    static void listBooks(){
        System.out.println(BookMgt.getBooksList());
    }


// tools

    /**
     * Function that checks a String
     * @param s is the String to check
     * @return a String checked
     * @throws CliException
     */
    private static String getString(String s) throws CliException{
        if (s.equals("") == true) {
            throw new CliException("Error,String is empty ");
        }
        if(isAlpha(s) == false) {
            throw new CliException("Error,not a String");
        }
        return s;
    }

    /**
     * Function that allows to check if numbers are presents in a String
     * @param name is the String to check
     * @return a boolean
     */
    public static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    /**
     * Function that reads integer input
     * @param message String that is processed
     * @param min integer reresents minimum limit
     * @param max integer represents maximum limit
     * @return* @return int value
     * @throws CliException
     */
    private static int getInt(String message,int min, int max) throws CliException {
        if(message.equals("") == true){
            System.out.println("Found an empty field!");
            return -1;
        }

        int number = Integer.parseInt(message);
        if (number > max) {
            //  myPrint("Blue","Please be serious " + number + "?" + " are you from the future?");
            throw new CliException("over the limit");
        }
        if (number < min){
            //   myPrint("Red",number + " Very old, you have to move with the times!");
            throw new CliException("under the limit");
        }
        return number;
    }

    /**
     * Function that reads string input
     * @param message String which represents input of the user
     * @return string
     */
    private static String getLine(String message){
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        return string;

    }
// save and restore
    /**
     * Function that save all the informations stored
     */
    private static void save(){
        try {
            Serializer.serializeBook(BookMgt.getBooksList());
            Serializer.serializeUser(UserMgt.getUserList());
            Serializer.serializeBorrow(BorrowMgt.getBorrowList());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Function that restore all the informations of the last save
     * */
    private static void restore() {
        try{
            BookMgt.setBooksList(Serializer.deserializeBook("book.save"));
            UserMgt.setUserList(Serializer.deserializeUser("user.save"));
            BorrowMgt.setBorrowList(Serializer.deserializeBorrow("borrow.save"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}


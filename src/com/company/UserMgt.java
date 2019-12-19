package com.company;

import java.util.ArrayList;
/**
 * Class which manages the users
 */
public class UserMgt {


    public static final ArrayList<User> userList = new ArrayList<User>();

    /**
     * Function that add an user in a list if he did not exists before
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param dayBirth day of birth of the user
     * @param monthBirth month of birth of the user
     * @param yearBirth year of birth of the user
     */
    public static void addUser(String firstName, String lastName, int dayBirth, int monthBirth, int yearBirth){
        for(User user:userList) {
            if (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
                System.out.println("User already exists!");
                return;
            }
        }
        User user = new User(firstName, lastName, dayBirth, monthBirth, yearBirth);
        userList.add(user);
        return;
    }
    /**
     * Function that allows to update informations of an existing user
     * @param firstName firstname of the user
     * @param lastName lastname of the user
     */
    public static User findUser( String firstName,  String lastName) {
        for(User user:userList) {
            if(user.getFirstName().equals(firstName)  && user.getLastName().equals(lastName)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Function that allows to delete a user
     * @param firstName firstname of the user
     * @param lastName lastname of the user
     */
    static void removeUser(String firstName, String lastName) {
        for(User user:userList) {
            if(user.getFirstName().equals(firstName)  && user.getLastName().equals(lastName)) {
                userList.remove(user);
                CommandMenu.myPrint("Blue","Delete ok");
                return;
            }
        }
        System.out.println(" User not found");
    }

    /**
     * Function that diplays the list of all users
     * @return a list of users
     */
    public static ArrayList<User> getUserList() {
        return userList;
    }
}

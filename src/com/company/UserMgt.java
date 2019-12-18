package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which manage the users
 */
public class UserMgt {


    public static final ArrayList<User> userList = new ArrayList<User>();


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
     * Function that allows to update informations of a user
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
//- cette commande recherche un utilisateur avec le meme nom ET prénom rentrés et va le supprimer de la liste.
//- si l'utilisateur recherché n'existe pas, alors on affiche un message d'erreur comme quoi il est introuvable.
//            - si l'utilisateur existe, il est supprimé de la liste en mémoire, et on affiche un message de réussite de l'effacement.
//- si l'utilisateur est en cours d'emprunt de livre, alors l'effacement de cet utilisateur ne pourra pas se faire et un message d'erreur sera affiché

    /**
     * Function that diplays the list of all users
     * @return a list of users
     */

    public static ArrayList<User> getUserList() {
        return userList;
    }
}

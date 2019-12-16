package com.company;

import java.util.ArrayList;
import java.util.List;

public class UserMgt {


    private static ArrayList<User> userList = new ArrayList<User>();


    public static void addUser(String firstName, String lastName, int dayBirth, int monthBirth, int yearBirth){
        User user = new User(firstName, lastName , dayBirth , monthBirth, yearBirth);
        userList.add(user);
    }
    /**
     * Function that allows to update informations of a user
     * @param firstName firstname of the user
     * @param lastName lastname of the user
     */
    User findUser( String firstName,  String lastName) {
        for(User user:userList) {
            if(user.getFirstName().equals(firstName)  && user.getLastName().equals(lastName)) {
              return user;
            }
        }
        return null;
    }


//        userList.contains();
//- la commande recherche un utilisateur avec exactement le patronyme rentré. Si l'utilisateur existe, alors la commande demande le nouveau nom (si on entre une chaine vide, alors pas de changement de nom), demande ensuite le nouveau prénom (si chaine vide, pas de changement) et va demander ensuite chaque champ du jour, mois, année de naissance (toujours avec la possibilité de ne pas changer la valeur en appuyant sur entrée pour laisser une chaine vide).
//            - la commande va ensuite vérifier les nouvelles informations entrées (comme le fait adduser) et enregistrer les modifications de l'utilisateur DANS LE MEME OBJET (on modifie l'utilisateur, on n'en créé pas de nouveau). SI une erreur est survenue dans la saisie des nouvelles valeurs (ex : le nouveau nom et le nouveau prénom existent deja, ou bien une nouvelle date de naissance qui n'est pas un entier) alors on ne modifie pas l'utilisateur et on affiche un message d'erreur.
//- si l'utilisateur recherché n'existe pas dans la liste, alors on affiche un message d'erreur.
//            - si l'utilisateur est en cours d'emprunt, alors on ne pourra pas le modifier et un message d'erreur sera affiché



    /**
     * Function that allows to delete a user
     * @param firstName firstname of the user
     * @param lastName lastname of the user
     */
    void removeUser(String firstName, String lastName) {
        for(User user:userList) {
            if(user.getFirstName().equals(firstName)  && user.getLastName().equals(lastName)) {
               userList.remove(user);
                CommandMenu.myPrint("Blue","Delete ok");
            }
        }
        return null;
    }
//- cette commande recherche un utilisateur avec le meme nom ET prénom rentrés et va le supprimer de la liste.
//- si l'utilisateur recherché n'existe pas, alors on affiche un message d'erreur comme quoi il est introuvable.
//            - si l'utilisateur existe, il est supprimé de la liste en mémoire, et on affiche un message de réussite de l'effacement.
//- si l'utilisateur est en cours d'emprunt de livre, alors l'effacement de cet utilisateur ne pourra pas se faire et un message d'erreur sera affiché
    }
    /**
     * Function that diplays the list of all users
     * @return a list of users
     */

    public static ArrayList<User> getUserList() {
        return userList;
    }
}

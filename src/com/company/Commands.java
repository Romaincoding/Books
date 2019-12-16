package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class qui gère les commandes
 */

public class Commands {
    private List<User> userList = new ArrayList<User>();
    private List<Book> booksList = new ArrayList<Book>();
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

    void addUser() {

        try {
            myPrint("Green", "What is your first name? :");
            Scanner sc = new Scanner(System.in);
            String firstName = sc.nextLine();

            System.out.println("What is your last name? :");
            Scanner sc1 = new Scanner(System.in);
            String lastName = sc1.nextLine();

            System.out.println("What is your day of birth?:");
            Scanner sc2 = new Scanner(System.in);
            int dayBirth = sc2.nextInt();

            System.out.println("What is your month of birth? :");
            Scanner sc3 = new Scanner(System.in);
            int monthBirth = sc3.nextInt();

            System.out.println("What is your year of birth? :");
            Scanner sc4 = new Scanner(System.in);
            int yearBirth = sc3.nextInt();

            User user = new User(firstName, lastName, dayBirth, monthBirth, yearBirth);
            userList.add(user);


        } catch (Exception e) {
            e.getStackTrace();


        }

    }

    /**
     * Function that allows to update informations of a user
     * @param firstName firstname of the user
     * @param lastName lastname of the user
     */
 void  editUser( String firstName,  String lastName) {
//        userList.equals();
//        userList.contains();
//- la commande recherche un utilisateur avec exactement le patronyme rentré. Si l'utilisateur existe, alors la commande demande le nouveau nom (si on entre une chaine vide, alors pas de changement de nom), demande ensuite le nouveau prénom (si chaine vide, pas de changement) et va demander ensuite chaque champ du jour, mois, année de naissance (toujours avec la possibilité de ne pas changer la valeur en appuyant sur entrée pour laisser une chaine vide).
//            - la commande va ensuite vérifier les nouvelles informations entrées (comme le fait adduser) et enregistrer les modifications de l'utilisateur DANS LE MEME OBJET (on modifie l'utilisateur, on n'en créé pas de nouveau). SI une erreur est survenue dans la saisie des nouvelles valeurs (ex : le nouveau nom et le nouveau prénom existent deja, ou bien une nouvelle date de naissance qui n'est pas un entier) alors on ne modifie pas l'utilisateur et on affiche un message d'erreur.
//- si l'utilisateur recherché n'existe pas dans la liste, alors on affiche un message d'erreur.
//            - si l'utilisateur est en cours d'emprunt, alors on ne pourra pas le modifier et un message d'erreur sera affiché
}

    /**
     * Function that allows to delete a user
     * @param firstName firstname of the user
     * @param lastName lastname of the user
     */
  void removeUser(String firstName, String lastName)
//- cette commande recherche un utilisateur avec le meme nom ET prénom rentrés et va le supprimer de la liste.
//- si l'utilisateur recherché n'existe pas, alors on affiche un message d'erreur comme quoi il est introuvable.
//            - si l'utilisateur existe, il est supprimé de la liste en mémoire, et on affiche un message de réussite de l'effacement.
//- si l'utilisateur est en cours d'emprunt de livre, alors l'effacement de cet utilisateur ne pourra pas se faire et un message d'erreur sera affiché

    /**
     * Function that diplays the list of all users
     * @return a list of users
     */
    ArrayList listUsers() {
//- affiche tous les utilisateurs
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

    static boolean processCmd(int choice) {
        boolean programIsOn = true;

        switch (choice) {
            default:
                System.out.println("Command not supported");
                break;
            case 1:
                displayHelp();
                break;

            case 2:
                programIsOn = false;
                break;

            case 3:

                addUser(new User());

                break;

            case 4:
                editUser();

                break;


            case 5:
                removeUser();
                break;


            case 6:
                listUsers();
                break;

            case 7:
                addBook();

                break;
            case 8:
                editBook();

                break;

            case 9:
                removeBook();
                break;

            case 10:
                listBooks();
            case 11:
                borrowBook();
            case 12:
                returnBook();
            case 13:
                listBorrows();
            case 14:
                save();
            case 15:
                restore();
        }
        return true;
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
     * Function wich creates a new book
     *
     * @param title      title of the book
     * @param ref        unique String reference for a book
     * @param year       parution date of the book
     * @param editorName name of the editor of the book
     */
    void addBook(String title, String ref, int year, String editorName) {
//- cherche d'abord un livre qui porte la meme référence (ou le même titre ET la même année ET le même distributeur). Si un livre avec la meme référence (ou le même titre ET la même année ET le même éditeur) existe deja dans la mémoire, alors on affiche un message d'erreur (avec les infos du livre existant par exemple)
//
    }

    /**
     * Function that allows to update information of a book
     *
     * @param ref unique String reference for a book
     */
  static void editBook(String ref) {
//- cette commande va rechercher une référence de livre dans les données et si elle le trouve va demander de remplacer toutes les infos qui y sont liées (comme dans la commande edituser).
//            - si la référence de livre n'est pas trouvée, alors on affiche un message d'erreur.
//- pour chaque champ de valeur, on peut laisser une chaine vide pour indiquer qu'on ne change pas la valeur (comme expliqué dans la commande edituser).
    }

    /**
     * Function that allows to delete a book
     *
     * @param ref unique String reference for a book
     */
  static  void removeBook(String ref) {
//- cette commande recherche une référence de livre et la supprime de la liste en mémoire.
//- si la référence n'est pas trouvée, un message d'erreur s'affiche.
//            - si la référence existe, il faut vérifier que personne n'a actuellement emprunté le livre. Si c'est le cas, un message d'erreur affichera que ce livre ne peut pas être supprimé car il est en cours d'emprunt.
    }

    /**
     * Function that allows to display the list of all the books
     *
     * @return list of all the books
     */
  static  ArrayList listBooks() {
// affiche tous les livres
    }

    //
//
    static void borrowBook(String firstName, String lastname, String ref) {
    }
//- cette commande prend en paramètre le prénom et le nom d'un utilisateur ainsi que la référence du livre à emprunter
//            - si l'utilisateur n'existe pas on affiche une erreur.
//            - si la référence du livre n'existe pas on affiche une erreur.
//            - si le livre a déjà été emprunté par qqun on affiche une erreur.
//- dans tous les autres cas, on stocke l'emprunt de ce livre par cet utilisateur avec la date du jour (mettre une valeur aléatoire pour le jour, le mois et l'année histoire d'avoir des dates différentes par emprunt)
//            - afficher le récapitulatif de l'emprunt (utilisateur, ref livre, date d'emprunt)
}

    /**
     * Function that allows to signal the ends of a book's borrowing
     * @param ref unique String reference for a book
     * @return the recap of the loan
     */
   static String returnBook (String ref) {
//- cette commande prend en paramètre la référence d'un livre
//            - si cette référence n'existe pas, alors on affiche une erreur
//            - si ce livre n'a pas été emprunté, on affiche une erreur
//            - si ce livre est actuellement emprunté, alors on met a jour l'objet emprunt associé pour mettre la date du rendu (mettre une date aléatoire mais qui soit supérieure à la date d'emprunt)
//            - afficher le récapitulatif de l'emprunt (utilisateur, ref livre, date d'emprunt, date de rendu)
}

    /**
     * Function that display the list of books that are borrowed
     * @return a list of books that are borrows
     */
    static ArrayList listBorrows() {
//- cette commande affiche la liste des emprunts
//- vous êtes libres du formalisme d'affichage mais toutes les informations doivent apparaitre
//            - nom et prénom de l'utilisateur, titre du livre + référence (il faut donc aller chercher le titre à partir de la référence stockée dans l'emprunt), date de début d'emprunt, date de rendu ou vide si pas encore rendu.
}
//
//

    /**
     * Function that save all the informations stored
     */
    static void save() {
//- cette commande va sauvegarder toutes vos données liés aux utilisateurs, livres et emprunts sur le disque dur dans des fichiers.
//- vous êtes libres de sauvegarder un seul fichier qui contient toutes les données ou bien un fichier par utilisateur, un fichier par livre, un fichier par emprunt, ou bien toute combinaison intermédiaire.
//- le format des données à l'intérieur des fichiers peut etre du texte pur ou tout autre format qui vous semble plus pratique à manipuler.
//            - vous aurez un bonus sur l'évaluation si vous sauvegardez dans vos fichiers les objets RAM sérialisés (cf. sérialisation et désérialisation des objets Java)
}

    /**
     * Function that restore all the informations of the last save
     */
     static void restore(){
//- cette commande va détecter la présence des fichiers sauvegardés précédemment (si ils existent) et va les ouvrir en lecture et récupérer les informations contenues dedans pour créer de nouveaux objets en mémoire (utilisateur, livre, emprunt).
        }
    }



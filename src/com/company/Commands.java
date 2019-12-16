package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class qui gère les commandes
 */

public class Commands {

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



    static void addUser() {


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
            if(dayBirth <= 1 || dayBirth >= 31) {
                System.out.println("Please enter a correct day of Birth");
            }

            System.out.println("What is your month of birth? :");
            Scanner sc3 = new Scanner(System.in);
            int monthBirth = sc3.nextInt();
            if(monthBirth <= 1 || monthBirth >= 12) {
                throw new Exception("Please enter a correct month of Birth");
            }

            System.out.println("What is your year of birth? :");
            Scanner sc4 = new Scanner(System.in);
            int yearBirth = sc4.nextInt();

//            User user = new User(firstName, lastName, dayBirth, monthBirth, yearBirth);
//            userList.add(user);
//            System.out.println(userList.get(0));


        } catch (Exception e) {
            e.getStackTrace();


        }


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


            case 2:
                programIsOn = false;
                break;

            case 3:

                addUser();



            case 4:
                //editUser("mich","mouch");

                break;


            case 5:
//                removeUser();
                break;


            case 6:
//                listUsers();
                break;

            case 7:
//                addBook();

                break;
            case 8:
//                editBook();

                break;

            case 9:
//                removeBook();
                break;

            case 10:
//                listBooks();
            case 11:
//                borrowBook();
            case 12:
//                returnBook();
            case 13:
//                listBorrows();
            case 14:
//                save();
            case 15:
//                restore();
        }
        return programIsOn;
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
//   static String returnBook (String ref) {
//       return null;
//   }
//- cette commande prend en paramètre la référence d'un livre
//            - si cette référence n'existe pas, alors on affiche une erreur
//            - si ce livre n'a pas été emprunté, on affiche une erreur
//            - si ce livre est actuellement emprunté, alors on met a jour l'objet emprunt associé pour mettre la date du rendu (mettre une date aléatoire mais qui soit supérieure à la date d'emprunt)
//            - afficher le récapitulatif de l'emprunt (utilisateur, ref livre, date d'emprunt, date de rendu)


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



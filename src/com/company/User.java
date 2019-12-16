package com.company;

import java.util.List;

/**
 * Class qui gère les utilisateurs
 */

public class User {


    private String firstName;
    private String lastName;
    private int dayBirth;
    private int monthBirth;
    private int yearBirth;
    private List<User> userList;




    public User(String firstName, String lastName, int dayBirth, int monthBirth, int yearBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayBirth = dayBirth;
        this.monthBirth = monthBirth;
        this.yearBirth = yearBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dayBirth=" + dayBirth +
                ", monthBirth=" + monthBirth +
                ", yearBirth=" + yearBirth +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDayBirth() {
        return dayBirth;
    }

    public int getMonthBirth() {
        return monthBirth;
    }

    public int getYearBirth() {
        return yearBirth;
    }


//    void addUser () {
//        User user = new User(this.firstName, this.lastName, this.dayBirth, this. monthBirth, this.yearBirth);
//        userList.add(user);


        //- La commande doit créer en mémoire un nouvel utilisateur. Un utilisateur devra être considéré comme déjà existant si le nom ET le prénom d'un utilisateur correspondent parfaitement au nom ET prénom dans la commande. Dans ce cas un message d'erreur affiche que l'utilisateur existe déjà.
//            - La commande doit vérifier que le jour de naissance est entre 1 et 31 (on ne vérifiera pas les dates comme le 29 février;) ), que le mois est entre 1 et 12.
//            - La commande vérifiera également que les 3 derniers paramètres sont bien des valeurs numériques entières, sinon affichera un message d'erreur.
//    }
//      void  edituser(firstName, lastName) {
//        userList.equals();
//        userList.contains();
//- la commande recherche un utilisateur avec exactement le patronyme rentré. Si l'utilisateur existe, alors la commande demande le nouveau nom (si on entre une chaine vide, alors pas de changement de nom), demande ensuite le nouveau prénom (si chaine vide, pas de changement) et va demander ensuite chaque champ du jour, mois, année de naissance (toujours avec la possibilité de ne pas changer la valeur en appuyant sur entrée pour laisser une chaine vide).
//            - la commande va ensuite vérifier les nouvelles informations entrées (comme le fait adduser) et enregistrer les modifications de l'utilisateur DANS LE MEME OBJET (on modifie l'utilisateur, on n'en créé pas de nouveau). SI une erreur est survenue dans la saisie des nouvelles valeurs (ex : le nouveau nom et le nouveau prénom existent deja, ou bien une nouvelle date de naissance qui n'est pas un entier) alors on ne modifie pas l'utilisateur et on affiche un message d'erreur.
//- si l'utilisateur recherché n'existe pas dans la liste, alors on affiche un message d'erreur.
//            - si l'utilisateur est en cours d'emprunt, alors on ne pourra pas le modifier et un message d'erreur sera affiché
//        }
//            void removeUser(firstName, lastName)
//- cette commande recherche un utilisateur avec le meme nom ET prénom rentrés et va le supprimer de la liste.
//- si l'utilisateur recherché n'existe pas, alors on affiche un message d'erreur comme quoi il est introuvable.
//            - si l'utilisateur existe, il est supprimé de la liste en mémoire, et on affiche un message de réussite de l'effacement.
//- si l'utilisateur est en cours d'emprunt de livre, alors l'effacement de cet utilisateur ne pourra pas se faire et un message d'erreur sera affiché

//[#6] listusers
//- affiche tous les utilisateurs



}

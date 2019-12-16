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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDayBirth(int dayBirth) {
        this.dayBirth = dayBirth;
    }

    public void setMonthBirth(int monthBirth) {
        this.monthBirth = monthBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }




        //- La commande doit créer en mémoire un nouvel utilisateur. Un utilisateur devra être considéré comme déjà existant si le nom ET le prénom d'un utilisateur correspondent parfaitement au nom ET prénom dans la commande. Dans ce cas un message d'erreur affiche que l'utilisateur existe déjà.
//            - La commande doit vérifier que le jour de naissance est entre 1 et 31 (on ne vérifiera pas les dates comme le 29 février;) ), que le mois est entre 1 et 12.
//            - La commande vérifiera également que les 3 derniers paramètres sont bien des valeurs numériques entières, sinon affichera un message d'erreur.
//    }



}

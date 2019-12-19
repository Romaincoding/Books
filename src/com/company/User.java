package com.company;


/**
 * Class that represents a user
 */

public class User {

    private String firstName;
    private String lastName;
    private int dayBirth;
    private int monthBirth;
    private int yearBirth;


    /**
     * Method constructor of User
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param dayBirth day of birth of the user
     * @param monthBirth month of birth of the user
     * @param yearBirth year of birth of the user
     */
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
}

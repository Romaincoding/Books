package com.company;

/**
 * Main class
 */

public class App {

    public static void main(String[] args) throws Exception {
        boolean programIsOn;

        do {
            programIsOn = CommandMenu.getUserCommand();

        }
        while (programIsOn);
    }
}

package com.company;



public class App {

    public static void main(String[] args) throws Exception {
        boolean programIsOn = true;
//            String message = FigletFont.convertOneLine("Hello les TPs !");
        do {
            programIsOn = CommandMenu.getUserCommand();

        }
        while (programIsOn == true);
    }
}

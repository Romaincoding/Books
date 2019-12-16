package com.company;

import java.util.List;

public class App {

    public static void main(String[] args) {
        boolean programIsOn = false;
//        List<User> userList = null;
//        Library library = new Library();
//        User user1 = new User("Michel","Polnareff",12,12,1956);
//        library.addUser(user1,userList);
//        User test = userList.get(0);
//       String test2 = test.toString();
//        System.out.println(test2);
        do {
            CommandMenu.displayHelp();
            int ch = CommandMenu.getUserChoice();
            // System.out.println(ch);
           programIsOn = CommandMenu.processCmd(ch);

        }
        while (programIsOn == true);

	// write your code here
    }
}

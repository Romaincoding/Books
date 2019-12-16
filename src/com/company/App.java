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
            UserMgt.addUser("michel", "polnareff",23,4,1345);
            UserMgt.addUser("gerald", "polnareff",23,4,1345);
            UserMgt.addUser("Robert", "polnareff",23,4,1345);
            System.out.println(UserMgt.getUserList());
            break;

        } while (programIsOn == true);




	// write your code here
    }
}

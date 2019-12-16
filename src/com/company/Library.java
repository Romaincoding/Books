package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Library  {
    public List<User> userList =null;
    private User user;


    public void addUser(User user,  List userList) {
        user = new User(user.getFirstName(), user.getLastName(), user.getDayBirth(), user.getMonthBirth(), user.getYearBirth());
        this.userList.add(user);

    }
}

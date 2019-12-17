package com.company;

import org.w3c.dom.ls.LSOutput;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Borrow {

    private User user;
    private String bookref;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private  String timestampStr = sdf.format(new Date());


}

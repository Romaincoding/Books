package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowLogger {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    void logToFile(String message) {

        String timestampStr = sdf.format(new Date());
        try {
            File f = new File("Borrowings.log");
            FileWriter fileWriter = new FileWriter(f, true);
            fileWriter.write(timestampStr + " - " +message + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


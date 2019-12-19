package com.company;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;

public class BorrowLogger {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static void logToFile(String message) {

        String timestampStr = sdf.format(new Date());
        try {
            File f = new File("save.Json");
            FileWriter fileWriter = new FileWriter(f, true);
            fileWriter.write(timestampStr + " - " +message + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializeBook(ArrayList<Book> book) throws IOException {

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        fout = new FileOutputStream("book.test");
        oos = new ObjectOutputStream(fout);
        oos.writeObject(book);
    }

    public static ArrayList<Book> deserializeBook(String file) throws IOException, ClassNotFoundException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        fis = new FileInputStream(file);
        ois = new ObjectInputStream(fis);
        return (ArrayList<Book>) ois.readObject();
    }


//   public static void logToGson(Object object,String file) throws IOException {
//        GsonBuilder gsonBuilder= new GsonBuilder();
//        Gson gson = gsonBuilder.create();
//       Writer writer = new FileWriter(file);
//       System.out.printf(gson.toJson(object));
//       System.out.printf(gson.);
//       logToFile(gson.toString());
//       }
}


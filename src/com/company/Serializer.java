package com.company;

import java.io.*;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Class which manages serialization
 */
public class Serializer {

    /**
     * Function that serializes ArrayList<Book> in a file
     * @param book is an ArrayList of books
     * @throws IOException
     */
    public static void serializeBook(ArrayList<Book> book) throws IOException {

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        fout = new FileOutputStream("book.save");
        oos = new ObjectOutputStream(fout);
        oos.writeObject(book);
    }

    /**
     * Function that parses a serialized 's list of books
     * @param file is a String which represents the file's name to parse
     * @return an ArrayList of books
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Book> deserializeBook(String file) throws IOException, ClassNotFoundException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        fis = new FileInputStream(file);
        ois = new ObjectInputStream(fis);
        return (ArrayList<Book>) ois.readObject();
    }

    /**
     * Function that serializes an ArrayList<User> in a file
     * @param user is an ArrayList of users
     * @throws IOException
     */
    public static void serializeUser(ArrayList<User> user) throws IOException {

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        fout = new FileOutputStream("user.save");
        oos = new ObjectOutputStream(fout);
        oos.writeObject(user);
    }

    /**
     ** Function that parses a serialized 's list of users
     * @param file is a String which represents the file's name to parse
     * @return an Arraylist of users
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<User> deserializeUser(String file) throws IOException, ClassNotFoundException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        fis = new FileInputStream(file);
        ois = new ObjectInputStream(fis);
        return (ArrayList<User>) ois.readObject();
    }

    /**
     * Function that serializes an ArrayList<Borrow> in a file
     * @param borrow is an Arraylist of borrows
     * @throws IOException
     */
    public static void serializeBorrow(ArrayList<Borrow> borrow) throws IOException {

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        fout = new FileOutputStream("borrow.save");
        oos = new ObjectOutputStream(fout);
        oos.writeObject(borrow);
    }

    /**
     ** Function that parses a serialized 's list of borrows
     * @param file is a String which represents the file's name to parse
     * @return an Arraylist of borrows
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Borrow> deserializeBorrow(String file) throws IOException, ClassNotFoundException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        fis = new FileInputStream(file);
        ois = new ObjectInputStream(fis);
        return (ArrayList<Borrow>) ois.readObject();
    }
}


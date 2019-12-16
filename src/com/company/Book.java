package com.company;

/**
 * Class qui gère les livres
 */

public class Book {
    private String title;
    private String ref;
    private int dateOfParution;
    private String editorName;

    public Book(String title, String ref, int dateOfParution, String editorName) {
        this.title = title;
        this.ref = ref;
        this.dateOfParution = dateOfParution;
        this.editorName = editorName;
    }
    public String getTitle() {
        return title;
    }

    public String getRef() {
        return ref;
    }

    public int getDateOfParution() {
        return dateOfParution;
    }

    public String getEditorName() {
        return editorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", ref='" + ref + '\'' +
                ", dateOfParution=" + dateOfParution +
                ", editorName='" + editorName + '\'' +
                '}';
    }
}

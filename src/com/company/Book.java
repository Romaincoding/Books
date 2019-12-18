package com.company;

/**
 * Class qui gère les livres
 */

public class Book {


    private String title;
    private String ref;
    private int dateOfParution;
    private String editorName;

    /**
     * Constructor method of Book
     * @param title title of the book
     * @param ref unique String reference for a book
     * @param dateOfParution date of parution date of the book
     * @param editorName name of the editor of the book
     */
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
    public void setTitle(String title) {
        this.title = title;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setDateOfParution(int dateOfParution) {
        this.dateOfParution = dateOfParution;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }
}

package com.company;

import java.util.ArrayList;
import java.util.List;

public class BookMgt {

    private static ArrayList<Book> booksList = new ArrayList<Book>();


    public static void addBook(String title, String ref, int year, String editorName) {
        Book book = new Book(title, ref, year, editorName);
        booksList.add(book);
//- cherche d'abord un livre qui porte la meme référence (ou le même titre ET la même année ET le même distributeur). Si un livre avec la meme référence (ou le même titre ET la même année ET le même éditeur) existe deja dans la mémoire, alors on affiche un message d'erreur (avec les infos du livre existant par exemple)
//
    }

    /**
     * Function that allows to update information of a book
     *
     * @param ref unique String reference for a book
     */
    Book findBook(String ref) {
        for (Book book : booksList) {
            if (book.getRef().equals(ref)) {
                return book;
            }
        }
        return null;
    }
//- cette commande va rechercher une référence de livre dans les données et si elle le trouve va demander de remplacer toutes les infos qui y sont liées (comme dans la commande edituser).
//            - si la référence de livre n'est pas trouvée, alors on affiche un message d'erreur.
//- pour chaque champ de valeur, on peut laisser une chaine vide pour indiquer qu'on ne change pas la valeur (comme expliqué dans la commande edituser).


    /**
     * Function that allows to delete a book
     *
     * @param ref unique String reference for a book
     */
    static void removeBook(String ref) {
        for (Book book : booksList) {
            if (book.getRef().equals(ref)) {
                booksList.remove(book);
//- cette commande recherche une référence de livre et la supprime de la liste en mémoire.
//- si la référence n'est pas trouvée, un message d'erreur s'affiche.
//            - si la référence existe, il faut vérifier que personne n'a actuellement emprunté le livre. Si c'est le cas, un message d'erreur affichera que ce livre ne peut pas être supprimé car il est en cours d'emprunt.
            }
        }
    }

            /**
             * Function that allows to display the list of all the books
             *
             * @return list of all the books
             */
            public static ArrayList<Book> getBooksList () {
                return booksList;
            }



}


package com.fernando.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Hereda de {@link Publication}
 *
 * @author : Fernando Ambrosio
 * @since : 22/04/2020
 */
public class Magazine extends Publication {

    private int id;

    public Magazine(String title, Date edititionDate, String editorial) {
        super(title, edititionDate, editorial);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String detailMagazine = "\n :: MAGAZINE ::"
                + "\n Titulo: " + getTitle()
                + "\n Editorial: " + getEditorial()
                + "\n Fecha Edicion: " + getEditionDate()
                + "\n Autoress: ";
        for (int i = 0; i < getAutores().length; i++) {
            detailMagazine += "\t" + getAutores()[i] + " ";
        }
        return detailMagazine;
    }

    public static ArrayList<Magazine> makeMagazineList() {
        ArrayList<Magazine> magazines = new ArrayList();
        String[] authors = new String[3];
        for (int i = 0; i < 3; i++) {
            authors[i] = "author " + i;
        }
        for (int i = 1; i <= 5; i++) {
            magazines.add(new Magazine("Revista " + i, new Date(), "Editorial " + i));
        }

        return magazines;
    }

}

package com.fernando.amazonviewer.model;

import java.util.ArrayList;

/**
 * Hereda de {@link Film}
 * @author : Fernando Ambrosio
 * @since : 22/04/2020
 */
public class Serie extends Film {

    private int id;
    private int sessionQuantity;
    private ArrayList<Chapter> chapters;

    public Serie(String title, String genre, String creator, int duration, int sessionQuantity) {
        super(title, genre, creator, duration);
        this.sessionQuantity = sessionQuantity;
    }

    public int getId() {
        return id;
    }

    public int getSessionQuantity() {
        return sessionQuantity;
    }

    public void setSessionQuantity(int sessionQuantity) {
        this.sessionQuantity = sessionQuantity;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\n :: SERIE ::"
                + "\n Titulo: " + getTitle()
                + "\n Genero: " + getGenre()
                + "\n Año: " + getYear()
                + "\n Creador: " + getCreator()
                + "\n Duracion: " + getDuration();
    }

    public static ArrayList<Serie> makeSeriesList() {
        ArrayList<Serie> series = new ArrayList();

        for (int i = 1; i <= 5; i++) {
            Serie serie = new Serie("Serie " + i, "genero " + i, "creador " + i, 1200, 5);
            serie.setChapters(Chapter.makeChaptersList(serie));
            series.add(serie);

        }

        return series;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void view() {
        setViewed(true);
    }

}

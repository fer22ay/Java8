package com.fernando.amazonviewer.model;

import com.fernando.amazonviewer.dao.MovieDAO;
import java.util.ArrayList;
import java.util.Date;

/**
 * Hereda de {@link Film} Implementa de {@link IVisualizable}
 *
 * @author : Fernando Ambrosio
 * @since : 22/04/2020
 */
public class Movie extends Film implements IVisualizable, MovieDAO {

    private int id;
    private int timeViewed;

    public Movie(){
        
    }
    
    public Movie(String title, String genero, String creator, int duration, short year) {
        super(title, genero, creator, duration);
        setYear(year);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeViewed() {
        return timeViewed;
    }

    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }

    @Override
    public String toString() {
        return "\n :: MOVIE ::"
                + "\n Titulo: " + getTitle()
                + "\n Genero: " + getGenre()
                + "\n Año: " + getYear()
                + "\n Creador: " + getCreator()
                + "\n Duración: " + getDuration();
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void stopToSee(Date dateI, Date dateF) {
        if (dateF.getTime() > dateI.getTime()) {
            setTimeViewed((int) (dateF.getTime() - dateI.getTime()));
        } else {
            setTimeViewed(0);
        }

    }

    public static ArrayList<Movie> makeMoviesList(){
        Movie movie = new Movie();
        return movie.read();
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void view() {
        setViewed(true);
        Movie movie = new Movie();
        movie.setMovieViewed(this);
        Date dateI = startToSee(new Date());
        
        for (int i = 0; i < 100000; i++) {
            System.out.println("............");
        }
        //Termine de verla.
        stopToSee(dateI, new Date());
        System.out.println();
        System.out.println("Visto: " + toString());
        System.out.println("Por: " + getTimeViewed() + " milisegundos");
    }

}

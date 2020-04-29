package com.fernando.amazonviewer.dao;

import com.fernando.amazonviewer.db.IDBConnection;
import static com.fernando.amazonviewer.db.DataBase.*;
import com.fernando.amazonviewer.model.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * MovieDAO - Data Access Object
 *
 * @author : Fernando Ambrosio
 * @since : 22/04/2020
 */
public interface MovieDAO extends IDBConnection {

    default Movie setMovieViewed(Movie movie) {
        try (Connection connection = connectToDB()){
            
            Statement statement = connection.createStatement();
            var query = "INSERT INTO " + TVIEWED + 
                    " ("+ TVIEWED_ID_MATERIAL +", "+TVIEWED_ID_ELEMENT+", "+TVIEWED_ID_USER+")"+
                    " VALUES("+TMATERIAL_ID[0]+", "+movie.getId()+", "+TUSER_ID+")";
            if (statement.executeUpdate(query) > 0) {
                System.out.println("Se marco en Visto.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

    default ArrayList<Movie> read() {
        ArrayList<Movie> movies = new ArrayList<>();
        try (Connection connection = connectToDB()) {
            var query = "SELECT * FROM " + TMOVIE;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Movie movie = new Movie(
                        rs.getString(TMOVIE_TITLE),
                        rs.getString(TMOVIE_GENRE),
                        rs.getString(TMOVIE_CREATOR),
                        Integer.valueOf(rs.getString(TMOVIE_DURATION)),
                        Short.valueOf(rs.getString(TMOVIE_YEAR)));

                movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
                movie.setViewed(getMovieViewed(preparedStatement,
                        connection, Integer.valueOf(rs.getString(TMOVIE_ID))));
                movies.add(movie);
            }
        } catch (SQLException e) {

        }
        return movies;
    }

    private boolean getMovieViewed(PreparedStatement preparedStatement, Connection connection, int id_movie) {
        boolean viewed = false;
        var query = "SELECT * FROM " + TVIEWED
                + " WHERE " + TVIEWED_ID_MATERIAL + "= ?"
                + " AND " + TVIEWED_ID_ELEMENT + "= ?"
                + " AND " + TVIEWED_ID_USER + "= ?";
        ResultSet rs = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, TMATERIAL_ID[0]);
            preparedStatement.setInt(2, id_movie);
            preparedStatement.setInt(3, TUSER_ID);

            rs = preparedStatement.executeQuery();
            viewed = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewed;
    }

}

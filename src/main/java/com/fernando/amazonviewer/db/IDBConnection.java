package com.fernando.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.fernando.amazonviewer.db.DataBase.*;

/**
 * Interfaz con la configuracion a la base de datos.
 * @author : Fernando Ambrosio
 * @since : 24/04/2020
 */
public interface IDBConnection {

    default Connection connectToDB() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL+DB, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Se establecio la conexion");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             return connection;
        }
    }

}

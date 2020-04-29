package com.fernando.amazonviewer.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.fernando.amazonviewer.model.Book;
import com.fernando.amazonviewer.model.Chapter;
import com.fernando.amazonviewer.model.Magazine;
import com.fernando.amazonviewer.model.Movie;
import com.fernando.amazonviewer.model.Serie;
import com.fernando.amazonviewer.makereport.Report;
import com.fernando.amazonviewer.util.AmazonUtil;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * <h1>AmazonViewer</h1>
 * AmazonView es un programa que permite visualizar Peliculas, Series con sus
 * respectivos Capitulos, Libros y Revistas. Te permite generar reportes
 * generales y con fecha del dia.
 * <p>
 * Existen algunas reglas como que todos los elementos pueden ser visualizados o
 * leidos a excepcion de las Magazines, estas solo puede ser vistas a moodo de
 * exposicion sin ser leidas.
 *
 * @author : Fernando Ambrosio
 * @version : 1.0
 * @since : 21/042020
 */
public class Main {

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        var exit = 0;
        do {
            System.out.println("BIENVENIDO AMAZON VIEWER");
            System.out.println("");
            System.out.println("Selecciona el número de la opción deseada");
            System.out.println("1. Películas");
            System.out.println("2. Series");
            System.out.println("3. Libros");
            System.out.println("4. Revistas");
            System.out.println("5. Reporte");
            System.out.println("6. Report Today");
            System.out.println("0. Salir");

            var response = AmazonUtil.validateUserResponseMenu(0, 6);

            switch (response) {
                case 0:
                    exit = 0;
                    break;
                case 1:
                    showMovies();
                    break;
                case 2:
                    showSeries();
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    showMagazines();
                    break;
                case 5:
                    makeReport();
                    exit = 1;
                    break;
                case 6:
                    makeReport(new Date());
                    exit = 1;
                    break;
                default:
                    System.out.println();
                    System.out.println("....!!Selecciona una opción!!...");
                    System.out.println();
                    exit = 1;
                    break;
            }
        } while (exit != 0);
    }

    static ArrayList<Movie> movies = new ArrayList<>();

    public static void showMovies() {
        movies = Movie.makeMoviesList();
        var exit = 1;

        do {
            System.out.println();
            System.out.println(":: PELÍCULAS ::");
            System.out.println();

            AtomicInteger atomicInteger = new AtomicInteger(1);
            movies.forEach(m -> System.out.println(atomicInteger.getAndIncrement() + ". " 
                    + m.getTitle() + " Visto: " + m.isViewed()));

//            for (int i = 0; i < movies.size(); i++) {
//                System.out.println(i + 1 + ". " + movies.get(i).getTitle() + " Visto: "
//                        + movies.get(i).isViewed());
//            }
            System.out.println("0. Regresar al Menu");
            System.out.println();

            var response = AmazonUtil.validateUserResponseMenu(0, movies.size());

            if (response == 0) {
                exit = 0;
                showMenu();
                break;
            }
            if (response > 0) {
                Movie movieSelected = movies.get(response - 1);
                movieSelected.view();

            }
        } while (exit != 0);
    }

    static ArrayList<Serie> series = Serie.makeSeriesList();

    public static void showSeries() {
        var exit = 1;

        do {
            System.out.println();
            System.out.println(":: SERIES ::");
            System.out.println();

            for (int i = 0; i < series.size(); i++) {
                System.out.println(i + 1 + ". " + series.get(i).getTitle() + " Visto: "
                        + series.get(i).isViewed());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();

            var response = AmazonUtil.validateUserResponseMenu(0, series.size());

            if (response == 0) {
                exit = 0;
                showMenu();
            }
            if (response > 0) {
                showChapters(series.get(response - 1).getChapters());
            }
        } while (exit != 0);
    }

    public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
        var exit = 1;

        do {
            System.out.println();
            System.out.println(":: CAPÍTULOS ::");
            System.out.println();

            for (int i = 0; i < chaptersOfSerieSelected.size(); i++) {
                System.out.println(i + 1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + "Visto: "
                        + chaptersOfSerieSelected.get(i).isViewed());
            }
            System.out.println("0. Regresar al Menu");
            System.out.println();

            var response = AmazonUtil.validateUserResponseMenu(0, chaptersOfSerieSelected.size());

            if (response == 0) {
                exit = 0;
            }

            if (response > 0) {
                Chapter chapterSelected = chaptersOfSerieSelected.get(response - 1);
                chapterSelected.view();

            }

        } while (exit != 0);
    }

    static ArrayList<Book> books = Book.makeBookList();

    public static void showBooks() {
        var exit = 1;

        do {
            System.out.println();
            System.out.println(":: LIBROS ::");
            System.out.println();

            for (int i = 0; i < books.size(); i++) {
                System.out.println(i + 1 + ". " + books.get(i).getTitle() + " Leido: "
                        + books.get(i).isReaded());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();

            var response = AmazonUtil.validateUserResponseMenu(0, books.size());

            if (response == 0) {
                exit = 0;
                showMenu();
            }

            if (response > 0) {
                Book bookSelected = books.get(response - 1);
                bookSelected.view();
            }
        } while (exit != 0);
    }

    public static void showMagazines() {

        ArrayList<Magazine> magazines = Magazine.makeMagazineList();
        var exit = 0;
        do {
            System.out.println();
            System.out.println(":: REVISTAS ::");
            System.out.println();

            AtomicInteger atomicInteger = new AtomicInteger(1);
            magazines.forEach(mg -> System.out.println(atomicInteger.getAndIncrement() + ". " + mg.getTitle()));
            
//            for (int i = 0; i < magazines.size(); i++) {
//                System.out.println(i + 1 + ". " + magazines.get(i).getTitle());
//            }

            System.out.println("0. Regresar al Menu");
            System.out.println();

            int response = AmazonUtil.validateUserResponseMenu(0, 0);

            if (response == 0) {
                exit = 0;
                showMenu();
            }
        } while (exit != 0);

    }

    public static void makeReport() {

        Report report = new Report();
        report.setNameFile("reporte");
        report.setExtension("txt");
        report.setTitle(":: VISTOS ::");
        StringBuilder contentReport = new StringBuilder();

        movies.stream().filter(m -> m.getIsViewed()).forEach(m -> contentReport.append(m.toString() + "\n"));
        
        //Consumer<Serie> seriesEach = m -> contentReport.append(m.toString() + "\n");
        Consumer<Serie> seriesEach = s -> {
            ArrayList<Chapter> chapters = s.getChapters();
            chapters.stream().filter(c -> c.getIsViewed())
                    .forEach(c -> contentReport.append(c.toString() + "\n"));
        };
        series.stream().forEach(seriesEach);
        
//        for (Movie movie : movies) {
//            if (movie.getIsViewed()) {
//                contentReport += movie.toString() + "\n";
//            }
//        }

//        for (Serie serie : series) {
//            ArrayList<Chapter> chapters = serie.getChapters();
//            for (Chapter chapter : chapters) {
//                if (chapter.getIsViewed()) {
//                    contentReport += chapter.toString() + "\n";
//                }
//            }
//        }
//
//        for (Book book : books) {
//            if (book.getIsReaded()) {
//                contentReport += book.toString() + "\n";
//            }
//        }
//
        report.setContent(contentReport.toString());
        report.makeReport();
        System.out.println("Reporte generado");
        System.out.println();

    }

    public static void makeReport(Date date) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-h-m-s-S");
        var dateString = df.format(date);
        Report report = new Report();

        report.setNameFile("reporte" + dateString);
        report.setExtension("txt");
        report.setTitle(":: VISTOS ::");

        SimpleDateFormat dfNameDays = new SimpleDateFormat("E, W MMM Y");
        dateString = dfNameDays.format(date);
        var contentReport = "Date: " + dateString + "\n\n\n";

        for (Movie movie : movies) {
            if (movie.getIsViewed()) {
                contentReport += movie.toString() + "\n";
            }
        }

        for (Book book : books) {
            if (book.getIsReaded()) {
                contentReport += book.toString() + "\n";
            }
        }

        report.setContent(contentReport.toString());
        report.makeReport();

        System.out.println("Reporte Generado");
        System.out.println();

    }

}

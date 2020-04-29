package com.fernando.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;
import com.fernando.amazonviewer.util.AmazonUtil;

/**
 *
 * Book
 * Clase Book hereda de {@link Publication} {@link IVisualizable}
 *
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 15 de febrero del 2020
 */
public class Book extends Publication implements IVisualizable {

    private int id;
    private String isbn;
    private boolean readed;
    private int timeReaded;
    private ArrayList<Page> pages;

    public Book(String title, Date editionDate, String editorial, String[] authors, ArrayList<Page> pages) {
        super(title, editionDate, editorial);
        setAutores(authors);
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * *
     * Metodo para indicar cuando el usuario a terminado de leer el libro.
     *
     * @return type String, SI o NO
     */
    public String isReaded() {
        var leido = "";
        if (readed == true) {
            leido = "SI";
        } else {
            leido = "NO";
        }

        return leido;
    }

    public boolean getIsReaded() {
        return readed;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public int getTimeReaded() {
        return timeReaded;
    }

    public void setTimeReaded(int timeReaded) {
        this.timeReaded = timeReaded;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        String detailBook = "\n :: BOOK ::"
                + "\n Titulo: " + getTitle()
                + "\n Editorial: " + getEditorial()
                + "\n Fecha Edición: " + getEditionDate()
                + "\n Autores: ";
        for (int i = 0; i < getAutores().length; i++) {
            detailBook += "\t" + getAutores()[i] + " ";
        }
        return detailBook;
    }

    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {

        if (dateF.getTime() > dateI.getTime()) {
            setTimeReaded((int) (dateF.getTime() - dateI.getTime()));
        } else {
            setTimeReaded(0);
        }

    }

    public void view() {
        setReaded(true);
        var dateI = startToSee(new Date());

        var i = 0;
        do {
            System.out.println(".............");
            System.out.println("Pagina " + getPages().get(i).getNumber());
            System.out.println(getPages().get(i).getContent());
            System.out.println(".............");

            if (i != 0) {
                System.out.println("1. Regresar Pagina");
            }
            System.out.println("2. Siguiente Pagina");
            System.out.println("0. Cerrar Libro");
            System.out.println();

            var response = AmazonUtil.validateUserResponseMenu(0, 2);
            if (response == 2) {
                i++;
            } else if (response == 1) {
                i--;
            } else if (response == 0 && i > 0) {
                break;
            }
        } while (i < getPages().size());

        //Termine de verla
        stopToSee(dateI, new Date());
        System.out.println();
        System.out.println("Leiste: " + toString());
        System.out.println("Por: " + getTimeReaded() + " milisegundos");
    }

    /**
     * *
     * Metodo para leer las paginas del libro.
     *
     * @return ArrayList de Book
     */
    public static ArrayList<Book> makeBookList() {
        ArrayList<Book> books = new ArrayList<>();

        String[] authors = new String[3];
        for (int i = 0; i < 3; i++) {
            authors[i] = "author " + i;
        }

        ArrayList<Page> pages = new ArrayList<>();
        var pagina = 0;
        for (int i = 0; i < 3; i++) {
            pagina = i + 1;
            pages.add(new Book.Page(pagina, "El contenido de la pagina " + pagina));
        }

        for (int i = 0; i <= 5; i++) {
            books.add(new Book("Libro: " + i, new Date(), " editorial " + i, authors, pages));
        }
        return books;
    }

    /**
     * Clase anidada.
     */
    public static class Page {

        private int id;
        private int number;
        private String content;

        public Page(int number, String content) {
            super();
            this.number = number;
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

    }

}

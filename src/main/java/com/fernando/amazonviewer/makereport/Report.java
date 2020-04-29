package com.fernando.amazonviewer.makereport;

/**
 * Report Clase reporte
 * <p>
 * Libreria que permite generar un archivo (reporte) con un contenido y
 * extension especifico.
 *
 * @author : Fernando Ambrosio
 * @version : 1.0
 * @since : 15/02/2020
 */
public class Report {

    private String nameFile;
    private String extension;
    private String title;
    private String content;

    public Report() {
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void makeReport() {

    }

}

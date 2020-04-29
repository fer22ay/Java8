package com.fernando.amazonviewer.util;

/**
 *
 * @author : Fernando Ambrosio
 * @since : 22/04/2020
 */
public enum Day {
    
    SUNDAY ("DOMINGO"),
    MONDAY ("LUNES"),
    TUESDAY ("MARTES"),
    WEDNESDAY ("MIERCOLES"),
    THURSDAY ("JUEVES"),
    FRIDAY ("VIERNES"),
    SATURDAY ("SABADO");
    
    private String spanish;
    
    private Day(String spanish){
        this.spanish = spanish;
    }
    
    public String getSpanish(){
        return spanish;
    }
}

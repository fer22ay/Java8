package com.fernando.javabasic.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author : Fernando Ambrosio
 * @since : 18/04/2020
 */
public class LambdaApp {

    public void ordenar() {
        List<String> lista = new ArrayList<>();
        lista.add("Mitocode");
        lista.add("Code");
        lista.add("Mito");
        lista.add("Arbol");

        /**
         * *
         * Bloque #1 JDK < 1.7.
         */
        Collections.sort(lista, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String elemento : lista) {
            System.out.println(elemento);
        }

        /**
         * Lambda.
         */
        Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));

        lista.forEach((elemento) -> {
            System.out.println(elemento);
        });

    }

    public void calcular() {
        Operacion operacion = (x, y) -> (x + y) / 2;
        System.out.println(operacion.calcular(2, 2));
    }

    public void calcularDos() {
        Operacion operacion = (x, y) -> {
            double a = 2.0;
            return (x + y) / 2 + a;
        };

        System.out.println(operacion.calcular(2, 3));
    }

    public void listasJava10() {
        List<String> list = List.of("Fernando", "Zeta", "Arbol");

        list.forEach((elemento) -> {
            System.out.println(elemento);
        });
    }
    
    public void listasSet(){
        Set<String> set = Set.of("Manzana", "Naranja", "Pera");
        
        set.forEach((elemento) -> {
            System.out.println(elemento);
        });
    }

    public static void main(String[] args) {

        LambdaApp app = new LambdaApp();
        app.listasJava10();
        //app.listasSet();

    }

}

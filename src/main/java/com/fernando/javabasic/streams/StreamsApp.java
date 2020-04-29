package com.fernando.javabasic.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase StreamsApp
 * Con metodos para representar el comportamiento de los streams en una lista de
 * objetos.
 *
 * @author : Fernando Ambrosio
 * @since : 18/04/2020
 */
public class StreamsApp {

    private List<String> list;
    private List<String> numbers;

    public StreamsApp() {
        list = new ArrayList<>();
        list.add("Yener");
        list.add("Fernando");
        list.add("Ambrosio");
        list.add("Macario");

        numbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
    }

    /**
     * *
     * Metodo que devuelve el string completo de la lista.
     */
    public void filtrar() {
        list.stream().filter(x -> x.startsWith("Y")).forEach(System.out::println);
        System.out.println("Buscar con expresion lamda");
        list.stream().filter(x -> x.startsWith("F")).forEach(x -> System.out.println(x));
    }

    /**
     * *
     * Metodo para ordenar la lista alfabeticamente o inverso.
     */
    public void ordenar() {
        System.out.println("-- Orden Alfabetico --");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("-- Orden Inverso --");
        list.stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out::println);
    }

    /**
     * *
     * Metodo para transformar los elementos uno a uno de la lista.
     */
    public void transformar() {
        System.out.println("Transformar a mayusculas la lista");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println("Forma tradicional");
        for (String x : numbers) {
            int num = Integer.parseInt(x) + 1;
            System.out.println(num);
        }

        System.out.println("Con streams");
        numbers.stream().map(x -> Integer.parseInt(x) + 1).forEach(System.out::println);
    }

    /**
     * *
     * Metodo que devuelve los primeros dos elementos de la lista.
     */
    public void limitar() {
        list.stream().limit(2).forEach(System.out::println);
    }

    /**
     * *
     * Metodo para contar cuantos elementos tiene la lista.
     */
    public void contar() {
        long conteo = list.stream().count();
        System.out.println(conteo);
    }

    public static void main(String[] args) {

        StreamsApp app = new StreamsApp();
        //app.filtrar();
        //app.ordenar();
        //app.transformar();
        //app.limitar();
        app.contar();

    }

}

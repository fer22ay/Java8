package com.fernando.javabasic.lambda;

/**
 * MyInterface
 * <p>
 * Ejemplo de nuevas caracteristicas de interfaces con Java 9.
 *
 * @author : Fernando Ambrosio
 * @since : 22/04/2020
 */
public interface MyInterface {

    default void defaultMetodo() {
        privateMetodo("Hola desde el metodo defaul!");
    }

    private void privateMetodo(final String string) {
        System.out.println(string);
    }

    void normalMetodo();

}

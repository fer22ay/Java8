package com.fernando.amazonviewer.util;

import java.util.Scanner;

/**
 * AmazonUtil
 * Clase AmazonUtil
 *
 * @author Fernando Ambrosio
 * @version v0.1
 * @since : 15/02/2020
 */
public class AmazonUtil {

    /**
     * *
     * Metodo para validar el ingreso por consola del usuario.
     *
     * @param min tipo int, numero minimo
     * @param max tipo int, numero maximo
     * @return numero valido ingresado por usuario para el menu
     */
    public static int validateUserResponseMenu(int min, int max) {

        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println("No ingresaste un opcion valida");
            System.out.println("Intenta otra vez");
        }

        var response = sc.nextInt();

        while (response < min || response > max) {
            System.out.println("No ingresaste un opcion valida");
            System.out.println("Intenta otra vez");

            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("No ingresaste una opcion valida");
                System.out.println("Intenta otra vez");
            }
            response = sc.nextInt();
        }
        System.out.println("Tu respuesta fue: " + response + "\n");
        return response;
    }

}

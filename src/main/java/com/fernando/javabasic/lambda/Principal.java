package com.fernando.javabasic.lambda;

/**
 *
 * @author : Fernando Ambrosio
 * @since : 25/04/2020
 */
public class Principal {

    public static void main(String[] args) {
        OnOneListener oneListener = new OnOneListener() {
            @Override
            public void onOne(String message) {
                System.out.println("One : " + message);
            }
        };
        
        OnOneListener listener = (var message) -> {
            System.out.println("One : " + message);
        };
        
        listener.onOne("Con Lambda:");
        oneListener.onOne("Sin Lambda");
        
        Clickeable clickeable = (var message) ->{
            System.out.println("Presiona : " + message);
        };
        
        clickeable.doyClick("Doble click");
    }

}

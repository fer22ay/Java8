package com.fernando.javabasic.lambda;

/**
 *
 * @author : Fernando Ambrosio
 * @since : 18/04/2020
 */
public class Scopes {
    
    private static double atributo1;
    private double atributo2;
    
    public double probarLocalVariable(){
        final double n3 = 3;
        Operacion op = new Operacion(){
            
            @Override
            public double calcular(double n1, double n2) {
                return n1 + n2 + n3;
            }
            
        };
        
        return op.calcular(2, 3);
    }
    
    public double probarAtributosStaticVariables(){
        
        Operacion operacion = (x, y) -> {
            atributo1 = x + y;
            atributo2 = atributo1;
            return (x + y);
        };
        return operacion.calcular(1, 1);
    }
    
    public static void main(String[] args) {
        Scopes scopes = new Scopes();
        System.out.println(scopes.probarAtributosStaticVariables());
    }
    
}

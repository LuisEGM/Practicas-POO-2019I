package pruebas;

import geometria.Punto;

public class PruebaPunto {

    public static void main(String[] args) {
        
        //Declara la variable local punto1 y asigna un objeto Punto en las coordenadas (1, 3).
        Punto punto1 = new Punto(1,3);
        
        // Muestra el valor de las propiedades x e y por la consola. 
        System.out.println("Punto1 x: "+punto1.getX());
        System.out.println("Punto1 y: "+punto1.getY());
        
        System.out.println("*******************");
        
        //Declara la variable punto2 y asigna un objeto Punto construido a partir del constructor sin parámetros.
        Punto punto2 = new Punto();
        
        //Muestra por la consola el valor de sus propiedades. 
        System.out.println("Punto2 x: "+punto2.getX());
        System.out.println("Punto2 y: "+punto2.getY());
        
        System.out.println("*******************");
        
        //Declara la variable punto3 y asigna un objeto Punto construido a partir del punto1 (constructor de copia).
        Punto punto3 = new Punto(punto1);

        //Muestra sus propiedades por la consola. 
        System.out.println("Punto3 x: "+punto3.getX());
        System.out.println("Punto3 y: "+punto3.getY());
        
        //Declara la variable punto4 y asígnale la variable punto2. 
        Punto punto4 = new Punto(punto2);
        
        System.out.println("*******************");
        
        //Modifica las coordenadas de punto2 y muestra el valor de las propiedades por la consola.
        punto2.desplazar(1,2);
        System.out.println("Nuevo Punto2 x: "+punto2.getX());
        System.out.println("NUevo Punto2 y: "+punto2.getY());
        
        System.out.println("-------------------");
        
        //Muestra también el valor de las propiedades del punto4. Observa que tienen los mismos valores porque son referencias al mismo objeto. 
        System.out.println("Punto4 x: "+punto4.getX());
        System.out.println("Punto4 y: "+punto4.getY());
        
        
        
    }
    
}

package pruebas;

import geometria.Circulo;
import geometria.Direccion;
import geometria.Punto;

public class PruebaCirculo {

    public static void main(String[] args) {
    
        //Declara la variable local punto1 y asigna un objeto Punto en (2, 3).
        Punto punto1 = new Punto(2,3);
        
        //Declara la variable circulo1 que sea asignada por un círculo que tenga como centro
        //punto1 y radio 3.
        Circulo circulo1 = new Circulo(punto1,3);
        
        //Declara la variable circulo2 que sea asignada por un círculo que tenga de nuevo como
        //centro punto1 y radio 5.
        Circulo circulo2 = new Circulo(punto1,5);
        
        //Desplaza circulo1 3 unidades en el eje X y 2 unidades en Y.
        circulo1.desplazar(3,2);
        
        /*Muestra por la consola las coordenadas del centro de circulo1 y circulo2. Las
        coordenadas deben ser distintas puesto que el desplazamiento del circulo1 no debe
        influir en el circulo2.*/
        System.out.println("Centro circulo1 en X: "+circulo1.getCentro().getX());
        System.out.println("Centro circulo1 en Y: "+circulo1.getCentro().getY());
        System.out.println("-------------------------------");
        System.out.println("Centro circulo2 en X: "+circulo2.getCentro().getX());
        System.out.println("Centro circulo2 en Y: "+circulo2.getCentro().getY());
        
        System.out.println("-------------- EJEC #2 ----------------");
        
        /*Declara la variable punto2 de tipo Punto y asígnale el resultado de la consulta del
        centro del circulo2.*/
        Punto punto2 = new Punto(circulo2.getCentro().getX(),circulo2.getCentro().getY());
        
        //Desplaza el punto2 una unidad en el eje X.
        punto2.desplazarSC(Direccion.DERECHA);
         
        /*Muestra por la consola las propiedades de la variable punto2 y también del centro del
        circulo2. Las coordenadas deben ser distintas puesto que el desplazamiento del centro
        no debe influir en el circulo2.*/
        System.out.println("Punto2 X: "+punto2.getX());
        System.out.println("Punto2 Y: "+punto2.getY());
        System.out.println("------------------------------");
        System.out.println("Centro circulo2 en X: "+circulo2.getCentro().getX());
        System.out.println("Centro circulo2 en Y: "+circulo2.getCentro().getY());
        
        System.out.println("-------------- EJEC #3 ----------------");
        
        //Escala circulo2 al 150% y muestra sus propiedades por la consola.
        circulo2.escalar(150);
        System.out.println("Centro circulo2 en X: "+circulo2.getCentro().getX());
        System.out.println("Centro circulo2 en Y: "+circulo2.getCentro().getY());
        System.out.println("Radio circulo2: "+circulo2.getRadio());

    }
    
}

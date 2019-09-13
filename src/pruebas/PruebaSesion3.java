package pruebas;

import geometria.Direccion;
import geometria.Punto;

public class PruebaSesion3 {

    public static void main(String[] args) {
        
        //Declara la variable local punto1 y asigna un objeto Punto en (1, 1).
        Punto punto1 = new Punto(1,1);
        
        //Desplaza punto1 en la dirección hacia arriba.
        punto1.desplazarSC(Direccion.ARRIBA);
        
        //System.out.println(punto1.getY());

        //Declara la variable local punto2 y asigna un objeto Punto en (4, 2).
        Punto punto2 = new Punto(4,2);
        
        /*Declara un array de tipo Punto de tamaño 2. Almacena las referencias que contienen las
        variables punto1 y punto2 en ese array.*/
        Punto[] vectorPuntos; 
        vectorPuntos = new Punto[2];
        vectorPuntos[0] = punto1;
        vectorPuntos[1] = punto2;
        
        //Recorre el array con un bucle for each y muestra las propiedades de los puntos por la consola.
        for(Punto p: vectorPuntos){
            System.out.println("( "+p.getX()+" , "+p.getY()+" )");
        }
        
        //Calcula la distancia entre punto1 y punto2. Muestra el resultado en la consola.
        System.out.println("Distancia entre el P1 y P2: "+ Punto.distanciaAlt(punto1, punto2) );
        
        /*Utiliza el método mayorDistancia para comprobar cuál de los dos puntos (punto1, punto2)
        está más alejado del eje de coordenadas. Muestra el resultado en la consola.*/
        Punto masLejano = new Punto();
        masLejano = Punto.mayorDistancia(vectorPuntos);
        System.out.println("Punto mas lejano del centro => [ "+ masLejano.getX() +" , "+ masLejano.getY() +" ]");

    }
    
}

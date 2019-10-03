package Code;

import java.util.LinkedList;

public class Programa {

    public static void main(String[] args) {
        
        /*Declara y construye el siguiente evento libre: "Real Madrid - F.C. Barcelona",
        precio apuesta 1 euro. */
        EventoLibre evento1 = new EventoLibre("Real Madrid - F.C. Barcelona",1);
        
        /*El usuario "juan" apuesta por el marcador (5, 0). */
        Marcador mjuan = new Marcador(5,0);
        evento1.apostar("Juan", mjuan);
        
        /*El usuario "pepe" apuesta por (1, 3). */
        Marcador mPepe = new Marcador(1,3);
        evento1.apostar("Pepe", mPepe);
        
        /*Declara y construye el evento restringido: "Nadal vs Federer", 3 euros por
        apuesta y los marcadores posibles serían (2, 0), (2, 1), (0, 2) y (1, 2). */
        
        Marcador opc1 = new Marcador(2,0);
        Marcador opc2 = new Marcador(2,1);
        Marcador opc3 = new Marcador(0,2);
        Marcador opc4 = new Marcador(1,2);
        
        EventoRestringido evento2 = new EventoRestringido("Nadal vs Federer",3,opc1,opc2,opc3,opc4);
        
        //El usuario "juan" apuesta por (2, 0)
        Marcador majuan = new Marcador(2,0);
        evento2.apostar("Juan", majuan);
        
        //o El usuario “pedro” apuesta por (2, 1).
        Marcador mapedro = new Marcador(2,1);
        evento2.apostar("Pedro", mapedro);
        
        //o El usuario "pepe" apuesta por (2, 0). 
        Marcador mapepe = new Marcador(2,0);
        evento2.apostar("Pepe", mapepe);
        
        /*Declara y construye una lista para almacenar eventos. Añade los eventos a esa lista. */
        LinkedList<Evento> eventos = new LinkedList<>();
        eventos.add(evento1);
        eventos.add(evento2);
        
        /*Recorre todos los eventos: el usuario “enrique” apuesta por (5, 0) en cada
        evento. Observa que esta apuesta no se admite en ninguno de los dos
        eventos. En el libre porque ya hay una apuesta para ese marcador, y en el
        restringido porque no está incluido en el conjunto de marcadores válidos
        (opciones). */
        Marcador menrrique = new Marcador(5,0);
        for(Evento e: eventos){
            System.out.println(e.apostar("Enrrique",menrrique));
        }
        
        /*Recorre todos los eventos: muestra el nombre, el número de apuestas y la recaudación.*/
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++\n");
        for(Evento e: eventos){
            System.out.println(">> Nombre del evento: "+e.getNombreEvento());
            System.out.println(">> Numero de apuestas: "+e.getNumeroApuestas());
            System.out.println(">> Recaudacion: "+e.getRecaudacion()+" euros");
            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++\n");
        }
        
        /*Recorre todos los eventos: si el evento es restringido, muestra el nombre y el
        número de apuestas para el marcador (2, 0).*/
        Marcador marcador = new Marcador(2,0);
        for(Evento e: eventos){
            
            if(e instanceof EventoRestringido){
                System.out.println("<<<<<<<<<<<<< EVENTO RESTRINGIDO >>>>>>>>>>>>>>\n");
                System.out.println(">> Nombre: "+e.getNombreEvento());
                System.out.println(">> Numero de apuestas para el marcador [2,0]: "+((EventoRestringido) e).NumerodeApuestasparaElMarcador(marcador));
            }
            
        }
        
        
    }
    
}

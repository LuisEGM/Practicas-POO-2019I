package pruebas;

import PlazaCochesViajes.Reserva;
import PlazaCochesViajes.Viaje;
import PlazaCochesViajes.ViajePremium;
import PlazaCochesViajes.ViajeSelectivo;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class PruebaReservaciones {

    public static void main(String[] args) {
        
        /*Crea los siguientes viajes cuyo propietario sea “José Antonio” y coche “Seat León”*/
        
        //- Viaje “Murcia-Cartagena” con fecha de salida 9/junio/2019 con el número de plazas por defecto.
        LocalDate fechaViaje1 = LocalDate.of(2019,11,9);
        Viaje viaje1 = new Viaje("Jose Antonio","Seat León","Murcia-Cartagena",fechaViaje1);
        
        //- Viaje selectivo “Murcia–Campus” con fecha de salida 10/junio/2019 y 4 plazas.
        LocalDate fechaViaje2 = LocalDate.of(2019,11,9);
        ViajeSelectivo viaje2 = new ViajeSelectivo("Jose Antonio","Seat León","Murcia-Campus",fechaViaje2,4);
        
        //- Vetar a “Beatriz” en el viaje selectivo.
        viaje2.agregarVetados("Beatriz");
        
        // - Viaje premium “Murcia-Barcelona” con fecha de salida 15/junio/2019 y 6 plazas.
        LocalDate fechaViaje3 = LocalDate.of(2019,11,15);
        ViajePremium viaje3 = new ViajePremium("Jose Antonio","Seat León","Murcia-Barcelona",fechaViaje3,6);
        
        /*Realiza las siguientes reservas:*/
        
        //- "Alberto" hace 2 reservas en el viaje “Murcia-Cartagena”.
        viaje1.realizarReserva("Alberto");
        viaje1.realizarReserva("Alberto");
        
        //- "Enrique" hace 3 reservas en el viaje “Murcia-Campus”.
        viaje2.realizarReserva("Enrique");
        viaje2.realizarReserva("Enrique");
        viaje2.realizarReserva("Enrique");
        
        //- "Beatriz" hace 1 reserva en el viaje “Murcia-Campus”.
        viaje2.realizarReserva("Beatriz");
        
        //- "Ana" hace 2 reservas en el viaje “Murcia-Barcelona”.*/
        viaje3.realizarReserva("Ana");
        viaje3.realizarReserva("Ana");
        viaje3.realizarReserva("Ana");
        
        
        // Crea una colección con los tres viajes anteriores.
        HashSet<Viaje> coleccion = new HashSet<>();
        
        coleccion.add(viaje1);
        coleccion.add(viaje2);
        coleccion.add(viaje3);
        
        /*Recorre la colección de viajes:
        - Si el viaje es selectivo, quitar el veto a “Beatriz”.
        - Imprime (toString) la información de cada viaje.*/
        
        for(Viaje v: coleccion){
            if(v instanceof ViajeSelectivo){        
                ((ViajeSelectivo) v).quitarVetados("Beatriz");
            }
            System.out.println(v.toString());
            
        }
        
        
        
        // Copia de viajes.
        
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
        
        // Declara y construye un segundo conjunto de viajes (copias).
        HashSet<Viaje> copias = new HashSet<>();
        LinkedList<String> copiaReservasElim = new LinkedList<>();
        ViajePremium aux = null;
        
        /*Recorre el conjunto viajes y para cada elemento:
        - Crea una copia del viaje y añádela al conjunto copias.
        - Si el viaje es Premium, cancela todas las reservas en el objeto copia.*/
        
        for(Viaje v: coleccion){
            copias.add(v.clone());
            if(v instanceof ViajePremium){
                for(Reserva r: v.getReservas()){
                    copiaReservasElim.add(r.getCodigodeReserva());
                }
            }
        }    
        
        for(Viaje v: copias){
            if(v instanceof ViajePremium){
                aux = (ViajePremium)v;
                for(String c: copiaReservasElim){
                    aux.cancelarReserva(c);
                }
            }
        }
       
        // Muestra el contenido del conjunto copias por la consola (toString).
        for(Viaje v: copias){
            System.out.println(v.toString());
        }
        
    }
    
}

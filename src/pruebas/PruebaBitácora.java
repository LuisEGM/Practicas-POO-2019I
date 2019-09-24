package pruebas;

import bitácora.Bitácora;
import bitácora.BitácoraInteligente;
import bitácora.BitácoraUndo;
import bitácora.Entrada;
import java.util.LinkedList;

public class PruebaBitácora {

    public static void main(String[] args) {
    
        /*Declara una variable local de tipo Bitacora y asigna una bitácora básica con identificador “basica1”*/
        Bitácora btc1 = new Bitácora("basica1");
        
        /*Declara una variable local de tipo BitacoraInteligente y asigna una bitácora inteligente
        con identificador “inteligente1” y que tenga como palabras prohibidas “facebook” y
        “thepiratebay”.*/
        BitácoraInteligente btcInt1 = new BitácoraInteligente("inteligente1","facebook","thepiratebay");
        
        /*Declara una variable local de tipo BitacoraInteligente y asigna una bitácora inteligente
        con identificador “inteligente2” y que tenga como palabras prohibidas “foto” y “descargar”.*/
        BitácoraInteligente btcInt2 = new BitácoraInteligente("inteligente2","foto","descargar");
        
        /*Declara una variable local de tipo BitacoraUndo y asigna una bitácora undo con
        identificador “undo1”.*/
        BitácoraUndo btcUndo = new BitácoraUndo("undo1");
        
        /*Declara y construye una lista de bitácoras y añade las cuatro bitácoras construidas
        anteriormente.*/
        LinkedList<Bitácora> bitacoras = new LinkedList<>();
        bitacoras.add(btc1);
        bitacoras.add(btcInt1);
        bitacoras.add(btcInt2);
        bitacoras.add(btcUndo);
        
        /*Recorre la lista de bitácoras y añade en cada una de ellas las entradas:
        o “Se ha producido un error en el servicio”.
        o “Puedes descargar el driver desde thepiratebay”.
        o “Las fotos están publicadas en facebook”.*/
        for(Bitácora b: bitacoras){
            
            b.registrar("Se ha producido un error en el servicio");
            b.registrar("Puedes descargar el driver desde thepiratebay");
            b.registrar("Las fotos están publicadas en facebook");
            
        }
        
        /*Recorre la lista de bitácoras y:
        o Si es una bitácora undo, deshacemos la inserción de la última entrada.
        o Muestra las entradas que contiene*/
        for(Bitácora b: bitacoras){
            
            if(b instanceof BitácoraUndo){
                //La funcion deshacer entrada no existe en la clase Padre, se utiliza el Casting para poder acceder a este metodo de la clase hija
                if(((BitácoraUndo) b).deshacerEntrada()){
                    System.out.println("#########  Se elimino la ultima entrada de "+b.getNombre()+" #########");
                }
                
            }
            
            System.out.println("Bitacora » "+b.getNombre());
            for(Entrada e: b.getEntradas()){
                System.out.println(" => Suceso »» "+e.getSuceso()+" => Fecha »» "+e.getFecha());
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        }
        
        
    }
    
}

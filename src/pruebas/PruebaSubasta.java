package pruebas;

import subastas.Subasta;
import subastas.Usuario;

public class PruebaSubasta {

    public static void main(String[] args) {
        
        /*Crea tres usuarios con nombre "Juan", "Pedro" y "Enrique" con un crédito inicial
        de 100, 150 y 300 euros, respectivamente. */
        Usuario Juan = new Usuario("Juan",100);
        Usuario Pedro = new Usuario("Pedro",150);
        Usuario Enrique = new Usuario("Enrique",300);
        
        Usuario pujador; // para mostrar la info.
        
        /*Crea una subasta del producto "Teléfono Móvil" cuyo propietario sea el usuario Juan. */
        Subasta sub1 = new Subasta("Teléfono Móvil",Juan);
        
        /*El usuario Pedro puja por esa subasta 100 euros. */
        if(sub1.pujar(Pedro,100)){
            
            /*Muestra en la consola la puja mayor de la subasta (nombre del usuario y
            cantidad). */
            
            pujador = sub1.getPujaMayor().getPujador();
            System.out.println(".:: Mayor Puja de la subasta ::.");
            System.out.println("««««« "+pujador.getNombre()+" con € "+sub1.getPujaMayor().getCantidad()+" »»»»»");
            
        }
        else{
            System.out.println("Solicitud de puja rechazada");
        }
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        /*El usuario Enrique puja por esa subasta 50 euros. */
        /*Muestra en la consola la puja mayor. Comprueba que esta segunda puja no ha
        sido acepta, ya que es menor que la primera. */
        if(!sub1.pujar(Enrique,50)) System.out.println("Solicitud de puja rechazada");
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        pujador = sub1.getPujaMayor().getPujador();
        System.out.println(".:: Mayor Puja de la subasta ::.");
        System.out.println("««««« "+pujador.getNombre()+" con € "+sub1.getPujaMayor().getCantidad()+" »»»»»");
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        /*Ejecuta la subasta. */
        sub1.ejecutar();
        
        /*El usuario Enrique puja de nuevo por esa subasta con 200 euros. Comprueba
        que no es aceptada, ya que la subasta ha sido cerrada. */
        if(!sub1.pujar(Enrique,200)) System.out.println("Solicitud de puja rechazada");
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        System.out.println("»Nombre: "+Juan.getNombre()+" »Credito: € "+Juan.getCredito());
        System.out.println("»Nombre: "+Pedro.getNombre()+" »Credito: € "+Pedro.getCredito());
        System.out.println("»Nombre: "+Enrique.getNombre()+" »Credito: € "+Enrique.getCredito());
        
    }
    
}

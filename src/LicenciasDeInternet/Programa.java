package LicenciasDeInternet;

import java.time.LocalDate;
import java.util.LinkedList;

public class Programa {

    public static void main(String[] args) {
        
        /*Crea tres licencias para el servicio “http://api.um.es/disco/v1/” asociadas a los usuarios
        “juan@um.es”, “pepe@um.es” y “paco@um.es”.
        
        - La primera será una licencia temporal que caduca dentro de un mes. La segunda será una
        licencia con transacciones limitadas con un máximo de 3. La última será una licencia con límite
        diario, con un máximo de 4 transacciones, 1 por día.*/
        
        LocalDate fechaCaducidad = LocalDate.now().plusMonths(1);
        LicenciaTemporal lic1 = new LicenciaTemporal("juan@um.es","http://api.um.es/disco/v1/",fechaCaducidad);
        
        LicenciaTransaccionesLimitadas lic2 = new LicenciaTransaccionesLimitadas("pepe@um.es","http://api.um.es/disco/v1/",3);
        
        LicenciaLimiteDiario lic3 = new LicenciaLimiteDiario("paco@um.es","http://api.um.es/disco/v1/",4,1);
        
        /*Crea una lista de licencias y almacena las licencias anteriores en esa lista. Recorre la colección
        de licencias y muestra su información por la consola (toString).*/
        LinkedList<Licencia> licencias = new LinkedList<>();
        
        licencias.add(lic1);
        licencias.add(lic2);
        licencias.add(lic3);
        
        for(Licencia l: licencias){
            
            if(l instanceof LicenciaTemporal){
                System.out.println("##########################  LICENCIA TEMPORAL  ##########################\n");
                System.out.println(l.toString());
            }
            
            if(l instanceof LicenciaTransaccionesLimitadas){
                System.out.println("##########################  LICENCIA CON TRANSACCIONES LIMITADAS  ##########################\n");
                System.out.println(l.toString());
            }
            
        }
        
        /*Recorre la colección de licencias:
        - Si es una licencia con límite diario, muestra por la consola las transacciones restantes
        para hoy.
        - Revoca la licencia temporal.*/
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        
        for(Licencia l: licencias){
            
            if(l instanceof LicenciaTemporal){
                l.revocarLicencia();
            }
            
            if(l instanceof LicenciaLimiteDiario){
                System.out.println("»» Transacciones restantes hoy: "+((LicenciaLimiteDiario) l).TransaccionesRestantesHoy());
            }
            
        }
        
        /*Recorre la colección de licencias y para cada una: solicita 4 autorizaciones (transacciones) de
        forma consecutiva. Tras cada solicitud muestra la transacción por la consola (si no es un valor
        nulo), y en caso contrario, el texto “no autorizada”.*/
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        Transaccion aux = null;
        int iterador = 1;
        
        for(Licencia l: licencias){
            
            
            System.out.println("\n***********************************    Iteracion # "+iterador+"    **********************************\n");
            
            // La primera vez muestra no autoriazdo por que la primera iteracion es la Licencia temporal, que se pidio
            // revocar anteriormente.
            
            // La segunda vez mostrara solo tres, transacciones, por que es el limite que se puso.
            
            // la tercera vez solo mostrara una transaccion, ya que estupulo una por dia.
            
            aux = l.ObtenerAutorizaciónDeUsoDelServicio();
            if(aux != null){
                System.out.println(aux);
            }
            else{
                System.out.println("!...ERROR, TRANSACCIÓ NO AUTORIZADA");
            }
            
            aux = l.ObtenerAutorizaciónDeUsoDelServicio();
            if(aux != null){
                System.out.println(aux);
            }
            else{
                System.out.println("!...ERROR, TRANSACCIÓ NO AUTORIZADA");
            }
            
            aux = l.ObtenerAutorizaciónDeUsoDelServicio();
            if(aux != null){
                System.out.println(aux);
            }
            else{
                System.out.println("!...ERROR, TRANSACCIÓ NO AUTORIZADA");
            }
            
            aux = l.ObtenerAutorizaciónDeUsoDelServicio();
            if(aux != null){
                System.out.println(aux);
            }
            else{
                System.out.println("!...ERROR, TRANSACCIÓ NO AUTORIZADA");
            }
            
            iterador++;
        }
        
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        //Recorre la colección de licencias y muestra su información por la consola (toString).
        
        for(Licencia l: licencias){
            
            if(l instanceof LicenciaTemporal){
                System.out.println("##########################  LICENCIA TEMPORAL  ##########################\n");
                System.out.println(l.toString());
            }
            
            if(l instanceof LicenciaTransaccionesLimitadas){
                System.out.println("##########################  LICENCIA CON TRANSACCIONES LIMITADAS  ##########################\n");
                System.out.println(l.toString());
            }
            
        }
        
        /*Crea una lista de licencias llamada copias. Recorre la colección de licencias y para cada una
        obtén una copia. Almacena la copia en la nueva colección. Recorre la colección de copias y
        muestra la información por la consola.*/
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        LinkedList<Licencia> copia = new LinkedList<>();
        
        for(Licencia l: licencias){
            copia.add(l.clone());
        }
        
        for(Licencia l: copia){
            
            if(l instanceof LicenciaTemporal){
                System.out.println("##########################  LICENCIA TEMPORAL COPIA  ##########################\n");
                System.out.println(l.toString());
            }
            
            if(l instanceof LicenciaTransaccionesLimitadas){
                System.out.println("##########################  LICENCIA CON TRANSACCIONES LIMITADAS COPIA  ##########################\n");
                System.out.println(l.toString());
            }
            
        }
        
    }
    
}

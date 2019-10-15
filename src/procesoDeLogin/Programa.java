package procesoDeLogin;

import java.util.LinkedList;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        /*Crea un usuario con login “fperez” con password “lechemerengada”. Modifica el
        password del usuario anterior estableciendo “cr7comeback”*/
        Usuario user1 = new Usuario("fperez","lechemerengada");
        user1.modificarPassword("lechemerengada","cr7comeback");
        
        //Crea un usuario con login “mlama” con password “tururu”.
        Usuario user2 = new Usuario("mlama","tururu");
        
        // Crea un verificador blacklist y un verificador por código.
        VerificadorBlacklist verificador1 = new VerificadorBlacklist("Introduzca el número del día de su último acceso");
        VerificadorPorCodigo verificador2 = new VerificadorPorCodigo("Introduzca el número que ha recibido por SMS",5);
        
        // Añade los usuarios a los verificadores.
        verificador1.añadirUsuarios(user1,user2);
        verificador2.añadirUsuarios(user1,user2);
        
        //Declara y construye una lista de verificadores. Añade los verificadores anteriores.
        LinkedList<Verificador> verificadores = new LinkedList<>();
        verificadores.add(verificador1);
        verificadores.add(verificador2);
        
        /*Recorre la lista de verificadores: si el verificador es de tipo blacklist, añade el usuario 
        “mlama” como usuario bloqueado.*/
        for(Verificador v: verificadores){
            if(v instanceof VerificadorBlacklist){
                ((VerificadorBlacklist) v).bloquearUsuario(user2);
            }
        }
        
        /*Recorre la lista de verificadores:
            o Solicita por la consola el login y password del usuario.
            Nota: utiliza la clase java.util.Scanner para leer información de la consola.
            o Con las credenciales anteriores, realiza el primer paso de verificación.
            o Si el primer paso ha sido superado:
                ▪ Obtén del verificador la petición del desafío y muéstrala por la consola.
                ▪ Solicita por la consola la respuesta al desafío.
                ▪ Con el token obtenido en el paso 1 y la respuesta, realiza el segundo paso
                del desafío. Muestra por la consola el resultado.*/
        Scanner entrada = new Scanner(System.in);
        int i=1;
        String user = null;
        String password = null;
        String respuesta = null;
        String token = null;
        
        // EL VERIFICADOR # 1 (VerificadorBlacklist), solo tiene un susuario. > fperez:cr7comeback > el otro se bloqueo.
        // EL VERIFICADOR # 2 (VerificadorPorCodigo), tiene los dos usuarios. > fperez:cr7comback > mlama:tururu
        
        for(Verificador v: verificadores){
            
            System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ EJECUCIÓN # "+i+"  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
            
            System.out.println("\n+++++++++++++++  LOGIN  ++++++++++++++++");
            System.out.print("\n»» User: ");
            user = entrada.nextLine();
            System.out.print("»» password: ");
            password = entrada.nextLine();
            
            token = v.primerPasoDelProcesoDeVerificacion(user, password); 
            
            if(token != null){
                
                System.out.print("\n@» Verificación »» "+v.getPeticionDelDesafio()+": ");
                respuesta = entrada.nextLine();
                
                if(v.SegundoPasoDelProcesoDeVerificacion(token,respuesta)){
                    System.out.println("\n»>»>»> ACCESO CONCEDIDO  <«<«<«\n");
                }
                else{
                    System.err.println("\n!...ACCESO DENEGADO\n");
                }
                
            }
            else{
                System.err.println("\n!...ERROR, datos invalidos");
            }
            
            i++;
        }
        
        /*Declara y construye una nueva lista de verificadores llamada copias.
            - Recorre la primera lista de verificadores y para cada elemento obtén una copia y
            guárdala en la lista copias.
            - Recorre la lista con las copias y para cada verificador muestra su información por la
            consola (toString).*/
        
        entrada.nextLine();
        
        System.out.println("\n======================================  COPIAS  ======================================\n\n");
        
        LinkedList<Verificador> copia = new LinkedList<>();
        for(Verificador v: verificadores){
            copia.add(v.clone());
        }
        
        for(Verificador v: copia){
            System.out.println(v.toString());
            System.out.println("\n============================================================================\n\n");
        }
        
        entrada.close();
        
    }
    
}

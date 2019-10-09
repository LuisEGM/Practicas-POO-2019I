package referendums;

import java.time.LocalDate;
import java.util.LinkedList;

public class Programa {

    public static void main(String[] args) {
        
        /*Crea los electores:
        o "Juan Martínez" con dni "17456789" y fecha de nacimiento 16/12/1998.
        o "Pedro López" con dni "34567890" y fecha de nacimiento 18/3/1998.
        o “Ana Abenza" con dni "23456812" y fecha de nacimiento 1/5/1995.
        o “María Gómez” con dni “23754612” y fecha de nacimiento 1/9/1994.*/
       
        LocalDate fne1 = LocalDate.of(1998,12,18);
        Elector elec1 = new Elector("17456789","Juan Martínez",fne1);
        
        LocalDate fne2 = LocalDate.of(1998,3,18);
        Elector elec2 = new Elector("34567890","Pedro López",fne2);
        
        LocalDate fne3 = LocalDate.of(1995,5,1);
        Elector elec3 = new Elector("23456812","Ana Abenza",fne3);
        
        LocalDate fne4 = LocalDate.of(1994,9,1);
        Elector elec4 = new Elector("23754612","María Gómez",fne3);
        
        /*LinkedList<Elector> electores = new LinkedList<>();
        electores.add(elec1);
        electores.add(elec2);
        electores.add(elec3);
        electores.add(elec4);*/
        
        /*Crea una consulta ordinaria que tenga por título “Sobre los exámenes en la universidad”.
        Añade a la consulta ordinaria las preguntas:
        o “¿Debemos volver a la convocatoria de septiembre?”
        o “¿Se deben hacer parciales en todas las cuatrimestrales?”*/
        
        ConsultaOrdinaria con1 = new ConsultaOrdinaria("Sobre los exámenes en la universidad");
        con1.añadirPregunta("¿Debemos volver a la convocatoria de septiembre?");
        con1.añadirPregunta("¿Se deben hacer parciales en todas las cuatrimestrales?");
        
        /*Crea una consulta selectiva que tenga por título “Sobre las fiestas patronales”, que se
        celebre hoy y tenga como fecha umbral el 31/12/1997.
        - Añade a la consulta selectiva las preguntas:
        o “¿Se debe cerrar el centro el día del patrón?”
        o “¿Se deben recuperar las clases que se pierden en las fiestas?”*/
        
        LocalDate fecha = LocalDate.now();
        LocalDate fechaumbral = LocalDate.of(1997,12,31);
        consultaSelectiva con2 = new consultaSelectiva("Sobre las fiestas patronales",fechaumbral,fecha);
        con2.añadirPregunta("¿Se debe cerrar el centro el día del patrón?");
        con2.añadirPregunta("¿Se deben recuperar las clases que se pierden en las fiestas?");
        
        //Establece como pregunta condicionada la 1.
        con2.establecerPreguntasCondicionadas(1);
        
        //Crea una lista de consultas y añade las dos consultas que se han creado.
        LinkedList<Consulta> consultas = new LinkedList<>();
        consultas.add(con1);
        consultas.add(con2);
        
        /*Recorre las consultas y para cada consulta:
        o Añade todos los electores a la consulta.
        o Abre la consulta si es ordinaria.
        o Juan vota “si” a todas las preguntas.
        o Pedro vota en blanco a todas las preguntas.
        o Ana vota “si” a la primera y “no” a la segunda.
        o María vota “no” a todas las preguntas.*/
        
        for(Consulta c: consultas){
            
            c.añadirElectores(elec1,elec2,elec3,elec4);
            
            if(c instanceof ConsultaOrdinaria) ((ConsultaOrdinaria) c).abrirConsulta();
            
            c.votar(elec1.getDni(),Opcion.SI,Opcion.SI);
            c.votar(elec2.getDni(),Opcion.EN_BLANCO,Opcion.EN_BLANCO);
            c.votar(elec3.getDni(),Opcion.SI,Opcion.NO);
            c.votar(elec4.getDni(),Opcion.NO,Opcion.NO);
            
            /*Muestra por la consola:
            ▪ El título de la consulta.
            ▪ Si es una consulta selectiva el censo autorizado.
            ▪ El número de votos emitidos.
            ▪ El escrutinio para cada pregunta.*/
            
            if(c instanceof ConsultaOrdinaria){
                System.out.println(((ConsultaOrdinaria) c).toString());
            }
            
            if(c instanceof consultaSelectiva){
                System.out.println(((consultaSelectiva) c).toString());
            }
            
        }
        
        /*Crea una lista de consultas llamada copias y añade una copia de cada una de las consultas existentes.
        - Recorre la lista de las copias y muestra por la consola la información de cada una de ellas (toString).*/
        
        LinkedList<Consulta> copias = new LinkedList<>();
        
        for(Consulta c: consultas){
            
            if(c instanceof ConsultaOrdinaria){
                ConsultaOrdinaria co = (ConsultaOrdinaria) c.clone();
                copias.add(co);
            }
            
            if(c instanceof consultaSelectiva){
                consultaSelectiva cs = (consultaSelectiva) c.clone();
                copias.add(cs);
            }
        }
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  COPIAS  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        for(Consulta c: copias){
            
            if(c instanceof ConsultaOrdinaria){
                System.out.println(((ConsultaOrdinaria) c).toString());
            }
            
            if(c instanceof consultaSelectiva){
                System.out.println(((consultaSelectiva) c).toString());
            }
        }
        
    }
    
}

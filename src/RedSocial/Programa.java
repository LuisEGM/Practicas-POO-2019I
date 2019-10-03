package RedSocial;

import java.util.LinkedList;

public class Programa {

    public static void main(String[] args) {

        /*Declara y construye un perfil con identificador “Juan”. Añade el tema de interés “Java vs. C++” a este perfil.*/
        Perfil perfil1 = new Perfil("Juan");
        perfil1.añadirTemadeInteres("Java vs. C++");
        
        /*Declara y construye un perfil con identificador “Pedro”. Añade el tema de interés “El nuevo estadio del Real Madrid”*/
        Perfil perfil2 = new Perfil("Pedro");
        perfil2.añadirTemadeInteres("El nuevo estadio del Real Madrid");
        
        /*Declara y construye un perfil con identificador “Enrique”.*/
        Perfil perfil3 = new Perfil("Enrrique");
    
        /*Declara y construye una lista de perfiles y añade a ella los tres perfiles creados anteriormente.*/
        LinkedList<Perfil> perfiles = new LinkedList<>();
        
        perfiles.add(perfil1);
        perfiles.add(perfil2);
        perfiles.add(perfil3);
    
        /*Declara y construye una lista de paneles.*/
        LinkedList<Panel> paneles = new LinkedList<>();
        
        /*Recorre la lista de perfiles, y para cada perfil:*/
        
        //o Añade el mensaje “Hola soy XXX ¡Bienvenidos!” en el panel privado, donde XXX es el identificador del perfil.        
        //o Añade a la lista de paneles el panel privado y los paneles de suscripción (temas de interés) del perfil.*/
        
        for(Perfil p: perfiles){
            p.getPanel().publicarMensaje("Hola soy XXX ¡Bienvenidos!","XXX",null);
            paneles.add(p.getPanel());
            paneles.add(new PanelSuscripcion(p));
        }
        
        /*Recorre la lista de paneles:
        o Si el panel es privado, establece como palabras de seguimiento (palabras clave), “Hola”, “Real Madrid”, “Fútbol”.*/
        
        for(Panel p: paneles){
            
            if(p instanceof PanelPrivado){
                
               ((PanelPrivado) p).establecerPalabrasClave("Hola","Real Madrid","Fútbol");
                
            }
            
        }
        
        
        /*Recorre de nuevo la colección de perfiles:
        o Recorre la lista de paneles:
            ▪ Si el panel es de suscripción y el propietario no es el perfil, se añade
            el perfil como colaborador del panel y publica el mensaje “Muy
            interesante”.*/
        
        for(Perfil per: perfiles){
            
            for(Panel pa: paneles){
                
                if(pa instanceof PanelSuscripcion){
                    
                    if(pa.getPropietario() != per){
                        
                        ((PanelSuscripcion) pa).añadirColaborador(per);
                        pa.publicarMensaje("Muy interesante");
                        
                    }
                    
                }
                
            }
            
        }
        
        
        /*Recorre la lista de paneles:
            o Muestra la cadena toString() por defecto del panel, el identificador del
            propietario y el número de mensajes que contiene.
            o Si el panel es de suscripción, crea una copia del panel y muestra los
            mensajes publicados tanto en el panel original como en la copia.*/
        
        PanelSuscripcion ps2 = null;
        
        for(Panel p: paneles){
            
            System.out.println(p.toString());
            
            if(p instanceof PanelSuscripcion){
                
                ps2 = (PanelSuscripcion) p.clone();
                
                for(Mensaje m: p.getMensajes()){
                    System.out.println(m.toString());
                }
                System.out.println("/////////////// colaboradores ////////////////\n");
                for(Perfil x: ((PanelSuscripcion) p).getColaboradores()){
                    System.out.println(x.toString());
                }
                
            }
            
        }
        
        //La copia no muestra nada
        for(Mensaje m: ps2.mensajes){
            System.out.println(m.toString());
        }
        
        
        /*for(Panel p: paneles){
            
            if(p instanceof PanelPrivado){
                
                System.out.println("PALABRAS CLAVE");
                for(String s: ((PanelPrivado) p).getPalabrasClave()){
                    System.out.println("["+s+"]");
                }
                
                System.out.println("SMS CON SEGUIMIENTO");
                for(Mensaje m: ((PanelPrivado) p).getMensajesSeguimiento()){
                    System.out.println(m.toString());
                }
                
            }
        
        }*/
        
        
    }
    
}

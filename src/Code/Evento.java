package Code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public abstract class Evento {
    
    private String nombreEvento;
    private double precioApuesta;
    protected HashMap<String,Marcador> apuestas;
    private int numeroApuestas;
    private int recaudacion;
    
    // APLICACIÓN DE LA SESION 11. (« +S11 »)
    private Marcador resultado; //se puede establecer despues. se declara un metodo para cambiarlo.
    private EstadosdeApuesta estado; //cree un enum con los estados de la apuesta.
    
    public Evento(String nombreEvento, double precioApuesta){
        this.nombreEvento = nombreEvento;
        this.precioApuesta = precioApuesta;
        this.apuestas = new HashMap<>();
        this.numeroApuestas = 0;
        this.recaudacion = 0;
        
        //(« +S11 »)
        this.resultado = null;
        this.estado = EstadosdeApuesta.ABIERTO;
        
    }
    
    // (« +S11 »)
    public void cerrarEvento(){
        estado = EstadosdeApuesta.CERRADO;
    } 
    
    // (« +S11 »)
    public LinkedList<String> usuariosGanadores(){
        
        LinkedList<String> Usuariosganadores = new LinkedList<>();
        
        if(estado == EstadosdeApuesta.FINALIZADO){

            for(String s: apuestas.keySet()){ // recorro las llaves del mapa
                if(resultado.equals(apuestas.get(s))){ // obtengo el valor(marcador) y los comparo con el resultados
                    Usuariosganadores.add(s);
                }
            }

            return Usuariosganadores;    
            
        }
        else{
            return null;
        }
        
    }
    
    // (« +S11 »)
    //esta funcion no atrapara la excepcion de escritura. la pasa si ocurre
    public boolean almacenarApuestasEnDisco(String nombreF) throws IOException{
        
        if(estado == EstadosdeApuesta.FINALIZADO){
            
            File archivo = new File(nombreF);
            FileWriter escribir = new FileWriter(archivo, true);

            escribir.write("»»»»»»»    APUESTAS    ««««««««\n\n");
            escribir.write("»» Evento: "+ nombreEvento +"\n");

            for(String s: apuestas.keySet()){

                escribir.write("» Usuario: "+s+" || Apuesta a: "+""+apuestas.get(s).toString()+"\n");

            }

            escribir.close();
            return true;
            
        }
        else{
            return false;
        }
        

    }
    
    // (« +S11 »)
    public boolean establecerResultadoDelEvento(Marcador m){
        
        if(estado == EstadosdeApuesta.CERRADO){ // solo se establece el resultado si el evento esta cerrado
            resultado = m;
            estado = EstadosdeApuesta.FINALIZADO; // una vez se de el resultado se finaliza el evento, para poder entregar el .txt
            return true;
        }
        else{
            return false;
        }
    
    }
    
    public String getNombreEvento() {
        return nombreEvento;
    }

    public double getPrecioApuesta() {
        return precioApuesta;
    }
    
    public HashMap<String, Marcador> getApuestas() {
        return apuestas;
    }
    
    public int getNumeroApuestas() {
        return this.apuestas.size();
    }
    
    public int getRecaudacion() {
        return (int) (this.apuestas.size() * this.precioApuesta);
    }

    public boolean apostar(String nombre, Marcador x){
        
        // (« +S11 »)
        // solo se admiten apuestas si el evneto no esta cerrado.
        if(estado == EstadosdeApuesta.CERRADO || estado == EstadosdeApuesta.FINALIZADO){
            return false;
        }
        else{
            
            if(aceptable(x)){
                this.apuestas.put(nombre,x);
                return true;
            }
            else{
                return false;
            }
            
        }
        
    }

    protected abstract boolean aceptable(Marcador x);
    
}

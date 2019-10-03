package Code;

import java.util.HashMap;

public abstract class Evento {
    
    private String nombreEvento;
    private double precioApuesta;
    protected HashMap<String,Marcador> apuestas;
    private int numeroApuestas;
    private int recaudacion;
    
    public Evento(String nombreEvento, double precioApuesta){
        this.nombreEvento = nombreEvento;
        this.precioApuesta = precioApuesta;
        this.apuestas = new HashMap<>();
        this.numeroApuestas = 0;
        this.recaudacion = 0;
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
        
        if(aceptable(x)){
            this.apuestas.put(nombre,x);
            return true;
        }
        else{
            return false;
        }
        
    }

    protected abstract boolean aceptable(Marcador x);
    
}

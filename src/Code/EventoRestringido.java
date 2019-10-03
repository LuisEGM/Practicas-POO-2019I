package Code;

import java.util.HashSet;

public class EventoRestringido extends Evento{
    
    private final HashSet<Marcador> opciones;
    
    public EventoRestringido(String nombreEvento, double precioApuesta,Marcador... opcion) {
        super(nombreEvento, precioApuesta);
        this.opciones = new HashSet<>();
        for(Marcador m: opcion){
            this.opciones.add(m);
        }
    }

    public HashSet<Marcador> getOpciones() {
        return opciones;
    }

    @Override
    protected boolean aceptable(Marcador x) {
        boolean correcto = false;
        for(Marcador m: opciones){
            if(m.equals(x)){
                correcto = true;
            }
        }
        return correcto;
    }
    
    public int NumerodeApuestasparaElMarcador(Marcador x){
        int contador = 0;
        for(Marcador m: this.apuestas.values()){
            if(m.equals(x)) contador++; 
        }
        return contador;
    }
    
}

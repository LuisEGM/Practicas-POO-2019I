package Code;

public class EventoLibre extends Evento{
    
    public EventoLibre(String nombreEvento, double precioApuesta){
        super(nombreEvento, precioApuesta);
    }
    
    @Override
    protected boolean aceptable(Marcador x) {
        boolean correcto = true;
        for(Marcador m: this.apuestas.values()){
            if(m.equals(x)){
                correcto = false;
            }
        }
        return correcto;
    }
    
    
    
}

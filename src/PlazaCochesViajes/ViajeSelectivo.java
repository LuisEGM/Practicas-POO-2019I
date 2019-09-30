package PlazaCochesViajes;

import java.time.LocalDate;
import java.util.HashSet;

public class ViajeSelectivo extends Viaje implements Cloneable{
    
    private HashSet<String> vetados;
    
    public ViajeSelectivo(String propietario, String coche, String ruta, LocalDate fechaSalida, int plazasOfrecidas) {
    
        super(propietario, coche, ruta, fechaSalida, plazasOfrecidas);
        this.vetados = new HashSet<>();
        
    }
    
    public boolean agregarVetados(String nombre){
        return this.vetados.add(nombre);
    }
    
    public boolean quitarVetados(String nombre){
        return this.vetados.remove(nombre);
    }

    public HashSet<String> getVetados() {
        return vetados;
    }
    
    @Override
    public Reserva realizarReserva(String usuario){
        
        for(String u: this.vetados){
            if(u == usuario) return null;
        }
        
        return super.realizarReserva(usuario);
    }
    
    @Override
    public String toString(){
        
        String retorno = "";
        
        retorno += "\n-----------------------------------------------------------------------\n";
        retorno += "»» Tipo de viaje: CLASIFICADO  <øøøøø>  »» Fecha del viaje: "+getFechaSalida().toString();
        retorno += "\n-----------------------------------------------------------------------\n";
        
        if(getReservas().isEmpty()){
            retorno = "!...Este viaje selectivo no tiene reservaciones";
        }
        else{
            for(Reserva r: getReservas()){
                retorno += r.toString();
            }
        }
        
        return retorno;
    }
    
    private ViajeSelectivo copiaSuperficial(){
    
        ViajeSelectivo copia = (ViajeSelectivo) super.clone();
        return copia;
        
    }
    
    @Override
    public ViajeSelectivo clone(){
        
        ViajeSelectivo clon = copiaSuperficial();
        if(clon != null){
            clon.vetados = new HashSet<>(this.vetados);
        }
        return clon;
    }
    
}

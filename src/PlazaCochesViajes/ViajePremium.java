package PlazaCochesViajes;

import java.time.LocalDate;

public class ViajePremium extends Viaje{
    
    public ViajePremium(String propietario, String coche, String ruta, LocalDate fechaSalida, int plazasOfrecidas) {
        super(propietario, coche, ruta, fechaSalida, plazasOfrecidas);
    }
    
    public boolean cancelarReserva(String codigo){
        
        boolean correcto = false;
        Reserva busqueda = super.consultarReserva(codigo);
        
        if(busqueda != null){
            getReservas().remove(busqueda);    
            setNumerodePlazasDisponibles(getNumerodePlazasDisponibles()+1);
            setNumerodePlazasReservadas(getNumerodePlazasReservadas()-1);
        }
        
        return correcto;
    }
    
    @Override
    public String toString(){
        
        String retorno = "";
        
        retorno += "\n-----------------------------------------------------------------------\n";
        retorno += "»» Tipo de viaje: PREMIUM  <øøøøø>  »» Fecha del viaje: "+getFechaSalida().toString();
        retorno += "\n-----------------------------------------------------------------------\n";
        
        if(getReservas().isEmpty()){
            retorno = "!...Este viaje premium no tiene reservaciones";
        }
        else{
            for(Reserva r: getReservas()){
                retorno += r.toString();
            }
        }
        
        return retorno;
    }
    
}

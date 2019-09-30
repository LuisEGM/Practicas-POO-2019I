package PlazaCochesViajes;

import java.time.LocalDate;
import java.util.UUID;

public class Reserva implements Cloneable{
    
    private String CodigodeReserva;
    private String usuario;
    private LocalDate fecha;
    
    public Reserva(String usuario){
        
        this.CodigodeReserva = UUID.randomUUID().toString();
        this.usuario = usuario;
        this.fecha = LocalDate.now();
        
    }   

    public String getCodigodeReserva() {
        return CodigodeReserva;
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    
    @Override
    public String toString(){
        
        String retorno = "";
        
        retorno += "»» Usuario: "+this.usuario+"\n»» Codigo de reserva: "+this.CodigodeReserva+"\n»» Fecha: "+this.fecha+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        
        return retorno;
    }
    
    private Reserva copiaSuperficial(){
        
        try{
            Reserva copia = (Reserva) super.clone();
            return copia;
        }
        catch(CloneNotSupportedException e){
            System.err.println("!...La clase no es clonable");
        }
        
        return null;
    }
    
    @Override
    public Reserva clone(){
        
        Reserva clon = copiaSuperficial();
        if(clon == null){
            System.out.println("!...No se puede clonar");
        }
        else{
            clon.CodigodeReserva = new String(this.CodigodeReserva);
            clon.usuario = new String(this.usuario);
            clon.fecha = LocalDate.of(this.fecha.getYear(),this.fecha.getMonthValue(),this.fecha.getDayOfMonth());
        }
        
        return clon;
    }
    
}

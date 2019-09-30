package PlazaCochesViajes;

import java.time.LocalDate;
import java.util.LinkedList;

public class Viaje implements Cloneable{
    
    public static final int NUMERO_DE_PLAZAS_POR_DEFECTO = 1;
    
    private String Propietario;
    private String coche;
    private String ruta;
    private LocalDate fechaSalida;
    private int plazasOfrecidas;
    private LinkedList<Reserva> reservas;
    private int numerodePlazasReservadas;
    private int numerodePlazasDisponibles;
    
    public Viaje(String propietario, String coche, String ruta, LocalDate fechaSalida, int plazasOfrecidas){
        
        this.Propietario = propietario;
        this.coche = coche;
        this.ruta = ruta;
        this.fechaSalida = fechaSalida;
        this.plazasOfrecidas = plazasOfrecidas;
        this.reservas = new LinkedList<>();
        this.numerodePlazasReservadas = 0;
        this.numerodePlazasDisponibles = plazasOfrecidas;
    }
    
    public Viaje(String propietario, String coche, String ruta, LocalDate fechaSalida){
        
        this.Propietario = propietario;
        this.coche = coche;
        this.ruta = ruta;
        this.fechaSalida = fechaSalida;
        this.plazasOfrecidas = NUMERO_DE_PLAZAS_POR_DEFECTO;
        this.reservas = new LinkedList<>();
        this.numerodePlazasReservadas = 0;
        this.numerodePlazasDisponibles = NUMERO_DE_PLAZAS_POR_DEFECTO;
        
    }

    public String getPropietario() {
        return Propietario;
    }

    public String getCoche() {
        return coche;
    }

    public String getRuta() {
        return ruta;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public int getPlazasOfrecidas() {
        return plazasOfrecidas;
    }

    public LinkedList<Reserva> getReservas() {
        return reservas;
    }

    public int getNumerodePlazasReservadas() {
        return numerodePlazasReservadas;
    }

    public int getNumerodePlazasDisponibles() {
        return numerodePlazasDisponibles;
    }

    public void setNumerodePlazasReservadas(int numerodePlazasReservadas) {
        this.numerodePlazasReservadas = numerodePlazasReservadas;
    }

    public void setNumerodePlazasDisponibles(int numerodePlazasDisponibles) {
        this.numerodePlazasDisponibles = numerodePlazasDisponibles;
    }
    
    public Reserva realizarReserva(String usuario){
        
        Reserva nueva = null;
        
        if(this.numerodePlazasDisponibles > 0){
            if(this.fechaSalida.isAfter(LocalDate.now())){
               
                nueva = new Reserva(usuario);
                this.reservas.add(nueva);
                this.numerodePlazasDisponibles--;
                this.numerodePlazasReservadas = this.reservas.size();
                
            }
        }
        
        return nueva;
    }
    
    public Reserva consultarReserva(String codigoReserva){
        
        if(!this.reservas.isEmpty()){
            //System.out.println("si hay elementos");
            for(Reserva r: this.reservas){
                //System.out.println("busca");
                if(r.getCodigodeReserva() == codigoReserva){
                    //System.out.println("encuentra");
                    return r;
                }
            }
        }
        else{
            System.out.println("!...No existen reservas en este viaje");
        }
        
        return null;
    }
    
    @Override
    public String toString(){
        
        String retorno = "";
        
        retorno += "\n---------------------------------------------------------------------\n";
        retorno += "»» Tipo de viaje: CORRIENTE  <øøøøø>  »» Fecha del viaje: "+this.fechaSalida;
        retorno += "\n---------------------------------------------------------------------\n";
        
        if(this.reservas.isEmpty()){
            retorno = "!...Este viaje corriente no tiene reservaciones";
        }
        else{
            for(Reserva r: this.reservas){
                retorno += r.toString();
            }
        }
        
        return retorno;
    }
    
    private Viaje copiaSuperficial(){
        
        try{
            Viaje copia = (Viaje) super.clone();
            return copia;
        }
        catch(CloneNotSupportedException e){
            System.err.println("!...La clase no es clonable");
        }
        
        return null;
    }
    
    @Override
    public Viaje clone(){
        
        Viaje clon = copiaSuperficial();
        if(clon != null){
            
            clon.Propietario = new String(this.Propietario);
            clon.coche = new String(this.coche.toString());
            clon.ruta = new String(this.ruta.toString());
            clon.plazasOfrecidas = this.plazasOfrecidas;
            clon.fechaSalida = LocalDate.of(this.fechaSalida.getYear(),this.fechaSalida.getMonthValue(),this.fechaSalida.getDayOfMonth());
            clon.reservas = new LinkedList<Reserva>(this.reservas);
            
        }
        
        return clon;
    }
    
}

package gestionDeAgendas;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class AgendaBalanceada extends Agenda implements Cloneable{

    private HashMap<LocalDate,Integer> balance;
    
    public AgendaBalanceada(String propietario, String descripcion) {
        super(propietario, descripcion);
        this.balance = new HashMap<>();
    }
    
    @Override
    public boolean agregarUnTurno(LocalDate fecha, String franja){
        
        boolean estaEnbalance = false;
        LocalDate fechaSeleccion = null;
        
        for(LocalDate l: this.balance.keySet()){
            if(fecha.equals(l)){
                estaEnbalance = true;
                fechaSeleccion = l;
            }
        }
        
        if(!estaEnbalance){ // si no esta en el balance, lo agrego y asigno uno a su numero de turnos.
            this.balance.put(fecha,1);
            return super.agregarUnTurno(fecha,franja);
        }
        else{// si por el contrario si esta en el balance utilizo la variable fechaSeleccion en la que almacene la fecha igual.
            
            int nuevo = this.balance.get(fechaSeleccion) + 1; //obtengo el valor de la llave y le sumo 1
            this.balance.replace(fechaSeleccion,nuevo); // luego reemplazo en el mapa.
            return super.agregarUnTurno(fecha,franja);
            
        }
        
    }
    
    @Override
    public boolean hacerReserva(String usuario, Turno x){
        
        boolean estaEnbalance = false;
        LocalDate fechaSeleccion = null;
        
        for(LocalDate l: this.balance.keySet()){
            if(x.getFecha().equals(l)){
                estaEnbalance = true;
                fechaSeleccion = l;
            }
        }
        
        if(estaEnbalance){
            
            if(this.balance.get(fechaSeleccion) >= 1){
                int valor = this.balance.get(fechaSeleccion) - 1;
                this.balance.replace(fechaSeleccion,valor);
                return super.hacerReserva(usuario, x);
            }
            else{
                return super.hacerReserva(usuario, x);
            }
            
        }
        else{
            return false;
        }
    }
    
    @Override
    public Turno hacerReserva(String usuario){
        
        Turno libre = elegirTurnoLibre();
        boolean estaEnbalance = false;
        LocalDate fechaSeleccion = null;
        
        for(LocalDate l: this.balance.keySet()){
            if(libre.getFecha().equals(l)){
                estaEnbalance = true;
                fechaSeleccion = l;
            }
        }
        
        if((libre != null) && estaEnbalance){
            
            if(this.balance.get(fechaSeleccion) >= 1){
                int valor = this.balance.get(fechaSeleccion) - 1;
                this.balance.replace(fechaSeleccion,valor);
                return super.hacerReserva(usuario);
            }
            else{
                return super.hacerReserva(usuario);
            }
            
        }
        else{
            return null;
        }
        
    }
    
    
    @Override
    public boolean cancelarReserva(Turno x, String usuario){
        
        boolean estaEnbalance = false;
        LocalDate fechaSeleccion = null;
        
        for(LocalDate l: this.balance.keySet()){
            if(x.getFecha().equals(l)){
                estaEnbalance = true;
                fechaSeleccion = l;
            }
        }
        
        if(!estaEnbalance){ 
            return false;
        }
        else{
            
            int nuevo = this.balance.get(fechaSeleccion) + 1; //obtengo el valor de la llave y le sumo 1
            this.balance.replace(fechaSeleccion,nuevo); // luego reemplazo en el mapa.
            return super.cancelarReserva(x, usuario);

        }
        
    }
    
    public LocalDate diasConMasTurnosDisponibles(){
        
        int mayor = 0;
        LocalDate retorno = null;
        
        for(LocalDate l: this.balance.keySet()){
            if(this.balance.get(l) > mayor){
                mayor = this.balance.get(l);
                retorno = l;
            }
        }
        
        return retorno;
    }
    
    @Override
    protected Turno elegirTurnoLibre() {
        
        LocalDate fecha = diasConMasTurnosDisponibles();
        LinkedList<Turno> posibles = new LinkedList<>();
        LinkedList<Turno> posiblesNOreservados = new LinkedList<>();
        
        
        for(Turno t: this.turnos){
            if(fecha.equals(t.getFecha())){
                posibles.add(t);
            }
        }
        
        for(Turno t: posibles){
            boolean esta = false;
            for(Turno t2: this.ocupaciones.keySet()){
                if(t.equals(t2)){
                    esta = true;
                }
            }
            if(!esta) posiblesNOreservados.add(t);
        }
        
        return posiblesNOreservados.get(0);
        
    }
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private AgendaBalanceada copiaSuperficial(){
        AgendaBalanceada copia = (AgendaBalanceada) super.clone();
        return copia;
    }
    
    @Override
    public AgendaBalanceada clone(){
        
        AgendaBalanceada clon = copiaSuperficial();
        if(clon != null){
            clon.balance = new HashMap<>(this.balance);
        }
        
        return clon;
    }
    
}

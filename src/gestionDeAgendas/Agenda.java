package gestionDeAgendas;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Agenda implements Cloneable{
    
    protected HashMap<Turno,String> ocupaciones;
    
    private String propietario;
    private String descripcion;
    protected HashSet<Turno> turnos;
    
    public Agenda(String propietario, String descripcion){
        this.descripcion = descripcion;
        this.propietario = propietario;
        this.turnos = new HashSet<>();
        this.ocupaciones = new HashMap<>();
    }

    public HashSet<Turno> getTurnos() {
        return turnos;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public boolean agregarUnTurno(LocalDate fecha, String franja){
        
        Turno nuevo = new Turno(fecha,franja);
        return this.turnos.add(nuevo);
        
    }
    
    public void ajustarDias(int num){
        
        boolean positivo = false;
        
        if(num > 0) positivo = true;
        else{
            num = num * -1;
        }
        
        if(positivo){
            
            for(Turno t: this.turnos){
                t.setFecha(t.getFecha().minusDays(num)); // si es positivo se restan los dias
            }
            
        }
        else{
            
            for(Turno t: this.turnos){
                t.setFecha(t.getFecha().plusDays(num)); // si es negativo se suman los dias
            }
            
        }
        
    }
    
    public HashSet<Turno> consultarTurnosDeUnDia(LocalDate fecha){
        
        HashSet<Turno> retorno = new HashSet<>();
        
        for(Turno t: this.turnos){
            if(fecha.equals(t.getFecha())){
                retorno.add(t);
            }
        }
        
        return retorno;
    }
    
    public boolean hacerReserva(String usuario, Turno x){
        
        boolean existeEnAjenda = false;
        boolean estaOcupado = false;
        
        for(Turno t: this.turnos){
            if(t.equals(x)){ // si existe en la agenda
                existeEnAjenda = true;
            }
        }
        
        for(Turno t: this.ocupaciones.keySet()){
            if(t.equals(x)){ // si esta ocupado
                estaOcupado = true;
            }
        }
        
        if(existeEnAjenda && !estaOcupado){ // si existe en la agenda y no esta ocupado
            this.ocupaciones.put(x,usuario);
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public Turno hacerReserva(String usuario){
        
        Turno libre = elegirTurnoLibre();
        
        if(libre != null){
            this.ocupaciones.put(libre,usuario);
            return libre;
        }
        else return null;
        
    }
    
    protected abstract Turno elegirTurnoLibre();
    
    public String consultarElUsuarioQueHaReservadoUnTurno(Turno x){
        
        for(Turno t: this.ocupaciones.keySet()){ // recorro los turnos 
            if(t.equals(x)){ // si lo encuentro
                return this.ocupaciones.get(t); // retorno el valor asociado a el turno.
            }
        }
        
        return null;
    }
    
    public boolean consultarSiUnTurnoEstaOcupado(Turno x){
        
        for(Turno t: this.ocupaciones.keySet()){ // recorro los turnos 
            if(t.equals(x)){ // si lo encuentro
                return true;
            }
        }
        
        return false;
    }
    
    public boolean cancelarReserva(Turno x, String usuario){
        
        for(Turno t: this.ocupaciones.keySet()){ // recorro los turnos 
            if(t.equals(x)){ // si lo encuentro
                if(usuario == this.ocupaciones.get(t)){ // extraigo la cadena asociada y la comparo con el parametro
                    //si son iguales, existe una relacioin entre el turno y el usuario, entonces puedo elimiar del mapa
                    return this.ocupaciones.remove(t,this.ocupaciones.get(t));
                }
            }
        }
        
        return false;
    }
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private Agenda copiaSuperficial(){
        
        try{
            Agenda copia = (Agenda) super.clone();
            return copia;
        }
        catch(CloneNotSupportedException e){
            System.err.println("!...La clase no es clonable");
        }
        
        return null;
    }
    
    @Override
    public Agenda clone(){
        
        Agenda clon = copiaSuperficial();
        if(clon != null){
            
            clon.descripcion = new String(this.descripcion);
            clon.propietario = new String(this.propietario);
            clon.turnos = new HashSet<>(this.turnos);
            clon.ocupaciones = new HashMap<>(this.ocupaciones);
            clon.ocupaciones.clear();
            
        }
        
        return clon;
    }
    
}

package gestionDeAgendas;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;

public class AgendaBasica extends Agenda implements Cloneable{
    
    private HashSet<String> usuariosQueReservaron;
    
    public AgendaBasica(String propietario, String descripcion) {
        super(propietario, descripcion);
        this.usuariosQueReservaron = new HashSet<>();
    }
    
    @Override
    protected Turno elegirTurnoLibre() {
        
        LinkedList<Turno> turnosLibres = new LinkedList<>();
        
        for(Turno tur: this.turnos){ // saco en una lista aparte los turnos que no estesn ocupados
            
            boolean ocupado = false; // creo una variable que empiece en falso, cada vez que evalue un turno.
            
            for(Turno turOcupado: this.ocupaciones.keySet()){ // si el turno esta dentro del mapa de turnos, esta ocupado
                if(tur.equals(turOcupado)){
                    ocupado = true; // ocupado se refresca y se vuelve verdadero.
                }
            }
            
            if(!ocupado) turnosLibres.add(tur); // si no esta ocupado lo agrego a la lista de posibles.
            
        }
        
        // hago algo similar a encontrar el numero menor de un conjunto de datos, pero con fechas;
        LocalDate fechaMenor = LocalDate.of(5000,1,1); // un año exagerado
        Turno retornar = null;
        
        for(Turno t: turnosLibres){
            if(t.getFecha().isBefore(fechaMenor)){
                fechaMenor = t.getFecha();
                retornar = t;
            }
        }
        
        return retornar;
    }
    
    @Override
    public boolean hacerReserva(String usuario, Turno x){
        
        boolean yaReservo = false;
        
        for(String s: this.usuariosQueReservaron){
            if(usuario.equals(s)){
                yaReservo = true;
            }
        }

        if(yaReservo){
            return false;
        }
        else{
            this.usuariosQueReservaron.add(usuario);
            return super.hacerReserva(usuario, x);
        }
        
    }
    
    @Override
    public Turno hacerReserva(String usuario){
        
        boolean yaReservo = false;
        
        for(String s: this.usuariosQueReservaron){
            if(usuario.equals(s)){
                yaReservo = true;
            }
        }

        if(!yaReservo){
            this.usuariosQueReservaron.add(usuario);
            return super.hacerReserva(usuario);
        }
        else{
            return null;
        }
        
    }
    
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private AgendaBasica copiaSuperficial(){
        AgendaBasica copia = (AgendaBasica) super.clone();
        return copia;
    }
    
    @Override
    public AgendaBasica clone(){
        
        AgendaBasica clon = copiaSuperficial();
        if(clon != null){
            clon.usuariosQueReservaron = new HashSet<>(this.usuariosQueReservaron);
        }
        
        return clon;
    }
        
}

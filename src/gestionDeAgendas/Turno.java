package gestionDeAgendas;

import java.time.LocalDate;
import java.util.Objects;

public class Turno {
    
    private LocalDate fecha;
    private String franja;
    
    public Turno(LocalDate fecha, String franja){
        this.fecha = fecha;
        this.franja = franja;
    }

    public String toString(){
        String retorno = "";
        
        retorno += "\n~~~~~~~~~~~  »» Turno  ~~~~~~~~~~~~~\n\n";
        retorno += "»» Fecha: "+this.fecha+"\n";
        retorno += "»» Franja: "+this.franja+"\n";
        
        
        return retorno;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public String getFranja() {
        return franja;
    }

    //Aunque se estipula que no se pueden modificar las propiedades de la clase turno, en la clase agenda se ofrece la opcion de ajustar turno
    // esto permite modificar las fechas del turno, por eso este set.
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.fecha);
        hash = 37 * hash + Objects.hashCode(this.franja);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turno other = (Turno) obj;
        if (!Objects.equals(this.franja, other.franja)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }
    
    
    
}

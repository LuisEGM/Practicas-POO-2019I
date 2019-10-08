package referendums;

import java.time.LocalDate;

public class Elector {
    
    private final double dni;
    private final String nombre;
    private final LocalDate fechadeNacimiento;
    
    public Elector(double dni, String nombre, LocalDate fechadeNacimiento){
        
        this.dni = dni;
        this.nombre = nombre;
        this.fechadeNacimiento = fechadeNacimiento;
        
    }

    public double getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechadeNacimiento() {
        return fechadeNacimiento;
    }
    
    @Override
    public String toString(){
        
        String retorno = "";
        
        retorno += "»» Nombre: "+this.nombre;
        retorno += "»» DNI: "+this.dni;
        retorno += "»» Fecha de nacimiento: "+this.fechadeNacimiento;
        
        return retorno;
    }
    
}

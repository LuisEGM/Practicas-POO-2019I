package referendums;

import java.time.LocalDate;

public class Elector {
    
    private final String dni;
    private final String nombre;
    private final LocalDate fechadeNacimiento;
    
    public Elector(String dni, String nombre, LocalDate fechadeNacimiento){
        
        this.dni = dni;
        this.nombre = nombre;
        this.fechadeNacimiento = fechadeNacimiento;
        
    }

    public String getDni() {
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
        
        retorno += "»» Nombre: "+this.nombre+"\n";
        retorno += "»» DNI: "+this.dni+"\n";
        retorno += "»» Fecha de nacimiento: "+this.fechadeNacimiento;
        
        return retorno;
    }
    
}

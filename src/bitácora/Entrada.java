package bitácora;

import java.time.LocalDate;

public class Entrada {
    
    private final String suceso;
    private final LocalDate fecha;
    
    public Entrada(String suceso){
        
        this.suceso = suceso;
        this.fecha = LocalDate.now();
        
    }

    public String getSuceso() {
        return suceso;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    
}

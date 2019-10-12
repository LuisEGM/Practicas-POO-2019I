package LicenciasDeInternet;

import java.time.LocalDate;

public class LicenciaTemporal extends Licencia{
    
    private LocalDate fechadeCaducidad;
    private boolean caducada;
    
    public LicenciaTemporal(String email, String servicio, LocalDate fechadeCaducidad) {
        
        super(email,servicio);
        this.fechadeCaducidad = fechadeCaducidad;
        this.caducada = false;
        
    }
    
    public LicenciaTemporal(String email, String servicio) {
        
        super(email,servicio);
        this.fechadeCaducidad = getFechaDeCreacion().plusMonths(3);
        this.caducada = false;
        
    }
    
    public void extenderFechaDeCaducidad(int numeroMeses){
        this.fechadeCaducidad = this.fechadeCaducidad.plusMonths(numeroMeses);
    }
    
    @Override
    protected boolean esAplicable() {
        
        if(LocalDate.now().isBefore(this.fechadeCaducidad) || LocalDate.now().isEqual(this.fechadeCaducidad)){
            
            this.caducada = true;
        }
        else{
            
            this.caducada = false;
        }
        
        if(!this.caducada){ // si no esta caducada
            return true;
        }
        else{
            return false;
        }
        
    }
    
    @Override
    public String toString(){
        String retorno = "";
        
        retorno += super.toString();
        retorno += "»» Fecha de caducidad: "+ this.fechadeCaducidad +"\n";
        
        return retorno;
    }
    
}

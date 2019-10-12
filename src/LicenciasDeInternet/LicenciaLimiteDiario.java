package LicenciasDeInternet;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;

public class LicenciaLimiteDiario extends LicenciaTransaccionesLimitadas implements Cloneable{
    
    private int limiteDeTransaccionesPorDia;
    private HashMap<LocalDate,Integer> CantidadTransaccionesPorDia;
    
    public LicenciaLimiteDiario(String email, String servicio, int limiteTransacciones, int limiteTransaccionesPorDia) {
        super(email, servicio, limiteTransacciones);
        this.limiteDeTransaccionesPorDia = limiteTransaccionesPorDia;
        this.CantidadTransaccionesPorDia = new HashMap<LocalDate,Integer>(); 
    }

    public int getLimiteDeTransaccionesPorDia() {
        return limiteDeTransaccionesPorDia;
    }
    
    public int TransaccionesRestantesHoy(){
        return (this.limiteDeTransaccionesPorDia - this.numerotransacciones);
    }
    
    @Override
    protected boolean esAplicable() {
        
        if(this.numerotransacciones < this.LimitedeTransacciones){
            
            if(this.numerotransacciones < TransaccionesRestantesHoy()){
                return true;
            }
            else{
                return false;
            }

        }
        else{
            return false;
        }
        
    }
    
    /*public int transaccionesRealizadasElDia(LocalDate fecha){
        
    }*/
    
    @Override
    public String toString(){
        String retorno = "";
        
        retorno += super.toString();
        retorno += "»» Limite de transacciones por dia: "+this.limiteDeTransaccionesPorDia+"\n";
        
        return retorno;
    }
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private LicenciaLimiteDiario copiaSuperficial(){
        
        LicenciaLimiteDiario copia = (LicenciaLimiteDiario) super.clone();
        return copia;

    }
    
    @Override
    public LicenciaLimiteDiario clone(){
        
        LicenciaLimiteDiario clon = copiaSuperficial();
        if(clon != null){
            
            clon.limiteDeTransaccionesPorDia = this.limiteDeTransaccionesPorDia;
            clon.CantidadTransaccionesPorDia = new HashMap<>(this.CantidadTransaccionesPorDia);
        }
        
        return clon;
    }
    
}

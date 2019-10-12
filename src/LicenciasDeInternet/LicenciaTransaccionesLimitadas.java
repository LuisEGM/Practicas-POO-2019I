package LicenciasDeInternet;

public class LicenciaTransaccionesLimitadas extends Licencia implements Cloneable{
    
    protected int LimitedeTransacciones;
    private int transaccionesRestantes;
    
    public LicenciaTransaccionesLimitadas(String email, String servicio, int limiteTransacciones) {
        
        super(email,servicio);
        this.LimitedeTransacciones = limiteTransacciones;
        
    }

    public int getLimitedeTransacciones() {
        return LimitedeTransacciones;
    }

    public int getTransaccionesRestantes() {
        return (this.LimitedeTransacciones - this.numerotransacciones);
    }
    
    @Override
    protected boolean esAplicable() {
        
        if(this.numerotransacciones < this.LimitedeTransacciones){
            /*if(getTransaccionesRestantes() > 0){
                return true;
            }
            else{
                return false;
            }*/
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
        retorno += "»» Limite de transacciones: "+ this.LimitedeTransacciones +"\n";
        retorno += "»» Transacciones restantes: "+ getTransaccionesRestantes() +"\n";
        
        return retorno;
    }
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private LicenciaTransaccionesLimitadas copiaSuperficial(){
       
        LicenciaTransaccionesLimitadas copia = (LicenciaTransaccionesLimitadas) super.clone();
        return copia;
   
    }
    
    @Override
    public LicenciaTransaccionesLimitadas clone(){
        
        LicenciaTransaccionesLimitadas clon = copiaSuperficial();
        if(clon != null){
            
            clon.LimitedeTransacciones = this.LimitedeTransacciones;
            clon.transaccionesRestantes = this.transaccionesRestantes;
                    
        }
        
        return clon;
    }
    
}

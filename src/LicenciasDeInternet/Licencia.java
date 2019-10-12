package LicenciasDeInternet;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.UUID;

public abstract class Licencia implements Cloneable{
    
    private String email;
    private LocalDate fechaDeCreacion;
    private String codigo;
    protected LinkedList<Transaccion> transacciones;
    protected int numerotransacciones;
    private boolean revocada;
    private String servicio;
    
    public Licencia(String email, String servicio){
        
        this.email = email;
        this.fechaDeCreacion = LocalDate.now();
        this.codigo = UUID.randomUUID().toString();
        this.transacciones = new LinkedList<>();
        this.numerotransacciones = 0;
        this.revocada = false;
        this.servicio = servicio;
        
    }

    
    
    public String getEmail() {
        return email;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public LinkedList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public int getNumerodeTransaciones() {
        return numerotransacciones;
    }

    public boolean isRevocada() {
        return revocada;
    }

    public String getServicio() {
        return servicio;
    }
    
    
    
    public void revocarLicencia(){
        this.revocada = true;
    }
    
    protected abstract boolean esAplicable();
    
    public Transaccion ObtenerAutorizaciónDeUsoDelServicio(){
        
        if(!this.revocada){
            
            if(esAplicable()){
                
                Transaccion nueva = new Transaccion(this);
                this.transacciones.add(nueva);
                this.numerotransacciones++;
                //System.out.println(this.transacciones.size());
                return nueva;
                
            }
            else{
                return null;
            }
            
        }
        else{
            return null;
        }
        
    }
    
    @Override
    public String toString(){
        String retorno = "";
        
        retorno += "»» E-mail: "+this.email+"\n";
        retorno += "»» Código: "+this.codigo+"\n";
        retorno += "»» Fecha de creación: "+this.fechaDeCreacion+"\n";
        retorno += "»» Servicio: "+this.servicio+"\n";
        retorno += "»» Revocada: "+this.revocada+"\n";
        retorno += "»» N° transacciones: "+this.numerotransacciones+"\n";
        
        return retorno;
    }
    
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private Licencia copiaSuperficial(){
        
        try{
            Licencia copia = (Licencia) super.clone();
            return copia;
        }
        catch(CloneNotSupportedException e){
            System.err.println("!...La clase no es clonable");
        }
        
        return null;
    }
    
    @Override
    public Licencia clone(){
        
        Licencia clon = copiaSuperficial();
        if(clon != null){
            
            clon.codigo = new String(this.codigo);
            clon.email = new String(this.email);
            clon.fechaDeCreacion = LocalDate.of(this.fechaDeCreacion.getYear(), this.fechaDeCreacion.getMonthValue(),this.fechaDeCreacion.getDayOfMonth());
            clon.servicio = new String(this.servicio);
            clon.transacciones = new LinkedList<>(this.transacciones);
            clon.revocada = this.revocada;
            clon.numerotransacciones = this.numerotransacciones;
            
        }
        
        return clon;
    }
    
}

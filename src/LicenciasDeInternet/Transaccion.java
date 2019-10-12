package LicenciasDeInternet;

import java.time.LocalDate;

public class Transaccion {
    
    private final Licencia autorizacion;
    private final LocalDate fecha;
    
    public Transaccion(Licencia autorizacion){
        this.autorizacion = autorizacion;
        this.fecha = LocalDate.now();
    }

    public Licencia getAutorizacion() {
        return autorizacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    
    @Override
    public String toString(){
        String retorno = "";
        
        retorno += "\n-------------------  INFORMACIÓN DE TRANSACCIÓN  ----------------------\n\n";
        retorno += "«~» INFORMACIÓsN DE LA LICENCIA DE LA TRANSACCIÓN\n";
        retorno += this.autorizacion.toString();
        retorno += "\n«~» FECHA DE LA TRANSACCIÓN: "+ this.fecha +"\n";
        
        return retorno;
    }
    
}

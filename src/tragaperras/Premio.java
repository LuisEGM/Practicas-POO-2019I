package tragaperras;

import java.util.ArrayList;
import java.util.Collections;

public class Premio {
    
    private final double cantidad;
    private ArrayList<Fruta> combinacion;
    
    public Premio(double cantidad, Fruta... Vcombinacion){
        this.cantidad = cantidad;
        this.combinacion = new ArrayList<>(Vcombinacion.length);
        Collections.addAll(this.combinacion,Vcombinacion);
    }
    
    public double getCantidad(){
        return cantidad;
    }

    public ArrayList<Fruta> getCombinacion() {
        return combinacion;
    }
    
}

package subastas;

public class Puja {
    
    private final Usuario pujador;
    private final double cantidad;
    private final Subasta subasta;
    
    public Puja(Usuario pujador, double cantidad, Subasta subasta){
        this.pujador = pujador;
        this.cantidad = cantidad;
        this.subasta = subasta;
    }
    
    // TENER EN CUENTA EL ALIASING
    
    public Usuario getPujador() {
        return pujador;
    }

    public double getCantidad() {
        return cantidad;
    }

    public Subasta getSubasta() {
        return subasta;
    }    
    
}

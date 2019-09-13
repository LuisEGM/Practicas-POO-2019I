package subastas;

public class Usuario {
    
    public static final double valorInicial = 50;
    
    private final String nombre;
    private double credito;
    
    public Usuario(String nombre, double credito){
        this.nombre = nombre;
        this.credito = credito;
    }
    
    public Usuario(String nombre){
        this(nombre,valorInicial);
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getCredito() {
        return credito;
    }
    
    public void incrementarCredito(double incremento){
        this.credito += incremento;
    }
    
    public void decrementarCredito(double decremento){
        this.credito -= decremento;
    }
    
}

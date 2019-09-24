package bitácora;

import java.util.LinkedList;

public class Bitácora {
    
    private final String nombre;
    protected LinkedList<Entrada> entradas;
    private int numeroEntradas;
    
    public Bitácora(String nombre){
        
        this.nombre = nombre;
        this.entradas = new LinkedList<>();
        this.numeroEntradas = 0;
        
    }

    public String getNombre() {
        return nombre;
    }

    public LinkedList<Entrada> getEntradas() {
        return entradas;
    }

    public int getNumeroEntradas() {
        return numeroEntradas;
    }
    
    public boolean registrar(String suceso){
        boolean correcto = true;
        
        Entrada nueva = new Entrada(suceso);
        this.entradas.addLast(nueva);
        this.numeroEntradas++;
        
        return correcto;
    }

}

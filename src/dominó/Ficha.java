package dominó;

public class Ficha {
    //En comienzo las pintas eran constantes, pero con el problema de cambiarlas si se cruzaban las fichas las deje normal.
    private int pintaDerecha;
    private int pintaIzquierda;
    private boolean entragada; // Para saber si la partida la entrego a un jugador.
    
    public Ficha(int pintaIzquierda, int pintaDerecha){
        this.pintaDerecha = pintaDerecha;
        this.pintaIzquierda = pintaIzquierda;
        this.entragada = false;
    }
    
    public Ficha(Ficha f){
        this(f.pintaIzquierda,f.pintaDerecha);
    }

    public int getPintaDerecha() {
        return pintaDerecha;
    }

    public int getPintaIzquierda() {
        return pintaIzquierda;
    }

    public void setPintaDerecha(int pintaDerecha) {
        this.pintaDerecha = pintaDerecha;
    }

    public void setPintaIzquierda(int pintaIzquierda) {
        this.pintaIzquierda = pintaIzquierda;
    }
    
    public boolean getEntregada(){
        return entragada;
    }
    
    public void setEntragada(boolean entragada) {
        this.entragada = entragada;
    }
    
}

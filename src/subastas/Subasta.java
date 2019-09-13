package subastas;

import java.util.LinkedList;

public class Subasta {
    
    private String nombreDelProducto;
    private Usuario propietario;
    private boolean abierta;
    private LinkedList<Puja> ListaPujas;
    private Puja PujaMayor;

    public Subasta(String nombreDelProducto, Usuario propietario){
        this.nombreDelProducto = nombreDelProducto;
        this.propietario = propietario;
        this.abierta = true;
        this.ListaPujas = new LinkedList<>();
        this.PujaMayor = null;
    }
    
    public String getNombreDelProducto() {
        return nombreDelProducto;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public boolean isAbierta() {
        return abierta;
    }
    
    //Retorna una copia de la lista
    public LinkedList<Puja> getListaPujas() {
        return new LinkedList<Puja> (ListaPujas);
    }

    public Puja getPujaMayor() {
        return PujaMayor;
    }
    
    public boolean pujar(Usuario pujador, double cantidad){
        
        boolean pujaAceptada = false;
        
        if(this.abierta){ // si la puja esta abierta
            
            if(pujador.getCredito() >= cantidad){ // tiene lo suficiente para pagar?
                
                if(pujador != this.propietario){ // quien subasta no puede pujar
                    
                    if(this.PujaMayor != null){ //si no hay pujas, la primera es la mayor
                        
                        if(cantidad > this.PujaMayor.getCantidad()){ // si hay pujas, revisa si la nueva supera la mayor
                        
                            Puja nueva = new Puja(pujador, cantidad,this); //si la supera se crea la puja
                            ListaPujas.addFirst(nueva); // se añade a las lista
                            this.PujaMayor = nueva; // se refresca la puja mayor
                            pujaAceptada = true;

                        }
                        else{
                            System.out.println("Hay mejores pujas");
                        }
                        
                    }
                    else{
                        Puja nueva = new Puja(pujador, cantidad,this);
                        ListaPujas.addFirst(nueva);
                        this.PujaMayor = nueva;
                        pujaAceptada = true;
                    }
                    
                }
                else{
                    System.out.println("El propietario de la subasta no puede pujar");
                }
            }
            else{
                System.out.println("Su credito es insuficiente");
            }
        }
        else{
            System.out.println("La puja esta cerrada");
        }
        
        return pujaAceptada;
    }
    
    public boolean pujarSC(Usuario pujador){
        
        double pujaMayorActual = this.PujaMayor.getCantidad();
        pujaMayorActual++;
        
        if(this.PujaMayor == null) return this.pujar(pujador,1.0);
        else return this.pujar(pujador,pujaMayorActual); 
    
    }
    
    public boolean ejecutar(){
        
        boolean seEjecuto = false;
        double pujaMayorActual = this.PujaMayor.getCantidad();
        
        if(this.PujaMayor != null){ // si hay pujas
            if(this.abierta){ // y la subasta esta habierta
                this.getPujaMayor().getPujador().decrementarCredito(pujaMayorActual);
                this.getPropietario().incrementarCredito(pujaMayorActual);
                this.abierta = false;
                seEjecuto = true;
            }
            else{
                System.out.println("La subasta esta cerrada");
            }
        }
        else{
            System.out.println("No existen pujas");
        }
        
        return seEjecuto;
    }
    
}

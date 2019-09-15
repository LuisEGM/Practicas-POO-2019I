package tragaperras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Maquina {
    
    private final double casillas;
    private double precioDeLaJugada;
    private double credito;
    private ArrayList<Premio> premios;
    
    public Maquina(double casillas, double precioDeLaJugada, Premio... Vecpremios){
        this.casillas = casillas;
        this.precioDeLaJugada = precioDeLaJugada;
        this.credito = 0.0;
        this.premios = new ArrayList<>(Vecpremios.length);
        Collections.addAll(this.premios,Vecpremios);
    }

    public double getCasillas() {
        return casillas;
    }

    public double getPrecioDeLaJugada() {
        return precioDeLaJugada;
    }
    
    public void setPrecioDeLaJugada(double PrecioDeLaJugada){
        this.precioDeLaJugada = PrecioDeLaJugada;
    }
    
    public double getCredito() {
        return credito;
    }

    public ArrayList<Premio> getPremios() {
        return premios;
    }
    
    public void IncrementarCredito(double credito){
        this.credito += credito;
    }
    
    public ArrayList<Fruta> generarCombinacion(){
        
        ArrayList<Fruta> combinacion = new ArrayList<>((int) this.casillas);
        
        Random random = new Random();
        Fruta[] todas = Fruta.values();
        
        for(int i=0 ; i < this.casillas ; i++){
            combinacion.add(todas[random.nextInt(todas.length)]);
        }
        
        return combinacion;
    }
    
    public ArrayList<Fruta> jugar(){
        
        ArrayList<Fruta> resultado = null;
        boolean consola = true;
        
        if(this.credito >= this.precioDeLaJugada){
            
            //Decrementar el crédito disponible la cantidad correspondiente al precio de la jugada
            this.credito -= this.precioDeLaJugada;
            
            //Generar aleatoriamente una combinación de frutas utilizando el método auxiliar (generarCombinacion).
            
            resultado = generarCombinacion();
            
            for(Premio f:this.premios){
                if(resultado.equals(f.getCombinacion())){
                    this.credito += f.getCantidad();
                    System.out.println("»»»»» Gana € "+f.getCantidad()+" «««««");
                    consola = false;
                }
            }
            
        }
        
        if(consola){
            System.out.println("xxxxx Pierde € 0.5 xxxxx");
        }
        
        return resultado;
    }
    
}

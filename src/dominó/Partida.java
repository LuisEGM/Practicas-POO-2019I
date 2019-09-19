package dominó;

import java.util.ArrayList;
import java.util.Random;

public class Partida {
    
    private ArrayList<Ficha> fichas;
    private String ganador;
    
    public Partida(){
        this.ganador = null;
        this.fichas = new ArrayList<>(28);
        
        int iterador = 0; // Genera las fichas del domino y las mete en un vector.
        for(int i=0 ; i <= 6 ; i++){
            for(int j=0 ; j <= i ; j++){
                this.fichas.add(iterador,new Ficha(j,i));
                iterador++;
            }
        }
        
    }
    
    /*Revolver y repartir, recibe los jugadores que estaran en la partida y les reparte las fichas al azar*/
    public void RevolveryRepartir(Jugador... jugadores){
        
        for(Jugador j: jugadores){ //Para cada jugador
            
            int FichasEntregadasUnjugador = 0;
            while(FichasEntregadasUnjugador < 7){ //Se repartiran 7 fichas
                
                Random random = new Random(); // Aleaatoriamente se escoje una ficha.
                int FichaAleatoria = random.nextInt(this.fichas.size()); 
                
                // Visita la ficha seleccionada y se verifica si no ha sido entregada.
                if(!this.fichas.get(FichaAleatoria).getEntregada()){  
                    
                    j.getBaraja().add(this.fichas.get(FichaAleatoria)); //Agrego la ficha a la baraja del jugador.
                    this.fichas.get(FichaAleatoria).setEntragada(true); // la marco como entregada.
                    FichasEntregadasUnjugador++; //Aumento el controlador del ciclo.
                    
                }
                
            }
            
        }
        
    }
    
}

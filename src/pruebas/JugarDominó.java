package pruebas;

import dominó.Ficha;
import dominó.Jugador;
import dominó.Partida;
import java.util.LinkedList;

public class JugarDominó {

    public static void main(String[] args) {
        
        boolean PartidaCerrada = false;
        
        int numPintasJug1 = 0;
        int numPintasJug2 = 0;
        int numPintasJug3 = 0;
        int numPintasJug4 = 0;
        int menor = 999999;
        
        //Se define la lista ligada donde se almacenaran las fichas jugadas por los jugadores.
        LinkedList<Ficha> FichasJugadas = new LinkedList<>();
        
        //Se instancian los jugadores.
        Jugador jugador1 = new Jugador("LUIS");
        Jugador jugador2 = new Jugador("ENRRIQUE");
        Jugador jugador3 = new Jugador("JUAN");
        Jugador jugador4 = new Jugador("PEPITO");
        
        //Se instancia una partida.
        Partida partida1 = new Partida();
        
        //Se inicia la partida.
        partida1.RevolveryRepartir(jugador1,jugador2,jugador3,jugador4);
        
        while(!PartidaCerrada && (!jugador1.getSinFichas() && !jugador2.getSinFichas() && !jugador3.getSinFichas() && !jugador4.getSinFichas())){
            
            // que cada jugador ponga fichas, cuando todos pasen, la partida se habra cerrado.
            jugador1.jugar(FichasJugadas);
            if(jugador1.getSinFichas()) break;
                
            jugador2.jugar(FichasJugadas);
            if(jugador2.getSinFichas()) break;
            
            jugador3.jugar(FichasJugadas);
            if(jugador3.getSinFichas()) break; 
            
            jugador4.jugar(FichasJugadas);
            if(jugador4.getSinFichas()) break;
            
            if((jugador1.getPASÓ() == jugador2.getPASÓ() == jugador3.getPASÓ() == jugador4.getPASÓ())==true){
                PartidaCerrada = true;
            }
            
        }
         
        // EL ciclo se repetira hasta que la partida se cierre o que alguno de los jugadores no tenga fichas.
        
        //Reviso cual jugador se quedo sin fichas
        if(jugador1.getBaraja().isEmpty()){
            System.out.println("\n@@@@@@@@ EL GANADOR DE LA PARTIDA ES "+ jugador1.getNombre() +" @@@@@@@@\n");
        }
        if(jugador2.getBaraja().isEmpty()){
            System.out.println("\n@@@@@@@@ EL GANADOR DE LA PARTIDA ES "+ jugador2.getNombre() +" @@@@@@@@\n");
        }
        if(jugador3.getBaraja().isEmpty()){
            System.out.println("\n@@@@@@@@ EL GANADOR DE LA PARTIDA ES "+ jugador3.getNombre() +" @@@@@@@@\n");
        }
        if(jugador4.getBaraja().isEmpty()){
            System.out.println("\n@@@@@@@@ EL GANADOR DE LA PARTIDA ES "+ jugador4.getNombre() +" @@@@@@@@\n");
        }
        
        if(PartidaCerrada){ //SI se cerro cuento las pintas de cada jugador.
            
            for(Ficha f: jugador1.getBaraja()){
                numPintasJug1 += (f.getPintaDerecha() + f.getPintaIzquierda());
            }
            
            for(Ficha f: jugador2.getBaraja()){
                numPintasJug2 += (f.getPintaDerecha() + f.getPintaIzquierda());
            }
            
            for(Ficha f: jugador3.getBaraja()){
                numPintasJug3 += (f.getPintaDerecha() + f.getPintaIzquierda());
            }
            
            for(Ficha f: jugador4.getBaraja()){
                numPintasJug4 += (f.getPintaDerecha() + f.getPintaIzquierda());
            }
            
            //Luego saco la menor
            int vector[] = new int[4];
            int iterador = -1;
            vector[0] = numPintasJug1;
            vector[1] = numPintasJug2;
            vector[2] = numPintasJug3;
            vector[3] = numPintasJug4;
            
            for(int i=0 ; i < 4 ; i++){
                if(vector[i] < menor){
                    menor = vector[i];
                    iterador = i;
                }
            }
            
            //Ya conocinedo los datos de cual es menor numero de pintas y con el iterador saber a que jugador pertenece
            System.out.println("\n°°°°°°°°°°°°°°°°°°° LA PARTIDA SE CERRO °°°°°°°°°°°°°°°°°°°\n");
            if(iterador == 0){
                System.out.println("@@@@@@@@ EL GANADOR DE LA PARTIDA ES "+ jugador1.getNombre() +" CON "+ numPintasJug1 +" PINTAS @@@@@@@@\n");
            }
            if(iterador == 1){
                System.out.println("@@@@@@@@ EL GANADOR DE LA PARTIDA ES "+ jugador2.getNombre() +" CON "+ numPintasJug2 +" PINTAS @@@@@@@@\n");
            }
            if(iterador == 2){
                System.out.println("@@@@@@@@ EL GANADOR DE LA PARTIDA ES "+ jugador3.getNombre() +" CON "+ numPintasJug3 +" PINTAS @@@@@@@@\n");
            }
            if(iterador == 3){
                System.out.println("@@@@@@@@ EL GANADOR DE LA PARTIDA ES "+ jugador4.getNombre() +" CON "+ numPintasJug4 +" PINTAS @@@@@@@@\n");
            }
            
        }
        
    }
    
}

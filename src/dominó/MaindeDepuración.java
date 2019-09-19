// Aqui se realizaron las depuraciones.
package dominó;

//import java.util.ArrayList;
//import java.util.LinkedList;

public class MaindeDepuración {

    public static void main(String[] args) {
        
        /*
        >> Prueba 4: Se cumplen bien las operaciones de juego, no valido si el jugador pone una ficha indevida.
        si el jugador no tiene ficha para escojer deberia PASAR, a menos que haga trampa.
        
        LinkedList<Ficha> FichasJugadas = new LinkedList<>();
        
        Jugador jugador1 = new Jugador("Luis");
        Jugador jugador2 = new Jugador("Enrrique");
        Jugador jugador3 = new Jugador("Juan");
        Jugador jugador4 = new Jugador("Pepito");
        
        Partida partida1 = new Partida();
        
        partida1.RevolveryRepartir(jugador1,jugador2,jugador3,jugador4);
        
        jugador1.jugar(FichasJugadas);
        jugador2.jugar(FichasJugadas);
        jugador3.jugar(FichasJugadas);
        jugador1.jugar(FichasJugadas);
        jugador2.jugar(FichasJugadas);
        jugador3.jugar(FichasJugadas);
        */
        
        /* 
        >> Prueba1: SE PUEDE PASAR UN VECTOR, COMO ARGUMENTO VARIBLE PARA CREAR EL JUGADOR, Y ESTE ARGUMENTO LUEGO PUEDE
        METERSE EN UNA LISTA LIGADA, LUEGO RETORNE LA LISTA Y LA MOSTRE EN PANTALLA.
        
        LinkedList<Ficha> lista = new LinkedList<>();
        
        Ficha vec[];
        vec = new Ficha[3];
        
        vec[0] = new Ficha(0,0);
        vec[1] = new Ficha(0,1);
        vec[2] = new Ficha(0,2);
        
        Jugador jugador1 = new Jugador("Luis", vec);
        
        lista = jugador1.getBaraja();
        
        for(Ficha f: lista){
            System.out.println("["+ f.getPintaIzquierda() +" , "+ f.getPintaDerecha() +"]");
        }*/
        
        
        
        
        /*
        >> Prueba2: Generando fichas.
        
        ArrayList<Ficha> fichas = new ArrayList<>(28);
        int iterador = 0;
        for(int i=0 ; i <= 6 ; i++){
            for(int j=0 ; j <= i ; j++){
                //System.out.println("["+ j +" , "+ i +"]");
                fichas.add(iterador,new Ficha(j,i));
                iterador++;
            }
        }
        System.out.println("»» "+iterador);
        for(Ficha f: fichas){
            System.out.println("["+ f.getPintaIzquierda() +" , "+ f.getPintaDerecha() +"]");
        }
        System.out.println("«« "+fichas.size());
        
        */
        
        
        
        
        /*
        >> Prueba 3: La clase pARTIDA GENERA REPARTE 7 FICHAS A CADA JUGADOR ALEATORIAMENTE, BIEN.
        
        Jugador jugador1 = new Jugador("Luis");
        Jugador jugador2 = new Jugador("Enrrique");
        Jugador jugador3 = new Jugador("Juan");
        Jugador jugador4 = new Jugador("Pepito");
        
        Partida partida1 = new Partida();
        
        partida1.RevolveryRepartir(jugador1,jugador2,jugador3,jugador4);
        
        for(Ficha f: jugador1.getBaraja()){
            System.out.println("["+ f.getPintaIzquierda() +" , "+ f.getPintaDerecha() +"]");
        }
        System.out.println("«««««««««««««««««««««««««««««««««");
        for(Ficha f: jugador2.getBaraja()){
            System.out.println("["+ f.getPintaIzquierda() +" , "+ f.getPintaDerecha() +"]");
        }
        System.out.println("«««««««««««««««««««««««««««««««««");
        for(Ficha f: jugador3.getBaraja()){
            System.out.println("["+ f.getPintaIzquierda() +" , "+ f.getPintaDerecha() +"]");
        }
        System.out.println("«««««««««««««««««««««««««««««««««");
        for(Ficha f: jugador4.getBaraja()){
            System.out.println("["+ f.getPintaIzquierda() +" , "+ f.getPintaDerecha() +"]");
        }
        
        */
        
    }
    
}

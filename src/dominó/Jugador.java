package dominó;

import java.util.LinkedList;
import java.util.Scanner;

public class Jugador {
    
    private final String nombre;
    private final LinkedList<Ficha> baraja;
    private boolean PASÓ;
    private boolean sinFichas; // Para saber si el jugador se quedo sin fichas, (GANO).
    
    public Jugador(String nombre/*,Ficha... vector*/){
        this.nombre = nombre;
        this.baraja = new LinkedList<>();
        this.PASÓ = false;
        this.sinFichas = false;
        /*for(Ficha f:vector){
            this.baraja.add(f);
        }*/
    }

    public String getNombre() {
        return nombre;
    }

    public LinkedList<Ficha> getBaraja() {
        return baraja;
    }

    public boolean getPASÓ() {
        return PASÓ;
    }

    public boolean getSinFichas() {
        return sinFichas;
    }
    
    public void jugar(LinkedList<Ficha> FichasJugadas){
        
        // ESPACIO PARA IMPRIMIR LAS FICHAS QUE SE VAN PONIENDO.
        if(FichasJugadas.size() == 0){
            System.out.println("\n$$$$$$$$$$$ QUE COMIENCE LA PARTIDA $$$$$$$$$$$\n");
        }
        else{
            System.out.println("\n$$$$$$$$$$$$$$$$$$$$ FICHAS JUGADAS $$$$$$$$$$$$$$$$$$$$\n");
            for(Ficha f: FichasJugadas){
                System.out.print(" ["+ f.getPintaIzquierda() +","+ f.getPintaDerecha() +"] ");
            }
            System.out.println("\n\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
        }
        
        Ficha cabeza = null;
        Ficha cola = null;
        int ponerAlaDeroIzq = 0; //Para que el usuario escoja donde quiere ubicar la ficha
        int opcion = -1; //selecciona la ficha, si no selecciona ninguna queda en -1.
        int iterador = 0; //Pra mostrar el numero de fichas al recorrer su baraja
        Ficha fichaJugada = null; //Ficha seleccionada
        boolean fichaValida = false;
        boolean puedeUbicarse = false;
       
        Scanner entrada = new Scanner(System.in);
            
            System.out.println("«» Actualmente "+ this.nombre +" tiene estas fichas «»\n");
        
            for(Ficha f:this.baraja){ //Muestro la baraja para que seleccione una ficha.
                System.out.println("» Ficha # "+(iterador+1)+" » ["+ f.getPintaIzquierda() +" , "+ f.getPintaDerecha() +"]");
                iterador++;
            }
            
            do{ // Este ciclo evitara un poco el error de entrada por teclado

                //entrada.nextLine();
                System.out.print("\n»» Si no le sirve ninguna y (PASA) digite -1 «« \n"
                        + "»» Digite el numero de la ficha que desea seleccionar:");
                opcion = entrada.nextInt();
                entrada.nextLine(); // ALgunas aclaraciones y decoracion
                
                if(opcion < -1 || opcion > this.baraja.size()+1) System.out.println("\n!...Ficha no encontrada, intente nuevamente\n");
                
                if(FichasJugadas.size() != 0 && opcion != -1){ // si no es la primera ficha en jugarse
                    
                    //Obtengo los extremos de las fichas jugadas.
                    cabeza = FichasJugadas.getFirst();
                    cola = FichasJugadas.getLast();
                    
                    //reviso si la ficha es valida.
                    if(this.baraja.get(opcion-1).getPintaDerecha() == cabeza.getPintaIzquierda() || this.baraja.get(opcion-1).getPintaDerecha() == cola.getPintaDerecha()
                       || this.baraja.get(opcion-1).getPintaIzquierda() == cabeza.getPintaIzquierda() || this.baraja.get(opcion-1).getPintaIzquierda() == cola.getPintaDerecha()){

                        fichaValida = true;

                    }
                    else{
                        System.out.println("\n!...ERROR esta ficha no puede ser jugada.\n");
                    }
                    
                }
                else{ //si es la primera ficha en jugarse.
                    fichaValida = true; // solo para que salga del ciclo.
                }
                
            }while((opcion < -1 || opcion > this.baraja.size()+1) || !fichaValida);

            if(opcion != -1){ // si selecciono una ficha
                
                System.out.println("»» Selecciono la ficha ["+this.baraja.get(opcion-1).getPintaIzquierda()+","+this.baraja.get(opcion-1).getPintaDerecha()+"]");
                fichaJugada = new Ficha(this.baraja.get(opcion-1)); // MUestro la ficha que se jugo y la copio.
                this.baraja.remove(opcion-1); // la elimino de la lista ligada
                
                //verifico si la lista lugada esta vacia
                if(this.baraja.size() == 0){
                    this.sinFichas = true; //actualizao el estado de sinFichas
                }
                
                if(FichasJugadas.size() != 0){ // Si no es la primera ficha en poner
                    
                    //Obtengo los extremos de las fichas jugadas.
                    cabeza = FichasJugadas.getFirst();
                    cola = FichasJugadas.getLast();
                    
                    //Para verificar si puede ubicar la ficha que selecciono
                    do{
                        
                        System.out.println("\n««««««««« De que lado la jugara »»»»»»»»»\n");
                    
                        //Que el jugador escoja donde quiere ubucar su ficha
                        System.out.println("»1» Del lado IZQUIERDO con la pinta {"+ cabeza.getPintaIzquierda() +"} de la ficha ["+ cabeza.getPintaIzquierda() +","+ cabeza.getPintaDerecha() +"]");
                        System.out.println("»2» Del lado DERECHO con la pinta {"+ cola.getPintaDerecha() +"} de la ficha ["+ cola.getPintaIzquierda() +","+ cola.getPintaDerecha() +"]");
                        System.out.print("\n»» Digite (izquierdo=1 o (derecho=2) segun escoja: ");
                        ponerAlaDeroIzq = entrada.nextInt();
                        
                        if(ponerAlaDeroIzq == 1){
                            if(cabeza.getPintaIzquierda() == fichaJugada.getPintaDerecha() || cabeza.getPintaIzquierda() == fichaJugada.getPintaIzquierda()){
                                puedeUbicarse = true;
                            }
                            else{
                                System.out.println("\n!...No se puede ubicar la ficha seleccionada a la izquierda\n");
                            }
                        }
                        else if(ponerAlaDeroIzq == 2){
                            if(cola.getPintaDerecha() == fichaJugada.getPintaDerecha() || cola.getPintaDerecha() == fichaJugada.getPintaIzquierda()){
                                puedeUbicarse = true;
                            }
                            else{
                                System.out.println("\n!...No se puede ubicar la ficha seleccionada a la derecha\n");
                            }
                        }
                        else{
                            System.out.println("\n!...ERROR, entrada invalida\n");
                        }
                        
                    }while(!puedeUbicarse);
                    
                    if(ponerAlaDeroIzq == 1){ // se inserta por cabeza si escoje izquierda
                        // otro problema es hay que voltear las fichas cuando las pintas se cruzan, en ambos casos
                        if(cabeza.getPintaIzquierda() == fichaJugada.getPintaIzquierda()){
                            // Es como si le dierva vuelta a la ficha.(completamente valido)
                            int aux = fichaJugada.getPintaDerecha();
                            fichaJugada.setPintaDerecha(fichaJugada.getPintaIzquierda());
                            fichaJugada.setPintaIzquierda(aux);

                        }
                        FichasJugadas.addFirst(fichaJugada);
                    }
                    if(ponerAlaDeroIzq == 2){ // y por cola si escoje derecha

                        if(cola.getPintaDerecha() == fichaJugada.getPintaDerecha()){

                            int aux = fichaJugada.getPintaDerecha();
                            fichaJugada.setPintaDerecha(fichaJugada.getPintaIzquierda());
                            fichaJugada.setPintaIzquierda(aux);

                        }

                        FichasJugadas.addLast(fichaJugada);
                    }
                }
                else{ // Si es la priemra ficha
                    FichasJugadas.addFirst(fichaJugada);
                }

                this.PASÓ = false; //AL final des pues de la seleccion se defiine que si se pudo jugar

            }
            else{
                System.out.println("\n«» El jugador "+ this.nombre +" PASÓ«»\n");
                this.PASÓ = true; // si no pudo jugar Pasó.
            }
        
    }
    
}

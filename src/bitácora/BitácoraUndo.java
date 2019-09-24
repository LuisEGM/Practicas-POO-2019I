package bitácora;

public class BitácoraUndo extends Bitácora{
    
    private Entrada últimaEntrada;
    
    public BitácoraUndo(String nombre) {
        
        super(nombre);
        if(this.entradas.isEmpty()) this.últimaEntrada = null;
        else this.últimaEntrada = this.entradas.getLast();
    }
    
    public boolean deshacerEntrada(){
        
        boolean correcto = true;
        
        if(this.entradas.isEmpty()){
            System.out.print("\nBitacora vacia\n");
            correcto = false;
        }
        else{
            this.entradas.removeLast();
            correcto = true;
        }
        
        
        return correcto;
    }
    
}

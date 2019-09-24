package bitácora;

import java.util.HashSet;

public class BitácoraInteligente extends Bitácora{
    
    private final HashSet<String> palabrasProhibidas;
    private HashSet<String> spam;
    
    public BitácoraInteligente(String nombre, String... pProhibidas) {
        
        super(nombre);
        this.palabrasProhibidas =  new HashSet<>();
        for(String p: pProhibidas){
            this.palabrasProhibidas.add(p);
        }
        this.spam = new HashSet<>();
        
    }
    
    @Override
    public boolean registrar(String suceso){
        
        boolean correcto = true;
        boolean esSpam = false;
        
        for(String p: palabrasProhibidas){
            if(suceso.contains(p)){
                esSpam = true;
            }
        }
        
        if(esSpam){
            
            this.spam.add(suceso);
            correcto = false;
            
        }
        else{
            
            correcto = super.registrar(suceso);
            
        }
        
        return correcto;
    }
}

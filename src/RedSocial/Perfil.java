package RedSocial;

import java.util.HashMap;

public class Perfil {
    
    private final String identificador;
    private PanelPrivado panel;
    private HashMap<String,PanelSuscripcion> temasdeInteres;
    
    public Perfil(String identificador){
        this.identificador = identificador;
        this.panel = new PanelPrivado(this);
        this.temasdeInteres = new HashMap<>();
    }
    
    public Perfil(Perfil propietario){
        this.identificador = propietario.identificador;
        this.panel = new PanelPrivado(propietario);
        this.temasdeInteres = new HashMap<>();
    }

    public String getIdentificador() {
        return identificador;
    }

    public PanelPrivado getPanel() {
        return panel;
    }

    public HashMap<String, PanelSuscripcion> getTemasdeInteres() {
        return temasdeInteres;
    }
    
    public boolean añadirTemadeInteres(String tema){
        
        boolean existeTema = false;
        
        for(String s: this.temasdeInteres.keySet()){
            if(s == tema){
                existeTema = true;
            }
        }
        
        if(!existeTema){
            PanelSuscripcion ps = new PanelSuscripcion(this);
            this.temasdeInteres.put(tema,ps);
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public PanelSuscripcion consultarPanelAsociadoaUnTema(String tema){
        
        boolean resultado = this.temasdeInteres.containsKey(tema);
        
        if(resultado){
            PanelSuscripcion ps = this.temasdeInteres.get(tema);
            return ps;
        }
        else{
            return null;
        }
        
    }
    
    @Override
    public String toString(){
        
        String retorno = "";
                
        retorno += "»» Identificador: "+this.identificador+"\n";
        //retorno += "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        
        return retorno;
    }
    
}

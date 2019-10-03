package RedSocial;

import java.util.HashSet;

public class PanelSuscripcion extends Panel implements Cloneable{
    
    private HashSet<Perfil> colaboradores;
    
    public PanelSuscripcion(Perfil propietario) {
        super(propietario);
        this.colaboradores = new HashSet<>();
    }


    
    
    public HashSet<Perfil> getColaboradores() {
        return colaboradores;
    }
    

    
    
    public boolean añadirColaborador(Perfil per){
        return this.colaboradores.add(per);
    }
    
    public boolean eliminarColaborador(Perfil x){
        return this.colaboradores.remove(x);
    }

    @Override
    public String toString(){
        
        String retorno = "";
        
        retorno += "******************  Panel Suscripcion  ******************\n\n";        
        retorno += "»» Propietario: "+this.propietario.getIdentificador()+"\n";
        retorno += "»» Numero de SMS: "+this.mensajes.size()+"\n";
        //retorno += "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        
        return retorno;
    }
    
    @Override
    protected boolean esPublicable(Mensaje sms){
        
        boolean retorno = false;
        
        if(sms.getAutor() == this.propietario){ // si el sms es del propietario
        
            retorno = true;
        
        }
        else{ // si no 
            
            for(Perfil p: this.colaboradores){
                
                if(sms.getAutor() == p){ // si el sms es de algun colaborador
                    
                    retorno = true;
                    
                }
                
            }
            
        }
        
        return retorno;
    }
    
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private PanelSuscripcion copiaSuperficial(){
        
        PanelSuscripcion copia = (PanelSuscripcion) super.clone();
        return copia;
        
    }
    
    @Override
    public Panel clone(){
        
        PanelSuscripcion clon = copiaSuperficial();
        if(clon != null){
            
            clon.colaboradores = new HashSet<>(this.colaboradores);
        
        }
        
        return clon;
    }
    
    
}

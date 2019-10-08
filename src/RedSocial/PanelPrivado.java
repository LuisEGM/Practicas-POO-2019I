package RedSocial;

import java.util.HashSet;

public class PanelPrivado extends Panel implements Cloneable{
    
    private HashSet<String> palabrasClave;
    private HashSet<Mensaje> mensajesSeguimiento;
    
    public PanelPrivado(Perfil propietario) {
        super(propietario);
        this.mensajesSeguimiento = new HashSet<>();
        this.palabrasClave = new HashSet<>();
    }


    
    
    public HashSet<String> getPalabrasClave() {
        return palabrasClave;
    }

    public HashSet<Mensaje> getMensajesSeguimiento() {
        return mensajesSeguimiento;
    }
    
    
    
    public void establecerPalabrasClave(String... palabras){
        
        for(String c: palabras){
            this.palabrasClave.add(c);
        }
        
        this.mensajesSeguimiento.clear();
        
        for(Mensaje m: this.mensajes){ // recorro el panel de sms
            
            for(String p: palabrasClave){ // por cada sms del panel, recorro la lista de palbras clave
                
                if(m.getTexto().contains(p)){ //si el texto del sms contiene alguna de las palbras clave
                    this.mensajesSeguimiento.add(m); // le hago seguimiento al sms
                }
                
            }
            
        }
        
    }

    
    @Override
    public String toString(){
        
        String retorno = "";
        
        retorno += "******************  Panel Privado  ******************\n\n";        
        retorno += "»» Propietario: "+this.propietario.getIdentificador()+"\n";
        retorno += "»» Numero de SMS: "+this.mensajes.size()+"\n";
        
        //retorno += "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        
        return retorno;
    }
    
    
    @Override
    protected boolean esPublicable(Mensaje sms) {
        
        boolean retorno = false;
        
        if(sms.isIndependiente()){
           
           if(sms.getAutor() == this.propietario){
               retorno = true;
           } 
            
        }
        else{
            
            for(Mensaje m: this.mensajes){ // recorro los sms del panel
                if(sms.getSmsAlqueResponde() == m){ // cualquier sms que sea respuesta a otro publicado previamente
                    retorno = true;
                }
            }
            
        }
        
        return retorno;
    }
    
    /*------------------   Extensión paneles privados   ---------------------*/
    
    @Override
    public Mensaje publicarMensaje(String texto, Perfil autor, Mensaje smsAlQueResponde){
        
        Mensaje m = null;
        
        if(smsAlQueResponde != null){
            m = new Mensaje(texto, autor, smsAlQueResponde);
        }
        else{
            m = new Mensaje(texto, autor);
        }
        
        
        if(esPublicable(m)){
            //System.out.println("se publico");
            for(String s: this.palabrasClave){ // se recorre la lista de palabras clave
                
                if(m.getTexto().contains(s)){ //si el texto del sms contiene alguna
                    
                    this.mensajesSeguimiento.add(m); // se hace el seguimiento a el sms
                    
                }
                
            }
            
            this.mensajes.add(m);
            return m;
            
        }
        else{
            return null;
        }
        
    }
    
    @Override
    public Mensaje publicarMensaje(String texto){
    
        Mensaje m = new Mensaje(texto, this.propietario);
        
        if(esPublicable(m)){
           
            for(String s: this.palabrasClave){ // se recorre la lista de palabras clave
                
                if(m.getTexto().contains(s)){ //si el texto del sms contiene alguna
                    
                    this.mensajesSeguimiento.add(m); // se hace el seguimiento a el sms
                    
                }
                
            }
            
            this.mensajes.add(m);
            return m;
            
        }
        else{
            return null;
        }
        
    }
    
    @Override
    public boolean borrarMensaje(Mensaje sms){
    
        boolean seBorra = true; //bandera
        
        for(Mensaje m: this.mensajes){ // recorro los sms del panel
            if(m.getSmsAlqueResponde() == sms){ // si sms tiene al menos una respuesta
                seBorra = false; // no se puede borrar
            }
        }
        
        for(Mensaje m: this.mensajesSeguimiento){
            if(sms == m) seBorra = false;
        }
        
        if(seBorra){ //si seborra el verdadero 
            this.mensajes.remove(sms); // se elimina el sms de la lista
        }
        
        return seBorra;
        
    }
    
    
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private PanelPrivado copiaSuperficial(){
        
        PanelPrivado copia = (PanelPrivado) super.clone();
        return copia;
        
    }
    
    @Override
    public Panel clone(){
        
        PanelPrivado clon = copiaSuperficial();
        if(clon != null){
            
            clon.palabrasClave = new HashSet<>(this.palabrasClave);
            clon.mensajesSeguimiento = new HashSet<>(this.mensajesSeguimiento);
            
        }
        
        return clon;
    }
    
}

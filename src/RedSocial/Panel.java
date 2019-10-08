package RedSocial;

import java.util.LinkedList;

public abstract class Panel implements Cloneable{
    
    protected Perfil propietario;
    protected LinkedList<Mensaje> mensajes;
    
    public Panel(Perfil propietario){
        this.propietario = propietario;
        this.mensajes = new LinkedList<>();
    }

    
    
    public Perfil getPropietario() {
        return propietario;
    }

    public LinkedList<Mensaje> getMensajes() {
        return mensajes;
    }
    
    public int getNumerodeSms(){
        return mensajes.size();
    }
    
    @Override
    public String toString(){
        
        String retorno = "";
        
        //retorno += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";            
        retorno += "»» Propietario: "+this.propietario.getIdentificador()+"\n";
        retorno += "»» Numero de SMS: "+this.mensajes.size()+"\n";
        //retorno += "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        
        return retorno;
    }
    
    // retorna una lista con los sms que son respuesta a el sms establecido por parametro
    public LinkedList<Mensaje> consultarRespuestas(Mensaje sms){
        
        LinkedList<Mensaje> listaderespuestas = new LinkedList<>();
        
        for(Mensaje m: this.mensajes){ // recorro los sms del panel
            if(m.getSmsAlqueResponde() == sms){ // si el sms es una respuesta al establecido por parametro
                listaderespuestas.add(m); // lo agrego a la lista
            }
        }
        
        return listaderespuestas;
        
    }
    
    // realiza la acción solicitada si el mensaje que se pretende borrar no ha sido respondido por ningún otro. 
    public boolean borrarMensaje(Mensaje sms){
        
        boolean seBorra = true; //bandera
        
        for(Mensaje m: this.mensajes){ // recorro los sms del panel
            if(m.getSmsAlqueResponde() == sms){ // si sms tiene al menos una respuesta
                seBorra = false; // no se puede borrar
            }
        }
        
        if(seBorra){ //si seborra el verdadero 
            this.mensajes.remove(sms); // se elimina el sms de la lista
        }
        
        return seBorra;
    }
    
    
    public Mensaje publicarMensaje(String texto, Perfil autor, Mensaje smsAlQueResponde){
        
        Mensaje m = new Mensaje(texto, autor, smsAlQueResponde);
        
        if(esPublicable(m)){
            
            this.mensajes.add(m);
            return m;
            
        }
        else{
            return null;
        }
        
    }
    
    public Mensaje publicarMensaje(String texto){
        
        Mensaje m = new Mensaje(texto, this.propietario);
        
        if(esPublicable(m)){
           
            this.mensajes.add(m);
            return m;
            
        }
        else{
            return null;
        }
        
    }
    
    protected abstract boolean esPublicable(Mensaje sms);
    
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private Panel copiaSuperficial(){
        
        try{
            Panel copia = (Panel) super.clone();
            return copia;
        }
        catch(CloneNotSupportedException e){
            System.err.println("!...La clase no es clonable");
        }
        
        return null;
    }
    
    @Override
    public Panel clone(){
        
        Panel clon = copiaSuperficial();
        if(clon != null){
            
            clon.propietario = new Perfil(this.propietario);
            clon.mensajes = new LinkedList<>(this.mensajes);
            clon.mensajes.clear();
            
        }
        
        return clon;
    }
    
    
}

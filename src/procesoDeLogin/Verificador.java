package procesoDeLogin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public abstract class Verificador {
    
    protected HashMap<String,String> desafios;
    
    protected HashMap<String,Usuario> usuarios;
    protected String peticionDelDesafio;
    
    public Verificador(String peticionDelDesafio){
        this.peticionDelDesafio = peticionDelDesafio;
        this.usuarios = new HashMap<>();
        this.desafios = new HashMap<>();
    }

    public HashSet<Usuario> getUsarios() {
        return (HashSet<Usuario>) this.usuarios.values();
    }

    public String getPeticionDelDesafio() {
        return peticionDelDesafio;
    }
    
    public void añadirUsuarios(Usuario... usuariosAgregar){
        for(Usuario u: usuariosAgregar){
            this.usuarios.put(u.getLogin(),u);
        }
    }
    
    public boolean borrarUsuario(Usuario u){
        
        boolean resultado = this.usuarios.containsKey(u.getLogin());

        if(resultado){
            return this.usuarios.remove(u.getLogin(),u);
        }
        else{
            return false;
        }
        
    }    
    
    protected abstract String generarRespuestaCorrectaAElDesafio(String login);
    
    public String primerPasoDelProcesoDeVerificacion(String login, String password){
      
        String token = null;
        String respuesta = null;
        
        boolean resultado = this.usuarios.containsKey(login);

        if(resultado){ // si el usuario existe en el mapa.
            
            if(password.equals(  this.usuarios.get(login).getPassword()  )){ // reviso si la contraseña, concuerda
                
                token = UUID.randomUUID().toString();
                respuesta = generarRespuestaCorrectaAElDesafio(login);
                this.desafios.put(token,respuesta);
                
            }
            
        }
        
        return token;
    }
    
    public boolean SegundoPasoDelProcesoDeVerificacion(String token, String respuestaDeUsuario){
        
        boolean resultado = this.desafios.containsKey(token);
        
        if(resultado){ // si existe el desafio
            
            if(respuestaDeUsuario.equals(  this.desafios.get(token)  )){ // si la respues es correcta
                this.desafios.remove(token);
                return true;
            }
            else{
                return false;
            }
            
        }
        else{
            return false;
        }
        
    }
    
    @Override
    public String toString(){
        String retorno = "";
        
        retorno += "* Petición: "+this.peticionDelDesafio+"\n";
        for(Usuario u: this.usuarios.values()){
            retorno += u.toString();
        }
        
        return retorno;
    }
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private Verificador copiaSuperficial(){
        
        try{
            Verificador copia = (Verificador) super.clone();
            return copia;
        }
        catch(CloneNotSupportedException e){
            System.err.println("!...La clase no es clonable");
        }
        
        return null;
    }
    
    @Override
    public Verificador clone(){
        
        Verificador clon = copiaSuperficial();
        if(clon != null){
            
            clon.usuarios = new HashMap<>(this.usuarios);
            clon.peticionDelDesafio = new String(this.peticionDelDesafio);
        
        }
        
        return clon;
    }
    
}

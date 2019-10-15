package procesoDeLogin;

import java.time.LocalDate;
import java.util.HashSet;

public class VerificadorBlacklist extends Verificador implements Cloneable{
    
    private HashSet<String> loginsBloqueados;
    
    public VerificadorBlacklist(String peticionDelDesafio) {
        super(peticionDelDesafio); //“Introduzca el número del día de su último acceso”
        this.loginsBloqueados = new HashSet<>();
    }

    public HashSet<String> getLoginsBloqueados() {
        return loginsBloqueados;
    }

    public boolean bloquearUsuario(Usuario u){
        return this.loginsBloqueados.add(u.getLogin());
    }
    
    public boolean desbloquearUsuario(Usuario u){
        return this.loginsBloqueados.remove(u.getLogin());
    }
    
    @Override
    protected String generarRespuestaCorrectaAElDesafio(String login) {
        String retorno = null;
        
        LocalDate fecha = this.usuarios.get(login).getFechaDeUltimoAcceso();
        retorno = Integer.toString(fecha.getDayOfMonth());
        
        return retorno;
    }

    @Override
    public String primerPasoDelProcesoDeVerificacion(String login, String password){
      
        boolean bloqueado = false;
        
        for(String s: this.loginsBloqueados){
            if(login.equals(s)){
                bloqueado = true;
            }
        }
        
        if(!bloqueado){
            return super.primerPasoDelProcesoDeVerificacion(login, password);
        }
        else{
            return null;
        }
        
    }
    
    @Override
    public String toString(){
        String retorno = "";
        
        retorno += "»» VERFICICADOR BLACKLIST\n\n";
        retorno += "* Petición: "+this.peticionDelDesafio+"\n";
        retorno += "\n«««««««««««««««« Usuarios Registrados  »»»»»»»»»»»»»»»»\n\n";
        for(Usuario u: this.usuarios.values()){
            retorno += u.toString();
        }
        
        return retorno;
    }
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private VerificadorBlacklist copiaSuperficial(){
        
        VerificadorBlacklist copia = (VerificadorBlacklist) super.clone();
        return copia;
        
    }
    
    @Override
    public VerificadorBlacklist clone(){
        
        VerificadorBlacklist clon = copiaSuperficial();
        if(clon != null){
            
            clon.loginsBloqueados = new HashSet<>(this.loginsBloqueados);
            clon.loginsBloqueados.clear();
            
        }
        
        return clon;
    }
    
}

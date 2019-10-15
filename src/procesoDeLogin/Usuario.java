package procesoDeLogin;

import java.time.LocalDate;
import java.util.HashSet;

public class Usuario {
    
    private String login;
    private LocalDate fechaDeUltimoAcceso;
    private String password;
    private HashSet<String> historialDePasswords;
    
    public Usuario(String login, String password){
        
        this.login = login;
        this.password = password;
        this.historialDePasswords = new HashSet<>();
        this.historialDePasswords.add(password);
        this.fechaDeUltimoAcceso = LocalDate.now();
        
    }

    public String getLogin() {
        return login;
    }

    public LocalDate getFechaDeUltimoAcceso() {
        return fechaDeUltimoAcceso;
    }

    public String getPassword() {
        return password;
    }

    public HashSet<String> getHistorialDePasswords() {
        return historialDePasswords;
    }
    
    public boolean modificarPassword(String passwordActual, String passwordNuevo){
        
        boolean existeConstraseña = false;
        
        if(this.password.equals(passwordActual)){
            
            for(String s: this.historialDePasswords){
                if(passwordNuevo.equals(s)){
                    existeConstraseña = true;
                }
            }
            
            if(!existeConstraseña){
                this.password = passwordNuevo;
                this.historialDePasswords.add(passwordNuevo);
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
    
    public boolean validar(String password){
        return this.password.equals(password);
    }
    
    public void establecerFechaDeUltimoAcceso(){
        this.fechaDeUltimoAcceso = LocalDate.now();
    }
    
    @Override
    public String toString(){
        String retorno = "";
        
        retorno += "»» login: "+this.login+"\n";
        retorno += "»» password: "+this.password+"\n";
        retorno += "»» fecha de ultimo acceso: "+this.fechaDeUltimoAcceso+"\n";
        retorno += "\n-----------------------------------------------\n\n";
        
        return retorno;
    }
    
}

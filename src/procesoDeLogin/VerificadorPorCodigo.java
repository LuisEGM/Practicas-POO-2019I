package procesoDeLogin;

import java.util.Random;

public class VerificadorPorCodigo extends Verificador implements Cloneable{

    private int numeroIntentosMaximo;
    
    public VerificadorPorCodigo(String peticionDelDesafio, int numeroIntentosMaximo) {
        super(peticionDelDesafio); // “Introduzca el número que ha recibido por SMS”
        this.numeroIntentosMaximo = numeroIntentosMaximo;
    }

    @Override
    protected String generarRespuestaCorrectaAElDesafio(String login) {
        
        String retorno = null;
        
        Random random = new Random();
        retorno = Integer.toString(random.nextInt(999));
        System.err.println("»» cod generado: "+retorno);
        
        return retorno;
    }
    
    @Override
    public boolean SegundoPasoDelProcesoDeVerificacion(String token, String respuestaDeUsuario){
        
        if(this.numeroIntentosMaximo > 0){
            this.numeroIntentosMaximo--;
            return super.SegundoPasoDelProcesoDeVerificacion(token, respuestaDeUsuario);
        }
        else{
            this.desafios.remove(token);
            return false;
        }
        
    }
    
    @Override
    public String toString(){
        String retorno = "";
        
        retorno += "»» VERFICICADOR POR CODIGO\n\n";
        retorno += "* Petición: "+this.peticionDelDesafio+"\n";
        retorno += "\n«««««««««««««««« Usuarios Registrados  »»»»»»»»»»»»»»»»\n\n";
        for(Usuario u: this.usuarios.values()){
            retorno += u.toString();
        }
        
        return retorno;
    }
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private VerificadorPorCodigo copiaSuperficial(){
        
        VerificadorPorCodigo copia = (VerificadorPorCodigo) super.clone();
        return copia;
        
    }
    
    @Override
    public VerificadorPorCodigo clone(){
        
        VerificadorPorCodigo clon = copiaSuperficial();
        if(clon != null){
            
            clon.numeroIntentosMaximo = this.numeroIntentosMaximo;
            
        }
        
        return clon;
    }
    
}

package RedSocial;

public class Mensaje {
    
    private final String texto;
    private final Perfil autor;
    private Mensaje smsAlqueResponde;
    private boolean independiente;
    
    public Mensaje(String texto, Perfil autor){
        
        this.texto = texto;
        this.autor = autor;
        this.independiente = true;
        this.smsAlqueResponde = null;
        
    }
    
    public Mensaje(String texto, Perfil autor, Mensaje smsAlqueResponde){
        this(texto,autor);
        this.smsAlqueResponde = smsAlqueResponde;
        this.independiente = false;
    }

    public String getTexto() {
        return texto;
    }

    public Perfil getAutor() {
        return autor;
    }

    public Mensaje getSmsAlqueResponde() {
        return smsAlqueResponde;
    }

    public boolean isIndependiente() {
        return independiente;
    }
    
    @Override
    public String toString(){
        
        String retorno = "";
        
        retorno += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
        retorno += "»» Autor: "+this.autor.getIdentificador()+"\n";
        retorno += "»» Texto: "+this.texto+"\n";
        retorno += "»» Independiente: "+this.independiente+"\n";
        //retorno += "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        
        return retorno;
    }
    
}

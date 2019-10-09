package referendums;

import java.util.HashMap;
import java.util.LinkedList;

public class ConsultaOrdinaria extends Consulta implements Cloneable{
    
    private boolean estaActiva;
    
    public ConsultaOrdinaria(String titulo) {
        super(titulo);
        this.estaActiva = false;
    }

    public boolean isEstaActiva() {
        return estaActiva;
    }
    
    public void abrirConsulta(){
        this.estaActiva = true;
    }
    
    public void cerrarConsulta(){
        this.estaActiva = false;
    }
    
    @Override
    protected boolean consultaActiva() {
        return estaActiva;
    }
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private ConsultaOrdinaria copiaSuperficial(){
        
        ConsultaOrdinaria copia = (ConsultaOrdinaria) super.clone();
        return copia;
    
    }
    
    @Override
    public ConsultaOrdinaria clone(){
        
        ConsultaOrdinaria clon = copiaSuperficial();
        if(clon != null){
            clon.estaActiva = isEstaActiva();
        }
        
        return clon;
    }
    
    @Override
    public String toString(){
        String retorno = "";
        HashMap<String,Integer> mapImprimir = new HashMap<>();
        LinkedList<String> opciones = new LinkedList<>();
        
        retorno += "############################################################################\n\n";
        retorno += "»» Titulo de la consulta: "+getTirulo()+"\n";
        retorno += "»» Numero de votos emitidos: "+getNumerodeVotosEmitidos()+"\n";
        retorno += "\n///////////////////  ESCRUTINIO  ////////////////////\n";
        
        for(int i=0 ; i < this.preguntas.size() ; i++){
            //System.out.println(this.preguntas.size());
            mapImprimir = obtenerEscrutiniodeunaPregunta(i+1);
            
            retorno += "\n# Para la pregunta ( "+this.preguntas.get(i)+" ).\n";
            
            for(String x: mapImprimir.keySet()){
                opciones.add(x);
            }
            
            for(String s: opciones){
                retorno += "» Votaron "+s+": ( "+mapImprimir.get(s)+" )\n";
            }
            opciones.clear();
        }
        
        return retorno;
    }
    
}

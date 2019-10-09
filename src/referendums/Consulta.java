package referendums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public abstract class Consulta implements Cloneable{
    
    private String tirulo;
    private HashSet<Elector> censo;
    protected LinkedList<String> preguntas;
    protected HashMap<String, LinkedList<Opcion>> votos;
    private int numerodeVotosEmitidos;
    private int numerodeElectores;
    private double indicedeParticipacion;
    
    public Consulta(String titulo){
        
        this.tirulo = titulo;
        this.censo = new HashSet<>();
        this.preguntas = new LinkedList<>();
        this.votos = new HashMap<>();
        this.numerodeVotosEmitidos = 0;
        this.numerodeElectores = 0;
        this.indicedeParticipacion = 0.0;
    }

    
    
    public String getTirulo() {
        return tirulo;
    }

    public HashSet<Elector> getCenso() {
        return censo;
    }

    public LinkedList<String> getPreguntas() {
        return preguntas;
    }

    public HashMap<String, LinkedList<Opcion>> getVotos() {
        return votos;
    }

    public int getNumerodeVotosEmitidos() {
        return this.votos.size();
    }

    public int getNumerodeElectores() {
        return this.censo.size();
    }

    public double getIndicedeParticipacion() {
        return (double) this.votos.size() / this.censo.size();
    }
    
    
    
    public void añadirElectores(Elector... electores){
        
        for(Elector e: electores){
            this.censo.add(e);
        }
        
    }
    
    public int añadirPregunta(String preg){
        
        boolean existe = false;
        int pos = -1;
        
        for(String s: this.preguntas){
            if(preg == s){
                existe = true;
                pos = this.preguntas.indexOf(s)+1;
            }
            
        }
        
        if(!existe){
            
            this.preguntas.add(preg);
            pos = this.preguntas.indexOf(preg)+1;
         
        }
        
        return pos;
    }
    
    public boolean eliminarPregunta(int numerodelapregunta){
        
        if(this.preguntas.remove(numerodelapregunta-1) != null){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public Elector electorAsociado(String dni){
        
        for(Elector e: this.censo){
            if(e.getDni() == dni){
                return e;
            }
        }
        
        return null;
    }
    
    public boolean estaenelCenso(String dni){
        
        for(Elector e: this.censo){
            if(e.getDni() == dni){
                return true;
            }
        }
        
        return false;
        
    }
    
    public boolean haVotado(String dni){
        
        if(estaenelCenso(dni)){
            
            if(this.votos.containsKey(dni)){
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
    
    public HashMap<String,Integer> obtenerEscrutiniodeunaPregunta(int numerodePregunta){
        
        HashMap<String, Integer> escrutinio = new HashMap<String, Integer>(); 
        
        int numVotosSi = 0;
        int numVotosNO = 0;
        int numVotosEnBlanco = 0;
        
        for(LinkedList<Opcion> l: this.votos.values()){
            
            switch(l.get(numerodePregunta-1)){
                
                case SI:
                    numVotosSi++;
                break;
                
                case NO:
                    numVotosNO++;
                break;
                
                case EN_BLANCO:
                    numVotosEnBlanco++;
                break;
                
            }
            
        }
        
        escrutinio.put("SI",numVotosSi);
        escrutinio.put("NO",numVotosNO);
        escrutinio.put("EN_BLANCO",numVotosEnBlanco);
        
        return escrutinio;
    }
    
    protected abstract boolean consultaActiva();
    
    public boolean votar(String dni, LinkedList<Opcion> respuetas){
        
        if(consultaActiva()){
            //----->System.out.println("1");
            if(estaenelCenso(dni)){
                //------>System.out.println("2");
                if(!haVotado(dni)){
                    //------->System.out.println("3");
                    if(respuetas.size() == this.preguntas.size()){
                        //------->System.out.println("4");
                        this.votos.put(dni,respuetas);
                        return true;
                        
                    }
                    else{
                        return false;
                    }
                    
                }
                else{// si ya voto
                    
                    if(respuetas.size() == this.preguntas.size()){
                        
                        this.votos.remove(dni); // elimino del mapa
                        this.votos.put(dni,respuetas);
                        return true;
                    
                    }
                    else{
                        return false;
                    }
                    
                }
                
            }
            else{
                return false;
            }
            
        }
        else{
            return false;
        }
        
    }
    
    public boolean votar(String dni, Opcion... respuetas){
        
        LinkedList<Opcion> aux = new LinkedList<>();
        
        if(consultaActiva()){
            
            if(estaenelCenso(dni)){
                
                if(!haVotado(dni)){
                    
                    aux.addAll(Arrays.asList(respuetas));
                    
                    if(aux.size() == this.preguntas.size()){
                        
                        this.votos.put(dni,aux);
                        return true;
                        
                    }
                    else{
                        return false;
                    }
                    
                }
                else{// si ya voto
                    aux.addAll(Arrays.asList(respuetas));
                    if(aux.size() == this.preguntas.size()){
                        
                        this.votos.remove(dni); // elimino del mapa
                        this.votos.put(dni,aux);
                        return true;
                    
                    }
                    else{
                        return false;
                    }
                    
                }
                
            }
            else{
                return false;
            }
            
        }
        else{
            return false;
        }
        
    }
    
    public boolean votar(String dni){
        
        LinkedList<Opcion> aux = new LinkedList<>();
        
        if(consultaActiva()){
            
            if(estaenelCenso(dni)){
                
                if(!haVotado(dni)){
                    
                    for(int i=0 ; i < this.preguntas.size() ; i++){
                        aux.add(Opcion.EN_BLANCO);
                    }

                    this.votos.put(dni,aux);
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
        else{
            return false;
        }
        
    }
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private Consulta copiaSuperficial(){
        
        try{
            Consulta copia = (Consulta) super.clone();
            return copia;
        }
        catch(CloneNotSupportedException e){
            System.err.println("!...La clase no es clonable");
        }
        
        return null;
    }
    
    @Override
    public Consulta clone(){
        
        Consulta clon = copiaSuperficial();
        if(clon != null){
            
            clon.tirulo = new String(this.tirulo);
            clon.censo = new HashSet<>(this.censo);
            clon.preguntas = new LinkedList<>(this.preguntas);
            clon.votos.clear();
            clon.numerodeElectores = getNumerodeElectores();
            clon.numerodeVotosEmitidos = getNumerodeVotosEmitidos();
            clon.indicedeParticipacion = getIndicedeParticipacion();
            
        }
        
        return clon;
    }
    
}

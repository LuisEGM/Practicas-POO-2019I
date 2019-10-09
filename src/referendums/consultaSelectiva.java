package referendums;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class consultaSelectiva extends Consulta implements Cloneable{
    
    private LocalDate fechaUmbral;
    private LocalDate fechadeCelebracion;
    private LinkedList<Integer> preguntasCondicionadas;
    private HashSet<Elector> censoAutorizado;

    public LocalDate getFechaUmbral() {
        return fechaUmbral;
    }

    public LocalDate getFechadeCelebracion() {
        return fechadeCelebracion;
    }
    
    public consultaSelectiva(String titulo, LocalDate fechaUmbral, LocalDate fechadeCelebracion) {
        super(titulo);
        this.fechaUmbral = fechaUmbral;
        this.fechadeCelebracion = fechadeCelebracion;
        this.preguntasCondicionadas = new LinkedList<>();
        this.censoAutorizado = new HashSet<>();
    }
    
    public consultaSelectiva(String titulo, LocalDate fechaUmbral) {
        super(titulo);
        this.fechaUmbral = fechaUmbral;
        this.fechadeCelebracion = LocalDate.now();//.plusDays(1); //confucion, se dice que la consulta esta activa si la fecha actual
        //coincide con la fecha de la creacion, pero cuando indican la declaracion del constructor pone "La fecha de celebración se
        //puede omitir y se entendera que es el día siguiente de la creación."  
        this.preguntasCondicionadas = new LinkedList<>();
        this.censoAutorizado = new HashSet<>();
    }
    
    public boolean establecerFechadeCelebracion(LocalDate fecha){
        
        if(this.fechadeCelebracion.isBefore(fecha)){
            this.fechadeCelebracion = fecha;
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public void establecerPreguntasCondicionadas(int... preguntas){
        for(int i: preguntas){
            if(i > 0 && i < this.preguntas.size()){
                this.preguntasCondicionadas.add(i);
            }
        }
        
    }
    
    @Override
    public boolean votar(String dni, LinkedList<Opcion> respuetas){
        
        Elector e = electorAsociado(dni);
        boolean puedeVotar = true;
        
        if(fechaUmbral.isBefore(e.getFechadeNacimiento())){ // la fecha de nacimiento esta despues de la fecha umbral
            
            for(Integer i: this.preguntasCondicionadas){ //para cada pregunta condicionada debe tener respuesta "EN_BLANCO"
               
                if(respuetas.get(i-1) != Opcion.EN_BLANCO){ //si la respues a alguna de estas preguntas no es "EN_BLANCO" 
                    puedeVotar = false; // no puede votar
                }

            }
            
            if(puedeVotar){
                return super.votar(dni, respuetas);
            }
            else{
                return false;
            }
            
        }
        else{ // si la fecha de nacimiento esta por debajo de la fecha umbral, puede votar
            return super.votar(dni, respuetas);
        }
        
    }
    
    @Override
    public boolean votar(String dni, Opcion... res){
        
        LinkedList<Opcion> respuestas = new LinkedList<>();
        respuestas.addAll(Arrays.asList(res));
        
        Elector e = electorAsociado(dni);
        boolean puedeVotar = true;
        
        if(fechaUmbral.isBefore(e.getFechadeNacimiento())){ // la fecha de nacimiento esta despues de la fecha umbral
            //------>System.out.println("condicionado"+e.getNombre());
            for(int i: this.preguntasCondicionadas){ //para cada pregunta condicionada debe tener respuesta "EN_BLANCO"
                
                if(respuestas.get(i-1) != Opcion.EN_BLANCO){ //si la respues a alguna de estas preguntas no es "EN_BLANCO" 
                    //------>System.out.println("no vota"+e.getNombre());
                    puedeVotar = false; // no puede votar
                }

            }
            
            if(puedeVotar){
                //----->System.out.println("voto"+e.getNombre());
                this.censoAutorizado.add(e);
                return super.votar(dni, respuestas);
            }
            else{
                return false;
            }
            
        }
        else{ // si la fecha de nacimiento esta por debajo de la fecha umbral, puede votar
            //---->System.out.println("voto"+e.getNombre());
            this.censoAutorizado.add(e);
            return super.votar(dni, respuestas);
        }
        
    }
    
    @Override
    protected boolean consultaActiva() {
        
        if(this.fechadeCelebracion.compareTo(LocalDate.now()) == 0){
            //------>System.out.println("entra");
            return true;
        }
        else{
            return false;
        }
    }
    
    /*------------------   CLONACIONES   ---------------------*/
    
    private consultaSelectiva copiaSuperficial(){
        
        consultaSelectiva copia = (consultaSelectiva) super.clone();
        return copia;

    }
    
    @Override
    public consultaSelectiva clone(){
        
        consultaSelectiva clon = copiaSuperficial();
        if(clon != null){
            clon.fechaUmbral = getFechaUmbral();
            clon.fechadeCelebracion = getFechadeCelebracion();
            clon.censoAutorizado.clear();
            clon.preguntasCondicionadas = new LinkedList<Integer>(this.preguntasCondicionadas);
        }
        
        return clon;
    }
    
    @Override
    public String toString(){
        String retorno = "";
        HashMap<String,Integer> mapImprimir = new HashMap<>();
        LinkedList<String> opcion = new LinkedList<>();
        
        retorno += "############################################################################\n\n";
        retorno += "»» Titulo de la consulta: "+getTirulo()+"\n";
        retorno += "»» Numero de votos emitidos: "+getNumerodeVotosEmitidos()+"\n";
        
        retorno += "\n----------------------  CENSO AUTORIZADO  --------------------------\n\n";
        
        for(Elector e: this.censoAutorizado){
            retorno += "»» Nombre: "+e.getNombre()+"\n";
            retorno += "»» DNI: "+e.getDni()+"\n";
            retorno += "»» Fecha de nacimiento: "+e.getFechadeNacimiento()+"\n";
            retorno += "--------------------------------------------------------------------\n\n";
        }
        
        
        retorno += "\n///////////////////  ESCRUTINIO  ////////////////////\n";
        
        for(int i=0 ; i < this.preguntas.size() ; i++){
            //System.out.println(this.preguntas.size());
            mapImprimir = obtenerEscrutiniodeunaPregunta(i+1);
            
            retorno += "\n# Para la pregunta ( "+this.preguntas.get(i)+" ).\n";
            
            for(String x: mapImprimir.keySet()){
                opcion.add(x);
            }
            
            for(String s: opcion){
                retorno += "» Votaron "+s+": ( "+mapImprimir.get(s)+" )\n";
            }
            opcion.clear();
        }
        
        return retorno;
    }
    
}

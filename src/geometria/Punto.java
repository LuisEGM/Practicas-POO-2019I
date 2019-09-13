package geometria;

public class Punto {
    
    private double x;
    private double y;
    
    /*Constructor con dos argumentos: inicializa las coordenadas del objeto punto a partir
    de los parámetros x e y. */
    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    /*Constructor sin argumentos: inicializa el punto en el origen de coordenadas (0, 0).
    Por tanto, este constructor no tiene ningún parámetro. */
    public Punto(){
        this(0,0);
    }
    
    /*Constructor de copia: establece las coordenadas del punto a partir de las
    coordenadas de otra posición. Así pues, el parámetro de este constructor es otro
    objeto posición. Nótese que un objeto tiene acceso a las declaraciones privadas de
    otro objeto de su misma clase. */
    public Punto(Punto p){
        this.x = p.x;
        this.y = p.y;
    }
    
    public double getX(){
        return x;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getY(){
        return y;
    }

    public void setY(double y){
        this.y = y;
    }
    
    /*Desplazar un incremento en x y un incremento en y. Esta función modifica los
    valores de las coordenadas x e y sumando las cantidades que se especifican como
    parámetros. */
    public void desplazar(double canX, double canY){
        this.x += canX;
        this.y += canY;
    }
    
    /*distancia: calcula la distancia euclídea entre un punto y otro que es establecido como parámetro. */
    // UTILICE LAS FUNCIONES COMO METODOS DE CLASE.
    //Si los parametros son valores de X e Y de cada punto. 
    public static double distancia(double x1, double y1, double x2, double y2){
        return Math.sqrt( (Math.pow(x1-x2,2)) + (Math.pow(y1-y2,2)) );
    } 
    
    //Si los parametros son dos puntos especificos
    public static double distanciaAlt(Punto p1, Punto p2){
        return Math.sqrt( (Math.pow(p1.getX()-p2.getX(),2)) + (Math.pow(p1.getY()-p2.getY(),2)) );
    }
    
    /*desplazar (versión sobrecargada): esta operación desplaza el punto una unidad
    según la dirección establecida como parámetro. */
    public void desplazarSC(Direccion dir){
        
        switch(dir){
            
            case ARRIBA:
                this.y++;
                break;
                
            case ABAJO:
                this.y--;
                break;
                
            case DERECHA:
                this.x++;
                break;
                
            case IZQUIERDA:
                this.x--;
                break;
        }
        
    }
    
    /*mayorDistancia: recibe como parámetro una colección de puntos (argumento
    variable) y devuelve aquel que esté más alejado del origen de coordenadas. */
    public Punto mayorDistancia(Punto... puntos){
        
        Punto centro = new Punto(0,0);
        double distMax = 0.0;
        Punto MasLejos = new Punto();
        
        for(Punto p: puntos){
            if(distanciaAlt(centro,p) > distMax){
                distMax = distanciaAlt(centro,p);
                MasLejos = p;
            }
        }
        
        return MasLejos;
    }
    
    
}

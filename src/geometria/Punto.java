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
    
}

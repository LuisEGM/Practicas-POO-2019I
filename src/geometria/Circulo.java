package geometria;

public class Circulo {
    
    private static final Punto porDefecto = new Punto(0,0);
    private static final double radioPDefecto = 5;
    
    private Punto centro;
    private double radio;
    private double perimetro;
    
    /*Estableciendo el punto que representa el centro y el radio.*/
    public Circulo(Punto centro, double radio){
        this.centro = centro;
        this.radio = radio;
        this.perimetro = 2*Math.PI*radio;
    }
    
    /*Tomando como valores por defecto el origen de coordenadas, para el centro, y 5
    para el radio. Los valores por defecto deben definirse como constantes. */
    public Circulo(){
        this.centro = porDefecto;
        this.radio = radioPDefecto;
        this.perimetro = 0.0;
    }
    
    /*Utilizando un constructor de copia. */
    public Circulo(Circulo c){
        this.centro = c.getCentro();
        this.radio = c.getRadio();
        this.perimetro = c.getPerimetro();
    }
    
    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }
    
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }
    
    /*desplazar: traslada el círculo una cierta cantidad en el eje X y en el eje Y. Los
    parámetros de este método son las cantidades de desplazamiento en el eje X y en el
    eje Y. */
    public void desplazar(double canX, double canY){
        // Si solo desplazo el centro, en el caso de que dos circulos compartan el mismo punto como centro, si hago el desplazamiento
        // en un circulo se vera reflejado en el otro, por que al fin y al cabo estooy moviendo el punto con el que fueron creados.
        // POr eso no puedo usar ==> this.centro.desplazar(canX, canY);
        this.centro = new Punto(this.centro.getX()+canX , this.centro.getY()+canY);
    }
    
    /*desplazar (versión sobrecargada): desplaza el círculo de modo que su centro
    coincida con el parámetro que se establece en la operación. */
    public void desplazarSC(Direccion dir){
        this.centro.desplazarSC(dir);
    }
    
    /*escalar: modifica el tamaño del radio en un porcentaje establecido como parámetro.
    Por ejemplo, escalar al 200% significa duplicar el tamaño del radio. */
    public void escalar(double aumento){
        
        double radCatual = this.radio;
        setRadio( radCatual * (aumento / 100));
       
    }
    
}

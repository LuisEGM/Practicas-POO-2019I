package geometria;

public class Rectangulo {
    
    private double ladoX;
    private double ladoY;
    private Punto verticeII;
    private Punto verticeSI;
    private Punto verticeSD;
    private Punto verticeID;
    private double perimetro;
    
    /*Estableciendo un punto que representa el vértice inferior izquierdo y el tamaño de los
    lados X e Y. */
    public Rectangulo(Punto p, double ladoX, double ladoY){
        
        this.ladoX = ladoX;
        this.ladoY = ladoY;
        
        this.verticeII = p;
        this.verticeID = new Punto(p.getX()+ladoX,p.getY()); 
        this.verticeSI = new Punto(p.getX(),p.getY()+ladoY);
        this.verticeSD = new Punto(p.getX()+ladoX,p.getY()+ladoY);
        
        this.perimetro = (2*ladoX) + (2*ladoY);
        
    }
    
    /*Estableciendo los vértices inferior izquierdo y superior derecho.*/
    public Rectangulo(Punto InfIzq, Punto SupDer){
        
        this.verticeII = InfIzq;
        this.verticeSD = SupDer;
        this.verticeID = new Punto(SupDer.getX(),InfIzq.getY());
        this.verticeSI = new Punto(InfIzq.getX(),SupDer.getY());
        
        this.ladoX = SupDer.getX() - InfIzq.getX();
        this.ladoY = SupDer.getY() - InfIzq.getY();
    
        this.perimetro = (2*ladoX) + (2*ladoY);
    }

    public double getLadoX() {
        return ladoX;
    }

    public void setLadoX(double ladoX) {
        this.ladoX = ladoX;
    }

    public double getLadoY() {
        return ladoY;
    }

    public void setLadoY(double ladoY) {
        this.ladoY = ladoY;
    }

    public Punto getVerticeII() {
        return verticeII;
    }

    public void setVerticeII(Punto verticeII) {
        this.verticeII = verticeII;
    }

    public Punto getVerticeSI() {
        return verticeSI;
    }

    public void setVerticeSI(Punto verticeSI) {
        this.verticeSI = verticeSI;
    }

    public Punto getVerticeSD() {
        return verticeSD;
    }

    public void setVerticeSD(Punto verticeSD) {
        this.verticeSD = verticeSD;
    }

    public Punto getVerticeID() {
        return verticeID;
    }

    public void setVerticeID(Punto verticeID) {
        this.verticeID = verticeID;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }
    
    /*desplazar: traslada el rectángulo una cierta cantidad en el eje X y en el eje Y. Los
    parámetros de este método son las cantidades de desplazamiento en el eje X y en el
    eje Y. */
    public void desplazar(double distX, double distY){
        
        this.verticeII.desplazar(distX, distY);
        this.verticeSI.desplazar(distX, distY);
        this.verticeSD.desplazar(distX, distY);
        this.verticeID.desplazar(distX, distY);

    }
    
    /*escalar: esta operación cambia el tamaño de los lados en un porcentaje establecido
    como parámetro. Por ejemplo, escalar al 200% significa duplicar el tamaño de los
    lados.*/
    public void escalar(double incremento){
        
        double ladXact = this.ladoX;
        double ladYact = this.ladoY;
        double nuevoLadX, nuevoLadY;
        
        nuevoLadX = (ladXact * (incremento / 100));
        this.ladoX = nuevoLadX;
        
        nuevoLadY = (ladYact * (incremento / 100));
        this.ladoY = nuevoLadY;
        
        Punto p = this.verticeII;
        
        this.verticeSI = new Punto(p.getX(),nuevoLadY);
        this.verticeSD = new Punto(nuevoLadX,nuevoLadY);
        this.verticeID = new Punto(nuevoLadX,p.getY());
        
        this.perimetro = (2*nuevoLadX) + (2*nuevoLadY);
        
        //System.out.println("[ "+this.ladoX+" - "+this.ladoY+" ]");
        
    }
    
}

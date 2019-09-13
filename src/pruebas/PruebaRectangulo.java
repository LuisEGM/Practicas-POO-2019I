package pruebas;

import geometria.Punto;
import geometria.Rectangulo;

public class PruebaRectangulo {

    public static void main(String[] args) {
        
        /*  PRUEBA DE MOETODOS
        Punto p1 = new Punto(0,0);
        Rectangulo r1 = new Rectangulo(p1,4,3);
        //r1.desplazar(1, 0);
        r1.escalar(200);
        System.out.println("II: ( "+r1.getVerticeII().getX()+" , "+r1.getVerticeII().getY()+" )");
        System.out.println("SI: ( "+r1.getVerticeSI().getX()+" , "+r1.getVerticeSI().getY()+" )");
        System.out.println("SD: ( "+r1.getVerticeSD().getX()+" , "+r1.getVerticeSD().getY()+" )");
        System.out.println("ID: ( "+r1.getVerticeID().getX()+" , "+r1.getVerticeID().getY()+" )");
        System.out.println("Lado X: "+r1.getLadoX());
        System.out.println("Lado Y: "+r1.getLadoY());
        System.out.println("Per: "+r1.getPerimetro());*/
        
        Punto p1 = new Punto(3,1);
        Rectangulo r1 = new Rectangulo(p1,2,5);
        System.out.println("#############  RECTANGULO  ############");
        System.out.println("II: ( "+r1.getVerticeII().getX()+" , "+r1.getVerticeII().getY()+" )");
        System.out.println("SI: ( "+r1.getVerticeSI().getX()+" , "+r1.getVerticeSI().getY()+" )");
        System.out.println("SD: ( "+r1.getVerticeSD().getX()+" , "+r1.getVerticeSD().getY()+" )");
        System.out.println("ID: ( "+r1.getVerticeID().getX()+" , "+r1.getVerticeID().getY()+" )");
        System.out.println("Lado X: "+r1.getLadoX());
        System.out.println("Lado Y: "+r1.getLadoY());
        System.out.println("Per: "+r1.getPerimetro());
        
        //desplazo el rectangulo
        r1.desplazar(0,-7);
        
        System.out.println("#############  RECTANGULO DESPLAZADO  ############");
        System.out.println("II: ( "+r1.getVerticeII().getX()+" , "+r1.getVerticeII().getY()+" )");
        System.out.println("SI: ( "+r1.getVerticeSI().getX()+" , "+r1.getVerticeSI().getY()+" )");
        System.out.println("SD: ( "+r1.getVerticeSD().getX()+" , "+r1.getVerticeSD().getY()+" )");
        System.out.println("ID: ( "+r1.getVerticeID().getX()+" , "+r1.getVerticeID().getY()+" )");
        System.out.println("Lado X: "+r1.getLadoX());
        System.out.println("Lado Y: "+r1.getLadoY());
        System.out.println("Per: "+r1.getPerimetro());
        
        r1.escalar(50);
        System.out.println("#############  RECTANGULO DESPLAZADO AL 50%  ############");
        System.out.println("II: ( "+r1.getVerticeII().getX()+" , "+r1.getVerticeII().getY()+" )");
        System.out.println("SI: ( "+r1.getVerticeSI().getX()+" , "+r1.getVerticeSI().getY()+" )");
        System.out.println("SD: ( "+r1.getVerticeSD().getX()+" , "+r1.getVerticeSD().getY()+" )");
        System.out.println("ID: ( "+r1.getVerticeID().getX()+" , "+r1.getVerticeID().getY()+" )");
        System.out.println("Lado X: "+r1.getLadoX());
        System.out.println("Lado Y: "+r1.getLadoY());
        System.out.println("Per: "+r1.getPerimetro());
        
    }
    
}

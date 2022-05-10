package graphic;

import graphic.geo.*;
import java.awt.Graphics2D;
import java.awt.Color;


public class Flecha implements Linea {
    private Punto origen;
    private Punto destino;

    public Flecha(Punto origen, Punto destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public Punto getOrigen() {
        return origen;
    }

    public Punto getDestino() {
        return destino;
    }

    public void setOrigen(Punto origen) {
        this.origen = origen;
    }

    public void setDestino(Punto destino) {
        this.destino = destino;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.BLACK);
        Recta recta = new Recta(origen, destino);
        Recta arista1 = obtenerArista(45);
        Recta arista2 = obtenerArista(-45);
        recta.paint(g);
        arista1.paint(g);
        arista2.paint(g);
    }
    private Recta obtenerArista(int angulo) {
        /*
            p2<--------p1 para que la rotacion sea correcta.
         */
        Punto p1 = new Punto(destino.getX(), destino.getY());
        Vector v = MathGeo.obtenerVector(origen, destino);
        //double r = MathGeo.distancia(origen, destino)/4;
        double r = 10;
        double d = MathGeo.distancia(origen, destino);
        double escalar = 1-(r/d);
        v.multiplicarEscalar(escalar);
        double x = origen.getX() + v.getX();
        double y = origen.getY() + v.getY();
        Punto p2 = new Punto(x, y);

        Vector u = MathGeo.obtenerVector(p1, p2);
        Vector w = MathGeo.rotarVector(u, angulo);
        p2 = MathGeo.sumarVectorPunto(w, p2);
        return new Recta(p1, p2);
    }
}

package graphic.geo;

import java.awt.*;

public class Linea {
    private Punto origen;
    private Punto destino;

    public Linea(Punto origen, Punto destino) {
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

    public void paint(Graphics g) {
        g.drawLine((int)origen.getX(), (int)origen.getY(), (int)destino.getX(), (int)destino.getY());
    }
}

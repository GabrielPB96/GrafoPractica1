package graphic;

import java.awt.*;

public class Arista {
    private double peso;
    private Vertice origen, destino;
    private Color color;

    public Arista() {
        peso = 0;
        color = Color.BLACK;
    }

    public Arista(BuilderArista builder) {
        Arista a = builder.getArista();
        if (a.getOrigen() == null || a.getDestino() == null) {
            throw new IllegalArgumentException("Origen y destino no pueden ser nulos");
        }
        this.origen = a.getOrigen();
        this.destino = a.getDestino();
        this.peso = a.getPeso();
        this.color = a.getColor();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Vertice getOrigen() {
        return origen;
    }

    public void setOrigen(Vertice origen) {
        this.origen = origen;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public void paint(Graphics g) {
        Punto o = origen.getLocation();
        Punto d = destino.getLocation();
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine((int) o.getX(), (int)o.getY(), (int)d.getX(), (int)d.getY());
    }
}

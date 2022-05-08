package graphic;

import graphic.geo.*;

import java.awt.*;

public class Arista {
    private double peso;
    private Vertice origen, destino, oF, dF;
    private Color color;
    private boolean flecha;

    public Arista() {
        peso = Double.MIN_VALUE;
        color = Color.BLACK;
        flecha = false;
    }

    public Arista(BuilderArista builder) {
        Arista a = builder.getArista();
        if (a.getOrigen() == null || a.getDestino() == null) {
            throw new IllegalArgumentException("Origen y destino no pueden ser nulos");
        }
        this.oF = a.getOrigen();
        this.dF = a.getDestino();
        this.origen = a.getOrigen().clone();
        this.destino = a.getDestino().clone();
        this.peso = a.getPeso();
        this.color = a.getColor();
        this.flecha = a.isFlecha();
    }

    public boolean isFlecha() {
        return flecha;
    }

    public void setFlecha(boolean flecha) {
        this.flecha = flecha;
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

    private void calcularPuntos() {
        Punto o1 = oF.getLocation();
        Punto d1 = dF.getLocation();
        Punto o2 = origen.getLocation();
        Punto d2 = destino.getLocation();
        Vector v = MathGeo.obtenerVectorReduccion(o1, d1, 13);
        Vector v2 = MathGeo.obtenerVectorReduccion(d1, o1, 13);
        d2.setX(o1.getX() + v.getX());
        d2.setY(o1.getY() + v.getY());
        o2.setX(d1.getX() + v2.getX());
        o2.setY(d1.getY() + v2.getY());
    }
    public void paint(Graphics g) {
        calcularPuntos();
        Punto o = origen.getLocation();
        Punto d = destino.getLocation();
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(3));
        Linea recta = (flecha) ? new Flecha(o, d) : new Recta(o, d);
        recta.paint(g2);

        if (peso != Double.MIN_VALUE) {
            g2.setColor(Color.WHITE);
            g2.fillRect((int) (o.getX() + d.getX()) / 2 - 10, (int) (o.getY() + d.getY()) / 2 - 10, 30, 30);
            g2.setFont(new Font("Arial", Font.BOLD, 15));
            g2.setColor(Color.BLUE);
            g2.drawString(String.valueOf(peso), ((int) (o.getX() + d.getX()) / 2)-9, ((int) (o.getY() + d.getY()) / 2)+9);
        }
    }
}

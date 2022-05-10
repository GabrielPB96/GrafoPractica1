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

    private void calcularPuntos(double dist1, double dist2) {
        Punto o1 = oF.getLocation();
        Punto d1 = dF.getLocation();
        Punto o2 = origen.getLocation();
        Punto d2 = destino.getLocation();
        Vector v = MathGeo.obtenerVectorReduccion(o1, d1, dist1);
        Vector v2 = MathGeo.obtenerVectorReduccion(d1, o1, dist2);
        d2.setX(o1.getX() + v.getX());
        d2.setY(o1.getY() + v.getY());
        o2.setX(d1.getX() + v2.getX());
        o2.setY(d1.getY() + v2.getY());
    }
    public void paint(Graphics g) {
        Punto o = oF.getLocation();
        Punto d = dF.getLocation();
        Punto[] puntos  = MathGeo.interseccionRectaElipse(o, d, dF.getRadioX(), dF.getRadioY());
        Punto[] puntos1 = MathGeo.interseccionRectaElipse(d, o, oF.getRadioX(), oF.getRadioY());

        double di1 = MathGeo.distancia(puntos[0], d);
        double di2 = MathGeo.distancia(puntos1[0], o);

        calcularPuntos(di1, di2);

        Punto o1 = origen.getLocation();
        Punto d1 = destino.getLocation();

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(3));
        if(!oF.equals(dF)) {
            Linea recta = (flecha) ? new Flecha(o1, d1) : new Recta(o1, d1);
            recta.paint(g2);
        }else{
            paintLazo(g2, o, d);
        }

        if (peso != Double.MIN_VALUE) {
            g2.setColor(Color.WHITE);
            g2.fillRect((int) (o.getX() + d.getX()) / 2 - 10, (int) (o.getY() + d.getY()) / 2 - 10, 30, 30);
            g2.setFont(new Font("Arial", Font.BOLD, 15));
            g2.setColor(Color.BLUE);
            g2.drawString(String.valueOf(peso), ((int) (o.getX() + d.getX()) / 2)-9, ((int) (o.getY() + d.getY()) / 2)+9);
        }
    }

    private void paintLazo(Graphics2D g2, Punto o1, Punto d1) {
        int x = (int)(o1.getX());
        int y = (int)(o1.getY()- (dF.getRadioY()+5));

        g2.drawOval(x, y, 23, 23);
    }
}

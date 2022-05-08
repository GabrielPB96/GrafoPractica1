package graphic;

import graphic.geo.Punto;

import java.awt.*;

public class Vertice{
    private Punto centro;
    private int radio;
    private Color color;
    private char etiqueta;

    public Vertice() {
        this.centro = null;
        this.etiqueta = ' ';
        this.color = new Color(50, 133, 206);
        this.radio = 13;
    }

    public Vertice(BuilderVertice builder) {
        Vertice v = builder.getVertice();
        if (builder.getPunto() == null) {
            throw new IllegalArgumentException("El centro no puede ser nulo");
        }
        this.centro = v.getLocation();
        this.etiqueta = v.getEtiqueta();
        this.color = v.getColor();
        this.radio = v.getRadio();
    }

    public void paint(Graphics g) {
        double xC = centro.getX(), yC = centro.getY();
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fillOval((int) xC - radio, (int) yC - radio, 2 * radio, 2 * radio);
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 15));
        g2.drawString(etiqueta+"", ((int) xC - radio/2), (int) yC + radio/2);
    }

    public void setLocation(Punto o) {
        this.centro = o;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void setEtiqueta(char e) {
        this.etiqueta = e;
    }

    public Punto getLocation() {
        return this.centro;
    }

    public Color getColor() {
        return this.color;
    }

    public char getEtiqueta() {
        return this.etiqueta;
    }

    public int getRadio() { return this.radio; }

    public boolean contains(double x, double y) {
        double xC = centro.getX(), yC = centro.getY();
        return (x >= xC - radio && x <= xC + radio && y >= yC - radio && y <= yC +  radio);
    }

    public String toString() {
        return "(" + centro.getX() + ", " + centro.getX() + ")";
    }

    public Vertice clone() {
        Vertice v = new Vertice();
        v.setLocation(this.getLocation().clone());
        v.setColor(new Color(this.getColor().getRed(), this.getColor().getGreen(), this.getColor().getBlue()));
        v.setEtiqueta(this.getEtiqueta());
        return v;
    }
}

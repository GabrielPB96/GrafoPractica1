package graphic;

import graphic.geo.Punto;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Vertice{
    private Punto centro;
    private int radioX, radioY;
    private Color color;
    private String etiqueta;

    private Vertice() {
    }

    public Vertice(BuilderVertice builder) {
        if (builder.getCentro() == null) {
            throw new IllegalArgumentException("El centro no puede ser nulo");
        }
        this.centro = builder.getCentro();
        this.etiqueta = builder.getEtiqueta();
        this.color = builder.getColor();
        this.radioY = 13;
        this.radioX = etiqueta.length() * 9;
    }

    public void paint(Graphics g) {
        double xC = centro.getX(), yC = centro.getY();
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fillOval((int) xC - radioX, (int) yC - radioY, 2 * radioX, 2 * radioY);
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 15));
        g2.drawString(etiqueta+"", ((int) xC - radioX/2), (int) yC + radioY/2);
    }

    public void setLocation(Punto o) {
        this.centro = o;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void setEtiqueta(String e) {
        this.etiqueta = e;
    }

    public Punto getLocation() {
        return this.centro;
    }

    public double getX() {
        return this.centro.getX();
    }

    public double getY() {
        return this.centro.getY();
    }

    public Color getColor() {
        return this.color;
    }

    public String getEtiqueta() {
        return this.etiqueta;
    }

    public int getRadioX() { return this.radioX; }

    public int getRadioY() { return this.radioY; }

    public boolean contains(double x, double y) {
        double xC = centro.getX(), yC = centro.getY();
        return (x >= xC - radioX && x <= xC + radioX && y >= yC - radioY && y <= yC +  radioY);
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

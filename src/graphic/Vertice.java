package graphic;

import javax.swing.*;
import java.awt.*;

public class Vertice{
    private double xC, yC;
    private int radio;
    private Color color;
    private char etiqueta;

    public Vertice(double xC, double yC, char etiqueta) {
        this.xC = xC;
        this.yC = yC;
        this.color = new Color(50, 133, 206);
        this.etiqueta = etiqueta;
        this.radio = 13;
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fillOval((int) xC - radio, (int) yC - radio, 2 * radio, 2 * radio);
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.PLAIN, 15));
        g2.drawString(etiqueta+"", ((int) xC - radio/2), (int) yC + radio/2);
    }

    public void setLocation(double xC, double yC) {
        this.xC = xC;
        this.yC = yC;
    }

    public boolean contains(double x, double y) {
        return (x >= xC - radio && x <= xC + radio && y >= yC - radio && y <= yC +  radio);
    }

    public String toString() {
        return "(" + xC + ", " + yC + ")";
    }
}

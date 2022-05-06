package graphic;

import java.awt.Color;

public class Vertice {
    private double xC, yC;
    private int radio;
    private Color color;
    private String etiqueta;

    public Vertice(double xC, double yC, int radio) {
        this.radio = radio;
        this.xC = xC;
        this.yC = yC;
        this.color = new Color(50, 133, 206);
    }
}

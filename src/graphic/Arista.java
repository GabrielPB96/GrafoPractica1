package graphic;

import java.awt.*;

public class Arista {
    private double peso;
    private double xOrigen, yOrigen, xDestino, yDestino;
    private Color color;

    public Arista(double xOrigen, double yOrigen, double xDestino, double yDestino) {
        this.xOrigen  = xOrigen;
        this.yOrigen  = yOrigen;
        this.xDestino = xDestino;
        this.yDestino = yDestino;
        this.color = new Color(0,0,0);
        this.peso  = 0;
    }

    public void paint(Graphics2D g) {

    }
}

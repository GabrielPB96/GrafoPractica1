package graphic;

import java.awt.*;

public class BuilderVertice {
    private Vertice vertice;

    public BuilderVertice() {
        this.vertice = new Vertice();
    }

    public BuilderVertice setPunto(Punto punto) {
        this.vertice.setLocation(punto);
        return this;
    }

    public BuilderVertice setEtiqueta(char etiqueta) {
        this.vertice.setEtiqueta(etiqueta);
        return this;
    }

    public BuilderVertice setColor(Color color) {
        this.vertice.setColor(color);
        return this;
    }

    public BuilderVertice setRandomLocation() {
        int x = ((int) (Math.random() *  (GraphPanel.b-GraphPanel.a))) + GraphPanel.a;
        int y = ((int) (Math.random() *  (GraphPanel.b-GraphPanel.a))) + GraphPanel.a;
        this.vertice.setLocation(new Punto(x, y));
        return this;
    }

    public Vertice getVertice() {
        return this.vertice;
    }

    public Vertice build() {
        return new Vertice(this);
    }

    public Punto getPunto() {
        return this.vertice.getLocation();
    }

    public char getEtiqueta() {
        return this.vertice.getEtiqueta();
    }

    public Color getColor() {
        return this.vertice.getColor();
    }
}

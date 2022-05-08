package graphic;

import java.awt.*;

public class BuilderArista {
    private Arista arista;

    public BuilderArista() {
        this.arista = new Arista();
    }

    public BuilderArista setOrigen(Vertice p) {
        this.arista.setOrigen(p);
        return this;
    }

    public BuilderArista setDestino(Vertice p) {
        this.arista.setDestino(p);
        return this;
    }

    public BuilderArista setPeso(double p) {
        this.arista.setPeso(p);
        return this;
    }

    public BuilderArista setFlecha(boolean p) {
        this.arista.setFlecha(p);
        return this;
    }

    public BuilderArista setColor(Color c) {
        this.arista.setColor(c);
        return this;
    }

    public Arista getArista() {
        return this.arista;
    }

    public Arista build() {
        return new Arista(this);
    }
}

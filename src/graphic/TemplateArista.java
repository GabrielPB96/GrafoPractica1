package graphic;

import java.awt.*;

public class TemplateArista {
    private char origen, destino;
    private double peso;

    public TemplateArista(char origen, char destino, double peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public TemplateArista(char origen, char destino) {
        this.origen = origen;
        this.destino = destino;
        this.peso = Double.MIN_VALUE;
    }

    public char getOrigen() {
        return origen;
    }

    public char getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setOrigen(char origen) {
        this.origen = origen;
    }

    public void setDestino(char destino) {
        this.destino = destino;
    }
}

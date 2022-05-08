package graphic;

public class TemplateArista {
    private char origen, destino;
    private double peso;
    private boolean flecha;

    public TemplateArista(char origen, char destino, double peso, boolean flecha) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
        this.flecha = flecha;
    }

    public TemplateArista(char origen, char destino, double peso) {
        this(origen, destino, peso, false);
    }

    public TemplateArista(char origen, char destino) {
        this(origen, destino, Double.MIN_VALUE, false);
    }

    public TemplateArista(char origen, char destino, boolean flecha) {
        this(origen, destino, Double.MIN_VALUE, flecha);
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

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isFlecha() {
        return flecha;
    }

    public void setFlecha(boolean flecha) {
        this.flecha = flecha;
    }
}

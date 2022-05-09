package graphic;

public class TemplateArista {
    private String origen, destino;
    private double peso;
    private boolean flecha;

    public TemplateArista(String origen, String destino, double peso, boolean flecha) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
        this.flecha = flecha;
    }

    public TemplateArista(String origen, String destino, double peso) {
        this(origen, destino, peso, false);
    }

    public TemplateArista(String origen, String destino) {
        this(origen, destino, Double.MIN_VALUE, false);
    }

    public TemplateArista(String origen, String destino, boolean flecha) {
        this(origen, destino, Double.MIN_VALUE, flecha);
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
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

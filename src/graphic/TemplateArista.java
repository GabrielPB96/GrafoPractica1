package graphic;

public class TemplateArista {
    private char origen, destino;

    public TemplateArista(char origen, char destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public char getOrigen() {
        return origen;
    }

    public char getDestino() {
        return destino;
    }

    public void setOrigen(char origen) {
        this.origen = origen;
    }

    public void setDestino(char destino) {
        this.destino = destino;
    }
}

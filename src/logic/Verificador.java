package logic;

public abstract class Verificador {
    protected Grafo grafo;

    public Verificador(Grafo grafo) {
        this.grafo = grafo;
    }
    public abstract boolean esCompleto();
    public abstract boolean esGrafoCiclo();
    public abstract boolean esGrafoRueda();
    public abstract boolean existeBucle();
}

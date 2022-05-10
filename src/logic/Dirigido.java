package logic;

public class Dirigido extends Verificador {
    public Dirigido(Grafo grafo) {
        super(grafo);
    }

    @Override
    public boolean esCompleto() {
        int nVertices = grafo.getNumVertices();
        int nAristas    = grafo.getNumAristas();
        return 2*((nVertices*(nVertices-1))/2) == nAristas;
    }

    @Override
    public boolean esGrafoCiclo() {
        int nVertices = grafo.getNumVertices();
        int nAristas    = grafo.getNumAristas();
        return 2*nVertices == nAristas;
    }

    @Override
    public boolean esGrafoRueda() {
        int nVertices = grafo.getNumVertices();
        int nAristas    = grafo.getNumAristas();
        return 4*(nVertices-1) == nAristas;
    }

    @Override
    public boolean existeBucle() {
        return false;
    }
}

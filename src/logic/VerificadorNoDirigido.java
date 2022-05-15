package logic;

public class VerificadorNoDirigido extends Verificador {
    public VerificadorNoDirigido(Grafo grafo) {
        super(grafo);
    }

    @Override
    public boolean esCompleto() {
        int nVertices = grafo.getNumVertices();
        int nAristas    = grafo.getNumAristas();

        return (nVertices*(nVertices-1))/2 == nAristas;
    }

    @Override
    public boolean esGrafoCiclo() {
        int nVertices = grafo.getNumVertices();
        int nAristas    = grafo.getNumAristas();
        if (nVertices <= 2 ) return false;
        return nVertices == nAristas;
    }

    @Override
    public boolean esGrafoRueda() {
        int nVertices = grafo.getNumVertices();
        int nAristas    = grafo.getNumAristas();
        if (nVertices <= 2 ) return false;
        return 2*(nVertices-1) == nAristas;
    }
}

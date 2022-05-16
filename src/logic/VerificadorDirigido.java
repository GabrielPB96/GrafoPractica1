package logic;

import java.util.ArrayList;

public class VerificadorDirigido extends Verificador {
    public VerificadorDirigido(Grafo grafo) {
        super(grafo);
    }

    @Override
    public boolean esCompleto() {
        int nVertices = grafo.getNumVertices();
        int nAristas    = grafo.getNumAristas();
        int a = nVertices*(nVertices-1)/2;
        int b = 2*((nVertices*(nVertices-1))/2);
        return  nAristas >= a && nAristas <= b;
    }

    @Override
    public boolean esGrafoCiclo() {
        int inicio = 0, v = inicio, anterior = grafo.getNumVertices() - 1;
        for(int i = 0; i < grafo.getNumVertices(); i++) {
            ArrayList<Vecino> vecinos = (ArrayList<Vecino>) grafo.getAdyacentes(v);
            if(vecinos.size() > 2) return false;
            else{
                int aux = v;
                for (Vecino vecino : vecinos) {
                    if(vecino.getValor() != anterior){
                        aux = vecino.getValor();
                    }
                }
                anterior = v;
                v = aux;
            }
        }
        return inicio == v;
    }

    @Override
    public boolean esGrafoRueda() {
        int nVertices = grafo.getNumVertices();
        int nAristas    = grafo.getNumAristas();
        return 4*(nVertices-1) == nAristas;
    }
}

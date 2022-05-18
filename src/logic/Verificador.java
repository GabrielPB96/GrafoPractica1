package logic;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Verificador {
    protected Grafo grafo;

    public Verificador(Grafo grafo) {
        this.grafo = grafo;
    }
    public abstract boolean esCompleto();
    public abstract boolean esGrafoCiclo();
    public abstract boolean esGrafoRueda();

    protected boolean existeBucle() {
        return grafo.getNumLazos() > 0;
    }
}

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
        if(grafo instanceof ListaAdyacencia) {
            ListaAdyacencia g = (ListaAdyacencia) grafo;
            HashMap<Integer, ArrayList<Vecino>> gM = g.getGrafo();
            for(Integer i : gM.keySet()) {
                ArrayList<Vecino> vecinos = gM.get(i);
                for(Vecino v : vecinos) {
                    if(v.getValor() == i) return true;
                }
            }
        }else{
            MatrizAdyacencia g = (MatrizAdyacencia) grafo;
            int[][] matriz = g.getMatriz();
            for (int i = 0; i < matriz.length; i++) {
                if(matriz[i][i] != 0) return true;
            }
        }
        return false;
    }
}

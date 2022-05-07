package logic;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaAdyacencia implements Grafo{
    private HashMap<Integer, ArrayList<Vertice>> grafo;
    private boolean dirigido;
    private int cantVertices, cantAristas;

    public ListaAdyacencia(boolean dirigido) {
        cantVertices = 0;
        cantAristas = 0;
        this.dirigido = dirigido;
        grafo = new HashMap<>();
    }

    public void insertarVertice(int v) {
        grafo.put(v, new ArrayList<>());
        cantVertices++;
    }

    public void insertarArista(int i, int j) {
        ArrayList<Vertice> ady = grafo.get(i);
        ady.add(new Vertice(j, 0));
        if (!dirigido) {
            ArrayList<Vertice> ady2 = grafo.get(j);
            ady2.add(new Vertice(i, 0));
        }
        cantAristas++;
    }

    public void insertarArista(int i, int j, double peso) {
        ArrayList<Vertice> ady = grafo.get(i);
        ady.add(new Vertice(j, peso));
        if (!dirigido) {
            ArrayList<Vertice> ady2 = grafo.get(j);
            ady2.add(new Vertice(i, peso));
        }
        cantAristas++;
    }

    public int getNumVertices() {
        return cantVertices;
    }

    public int getNumAristas() {
        return cantAristas;
    }

    public boolean existeArista(int origen, int destino) {
        ArrayList<Vertice> adyO = grafo.get(origen);
        boolean existe = false;
        if (adyO != null) {
            for (int i=0; i<adyO.size() && !existe; i++) {
                existe = adyO.get(i).getValor() == destino;
            }
        }
        return existe;
    }

    public double getPesoArista(int i, int j){
        ArrayList<Vertice> ady = grafo.get(i);
        double peso = Double.MIN_VALUE;
        Vertice v = null;
        if (ady != null) {
            for (int k = 0; k < ady.size() && v == null; k++) {
                if (ady.get(k).getValor() == j) v = ady.get(k);
            }
            if (v != null) peso = v.getPeso();
        }
        return peso;
    }

    public ArrayList<Vertice> getAdyacentes(int vertice) {
        ArrayList<Vertice> ady = grafo.get(vertice);
        return (ady != null) ? ady : new ArrayList<>();
    }

    public void dibujarGrafo(){}

    public boolean quitarArista(int origen, int destino) {
        boolean sePudo;
        sePudo = eliminarArista(origen, destino);
        if (!dirigido && sePudo) {
            eliminarArista(destino, origen);
        }
        return sePudo;
    }
    private boolean eliminarArista(int o, int d){
        ArrayList<Vertice> ady = grafo.get(o);
        if (ady != null) {
            for (int i = 0; i < ady.size(); i++) {
                if (ady.get(i).getValor() == d) {
                    ady.remove(i);
                    cantAristas--;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean esCompleto() {
        int n = (cantVertices*(cantVertices-1))/2;
        return n == cantAristas;
    }

    public boolean esGrafoCiclo() {
        if (cantVertices <= 2 ) return false;

        return false;
    }
    public boolean esGrafoRueda() {
        return false;
    }
    public boolean existeBucle() {
        return false;
    }
}

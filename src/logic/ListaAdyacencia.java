package logic;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaAdyacencia {
    private HashMap<Integer, ArrayList<Vertice>> grafo;
    private boolean dirigido;
    private int cantVertices, cantAristas;

    public ListaAdyacencia(boolean dirigido) {
        cantVertices = 0;
        cantAristas = 0;
        this.dirigido = dirigido;
        grafo = new HashMap();
    }

    public void insertarVertice(int v) {
        grafo.put(v, new ArrayList());
        cantVertices++;
    }

    public void insertarArista(int i, int j) {
        ArrayList<Vertice> adj = grafo.get(i);
        adj.add(new Vertice(j, 0));
        if (!dirigido) {
            ArrayList<Vertice> adj2 = grafo.get(j);
            adj2.add(new Vertice(i, 0));
        }
        cantAristas++;
    }

    public void insertarArista(int i, int j, double peso) {
        ArrayList<Vertice> adj = grafo.get(i);
        adj.add(new Vertice(j, peso));
        if (!dirigido) {
            ArrayList<Vertice> adj2 = grafo.get(j);
            adj2.add(new Vertice(i, peso));
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
        ArrayList<Vertice> adjO = grafo.get(origen);
        boolean existe = false;
        if (adjO != null) {

        }

        return existe;
    }

    public double getPesoArista(int i, int j) {
        return 0.0;
    }

    //public ArrayList<Adyacente> getAdyacentes(int vertice);/// valor de retorno puede ser diferente
    public void dibujarGrafo(){}
    public boolean quitarArista(int origen, int destino) {
        return false;
    }
    public boolean esCompleto() {
        return false;
    }
    public boolean esGrafoCiclo() {
        return false;
    }
    public boolean esGrafoRueda() {
        return false;
    }
    public boolean existeBucle() {
        return false;
    }
}

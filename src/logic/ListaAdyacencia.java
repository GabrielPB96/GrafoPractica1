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
            for (int i=0; i<adjO.size() && !existe; i++) {
                existe = adjO.get(i).getValor() == destino;
            }
        }
        return existe;
    }

    public double getPesoArista(int i, int j){
        ArrayList<Vertice> adj = grafo.get(i);
        double peso = Double.MIN_VALUE;
        Vertice v = null;
        if (adj != null) {
            for (int k = 0; k < adj.size() && v == null; k++) {
                if (adj.get(k).getValor() == j) v = adj.get(k);
            }
            if (v != null) peso = v.getPeso();
        }
        return peso;
    }

    //public ArrayList<Adyacente> getAdyacentes(int vertice);/// valor de retorno puede ser diferente

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
        ArrayList<Vertice> adj = grafo.get(o);
        if (adj != null) {
            for (int i = 0; i < adj.size(); i++) {
                if (adj.get(i).getValor() == d) {
                    adj.remove(i);
                    cantAristas--;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean esCompleto() {
        long n = factorial(cantVertices);
        long m = factorial(cantVertices - 2);
        return n / (2*m) == cantAristas;
    }

    private long factorial(int n){
        if(n == 0 || n == 1) return 1;
        else return n * factorial(n-1);
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

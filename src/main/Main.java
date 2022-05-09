package main;

import logic.Grafo;
import logic.ListaAdyacencia;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new ListaAdyacencia(true);

        int[] vertices = {0,10, 2,3};

        for (Integer v  : vertices)  {
            grafo.insertarVertice(v);
        }

        grafo.insertarArista(0, 10, 3);
        grafo.insertarArista(2, 0, 6);
        grafo.insertarArista(2, 10, 9);
        grafo.insertarArista(3, 0, 3);
        grafo.insertarArista(3, 10, 2);
        grafo.insertarArista(3, 2, 10);

        grafo.dibujarGrafo();
    }
}

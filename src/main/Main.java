package main;

import logic.Grafo;
import logic.ListaAdyacencia;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new ListaAdyacencia(false);

        int[] vertices = {0, 1, 2, 3};

        for (Integer v  : vertices)  {
            grafo.insertarVertice(v);
        }

        grafo.insertarArista(0, 1, 3);
        grafo.insertarArista(2, 0, 6);
        grafo.insertarArista(2, 1, 9);
        grafo.insertarArista(3, 0, 3);
        grafo.insertarArista(3, 1, 2);
        grafo.insertarArista(3, 2, 10);

        grafo.dibujarGrafo();
    }
}

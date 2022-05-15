package main;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

import logic.ListaAdyacencia;

public class Main {
    @Test
    public void test1() {
        ListaAdyacencia grafo = new ListaAdyacencia(true);
        int[] nodos = {0, 1, 2, 3};

        for (int nodo : nodos) {
            grafo.insertarVertice(nodo);
        }

        grafo.insertarArista(0, 1, 3);
        grafo.insertarArista(3, 0, 3);
        grafo.insertarArista(3, 1, 2);
        grafo.insertarArista(3, 2, 10);
        grafo.insertarArista(2, 1, 9);
        grafo.insertarArista(2, 0, 6);

        assertEquals(grafo.getNumVertices(),4);
    }
}

package main;

import logic.ListaAdyacencia;

public class Main {
    public static void main(String[] args) {
        ListaAdyacencia grafo = new ListaAdyacencia(false);

        int[] vertices = {0, 1, 2, 3, 4};

        for (Integer v  : vertices)  {
            grafo.insertarVertice(v);
        }

        grafo.insertarArista(0, 1);
        grafo.insertarArista(0, 3);
        grafo.insertarArista(1, 2);
        grafo.insertarArista(3, 2);
        grafo.insertarArista(3, 4);
        grafo.insertarArista(4, 2);
        grafo.insertarArista(4, 1);
        grafo.insertarArista(4, 0);
        grafo.insertarArista(2, 2);

        /*grafo.insertarArista(0, 1, 3);
        grafo.insertarArista(2, 0, 6);
        grafo.insertarArista(2, 1, 9);
        grafo.insertarArista(3, 0, 3);
        grafo.insertarArista(3, 1, 2);
        grafo.insertarArista(3, 2, 10);*/

        System.out.println("Completo: "+grafo.esCompleto());
        System.out.println("Grafo Ciclo: "+grafo.esGrafoCiclo());
        System.out.println("Grado Rueda: "+grafo.esGrafoRueda());

        grafo.dibujarGrafo();
    }
}

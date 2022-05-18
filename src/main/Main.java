package main;

import logic.ListaAdyacencia;

public class Main {
    public static void main(String[] args) {
        //grafo1();
        //grafo2();
        grafo3();

    }

    static void grafo1() {
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

        System.out.println("GRAFO 1");
        System.out.println("Vertices: " + grafo.getNumVertices());
        System.out.println("Aristas: " + grafo.getNumAristas());
        System.out.println("Existe la arista 3-0: " + grafo.existeArista(3, 0));
        try {
            System.out.println("Peso de la arista 3-0: " + grafo.getPesoArista(3, 0));
        }catch (Exception e){
            System.out.println("No existe la arista 3-0");
        }
        System.out.println("Adyacentes a 3: " + grafo.getAdyacentes(3));

        System.out.println();
        grafo.dibujarGrafo();

        System.out.println("Esta grafo completo: " + grafo.esCompleto());
        System.out.println("Es grafo ciclico: " + grafo.esGrafoCiclo());
        System.out.println("Es grafo rueda: " + grafo.esGrafoRueda());
        System.out.println("Existe bucle: " + grafo.existeBucle());

        System.out.println("Quitando la arista 3-0");
        grafo.quitarArista(3, 0);
        System.out.println("Existe la arista 3-0: " + grafo.existeArista(3, 0));
        System.out.println();
        grafo.dibujarGrafo();
    }

    static void grafo2() {
        ListaAdyacencia grafo = new ListaAdyacencia(false);
        int[] nodos = {0, 1, 2, 3};

        for (int nodo : nodos) {
            grafo.insertarVertice(nodo);
        }

        grafo.insertarArista(0, 1);
        grafo.insertarArista(0, 2);
        grafo.insertarArista(0, 3);
        grafo.insertarArista(1, 2);
        grafo.insertarArista(1, 3);
        grafo.insertarArista(2, 3);

        System.out.println("GRAFO 2");
        System.out.println("Vertices: " + grafo.getNumVertices());
        System.out.println("Aristas: " + grafo.getNumAristas());
        System.out.println("Existe la arista 3-0: " + grafo.existeArista(3, 0));
        try {
            System.out.println("Peso de la arista 3-0: " + grafo.getPesoArista(3, 0));
        }catch (Exception e){
            System.out.println("No existe la arista 3-0");
        }
        System.out.println("Adyacentes a 3: " + grafo.getAdyacentes(3));

        System.out.println();
        grafo.dibujarGrafo();

        System.out.println("Esta grafo completo: " + grafo.esCompleto());
        System.out.println("Es grafo ciclico: " + grafo.esGrafoCiclo());
        System.out.println("Es grafo rueda: " + grafo.esGrafoRueda());
        System.out.println("Existe bucle: " + grafo.existeBucle());

        System.out.println("Quitando la arista 3-0");
        grafo.quitarArista(3, 0);
        System.out.println("Existe la arista 3-0: " + grafo.existeArista(3, 0));
        System.out.println();
        grafo.dibujarGrafo();
    }

    static void grafo3() {
        ListaAdyacencia grafo = new ListaAdyacencia(false);
        int[] nodos = {0, 1, 2, 3, 4};

        for (int nodo : nodos) {
            grafo.insertarVertice(nodo);
        }

        grafo.insertarArista(0, 1);
        grafo.insertarArista(0, 2);
        grafo.insertarArista(0, 3);
        grafo.insertarArista(0, 4);
        grafo.insertarArista(1, 2);
        grafo.insertarArista(1, 3);
        grafo.insertarArista(1, 4);
        grafo.insertarArista(2, 3);
        grafo.insertarArista(2, 4);
        grafo.insertarArista(3, 4);

        System.out.println("GRAFO 2");
        System.out.println("Vertices: " + grafo.getNumVertices());
        System.out.println("Aristas: " + grafo.getNumAristas());
        System.out.println("Existe la arista 4-1: " + grafo.existeArista(4, 1));
        try {
            System.out.println("Peso de la arista 4-1: " + grafo.getPesoArista(4, 1));
        }catch (Exception e){
            System.out.println("No existe la arista 4-1");
        }
        System.out.println("Adyacentes a 4: " + grafo.getAdyacentes(4));

        System.out.println();
        grafo.dibujarGrafo();

        System.out.println("Esta grafo completo: " + grafo.esCompleto());
        System.out.println("Es grafo ciclico: " + grafo.esGrafoCiclo());
        System.out.println("Es grafo rueda: " + grafo.esGrafoRueda());
        System.out.println("Existe bucle: " + grafo.existeBucle());

        System.out.println("Quitando la arista 4-1");
        grafo.quitarArista(4, 1);
        System.out.println("Existe la arista 4-1: " + grafo.existeArista(4, 1));
        System.out.println();
        grafo.dibujarGrafo();
    }
}

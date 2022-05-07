package main;

import logic.Grafo;
import logic.ListaAdyacencia;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new ListaAdyacencia(true);

        int[] vertices = {0,1,2,3};

        for (Integer v  : vertices)  {
            grafo.insertarVertice(v);
        }

        grafo.insertarArista(0, 1, 3);
        grafo.insertarArista(2, 1, 9);
        grafo.insertarArista(2, 0, 6);
        grafo.insertarArista(3, 0, 3);
        grafo.insertarArista(3, 2, 10);
        grafo.insertarArista(3, 1, 2);


        //System.out.println(grafo.existeArista(1, 2));
        //System.out.println(grafo.existeArista(1, 3));
        //System.out.println(grafo.existeArista(1, 4));
        //System.out.println(grafo.existeArista(1, 5));


        /*System.out.println(grafo.existeArista(1, 2));
        System.out.println(grafo.existeArista(2, 1));
        System.out.println(grafo.quitarArista(1, 2));
        System.out.println(grafo.existeArista(1, 2));
        System.out.println(grafo.existeArista(2, 1));
        System.out.println(grafo.quitarArista(1, 2));*/

        /*System.out.println(grafo.esCompleto());
        System.out.println(grafo.quitarArista(1,4));
        System.out.println(grafo.esCompleto());*/

        grafo.dibujarGrafo();
    }
}

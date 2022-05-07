package main;

import logic.Grafo;
import logic.ListaAdyacencia;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new ListaAdyacencia(false);

        int[] vertices = {1,2,3,4};

        for (Integer v  : vertices)  {
            grafo.insertarVertice(v);
        }

        grafo.insertarArista(1, 2);
        grafo.insertarArista(1, 3);
        grafo.insertarArista(1, 4);
        grafo.insertarArista(2, 4);
        grafo.insertarArista(2, 3);
        grafo.insertarArista(3, 4);


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
    }
}

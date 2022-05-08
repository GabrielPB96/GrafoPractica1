package main;

import logic.Grafo;
import logic.ListaAdyacencia;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new ListaAdyacencia(true);

        int[] vertices = {0,1, 3};

        for (Integer v  : vertices)  {
            grafo.insertarVertice(v);
        }
        grafo.insertarArista(0, 1, 5);
        grafo.insertarArista(0, 3);

        /*grafo.insertarArista(5,0);
        grafo.insertarArista(5,1);
        grafo.insertarArista(5,3);
        grafo.insertarArista(5,4);
        grafo.insertarArista(0,1);
        grafo.insertarArista(0,4);
        grafo.insertarArista(0,3);
        grafo.insertarArista(1,4);
        grafo.insertarArista(1,3);
        grafo.insertarArista(3,4);*/


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

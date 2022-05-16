package test;

import logic.ListaAdyacencia;
import logic.Vecino;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListaAdyacenciaTest3 {
    private ListaAdyacencia grafo;
    @Before
    public void setUp() {
        grafo = new ListaAdyacencia(false);
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
        grafo.insertarArista(2, 3);
        grafo.insertarArista(2, 4);
        grafo.insertarArista(3, 4);
        grafo.insertarArista(4, 1);

    }

    @Test
    public void getNumVertices() {
        assertEquals(5, grafo.getNumVertices());
    }

    @Test
    public void getNumAristas() {
        assertEquals(10, grafo.getNumAristas());
    }

    @Test
    public void existeArista() {
        assertTrue(grafo.existeArista(0, 1));
    }

    @Test
    public void noExisteArista() {
        assertFalse(grafo.existeArista(0, 0));
    }

    @Test
    public void getPesoArista() throws Exception{
        assertEquals(Double.MIN_VALUE, grafo.getPesoArista(0, 1), 0.0);
    }

    @Test
    public void getAdyacentesTres() {
        ArrayList<Vecino> adyacentes = new ArrayList<Vecino>();
        adyacentes.add(new Vecino(0, Double.MIN_VALUE));
        adyacentes.add(new Vecino(1, Double.MIN_VALUE));
        adyacentes.add(new Vecino(2, Double.MIN_VALUE));
        adyacentes.add(new Vecino(4, Double.MIN_VALUE));

        boolean iguales = true;
        for (Vecino vecino : grafo.getAdyacentes(3)) {
            if(!adyacentes.contains(vecino)) iguales = false;
        }

        assertTrue(iguales);
    }

    @Test
    public void quitarArista() {
        grafo.quitarArista(0, 1);
        assertFalse(grafo.existeArista(0, 1));
    }

    @Test
    public void esCompleto() {
        assertTrue(grafo.esCompleto());
    }

    @Test
    public void esGrafoCiclo() {
        assertFalse(grafo.esGrafoCiclo());
    }

    @Test
    public void esGrafoRueda() {
        assertFalse(grafo.esGrafoRueda());
    }

    @Test
    public void existeBucle() {
        assertFalse(grafo.existeBucle());
    }

    public static void main(String[] args) {
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
        grafo.insertarArista(2, 3);
        grafo.insertarArista(2, 4);
        grafo.insertarArista(3, 4);
        grafo.insertarArista(4, 1);

        grafo.dibujarGrafo();
    }
}
package test;

import logic.ListaAdyacencia;
import logic.Vecino;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListaAdyacenciaTest2 {
    private ListaAdyacencia grafo;
    @Before
    public void setUp() {
        grafo = new ListaAdyacencia(false);
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

    }

    @Test
    public void getNumVertices() {
        assertEquals(4, grafo.getNumVertices());
    }

    @Test
    public void getNumAristas() {
        assertEquals(6, grafo.getNumAristas());
    }

    @Test
    public void existeArista() {
        assertTrue(grafo.existeArista(0, 1));
    }

    @Test
    public void getPesoArista() throws Exception {
        double peso = grafo.getPesoArista(0, 1);
        assertEquals(Double.MIN_VALUE, peso, 0.001);
    }

    @Test
    public void getAdyacentesCero() {
        ArrayList<Vecino> adyacentes = new ArrayList<Vecino>();
        adyacentes.add(new Vecino(3, Double.MIN_VALUE));
        adyacentes.add(new Vecino(1, Double.MIN_VALUE));
        adyacentes.add(new Vecino(2, Double.MIN_VALUE));

        boolean iguales = true;
        for (Vecino vecino : grafo.getAdyacentes(0)) {
            if(!adyacentes.contains(vecino)) iguales = false;
        }

        assertTrue(iguales);
    }

    @Test
    public void getAdyacentesTres() {
        ArrayList<Vecino> adyacentes = new ArrayList<Vecino>();
        adyacentes.add(new Vecino(0, Double.MIN_VALUE));
        adyacentes.add(new Vecino(1, Double.MIN_VALUE));
        adyacentes.add(new Vecino(2, Double.MIN_VALUE));

        boolean iguales = true;
        for (Vecino vecino : grafo.getAdyacentes(3)) {
            if(!adyacentes.contains(vecino)) iguales = false;
        }

        assertTrue(iguales);
    }

    @Test
    public void quitarArista() {
        grafo.quitarArista(0, 3);
        assertFalse(grafo.existeArista(0, 3));
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
        assertTrue(grafo.esGrafoRueda());
    }

    @Test
    public void existeBucle() {
        assertFalse(grafo.existeBucle());
    }
}
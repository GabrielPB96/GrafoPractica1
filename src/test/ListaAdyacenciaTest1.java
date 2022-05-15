package test;

import logic.ListaAdyacencia;
import logic.Vecino;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListaAdyacenciaTest1 {
    private ListaAdyacencia grafo;
    @Before
    public void setUp() {
       grafo = new ListaAdyacencia(true);
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
    public void existeArista(){
        assertTrue(grafo.existeArista(0, 1));
    }

    @Test
    public void noExisteArista(){
        assertFalse(grafo.existeArista(1, 0));
    }

    @Test
    public void getPesoArista() throws Exception {
        double peso = 10D;
        assertEquals(peso, grafo.getPesoArista(3, 2), 0.001);
    }

    @Test(expected = Exception.class)
    public void getPesoAristaInexistente() throws Exception {
        double peso = 10D;
        assertEquals(peso, grafo.getPesoArista(2, 3), 0.001);
    }

    @Test
    public void getAdyacentes() {
        ArrayList<Vecino> adyacentes = new ArrayList<Vecino>();
        adyacentes.add(new Vecino(0, 3));
        adyacentes.add(new Vecino(1, 2));
        adyacentes.add(new Vecino(2, 10));

        boolean iguales = true;
        for (Vecino vecino : grafo.getAdyacentes(3)) {
            if(!adyacentes.contains(vecino)) iguales = false;
        }

        assertTrue(iguales);
    }

    @Test
    public void quitarArista() {
        grafo.quitarArista(3, 2);
        assertFalse(grafo.existeArista(3, 2));
    }

    @Test
    public void esCompleto() {
        assertFalse(grafo.esCompleto());
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
}
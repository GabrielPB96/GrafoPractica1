package logic;

import java.util.ArrayList;

public class MatrizAdyacencia implements Grafo {
    private int[][] matriz;
    private double[][] pesos;
    private boolean dirigido;
    private Verificador verificador;

    public MatrizAdyacencia(int[][] matriz, boolean dirigido) {
        this.matriz = matriz;
        this.dirigido = dirigido;
        this.pesos = new double[matriz.length][matriz.length];
        verificador = dirigido ? new Dirigido(this) : new NoDirigido(this);
    }

    @Override
    public int getNumVertices() {
        return matriz.length;
    }

    @Override
    public int getNumAristas() {
        return dirigido ? contarAristas() : contarAristas() / 2;
    }
    private int contarAristas() {
        int numAristas = 0;
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz.length; j++) {
                if (this.matriz[i][j] != 0) numAristas++;
            }
        }
        return numAristas;
    }

    private boolean valido(int i, int j) {
        return i >= 0 && i < this.matriz.length && j >= 0 && j < this.matriz.length;
    }

    @Override
    public boolean existeArista(int origen, int destino) {
        if(!valido(origen,destino)) return false;
        return matriz[origen][destino] != 0;
    }

    @Override
    public double getPesoArista(int i, int j) {
        if(!valido(i,j)) return Double.MIN_VALUE;
        return pesos[i][j];
    }

    @Override
    public void insertarArista(int i, int j) {
        if(valido(i,j)) {
            this.matriz[i][j] = 1;
            if (!dirigido) this.matriz[j][i] = 1;
        }
    }

    @Override
    public void insertarArista(int i, int j, double peso) {
        if(valido(i,j)) {
            this.matriz[i][j] = 1;
            this.pesos[i][j] = peso;
            if (!dirigido) this.matriz[j][i] = 1;
        }
    }

    @Override
    public Object getAdyacentes(int vertice) {
        if(vertice < 0 || vertice >= this.matriz.length) return new ArrayList<>();
        ArrayList<Integer> adyacentes = new ArrayList<>();
        for (int i = 0; i < this.matriz.length; i++) {
            if(this.matriz[vertice][i] != 0) adyacentes.add(i);
        }
        return adyacentes;
    }

    @Override
    public void dibujarGrafo() {

    }

    @Override
    public boolean quitarArista(int origen, int destino) {
        if (!valido(origen, destino)) return false;
        this.matriz[origen][destino] = 0;
        if (!dirigido) this.matriz[destino][origen] = 0;
        return true;
    }

    @Override
    public boolean esCompleto() {
        return verificador.esCompleto();
    }

    @Override
    public boolean esGrafoCiclo() {
        return verificador.esGrafoCiclo();
    }

    @Override
    public boolean esGrafoRueda() {
        return verificador.esGrafoRueda();
    }

    @Override
    public boolean existeBucle() {
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz.length; j++) {
                sb.append(this.matriz[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

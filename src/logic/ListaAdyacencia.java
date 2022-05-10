package logic;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaAdyacencia implements Grafo{
    private HashMap<Integer, ArrayList<Vecino>> grafo;
    private boolean dirigido;
    private int cantVertices, cantAristas, cantLazos;
    private Verificador verificador;

    private GraphicAdyacencia graficador;

    public ListaAdyacencia(boolean dirigido) {
        cantVertices = 0;
        cantAristas = 0;
        cantLazos = 0;
        this.dirigido = dirigido;
        grafo = new HashMap<>();
        graficador = new GraphicAdyacencia(this);
        verificador = dirigido ? new Dirigido(this) : new NoDirigido(this);
    }

    public void insertarVertice(int v) {
        grafo.put(v, new ArrayList<>());
        cantVertices++;
    }

    @Override
    public void insertarArista(int i, int j) {
        ArrayList<Vecino> ady = grafo.get(i);
        ady.add(new Vecino(j, Double.MIN_VALUE));
        if (!dirigido) {
            ArrayList<Vecino> ady2 = grafo.get(j);
            ady2.add(new Vecino(i, Double.MIN_VALUE));
        }
        if (i == j) cantLazos++;
        cantAristas++;
    }

    @Override
    public void insertarArista(int i, int j, double peso) {
        ArrayList<Vecino> ady = grafo.get(i);
        ady.add(new Vecino(j, peso));
        if (!dirigido) {
            ArrayList<Vecino> ady2 = grafo.get(j);
            ady2.add(new Vecino(i, peso));
        }
        if (i == j) cantLazos++;
        cantAristas++;
    }

    @Override
    public int getNumVertices() {
        return cantVertices;
    }

    @Override
    public int getNumAristas() {
        return cantAristas;
    }

    @Override
    public boolean existeArista(int origen, int destino) {
        ArrayList<Vecino> adyO = grafo.get(origen);
        boolean existe = false;
        if (adyO != null) {
            for (int i=0; i<adyO.size() && !existe; i++) {
                existe = adyO.get(i).getValor() == destino;
            }
        }
        return existe;
    }

    @Override
    public double getPesoArista(int i, int j){
        ArrayList<Vecino> ady = grafo.get(i);
        double peso = Double.MIN_VALUE;
        Vecino v = null;
        if (ady != null) {
            for (int k = 0; k < ady.size() && v == null; k++) {
                if (ady.get(k).getValor() == j) v = ady.get(k);
            }
            if (v != null) peso = v.getPeso();
        }
        return peso;
    }

    @Override
    public ArrayList<Vecino> getAdyacentes(int vertice) {
        ArrayList<Vecino> ady = grafo.get(vertice);
        return (ady != null) ? ady : new ArrayList<>();
    }

    @Override
    public void dibujarGrafo(){
        graficador.paint();
        System.out.println("\nDibujo grafo");
        System.out.println("Cantidad de vertices: " + cantVertices);
        System.out.println("Cantidad de aristas: " + cantAristas);
        System.out.println("Cantidad de lazos: " + cantLazos);
        System.out.println("Es dirigido: " + dirigido);
        System.out.println(toString());
    }

    @Override
    public boolean quitarArista(int origen, int destino) {
        boolean sePudo;
        sePudo = eliminarArista(origen, destino);
        if (!dirigido && sePudo) {
            eliminarArista(destino, origen);
        }
        return sePudo;
    }
    private boolean eliminarArista(int o, int d){
        ArrayList<Vecino> ady = grafo.get(o);
        if (ady != null) {
            for (int i = 0; i < ady.size(); i++) {
                if (ady.get(i).getValor() == d) {
                    ady.remove(i);
                    if (o == d) cantLazos--;
                    cantAristas--;
                    return true;
                }
            }
        }
        return false;
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

    public HashMap<Integer, ArrayList<Vecino>> getGrafo() {
        return grafo;
    }
    public boolean esDirigido() {
        return dirigido;
    }

    public String toString(){
        String reporte = "Vertice | Adyacentes\n";
        for(Integer v : grafo.keySet()){
            reporte += ""+v + "   ->   {";
            ArrayList<Vecino> ady = grafo.get(v);
            for(Vecino vec : ady){
                double peso = vec.getPeso()==Double.MIN_VALUE ? 0 : vec.getPeso();
                reporte += "(" + vec.getValor() + ", " +peso+ ") ";
            }
            reporte += "}\n";
        }
        return reporte;
    }
}

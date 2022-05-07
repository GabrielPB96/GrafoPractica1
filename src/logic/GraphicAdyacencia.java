package logic;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphicAdyacencia {
    private ListaAdyacencia grafo;
    private HashMap<Integer, ArrayList<Vertice>> g;

    public GraphicAdyacencia(ListaAdyacencia grafo) {
        this.grafo = grafo;
        this.g = grafo.getGrafo();
    }

    private char[] construirVertices() {
        char[] vertices = new char[grafo.getNumVertices()];
        for (Integer key : g.keySet()) {
            vertices[key] = (char) (key + '0');
        }
        return vertices;
    }

    /*private TemplateAristas[] construirAristas() {
        TemplateArista[] aristas = new TemplateArista[grafo.getNumAristas()];
        for(Integer key : g.keySet()){
            ArrayList<Vertice> ady = g.get(key);
            for(int i=0; i<ady.size(); i++){
                int[] arista = {key, ady.get(i).getValor()};
                if(!existe(arista, aristas)){
                    TemplateArista a = new TemplateArista((char)(key+'0'), (char)(ady.get(i).getValor()+'0'));
                    if (ady.get(i).getPeso() != Double.MIN_VALUE) {
                        a.setPeso(ady.get(i).getPeso());
                        aristas[i] = a;
                    }
                }
            }
        }
        return aristas;
    }*/

    /*private boolean existe(int[] arista, TemplateAristas[] aristas) {
        for (int i = 0; i < aristas.length; i++) {
            int o = arista[0], d = arista[1];
            if ((aristas[i].getOrigen() == o && aristas[i].getDestino() == d)
                || (aristas[i].getOrigen() == d && aristas[i].getDestino() == o))
            {
                return true;
            }

        }
        return false;
    }*/
}

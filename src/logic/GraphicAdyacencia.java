package logic;

import graphic.Graph;
import graphic.TemplateArista;
import graphic.TemplateVertice;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphicAdyacencia {
    private ListaAdyacencia grafo;
    private HashMap<Integer, ArrayList<Vecino>> g;

    public GraphicAdyacencia(ListaAdyacencia grafo) {
        this.grafo = grafo;
        this.g = grafo.getGrafo();
    }

    public void paint(){
        new Graph(construirVertices(), construirAristas());
    }

    public TemplateVertice[] construirTemplateVertices(){
        TemplateVertice[] vertices = new TemplateVertice[grafo.getNumVertices()];
        int p = 0;
        for (Integer key : g.keySet()) {
            TemplateVertice v = new TemplateVertice(String.valueOf(key));
            vertices[p] = v;
            p++;
        }
        return vertices;
    }

    private String[] construirVertices() {
        String[] vertices = new String[grafo.getNumVertices()];
        int p = 0;
        for (Integer key : g.keySet()) {
            vertices[p] = String.valueOf(key);
            p++;
        }
        return vertices;
    }

    private TemplateArista[] construirAristas() {
        TemplateArista[] aristas = new TemplateArista[grafo.getNumAristas()];
        int p = 0;
        for(Integer key : g.keySet()){
            ArrayList<Vecino> ady = g.get(key);
            for(int i=0; i<ady.size(); i++){
                int[] arista = {key, ady.get(i).getValor()};
                if((!grafo.esDirigido() && !existe(arista, aristas)) || grafo.esDirigido()){
                    TemplateArista a = new TemplateArista(String.valueOf(key), String.valueOf(ady.get(i).getValor()));
                    if (ady.get(i).getPeso() != Double.MIN_VALUE) {
                        a.setPeso(ady.get(i).getPeso());
                    }
                    if (grafo.esDirigido()) {
                        a.setFlecha(true);
                    }
                    aristas[p] = a;
                    p++;
                }
            }
        }
        return aristas;
    }

    private boolean existe(int[] arista, TemplateArista[] aristas) {
        for (int i = 0; i < aristas.length; i++) {
            int o = arista[0], d = arista[1];
            TemplateArista v = aristas[i];
            if (v != null) {
                if ((v.getOrigen().equals(String.valueOf(o)) && v.getDestino().equals(String.valueOf(d)))
                        || (v.getOrigen().equals(String.valueOf(d)) && v.getDestino().equals(String.valueOf(o)))) {
                    return true;
                }
            }

        }
        return false;
    }
}

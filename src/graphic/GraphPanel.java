package graphic;

import graphic.geo.Punto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GraphPanel extends JPanel {
    private ArrayList<Vertice> vertices;
    private ArrayList<Arista> aristas;
    private Vertice clickedVertice;
    private final Manejador manejador = new Manejador();

    public static int a, b;

    public GraphPanel(int a, int b) {
        setBackground(Color.WHITE);
        this.a = a;
        this.b = b;
        addMouseMotionListener(manejador);
        addMouseListener(manejador);
        clickedVertice = null;
        vertices = new ArrayList<>();
        aristas = new ArrayList<>();
    }

    public void addVertices(Vertice[] v) {
        for (Vertice vertice : v) {
            vertices.add(vertice);
        }
    }

    public void addAristas(Arista[] a) {
        for (Arista aris : a) {
            addArista(aris);
        }
    }

    public void addVertices(String[] vert) {
        for (String ver : vert) {
            Vertice v = new BuilderVertice()
                    .setRandomLocation()
                    .setEtiqueta(ver)
                    .build();
            addVertice(v);
        }
    }

    public void addAristas(TemplateArista[] aris) {
        for (TemplateArista a1 : aris) {
            if (a1 != null) {
                Vertice o = getVertice(a1.getOrigen());
                Vertice d = getVertice(a1.getDestino());
                Arista a = new BuilderArista()
                        .setOrigen(o)
                        .setDestino(d)
                        .setPeso(a1.getPeso())
                        .setFlecha(a1.isFlecha())
                        .build();
                addArista(a);
            }
        }
    }

    public Vertice getVertice(String etiqueta) {
        for (Vertice v : vertices) {
            if (v.getEtiqueta().equals(etiqueta)) {
                return v;
            }
        }
        return null;
    }

    public void addVertice(Vertice v) {
        vertices.add(v);
    }

    public void addArista(Arista a) {
        aristas.add(a);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Arista a : aristas) {
            a.paint(g);
        }
        for (Vertice v : vertices) {
            v.paint(g);
        }
    }

    public void searchClickedVertice(double x, double y) {
        clickedVertice = null;
        for (Vertice v : vertices) {
            if (v.contains(x, y)) {
                clickedVertice = v;
            }
        }
    }

    private class Manejador extends MouseAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (clickedVertice != null) {
                clickedVertice.setLocation(new Punto(e.getX(), e.getY()));
                repaint();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            searchClickedVertice(e.getX(), e.getY());
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            searchClickedVertice(e.getX(), e.getY());
            if (clickedVertice != null) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }else{
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }
}

package graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Panel extends JPanel {
    private ArrayList<Vertice> vertices;
    private ArrayList<Arista> aristas;
    private Vertice clickedVertice;
    private final Manejador manejador = new Manejador();

    private int a, b;

    public Panel(int a, int b) {
        this.a = a;
        this.b = b;
        addMouseMotionListener(manejador);
        addMouseListener(manejador);
        clickedVertice = null;
        vertices = new ArrayList<>();
        aristas = new ArrayList<>();
    }

    public void addVertices(char[] vert) {
        for (char ver : vert) {
            Vertice v = new BuilderVertice()
                    .setRandomLocation(a, b)
                    .setEtiqueta(ver)
                    .build();
            addVertice(v);
        }
    }

    public void addAristas(TemplateArista[] aris) {
        for (TemplateArista a1 : aris) {
            Vertice o = getVertice(a1.getOrigen());
            Vertice d = getVertice(a1.getDestino());
            Arista a = new BuilderArista()
                    .setOrigen(o)
                    .setDestino(d)
                    .build();
            addArista(a);
        }
    }

    public Vertice getVertice(char etiqueta) {
        for (Vertice v : vertices) {
            if (v.getEtiqueta() == etiqueta) {
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
        for (Vertice v : vertices) {
            if (v.contains(x, y)) {
                clickedVertice = v;
            }
        }
    }

    private class Manejador extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                searchClickedVertice(e.getX(), e.getY());
                System.out.println(clickedVertice);
            }else {
                Vertice v = new BuilderVertice()
                        .setPunto(new Punto(e.getX(), e.getY()))
                        .build();
                vertices.add(v);
                repaint();
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            searchClickedVertice(e.getX(), e.getY());
            if (clickedVertice != null) {
                clickedVertice.setLocation(new Punto(e.getX(), e.getY()));
                repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            clickedVertice = null;
        }
    }
}

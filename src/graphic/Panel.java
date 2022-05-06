package graphic;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Panel extends javax.swing.JPanel implements MouseMotionListener, MouseListener {
    private ArrayList<Vertice> vertices;
    private Vertice clickedVertice;

    public Panel() {
        addMouseMotionListener(this);
        addMouseListener(this);
        clickedVertice = null;
        vertices = new ArrayList<>();
    }

    public void addVertice(Vertice v) {
        vertices.add(v);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
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

    @Override
    public void mouseDragged(MouseEvent e) {
        searchClickedVertice(e.getX(), e.getY());
        if (clickedVertice != null) {
            clickedVertice.setLocation(e.getX(), e.getY());
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            searchClickedVertice(e.getX(), e.getY());
            System.out.println(clickedVertice);
        }else {
            Vertice v = new Vertice(e.getX(), e.getY(),  ' ');
            vertices.add(v);
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clickedVertice = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

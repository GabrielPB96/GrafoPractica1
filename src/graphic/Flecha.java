package graphic;

import graphic.geo.Linea;
import graphic.geo.MathGeo;
import graphic.geo.Punto;
import graphic.geo.Vector;

import javax.swing.*;
import java.awt.*;

public class Flecha {
    private Punto origen;
    private Punto destino;

    public Flecha(Punto origen, Punto destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public Punto getOrigen() {
        return origen;
    }

    public Punto getDestino() {
        return destino;
    }

    public void setOrigen(Punto origen) {
        this.origen = origen;
    }

    public void setDestino(Punto destino) {
        this.destino = destino;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        Linea linea = new Linea(origen, destino);
        Linea arista1 = obtenerArista(45);
        Linea arista2 = obtenerArista(-45);
        linea.paint(g);
        arista1.paint(g);
        arista2.paint(g);
    }
    private Linea obtenerArista(int angulo) {
        Punto p1 = new Punto(destino.getX(), destino.getY());
        Vector v = MathGeo.obtenerVector(origen, destino);
        double r = MathGeo.distancia(origen, destino)/4;
        double d = MathGeo.distancia(origen, destino);
        double escalar = 1-(r/d);
        v.multiplicarEscalar(escalar);
        double x = origen.getX() + v.getX();
        double y = origen.getY() + v.getY();
        Punto p2 = new Punto(x, y);
        Vector u = MathGeo.obtenerVector(p1, p2);
        Vector w = MathGeo.rotarVectorHorario(u, angulo);
        p2 = MathGeo.sumarVectorPunto(w, p2);
        return new Linea(p1, p2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flecha");
        JPanel panel = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Flecha flecha = new Flecha(new Punto(50, 200), new Punto(70, 100));
                flecha.paint(g);
            }
        };
        frame.setBounds(0, 0, 500, 500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

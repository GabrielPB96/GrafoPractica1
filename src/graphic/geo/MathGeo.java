package graphic.geo;
import graphic.BuilderVertice;
import graphic.*;

import javax.swing.*;

import static java.lang.Math.*;
public class MathGeo {

    public static Vector rotarVector(Vector v, double angulo) {
        double x = v.getX();
        double y = v.getY();
        double c = cos(toRadians(angulo));
        double s = sin(toRadians(angulo));
        return new Vector(x * c - y * s, x * s + y * c);
    }

    public static Vector obtenerVector(Punto p1, Punto p2) {
        return new Vector(p2.getX() - p1.getX(), p2.getY() - p1.getY());
    }

    public static double distancia(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static double distancia(Punto p1, Punto p2) {
        return distancia(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public static Punto sumarVectorPunto(Vector v, Punto p) {
        return new Punto(v.getX() + p.getX(), v.getY() + p.getY());
    }

    public static Punto restarVectorPunto(Vector v, Punto p) {
        return new Punto(p.getX() - v.getX(), p.getY() - v.getY());
    }

    public static Vector obtenerVectorReduccion(Punto origen, Punto destino, double reduccion) {
        Vector v = MathGeo.obtenerVector(origen, destino);
        double d = MathGeo.distancia(origen, destino);
        double escalar = 1-(reduccion/d);
        v.multiplicarEscalar(escalar);
        return v;
    }

    /*
        centro -> es el centro de la elipse
        radioX -> es el radio de la elipse en el eje x (eje mayor)
        radioY -> es el radio de la elipse en el eje y (eje menor)
        p1 -> punto por donde pasa la recta
        La recta pasa por p1 y el centro de la elipse.
     */
    public static Punto[] interseccionRectaElipse(Punto p1, Punto centro, double radioX, double radioY) {
        Punto[] intersecciones = new Punto[2];
        double m = (centro.getY() - p1.getY()) / (centro.getX() - p1.getX());
        double r = ((p1.getY() - centro.getY()) / (centro.getX() - p1.getX()))* p1.getX() + p1.getY();

        double A = pow(radioY,2) + pow(radioX*m,2);
        double B = 2*(pow(radioX,2)*m*(r-centro.getY()) - pow(radioY,2)*centro.getX());
        double C = pow(radioY,2)*(pow(centro.getX(),2)-pow(radioX,2)) + pow(radioX,2)*pow(r-centro.getY(),2);

        double x1 = (-B + sqrt(B*B - 4*A*C)) / (2*A);
        double x2 = (-B - sqrt(B*B - 4*A*C)) / (2*A);
        double y1 = m*x1 + r;
        double y2 = m*x2 + r;

        intersecciones[0] = new Punto(x1, y1);
        intersecciones[1] = new Punto(x2, y2);

        return intersecciones;
    }
}

package graphic.geo;
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

    public static Vector obtenerVectorReduccion(Punto origen, Punto destino, double reduccion) {
        Vector v = MathGeo.obtenerVector(origen, destino);
        double d = MathGeo.distancia(origen, destino);
        double escalar = 1-(reduccion/d);
        v.multiplicarEscalar(escalar);
        return v;
    }
}

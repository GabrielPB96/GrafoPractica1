package graphic.geo;

public class Punto {
    private double x, y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean mayorX(Punto p) {
        return this.x > p.x;
    }

    public boolean equals(Punto p) {
        return this.x == p.x && this.y == p.y;
    }

    public Punto clone() {
        return new Punto(this.x, this.y);
    }

    public void setLocation(Punto p) {
        this.x = p.x;
        this.y = p.y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

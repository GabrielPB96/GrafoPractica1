package logic;

public class Vecino {
    private int valor;
    private double peso;

    public Vecino(int valor, double peso) {
        this.valor = valor;
        this.peso  = peso;
    }

    public int getValor() {
        return this.valor;
    }

    public double getPeso() {
        return peso;
    }
}

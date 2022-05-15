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

    @Override
    public boolean equals(Object v) {
        if (v instanceof Vecino) {
            Vecino vecino = (Vecino) v;
            return this.valor == vecino.getValor() && this.peso == vecino.getPeso();
        }
        return false;
    }
}

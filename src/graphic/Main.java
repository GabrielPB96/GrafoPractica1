package graphic;
import java.awt.Color;
public class Main {
    public static void main(String[] args) {
        Vertice[] vertices = {
                new BuilderVertice()
                        .setEtiqueta("A")
                        .setColor(Color.ORANGE).build(),

                new BuilderVertice()
                        .setEtiqueta("B").build(),

                new BuilderVertice()
                        .setEtiqueta("C")
                        .setColor(Color.RED).build(),

                new BuilderVertice()
                        .setEtiqueta("D")
                        .setColor(Color.YELLOW).build()
        };


        Arista[] aristas = {
                new BuilderArista()
                        .setOrigen(vertices[0])
                        .setDestino(vertices[1])
                        .setColor(Color.BLUE)
                        .setFlecha(true).build(),

                new BuilderArista()
                        .setOrigen(vertices[0])
                        .setDestino(vertices[2]).build(),

                new BuilderArista()
                        .setOrigen(vertices[0])
                        .setDestino(vertices[3])
                        .setColor(Color.GRAY).build(),

                new BuilderArista()
                        .setOrigen(vertices[1])
                        .setDestino(vertices[3]).build(),

                new BuilderArista()
                        .setOrigen(vertices[2])
                        .setDestino(vertices[3])
                        .setFlecha(true).build()
        };

        new Graph(vertices, aristas);
    }
}

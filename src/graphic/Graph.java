package graphic;

import javax.swing.*;
import java.awt.*;

public class Graph extends JFrame {
    private GraphPanel panel;

    public Graph(){
        panel = new GraphPanel(120, 370);
        setTitle("Graph");
        setBounds(0, 0, 500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public Graph(char[] vertices, TemplateArista[] aristas) {
        this();
        panel.addVertices(vertices);
        panel.addAristas(aristas);
    }

    public Graph(Vertice[] vertices, Arista[] aristas) {
        this();
        panel.addVertices(vertices);
        panel.addAristas(aristas);
    }

    public static void main(String[] args) {
        char[] vertices = {'A','B','C', 'D', 'E', 'F', 'G'};
        TemplateArista[] aristas = {
                new TemplateArista('A', 'E'),
                new TemplateArista('A', 'F'),
                new TemplateArista('A', 'G'),
                new TemplateArista('B', 'E'),
                new TemplateArista('B', 'F'),
                new TemplateArista('B', 'G'),
                new TemplateArista('C', 'E'),
                new TemplateArista('C', 'F'),
                new TemplateArista('C', 'G'),
                new TemplateArista('D', 'E'),
                new TemplateArista('D', 'F'),
                new TemplateArista('D', 'G'),
        };
        new Graph(vertices, aristas);
    }
}

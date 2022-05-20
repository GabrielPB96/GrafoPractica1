package graphic;

import javax.swing.JFrame;

/**
 * La clase grafica un grafo dado los vertices y las aristas.
 * @author PANTOJA BUSTAMANTE GABRIEL
 * @version 1.0
 */
public class Graph extends JFrame {
    private GraphPanel panel;

    public Graph(){
        panel = new GraphPanel();
        setTitle("Graph");
        setBounds(0, 0, 500, 500);
        setLocationRelativeTo(null);
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public Graph(String[] vertices, TemplateArista[] aristas) {
        this();
        panel.addVertices(vertices);
        panel.addAristas(aristas);
    }

    public Graph(Vertice[] vertices, Arista[] aristas) {
        this();
        panel.addVertices(vertices);
        panel.addAristas(aristas);
    }

    public Graph(TemplateVertice[] vertices, TemplateArista[] aristas) {
        this();
        panel.addVertices(vertices);
        panel.addAristas(aristas);
    }
}

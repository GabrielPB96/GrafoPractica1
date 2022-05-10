package graphic;

import javax.swing.JFrame;

public class Graph extends JFrame {
    private GraphPanel panel;

    public Graph(){
        panel = new GraphPanel(120, 370);
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

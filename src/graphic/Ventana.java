package graphic;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private Panel panel;
    public Ventana() {
        panel = new Panel(20, 380);
        setTitle("Ventana");
        setBounds(0, 0, 400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        char[] vertices = {'A','B','C'};
        TemplateArista[] aristas = {new TemplateArista('A','B'),
                                    new TemplateArista('A','C'),
                                    new TemplateArista('B','C')};
        panel.addVertices(vertices);
        panel.addAristas(aristas);
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}

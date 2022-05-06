package graphic;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana() {
        setTitle("Ventana");
        setBounds(0, 0, 400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Vertice v1 = new Vertice(100,100,'A'),
                v2 = new Vertice(200,100,'B'),
                v3 = new Vertice(200,200,'C');
        Panel panel = new Panel();
        panel.addVertice(v1);
        panel.addVertice(v2);
        panel.addVertice(v3);


        add(panel);


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}

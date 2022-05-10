package graphic;

import java.awt.Color;

public class TemplateVertice {
    private String etiqueta;
    private Color color;

    public TemplateVertice(String etiqueta, Color color) {
        this.etiqueta = etiqueta;
        this.color = color;
    }

    public TemplateVertice(String etiqueta) {
        this.etiqueta = etiqueta;
        this.color = new Color(50, 133, 206);
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public Color getColor() {
        return color;
    }
}

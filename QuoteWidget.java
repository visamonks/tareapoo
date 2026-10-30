import javax.swing.*;
import java.awt.*;

public class QuoteWidget implements Widget {
    private int id;
    private String nombre;
    private int memoriaKB;
    private String frase;
    private String autor;
    private JPanel vista;

    public QuoteWidget(int id, String nombre, int memoriaKB, String frase, String autor) {
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
        this.frase = frase;
        this.autor = autor;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getMemoriaKB() { return memoriaKB; }

    public String renderizar() {
        return "\"" + frase + "\" - " + autor;
    }

    public JComponent obtenerVista() {
        if (vista == null) {
            vista = new JPanel(new BorderLayout());
            vista.setBorder(BorderFactory.createTitledBorder(nombre));
            JLabel lblFrase = new JLabel("<html><i>" + renderizar() + "</i></html>", SwingConstants.CENTER);
            vista.add(lblFrase, BorderLayout.CENTER);
        }
        return vista;
    }
}

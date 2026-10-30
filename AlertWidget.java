import javax.swing.*;
import java.awt.*;

public class AlertWidget implements Widget, Interactivo {
    private int id;
    private String nombre;
    private int memoriaKB;
    private String mensaje;
    private String prioridad;
    private boolean leida;
    private JPanel vista;
    private JLabel lblAlerta;

    public AlertWidget(int id, String nombre, int memoriaKB, String mensaje, String prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
        this.mensaje = mensaje;
        this.prioridad = prioridad;
        this.leida = false;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getMemoriaKB() { return memoriaKB; }

    public String renderizar() {
        String estado = leida ? "Leída" : "No leída";
        return "[" + prioridad + "] " + mensaje + " (" + estado + ")";
    }

    public void interactuar() {
        leida = true;
    }

    public JComponent obtenerVista() {
        if (vista == null) {
            vista = new JPanel(new BorderLayout(5, 5));
            vista.setBorder(BorderFactory.createTitledBorder(nombre));
            lblAlerta = new JLabel("<html>" + renderizar() + "</html>");
            lblAlerta.setForeground(new Color(180, 0, 0));
            JButton btnLeida = new JButton("Marcar como leída");
            btnLeida.addActionListener(e -> {
                interactuar();
                lblAlerta.setText("<html>" + renderizar() + "</html>");
                lblAlerta.setForeground(Color.GRAY);
            });
            vista.add(lblAlerta, BorderLayout.CENTER);
            vista.add(btnLeida, BorderLayout.SOUTH);
        }
        return vista;
    }
}

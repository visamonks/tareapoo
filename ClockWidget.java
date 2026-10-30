import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClockWidget implements Widget {
    private int id;
    private String nombre;
    private int memoriaKB;
    private JPanel vista;

    public ClockWidget(int id, String nombre, int memoriaKB) {
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getMemoriaKB() { return memoriaKB; }

    public String renderizar() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public JComponent obtenerVista() {
        if (vista == null) {
            vista = new JPanel(new BorderLayout());
            vista.setBorder(BorderFactory.createTitledBorder(nombre));
            JLabel lblHora = new JLabel(renderizar(), SwingConstants.CENTER);
            lblHora.setFont(new Font("Monospaced", Font.BOLD, 26));
            Timer timer = new Timer(1000, e -> lblHora.setText(renderizar()));
            timer.start();
            vista.add(lblHora, BorderLayout.CENTER);
        }
        return vista;
    }
}

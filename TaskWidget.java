import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TaskWidget implements Widget, Interactivo {
    private int id;
    private String nombre;
    private int memoriaKB;
    private ArrayList<String> tareas;
    private ArrayList<Boolean> completadas;
    private JPanel vista;
    private JLabel lblTareas;

    public TaskWidget(int id, String nombre, int memoriaKB) {
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
        this.tareas = new ArrayList<>();
        this.completadas = new ArrayList<>();
    }

    public void agregarTarea(String tarea) {
        tareas.add(tarea);
        completadas.add(false);
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getMemoriaKB() { return memoriaKB; }

    public String renderizar() {
        String texto = "";
        for (int i = 0; i < tareas.size(); i++) {
            String marca = completadas.get(i) ? "[x] " : "[ ] ";
            texto += marca + tareas.get(i) + "\n";
        }
        return texto;
    }

    public void interactuar() {
        for (int i = 0; i < completadas.size(); i++) {
            if (!completadas.get(i)) {
                completadas.set(i, true);
                return;
            }
        }
    }

    private String textoHtml() {
        return "<html>" + renderizar().replace("\n", "<br>") + "</html>";
    }

    public JComponent obtenerVista() {
        if (vista == null) {
            vista = new JPanel(new BorderLayout(5, 5));
            vista.setBorder(BorderFactory.createTitledBorder(nombre));
            lblTareas = new JLabel(textoHtml());
            JButton btnCompletar = new JButton("Completar siguiente");
            btnCompletar.addActionListener(e -> {
                interactuar();
                lblTareas.setText(textoHtml());
            });
            vista.add(lblTareas, BorderLayout.CENTER);
            vista.add(btnCompletar, BorderLayout.SOUTH);
        }
        return vista;
    }
}

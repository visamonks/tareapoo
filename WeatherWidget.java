import javax.swing.*;
import java.awt.*;

public class WeatherWidget implements Widget, Interactivo {
    private int id;
    private String nombre;
    private int memoriaKB;
    private String ciudad;
    private double temperatura;
    private boolean enCelsius;
    private JPanel vista;
    private JLabel lblTexto;

    public WeatherWidget(int id, String nombre, int memoriaKB, String ciudad, double temperatura) {
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.enCelsius = true;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getMemoriaKB() { return memoriaKB; }

    public String renderizar() {
        if (enCelsius) {
            return ciudad + ": " + String.format("%.1f", temperatura) + " °C";
        }
        double f = temperatura * 9 / 5 + 32;
        return ciudad + ": " + String.format("%.1f", f) + " °F";
    }

    public void interactuar() {
        enCelsius = !enCelsius;
    }

    public JComponent obtenerVista() {
        if (vista == null) {
            vista = new JPanel(new BorderLayout(5, 5));
            vista.setBorder(BorderFactory.createTitledBorder(nombre));
            lblTexto = new JLabel(renderizar(), SwingConstants.CENTER);
            lblTexto.setFont(new Font("Arial", Font.BOLD, 18));
            JButton btnUnidad = new JButton("°C / °F");
            btnUnidad.addActionListener(e -> {
                interactuar();
                lblTexto.setText(renderizar());
            });
            vista.add(lblTexto, BorderLayout.CENTER);
            vista.add(btnUnidad, BorderLayout.SOUTH);
        }
        return vista;
    }
}

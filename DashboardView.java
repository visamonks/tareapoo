import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DashboardView extends JFrame {
    private JPanel panelWidgets;
    private JButton btnMostrarTodos;
    private JButton btnOrdenar;
    private JButton btnBuscar;
    private JTextField txtBuscar;

    public DashboardView() {
        setTitle("Dashboard");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));

        txtBuscar = new JTextField(12);
        btnBuscar = new JButton("Buscar");
        btnOrdenar = new JButton("Ordenar");
        btnMostrarTodos = new JButton("Mostrar todos");

        txtBuscar.addActionListener(e -> btnBuscar.doClick());

        panelSuperior.add(new JLabel("Buscar:"));
        panelSuperior.add(txtBuscar);
        panelSuperior.add(btnBuscar);
        panelSuperior.add(btnOrdenar);
        panelSuperior.add(btnMostrarTodos);

        add(panelSuperior, BorderLayout.NORTH);

        panelWidgets = new JPanel(new GridLayout(0, 3, 10, 10));
        panelWidgets.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scroll = new JScrollPane(panelWidgets);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);
    }

    public void mostrarWidgets(List<Widget> widgets) {
        panelWidgets.removeAll();
        for (Widget w : widgets) {
            panelWidgets.add(w.obtenerVista());
        }
        panelWidgets.revalidate();
        panelWidgets.repaint();
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public String getTextoBusqueda() { return txtBuscar.getText().trim(); }
    public JButton getBtnMostrarTodos() { return btnMostrarTodos; }
    public JButton getBtnOrdenar() { return btnOrdenar; }
    public JButton getBtnBuscar() { return btnBuscar; }
}

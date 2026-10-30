import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard modelo = new Dashboard();
            DashboardView vista = new DashboardView();
            DashboardController controlador = new DashboardController(modelo, vista);
            controlador.iniciar();
        });
    }
}

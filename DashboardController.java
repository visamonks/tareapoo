import java.util.ArrayList;
import java.util.List;

public class DashboardController {
    private Dashboard modelo;
    private DashboardView vista;

    public DashboardController(Dashboard modelo, DashboardView vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.getBtnMostrarTodos().addActionListener(e -> mostrarTodos());
        vista.getBtnOrdenar().addActionListener(e -> ordenar());
        vista.getBtnBuscar().addActionListener(e -> buscar());
    }

    public void iniciar() {
        modelo.init();
        mostrarTodos();
        vista.setVisible(true);
    }

    private void mostrarTodos() {
        vista.mostrarWidgets(modelo.getWidgets());
    }

    private void ordenar() {
        modelo.ordenarPorMemoria();
        vista.mostrarWidgets(modelo.getWidgets());
    }

    private void buscar() {
        String texto = vista.getTextoBusqueda();
        if (texto.isEmpty()) {
            vista.mostrarMensaje("Ingresa un ID o nombre para buscar.");
            return;
        }

        Widget encontrado;
        try {
            encontrado = modelo.buscarPorId(Integer.parseInt(texto));
        } catch (NumberFormatException ex) {
            encontrado = modelo.buscarPorNombre(texto);
        }

        if (encontrado == null) {
            vista.mostrarMensaje("No se encontró ningún widget con: " + texto);
        } else {
            String tipo = (encontrado instanceof Interactivo) ? "Interactivo" : "Estático";
            vista.mostrarMensaje("ID: " + encontrado.getId()
                    + "\nNombre: " + encontrado.getNombre()
                    + "\nTipo: " + tipo
                    + "\nMemoria: " + encontrado.getMemoriaKB() + " KB"
                    + "\nContenido: " + encontrado.renderizar());

            List<Widget> resultado = new ArrayList<>();
            resultado.add(encontrado);
            vista.mostrarWidgets(resultado);
        }
    }
}
